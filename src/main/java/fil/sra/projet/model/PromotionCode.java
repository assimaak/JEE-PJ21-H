package fil.sra.projet.model;

import javax.persistence.*;

@Entity
@Table(name="promotionCode")
public class PromotionCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idCode;
    String dateStart = null;
    String dateEnd = null;
    String typeReduc = null;
    String valeur;
    String codePromo;

    public long getIdCode() {
        return idCode;
    }

    public void setIdCode(long idCode) {
        this.idCode = idCode;
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

    public String getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(String codePromo) {
        this.codePromo = codePromo;
    }
}
