package fil.sra.projet.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fil.sra.projet.dao.ArticleDao;
import fil.sra.projet.model.Article;
import fil.sra.projet.model.Brand;
import fil.sra.projet.model.Category;

@Component
@Qualifier("mock")
public class ArticleMockDao implements ArticleDao {
	
	private HashMap<String, Article> arts = new HashMap<>();
	private List<Category> categories = new ArrayList<>();
	private List<Brand> brands = new ArrayList<>();
	
	public ArticleMockDao() {
		
		{

			Category boisson = new Category();
			boisson.setName("Boissons");
			boisson.setId("0");
			categories.add(boisson);
			Brand auchan = new Brand();
			auchan.setName("Auchan");
			auchan.setId("0");
			brands.add(auchan);
		}
		
		{
			Article a = new Article();
			a.setId("10101010");
			a.setName("Boisson énergétique");
			a.setPrice(299);
			a.setImg("https://static1.chronodrive.com/img/PM/P/0/76/0P_61276.gif");
			a.setCat_id("0");
			arts.put( a.getId(), a );
		}
		
		{
			Article a = new Article();
			a.setId("10101012");
			a.setName("Papier Cadeau");
			a.setPrice(150);
			a.setImg("https://static1.chronodrive.com/img/PM/P/0/72/0P_348972.gif");
			arts.put( a.getId(), a );
		}
		
		{
			Article a = new Article();
			a.setId("10101013");
			a.setName("Pur jus d&#039;orange");
			a.setPrice(235);
			a.setImg("https://static1.chronodrive.com/img/PM/P/0/42/0P_40042.gif");
			a.setCat_id("0");
			a.setBra_id("0");
			arts.put( a.getId(), a );
		}
		
		{
			Article a = new Article();
			a.setId("195420");
			a.setName("420g Fromage à raclette");
			a.setPrice(450);
			a.setImg("https://static1.chronodrive.com/img/PM/P/0/20/0P_195420.gif");
			arts.put( a.getId(), a );
		}
		
		{
			Article a = new Article();
			a.setId("165609");
			a.setName("6 tranches Jambon Serrano");
			a.setPrice(174);
			a.setImg("https://static1.chronodrive.com/img/PM/P/0/09/0P_165609.gif");
			a.setBra_id("0");
			arts.put( a.getId(), a );
		}
		
		{
			Article a = new Article();
			a.setId("120574");
			a.setName("2,5 kg Pomme de terre Cat 1");
			a.setPrice(169);
			a.setImg("https://static1.chronodrive.com/img/PM/P/0/74/0P_120574.gif");
			a.setBra_id("0");
			arts.put( a.getId(), a );
		}
		
	}
	

	public void setArticle( String i, Article art) {
		arts.put(i, art);
	}
	
	@Override
	public Article find(String id) {
		return arts.get(id);
	}

	public List<Article> getListArticle() { return new ArrayList<Article>(arts.values()); }
	
	public List<Category> getCategories() { return categories;}
	
	public List<Brand> getBrands() { return brands;}
	
}
