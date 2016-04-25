package com.houserental.entity.landlord;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheyikung on 4/17/16.
 */

@Document(collection = "landlord")
public class Landlord {

    @Id
    private String landlordId;

    //unique
    private String facebookId;

    private String name;

    private List<HouseInfo> houseInfoList = new ArrayList<HouseInfo>();

    private String phoneNum;

    private String email;

    public Landlord() {
    }

    @PersistenceConstructor
    public Landlord(String facebookId, String name, String phoneNum, String email) {
        super();
        this.facebookId = facebookId;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }


    public String getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(String landlordId) {
        this.landlordId = landlordId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HouseInfo> getHouseInfoList() {
        return houseInfoList;
    }

    public HouseInfo getHouseById(String houseId) {
        for (HouseInfo house : houseInfoList) {
            if (house.getHouseId().endsWith(houseId)) {
                return house;
            }
        }
        return null;
    }

    public void setHouseById(String houseId, HouseInfo house){
        houseInfoList.set(Integer.parseInt(houseId), house);
    }

    public void addHouse(HouseInfo newHouse) {
        newHouse.setHouseId(Integer.toString(houseInfoList.size()));
        houseInfoList.add(newHouse);
    }

    public void setHouseInfoList(List<HouseInfo> houseInfoList) {
        this.houseInfoList = houseInfoList;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumOfHouses() {
        return houseInfoList.size();
    }

    @Override
    public String toString() {
        return "Landlord [landlordId= " + landlordId + ", phone number= " + phoneNum + ", email= " + email + ", houseInfoList= " + houseInfoList + "]";
    }
}
