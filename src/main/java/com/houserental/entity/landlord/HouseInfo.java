package com.houserental.entity.landlord;

import java.util.List;

/**
 * Created by cheyikung on 4/17/16.
 */
public class HouseInfo {

    private String houseId;

    private String landlordFbId;

    private Address address;

    private String propertyType;

    private int numOfBathroom;

    private int numOfBedroom;

    private double sqrtft;

    private double price;

    private int numOfViews;

    private String description;

    private String status;

    private String postingDate;

    private String ld_email;

    private String ld_phone;

    public HouseInfo() {}

    public HouseInfo(String landlordFbId, Address address, String propertyType, int numOfBathroom, int numOfBedroom, double sqrtft, double price, String description, String status, String postingDate) {
        this.landlordFbId=landlordFbId;
        this.address = address;
        this.propertyType = propertyType;
        this.numOfBathroom = numOfBathroom;
        this.numOfBedroom = numOfBedroom;
        this.sqrtft = sqrtft;
        this.price = price;
        this.description = description;
        this.status = status;
        this.postingDate = postingDate;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getLandlordFbId() {
        return landlordFbId;
    }

    public void setLandlordFbId(String landlordFbId) {
        this.landlordFbId = landlordFbId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getNumOfBathroom() {
        return numOfBathroom;
    }

    public void setNumOfBathroom(int numOfBathroom) {
        this.numOfBathroom = numOfBathroom;
    }

    public int getNumOfBedroom() {
        return numOfBedroom;
    }

    public void setNumOfBedroom(int numOfBedroom) {
        this.numOfBedroom = numOfBedroom;
    }

    public double getSqrtft() {
        return sqrtft;
    }

    public void setSqrtft(double sqrtft) {
        this.sqrtft = sqrtft;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(String postingDate) {
        this.postingDate = postingDate;
    }

    public String getLd_email() {
        return ld_email;
    }

    public void setLd_email(String ld_email) {
        this.ld_email = ld_email;
    }

    public String getLd_phone() {
        return ld_phone;
    }

    public void setLd_phone(String ld_phone) {
        this.ld_phone = ld_phone;
    }

    public int getNumOfViews() {
        return numOfViews;
    }

    public void setNumOfViews(int numOfViews) {
        this.numOfViews = numOfViews;
    }
}
