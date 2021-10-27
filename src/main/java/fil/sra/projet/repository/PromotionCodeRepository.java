package fil.sra.projet.repository;

import fil.sra.projet.dao.PromotionCodeDao;
import fil.sra.projet.model.PromotionCode;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PromotionCodeRepository
    extends PromotionCodeDao, CrudRepository<PromotionCode, Long> {
    List<PromotionCode> findAll();
}
