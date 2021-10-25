package fil.sra.projet.web;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public String addOnePromotion(Model model, @ModelAttribute("promotionOneArticle") PromotionOneArticle promotionOneArticle) throws ParseException {


		SimpleResponse res = new SimpleResponse();
		
		Date start = new SimpleDateFormat( "dd-mm-yyyy" ).parse( promotionOneArticle.getDateStart() );
		Date end = new SimpleDateFormat( "dd-mm-yyyy" ).parse( promotionOneArticle.getDateEnd() );
		
		try {
			if(Integer.parseInt(promotionOneArticle.getValeur())<=0){
				res.message = "valeur négative ou nulle";
				res.status = Status.ERROR;
			}else if (daoArt.find(promotionOneArticle.getReference()) == null) {
				res.message = "le produit n'existe pas";
				res.status = Status.ERROR;
				System.out.println("id = "+promotionOneArticle.getReference());
			}
			else if (start.after(end)) {
				res.message = "la date saisie est incorrecte";
				res.status = Status.ERROR;
				System.out.println("id = "+promotionOneArticle.getReference());
			}else if(promotionOneArticle.getTypeReduc().equals("pourcentage") && Integer.parseInt(promotionOneArticle.getValeur())>100){
				res.message = "pourcentage invalide (superieur a 100)";
				res.status = Status.ERROR;
			}else if(promotionOneArticle.getTypeReduc().equals("valeur") && daoArt.find(promotionOneArticle.getReference()).getPrice()-(Integer.parseInt(promotionOneArticle.getValeur())*100)<0){
				res.message = "prix négatif après promotion";
				res.status = Status.ERROR;
			}	else if (promotionOneArticleRepository.findByIdPromotion(promotionOneArticle.getIdPromotion())!=null) {
				res.message = "id promotion already exists";
				res.status = Status.ERROR;
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
