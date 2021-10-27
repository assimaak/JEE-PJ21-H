package fil.sra.projet.repository;

import fil.sra.projet.dao.OrderDao;
import fil.sra.projet.model.Operation;
import fil.sra.projet.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OperationRepository
extends OrderDao, CrudRepository<Operation, Long>
{
      Operation findById(Long id);
}
