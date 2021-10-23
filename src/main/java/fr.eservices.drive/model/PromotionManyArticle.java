package fr.eservices.drive.model;

public class PromotionManyArticle extends Promotion{
    List<String> listIdArticle;
    int percentage;

    public int getPercentage(){
        return this.percentage;
    }

    public void setPercentage(tmpPercentage){
        this.percentage = tmpPercentage;
    }

    public String getListIdArticle(){ return this.listIdArticle; }

    public void setIdArticle(tmpIdArticle){
        this.idArticle = tmpIdArticle;
    }
}