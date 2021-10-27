package fil.sra.projet.web;

import fil.sra.projet.model.Article;
import fil.sra.projet.model.Operation;
import fil.sra.projet.repository.ArticleRepository;
import fil.sra.projet.repository.OperationRepository;
import fil.sra.projet.web.dto.OperationAssingEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(path="/admin/articles")
public class ArticleController {

    @Autowired
    ArticleRepository articleRepo;

    @ResponseBody
	@GetMapping(path="/list.json")
    public List<Article> listOperations(Model model, HttpServletResponse resp) {


        return (List<Article>) articleRepo.findAll();

    }

    @ResponseBody
    @PostMapping(path="/post.json")
    public String addProductToOperation(Model model,
                                        HttpServletResponse resp,
                                        Article article) {


        try {

            /*Article maxIdHoliday= articleRepo.findFirstByOrderByIdDesc();
            article.setId(maxIdHoliday != null ? maxIdHoliday.getId() + 1 : 1);*/
            articleRepo.save(article);
            resp.setStatus(200);
            return "added!";
        }
        catch (Exception e){

            resp.setStatus(500);
            return "Internal error";
        }


    }




}
