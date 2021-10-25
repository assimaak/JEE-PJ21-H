package fil.sra.projet.web;

import fil.sra.projet.dao.DataException;
import fil.sra.projet.model.PromotionOneArticle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/client")
public class sampleProductsController {
    @RequestMapping(path = "/products.html", produces = "text/html")
    public String getForms(Model model) throws DataException {
        return "sample_products";
    }
}
