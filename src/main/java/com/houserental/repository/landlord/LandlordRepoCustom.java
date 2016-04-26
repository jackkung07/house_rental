package com.houserental.repository.landlord;

import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.review.Review;

import java.util.List;

/**
 * Created by cheyikung on 4/19/16.
 */
public interface LandlordRepoCustom {
    public void addHouse(String landlordFbId, HouseInfo houseInfo);
    public void editHouse(String landlordFbId, String houseId, HouseInfo houseInfo);
    public void changeHouseStatus(String landlordFbId, String houseId, String status);
    public List<Review> rtvReview(String ldname, String houseid);

}
