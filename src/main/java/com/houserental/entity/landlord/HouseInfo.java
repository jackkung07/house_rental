package com.houserental.entity.landlord;

import java.util.List;

/**
 * Created by cheyikung on 4/17/16.
 */
public class HouseInfo {

    private String houseId;

    private String landlordName;

    private Address address;

    private String propertyType;

    private int numOfBathroom;

    private int numOfBedroom;

    private double sqrtft;

    private double price;

    private List<String> reviewIdList;

    private String description;

    private String status;

    private String postingDate;

    public HouseInfo() {}

    public HouseInfo(String landlordName, Address address, String propertyType, int numOfBathroom, int numOfBedroom, double sqrtft, double price, String description, String status, String postingDate) {
        this.address = address;
        this.propertyType = propertyType;
        this.numOfBathroom = numOfBathroom;
        this.numOfBedroom = numOfBedroom;
        this.sqrtft = sqrtft;
        this.price = price;
        this.description = description;
        this.status = status;
        this.postingDate = postingDate;
        this.landlordName=landlordName;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getlandlordName() {
        return landlordName;
    }

    public void setlandlordName(String landlordName) {
        this.landlordName = landlordName;
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

    public List<String> getReviewIdList() {
        return reviewIdList;
    }

    public void setReviewIdList(List<String> reviewIdList) {
        this.reviewIdList = reviewIdList;
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

    public void addReviewId(String reviewId){
        reviewIdList.add(reviewId);
    }
}
