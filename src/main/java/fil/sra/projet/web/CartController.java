package fil.sra.projet.web;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fil.sra.projet.dao.ArticleDao;
import fil.sra.projet.dao.CartDao;
import fil.sra.projet.dao.DataException;
import fil.sra.projet.dao.OrderDao;
import fil.sra.projet.model.Article;
import fil.sra.projet.model.Cart;
import fil.sra.projet.model.Order;
import fil.sra.projet.repository.OrderRepository;
import fil.sra.projet.web.dto.CartEntry;
import fil.sra.projet.web.dto.SimpleResponse;
import fil.sra.projet.web.dto.SimpleResponse.Status;

@Controller
@RequestMapping(path = "/cart")
public class CartController {

	@Autowired
	CartDao daoCart;
	@Autowired
	ArticleDao daoArt;

	@Autowired
	OrderRepository orderRepo;

	@ExceptionHandler(DataException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String dataExceptionHandler(Exception ex) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintWriter w = new PrintWriter(out);
		ex.printStackTrace(w);
		w.close();
		return "ERROR" + "<!--\n" + out.toString() + "\n-->";
	}

	@GetMapping(path = "/{id}.html", produces = "text/html")
	public String getCart(@PathVariable(name = "id") int id, Model model) throws DataException {

		// get cart from dao
		// assign to model var "cart"
		// return view name to display content of /WEB-INF/views/_cart_header.jsp
		if (id < 1) {
			throw new DataException(null);
		}
		Cart cart = daoCart.getCartContent(id);
		model.addAttribute("cart", cart);
		return "_cart_header";

	}

	@ResponseBody
	@PostMapping(path = "/{id}/add.json", consumes = "application/json")
	public SimpleResponse add(@PathVariable(name = "id") int id, @RequestBody CartEntry art) {
		SimpleResponse res = new SimpleResponse();

		try {
			if (art.getQty() < 0) {
				res.message = "Quantity";
				res.status = Status.ERROR;
			} else if (daoArt.find(art.getId()) == null) {
				res.message = "product doesn't exist";
				res.status = Status.ERROR;
			} else {
				Map<Article,Integer>tmp = new HashMap<Article,Integer>();
				tmp.put(daoArt.find(art.getId()),1);
				if (daoCart.getCartContent(id) == null) {
					Cart cart = new Cart();
					cart.setArticles(tmp);
					daoCart.store(id, cart);
				} else {
					if(daoCart.getCartContent(id).getArticles().containsKey(daoArt.find(art.getId()))) {
						int a = daoCart.getCartContent(id).getArticles().get(daoArt.find(art.getId()));
						daoCart.getCartContent(id).getArticles().put(daoArt.find(art.getId()),a+1);
					}
					else {
						daoCart.getCartContent(id).getArticles().put(daoArt.find(art.getId()),1);

					}
				}

				System.out.println("********************\n" + "***** "
						+ String.format("Add Article %d x [%s] to cart", art.getQty(), art.getId()) + "\n"
						+ "********************"+daoCart.getCartContent(id).getArticles().toString());
				res.status = Status.OK;
			}

		} catch (DataException e) {
			res.message = "error 2";
			res.status = Status.ERROR;
		}
		return res;
	}

}
