package fil.sra.projet.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fil.sra.projet.dao.OrderDao;
import fil.sra.projet.model.Order;

public interface OrderRepository 
extends OrderDao, CrudRepository<Order, Long>
{
	List<Order> findByCustomerIdOrderByCreatedOnDesc(String customerId);
    Order findOneByCustomerId(String customerId);
}
