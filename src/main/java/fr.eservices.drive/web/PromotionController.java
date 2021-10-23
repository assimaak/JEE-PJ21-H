import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns={"/promotion"})
public class PromotionController {

    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        String valueTest = req.getParameter("valueTest");
        System.out.println(valueTest);
    }
}