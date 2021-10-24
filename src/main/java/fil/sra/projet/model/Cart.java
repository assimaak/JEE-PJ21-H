package fil.sra.projet.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

	Map<Article,Integer>articles = new HashMap<Article,Integer>();
	
	public Map<Article,Integer> getArticles() {
		return articles;
	}
	public void setArticles(Map<Article,Integer> articles) {
		this.articles = articles;
	}
}
