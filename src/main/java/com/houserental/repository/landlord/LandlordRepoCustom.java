package com.houserental.repository.landlord;

import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.review.Review;

import java.util.List;

/**
 * Created by cheyikung on 4/19/16.
 */
public interface LandlordRepoCustom {
    public void addHouse(String landlordName, HouseInfo houseInfo);
    public List<Review> rtvReview(String ldname, String houseid);
    public void chgHouseSts(String landlordName, String houseid, String status);
}
