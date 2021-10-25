package fil.sra.projet.model;

import javax.persistence.*;

@Entity
@Table(name="brand")
public class Brand {
	@Id
	private int id;
	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
