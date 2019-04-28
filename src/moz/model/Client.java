package moz.model;

import model.BaseModel;

public class Client extends BaseModel {

    private String name;
    private long city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCity() {
        return city;
    }

    public void setCity(long city) {
        this.city = city;
    }

}
