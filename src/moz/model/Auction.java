package moz.model;

import model.BaseModel;

public class Auction extends BaseModel {

    private String description;
    private Integer eDate;
    private long client;
    private long buTitle;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer geteDate() {
        return eDate;
    }

    public void seteDate(Integer eDate) {
        this.eDate = eDate;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    public long getBuTitle() {
        return buTitle;
    }

    public void setBuTitle(long buTitle) {
        this.buTitle = buTitle;
    }
}
