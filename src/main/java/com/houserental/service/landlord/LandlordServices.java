package com.houserental.service.landlord;

import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.review.Review;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ivanybma on 4/19/16.
 */

public interface LandlordServices {

//    add new house posting
    public void addHousing(String ldname, HouseInfo house);

//    retrieve house posting review list
    public List<Review> rtvReviewByHid(String ldname, String houseid);

//    retrieve all reviews for house posted by tis landlord
    public List<Review> rtvAllReview(String ldname);

//    change house status
    public void chgHouseSts(String ldname, String houseid, String status);

//    retrieve all posted house info
    public List<HouseInfo> rtvAllPhouse(String ldname);

}
