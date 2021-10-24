package fil.sra.projet.model;

import javax.persistence.*;

//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // ajouter param
@Entity
public class PromotionOneArticle{// extends Promotion{
    int percentage;
    String reference;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPromotion;
    private String dateStart = null;
    private String dateEnd = null;
    private String typeReduc = null;
    private int value = 0;











    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public int getValue() {
        return value;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getIdPromotion() {
        return idPromotion;
    }

    public String getTypeReduc() {
        return typeReduc;
    }

    public void setTypeReduc(String typeReduc) {
        this.typeReduc = typeReduc;
    }

    public void setIdPromotion(long idPromotion) {
        this.idPromotion = idPromotion;
    }
}