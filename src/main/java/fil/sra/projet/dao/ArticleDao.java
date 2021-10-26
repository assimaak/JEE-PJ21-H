package fil.sra.projet.dao;

import fil.sra.projet.model.Article;

import java.util.List;

public interface ArticleDao {
	
	Article find(String id);

	List<Article> getListArticle();

}
