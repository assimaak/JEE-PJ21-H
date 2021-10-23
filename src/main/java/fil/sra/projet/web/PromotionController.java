package fil.sra.projet.web;

import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns={"/promotion"})
public class PromotionController {

    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        String valueTest = req.getParameter("valueTest");
        System.out.println(valueTest);
    }
}