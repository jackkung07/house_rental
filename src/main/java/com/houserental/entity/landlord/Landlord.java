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
    private String name;

    private List<HouseInfo> houseOwned = new ArrayList<HouseInfo>();

    private String phoneNum;

    private String email;

    public Landlord() {
    }

    @PersistenceConstructor
    public Landlord(String phoneNum, String email) {
        super();
        this.phoneNum = phoneNum;
        this.email = email;
    }


    public String getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(String landlordId) {
        this.landlordId = landlordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HouseInfo> getHouseOwned() {
        return houseOwned;
    }

    public HouseInfo getHouseById(String houseId) {
        for (HouseInfo house : houseOwned) {
            if (house.getHouseId().endsWith(houseId)) {
                return house;
            }
        }
        return null;
    }

    public void setHouseById(String houseId, HouseInfo house){
        houseOwned.set(Integer.parseInt(houseId), house);
    }

    public void addHouse(HouseInfo newHouse) {
        newHouse.setHouseId(Integer.toString(houseOwned.size()));
        houseOwned.add(newHouse);
    }

    public void setHouseOwned(List<HouseInfo> houseOwned) {
        this.houseOwned = houseOwned;
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
        return houseOwned.size();
    }

    @Override
    public String toString() {
        return "Landlord [landlordId= " + landlordId + ", phone number= " + phoneNum + ", email= " + email + ", houseOwned= " + houseOwned + "]";
    }
}
