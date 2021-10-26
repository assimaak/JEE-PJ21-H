package fil.sra.projet.dao;

import fil.sra.projet.model.Article;
import fil.sra.projet.model.Brand;
import fil.sra.projet.model.Category;

import java.util.List;

public interface ArticleDao {
	
	Article find(String id);

	List<Article> getListArticle();

	List<Category> getCategories();

	List<Brand> getBrands();

}
