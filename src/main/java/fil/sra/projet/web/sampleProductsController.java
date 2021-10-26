package fil.sra.projet.web;

import fil.sra.projet.dao.ArticleDao;
import fil.sra.projet.dao.CartDao;
import fil.sra.projet.dao.DataException;
import fil.sra.projet.model.Article;
import fil.sra.projet.model.Cart;
import fil.sra.projet.model.PromotionGroupe;
import fil.sra.projet.model.PromotionOneArticle;
import fil.sra.projet.repository.PromotionGroupeRepository;
import fil.sra.projet.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/client")
public class sampleProductsController {

    @Autowired
    ArticleDao daoArt;
    @Autowired
    PromotionRepository promotionOneArticleRepository;
    @Autowired
    PromotionGroupeRepository promotionGroupeRepository;
    @Autowired
    CartDao daoCart;

    @RequestMapping(path = "/products.html", produces = "text/html")
    public String getForms(Model model) throws DataException {
        List<Article> listArticle = daoArt.getListArticle();
        model.addAttribute("listArticle", listArticle);
        model.addAttribute("cart", daoCart.getCartContent(1));

        Iterable<PromotionOneArticle> iterator = promotionOneArticleRepository.findAll();
        List<PromotionOneArticle> listPromotion = new ArrayList<>();
        List<PromotionOneArticle> listPromotionValide = new ArrayList<>();
        iterator.forEach(listPromotion::add);


        Iterable<PromotionGroupe> iteratorPromoGroupe = promotionGroupeRepository.findAll();

        List<PromotionGroupe> listPromotionGroupe = new ArrayList<>();
        iteratorPromoGroupe.forEach(listPromotionGroupe::add);

        for(PromotionGroupe p : listPromotionGroupe){
            String pTypeReduc = String.valueOf(p.getGroupPromo().charAt(0));
            String pArticleId = p.getGroupPromo().substring(1);
            for(Article a : daoArt.getListArticle()){
                if( (pTypeReduc.equals("c") && a.getCat_id()!=null && a.getCat_id().equals(pArticleId)) || (pTypeReduc.equals("b") && a.getBra_id()!=null && a.getBra_id().equals(pArticleId)) ){
                    PromotionOneArticle pTmp = new PromotionOneArticle();
                    pTmp.setDateEnd(p.getDateEnd());
                    pTmp.setDateStart(p.getDateStart());
                    pTmp.setValeur(p.getValeur());
                    pTmp.setTypeReduc(p.getTypeReduc());
                    pTmp.setReference(a.getId());
                    listPromotionValide.add(pTmp);
                }
            }
        }

        for(PromotionOneArticle p : listPromotion){
            if(testDateValide(p.getDateStart(), p.getDateEnd())){
                listPromotionValide.add(p);
            }
        }

        model.addAttribute("listPromotion", listPromotionValide);
        return "sample_products";
    }

    private boolean testDateValide(String sDateStart, String sDateEnd){
        try {
            Date dateNow = new SimpleDateFormat("dd-MM-yyyy").parse(String.valueOf((new SimpleDateFormat("dd-MM-yyyy")).format(new Date())));

            Date dateStart = new SimpleDateFormat("dd-MM-yyyy").parse(String.valueOf(sDateStart));

            Date dateEnd = new SimpleDateFormat("dd-MM-yyyy").parse(String.valueOf(sDateEnd));
            if((dateNow.compareTo(dateStart) != dateNow.compareTo(dateEnd))||dateNow.compareTo(dateStart)==0){
                return true;
            }
        }catch (ParseException e) {
            System.out.println("Error parse String to date");
        }
        return false;
    }
}

