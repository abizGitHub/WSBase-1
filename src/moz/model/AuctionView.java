package moz.model;

import model.BaseModel;

public class AuctionView extends BaseModel {

    private String description;
    private Integer eDate;
    private String client;
    private String buTitle;
    private String city;
    private String province;
    private Long cityId;
    private Long provinceId;

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

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getBuTitle() {
        return buTitle;
    }

    public void setBuTitle(String buTitle) {
        this.buTitle = buTitle;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }
}
