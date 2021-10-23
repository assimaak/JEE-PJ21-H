package fil.sra.projet.model;

public class PromotionOneArticle extends Promotion{
    String idArticle;
    int percentage;
    String reference;


	public String getReference() {
		return reference;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}