package com.houserental.entity.tenant;

/**
 * Created by cheyikung on 4/19/16.
 */
public class Favorite {

    private String landlordName;
    private String houseId;

    public Favorite(){}

    public Favorite(String landlordName, String houseId) {
        this.landlordName = landlordName;
        this.houseId = houseId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }
}
