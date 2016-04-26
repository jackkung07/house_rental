package com.houserental.service.landlord;

import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.landlord.Landlord;
import com.houserental.entity.review.Review;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ivanybma on 4/19/16.
 */


public interface LandlordServices {

    //find landlord by fbId
    public Landlord findLandlordByFbId(String fbId);

    //add landlord info
    public void addLandlord(Landlord landlord);

    //add new house posting
    public void addHouse(String landlordFbId, HouseInfo house);

    //edit house information
    public void editHouse(String landlordFbId, String houseId, HouseInfo houseInfo);

    //change house status
    public void changeHouseStatus(String landlordFbId, String houseId, String status);

    //override landlord information
    public void overrideLandlord(Landlord landlord);

    //retrieve house posting review list
    public List<Review> rtvReviewByHid(String ldname, String houseid);

    //retrieve all reviews for house posted by tis landlord
    public List<Review> rtvAllReview(String ldname);

    //retrieve all posted house info
    public List<HouseInfo> rtvAllPhouse(String ldname);

    public Landlord newLandlord(Landlord ld);

}
