package fil.sra.projet.repository;

import fil.sra.projet.dao.DataException;
import fil.sra.projet.dao.PromotionOneArticleDao;
//import fil.sra.projet.model.Promotion;
import fil.sra.projet.model.PromotionOneArticle;
import org.springframework.data.repository.CrudRepository;

public interface PromotionRepository
extends PromotionOneArticleDao, CrudRepository<PromotionOneArticle, Long> {
    PromotionOneArticle findByIdPromotion(long id) throws DataException;

}
