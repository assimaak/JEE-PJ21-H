package fil.sra.projet.web;

import fil.sra.projet.dao.ArticleDao;
import fil.sra.projet.dao.DataException;
import fil.sra.projet.model.Article;
import fil.sra.projet.model.PromotionOneArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/client")
public class sampleProductsController {

    @Autowired
    ArticleDao daoArt;

    @RequestMapping(path = "/products.html", produces = "text/html")
    public String getForms(Model model) throws DataException {
        List<Article> listArticle = daoArt.getListArticle();

        model.addAttribute("listArticle", listArticle);
        return "sample_products";
    }
}
