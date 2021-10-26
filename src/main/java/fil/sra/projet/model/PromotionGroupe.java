package fil.sra.projet.model;

import javax.persistence.*;

@Entity
@Table(name="promotionGroupeFirst")
public class PromotionGroupe{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idPromotion;
    String dateStart;
    String dateEnd;
    String typeReduc;
    String valeur;
    String groupPromo;

    public boolean isBrand() {
    	return groupPromo.startsWith("b");
    }
    
    public boolean isCategory() {
    	return groupPromo.startsWith("c");
    }
    public long getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(long idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getTypeReduc() {
        return typeReduc;
    }

    public void setTypeReduc(String typeReduc) {
        this.typeReduc = typeReduc;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getGroupPromo() {
        return groupPromo;
    }

    public void setGroupPromo(String groupPromo) {
        this.groupPromo = groupPromo;
    }
}