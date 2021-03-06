package fil.sra.projet.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fil.sra.projet.model.Order;
import fil.sra.projet.repository.OrderRepository;

@Controller
@RequestMapping(path="/order")
public class OrderController {
	
	
	// Autowire this
	@Autowired
	OrderRepository repoOrder;
	
	@RequestMapping(path="/ofCustomer/{custId}.html")
    public String list(@PathVariable String custId, Model model) {
        
        // use repo to get orders of a customer
        // assign in model as "orders"
        // return order list view
        
        List<Order> orders = repoOrder.findByCustomerIdOrderByCreatedOnDesc(custId);
        model.addAttribute("orders", orders);
        
        
        return "order_list";

    }

}
