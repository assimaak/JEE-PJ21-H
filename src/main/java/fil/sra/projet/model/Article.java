package fil.sra.projet.model;

//import javax.persistence.*;

//@Entity
//@Table(name="articles")

public class Article {
//      @Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	long id;
	private String
		id,
		name,
		img,
		cat_id,
		bra_id;
	
	public String getBra_id() {
		return bra_id;
	}

	public void setBra_id(String bra_id) {
		this.bra_id = bra_id;
	}

	private int price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public String getCat_id() {
		return cat_id;
	}
	
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	
//      public void setId(Long id) {
//        	this.id = id;
//	}
//	@Id
//	public Long getId() {
//		return id;
//	}
	
}
