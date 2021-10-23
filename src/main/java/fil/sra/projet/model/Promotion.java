package fil.sra.projet.model;

import java.util.Date;

public abstract class Promotion {

    private String idPromotion;
    private Date dateStart;
    private Date dateEnd;
    String typeReduc;
    int value;

    public Date getDateStart() {
		return dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public int getValue() {
		return value;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getIdPromotion() {
        return idPromotion;
    }
    
    public String getTypeReduc() {
		return typeReduc;
	}
    
	public void setTypeReduc(String typeReduc) {
		this.typeReduc = typeReduc;
	}

    public void setIdPromotion(String idPromotion) {
        this.idPromotion = idPromotion;
    }


}