package fr.eservices.drive.model;

import java.util.List;

public class PromotionManyArticle extends Promotion{
    List<String> listIdArticle;
    int percentage;

    public List<String> getListIdArticle() {
        return listIdArticle;
    }

    public void setListIdArticle(List<String> listIdArticle) {
        this.listIdArticle = listIdArticle;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}