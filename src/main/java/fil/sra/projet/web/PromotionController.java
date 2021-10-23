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
import fil.sra.projet.model.PromotionOneArticle;
import fil.sra.projet.repository.OrderRepository;
import fil.sra.projet.web.dto.CartEntry;
import fil.sra.projet.web.dto.SimpleResponse;
import fil.sra.projet.web.dto.SimpleResponse.Status;

@Controller
@RequestMapping(path = "/admin")
public class PromotionController {

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

	@RequestMapping(path = "/forms.html", produces = "text/html")
	public String getForms(Model model) throws DataException {
		model.addAttribute("promotionOneArticle", new PromotionOneArticle());
		
		return "admin";

	}

}
