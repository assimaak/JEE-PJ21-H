package fil.sra.projet.repository;

import fil.sra.projet.dao.OrderDao;
import fil.sra.projet.model.Article;
import fil.sra.projet.model.Operation;
import fil.sra.projet.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends  CrudRepository<Article, Long>
{
    //Article findById(long id);

    @Override
    Article findOne(Long id);

    Article findFirstByOrderByIdDesc();
}
