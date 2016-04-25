package com.houserental.entity.tenant;

/**
 * Created by cheyikung on 4/19/16.
 */
public class Favorite {

    private String landlordfbId;
    private String houseId;

    public Favorite(){}

    public Favorite(String landlordfbId, String houseId) {
        this.landlordfbId = landlordfbId;
        this.houseId = houseId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getLandlordfbId() {
        return landlordfbId;
    }

    public void setLandlordfbId(String landlordfbId) {
        this.landlordfbId = landlordfbId;
    }
}
