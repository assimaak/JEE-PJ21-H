package fil.sra.projet.web;

import fil.sra.projet.model.Article;
import fil.sra.projet.model.Operation;
import fil.sra.projet.model.Order;
import fil.sra.projet.repository.ArticleRepository;
import fil.sra.projet.repository.OperationRepository;
import fil.sra.projet.repository.OrderRepository;
import fil.sra.projet.web.dto.OperationAssingEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(path="/admin/operations")
public class OperationController {


	// Autowire this
	@Autowired
    OperationRepository operationRepo;

    @Autowired
    ArticleRepository articleRepo;

    @ResponseBody
	@GetMapping(path="/list.json")
    public List<Operation> listOperations(Model model, HttpServletResponse resp) {


        articleRepo.findAll();
        return (List<Operation>) operationRepo.findAll();

    }

    @ResponseBody
    @PostMapping(path="/post.json")
    public String addProductToOperation(Model model,
                                        HttpServletResponse resp,
                                        Operation operation) {

        try {
            operationRepo.save(operation);
            resp.setStatus(200);
            return "added!";
        }
        catch (Exception e){

            resp.setStatus(500);
            return "Internal error";
        }


    }

    @ResponseBody
    @PutMapping(path="/update.json")
    public String addProductToOperation(Model model,
                                        HttpServletResponse resp,
                                        OperationAssingEntry entry) {

        try {
            Operation operation = operationRepo.findById(entry.getOpId());
            Article article = articleRepo.findOne(entry.getProdId());
            operation.getArticles().add(article);
            operation.setValue(entry.getValue());
            operationRepo.save(operation);
            resp.setStatus(200);
            return "added!";
        }
        catch (Exception e){

            resp.setStatus(500);
            return "Internal error";
        }


    }



}
