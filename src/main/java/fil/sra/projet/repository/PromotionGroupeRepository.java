package fil.sra.projet.repository;

import fil.sra.projet.dao.DataException;
import fil.sra.projet.dao.PromotionGroupeDao;
import fil.sra.projet.model.PromotionGroupe;
import fil.sra.projet.model.PromotionOneArticle;
import org.springframework.data.repository.CrudRepository;

public interface PromotionGroupeRepository extends PromotionGroupeDao, CrudRepository<PromotionGroupe, Long> {
    PromotionGroupe findByIdPromotion(long id) throws DataException;

    Iterable<PromotionGroupe> findAll();
}
