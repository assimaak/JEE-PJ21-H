package fr.eservices.drive.model;

import java.util.Date;

public abstract class Promotion {

    private String idPromotion;
    private Date startDatePromotion;
    private Date endDatePromotion;

    public String getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(String idPromotion) {
        this.idPromotion = idPromotion;
    }

    public Date getStartDatePromotion() {
        return startDatePromotion;
    }

    public void setStartDatePromotion(Date startDatePromotion) {
        this.startDatePromotion = startDatePromotion;
    }

    public Date getEndDatePromotion() {
        return endDatePromotion;
    }

    public void setEndDatePromotion(Date endDatePromotion) {
        this.endDatePromotion = endDatePromotion;
    }
}