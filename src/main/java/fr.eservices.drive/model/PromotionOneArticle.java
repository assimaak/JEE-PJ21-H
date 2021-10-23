package fr.eservices.drive.model;

public class PromotionOneArticle extends Promotion{
    String idArticle;
    int percentage;

    public int getPercentage(){
        return this.percentage;
    }

    public void setPercentage(tmpPercentage){
        this.percentage = tmpPercentage;
    }

    public String getIdArticle(){
        return this.idArticle;
    }

    public void setIdArticle(tmpIdArticle){
        this.idArticle = tmpIdArticle;
    }
}