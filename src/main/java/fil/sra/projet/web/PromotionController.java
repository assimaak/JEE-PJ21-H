package fil.sra.projet.web;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import fil.sra.projet.dao.*;
import fil.sra.projet.model.*;
import fil.sra.projet.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import fil.sra.projet.repository.OrderRepository;
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
	PromotionRepository promotionOneArticleRepository;

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
		//créer liste de categories
		//créer liste de marques
		//créer liste de produits bientôt périmés
		//model.addAttribute("categories",categories);
		//model.addAttribute("marques", marques);
		//model.addAttribute("perishables",perishables);
		model.addAttribute("promotionOneArticle", new PromotionOneArticle());
		return "admin";
	}

	@RequestMapping(value = "/promotionArticle.html", method = RequestMethod.POST, produces = "text/html")
	public String addOnePromotion(Model model, @ModelAttribute("promotionOneArticle") PromotionOneArticle promotionOneArticle) {


		SimpleResponse res = new SimpleResponse();

		try {
			if(promotionOneArticle.getValue()>0){
				res.message = "invalid value";
				res.status = Status.ERROR;
			} else if (promotionOneArticleRepository.findByIdPromotion(promotionOneArticle.getIdPromotion())!=null) {
				res.message = "id promotion already exists";
				res.status = Status.ERROR;
			} else if (daoArt.find(promotionOneArticle.getReference()) == null) {
				res.message = "product doesn't exist";
				res.status = Status.ERROR;
				System.out.println("id = "+promotionOneArticle.getReference());
			} else {

				promotionOneArticleRepository.save(promotionOneArticle);
				
				res.status = Status.OK;
			}

		} catch (DataException e) {
			res.message = "error dataException";
			res.status = Status.ERROR;
		}
		model.addAttribute("response",res);
		return "promotionArticle";
	}

}
