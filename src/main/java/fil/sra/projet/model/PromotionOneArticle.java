package fil.sra.projet.model;

import javax.persistence.*;

@Entity
public class PromotionOneArticle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idPromotion;
    String dateStart = null;
    String dateEnd = null;
    String typeReduc = null;
    String valeur;
    String reference;

    public void setValeur(String valeur) { this.valeur = valeur; }

    public String getValeur() { return valeur; }

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
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