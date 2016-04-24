package com.houserental.service.landlord;

import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.review.Review;
import com.houserental.repository.landlord.LandlordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ivanybma on 4/19/16.
 */

@Service
public class LanlordServicesImp implements LandlordServices {

    @Autowired
    LandlordRepo landlordRepo;

    @Override
    public void addHousing(String ldname, HouseInfo house) {
        landlordRepo.addHouse(ldname,house);
    }

    @Override
    public List<Review> rtvReviewByHid(String ldname, String houseid) {
        return landlordRepo.rtvReview(ldname,houseid);
    }

    @Override
    public List<Review> rtvAllReview(String ldname) {
        return landlordRepo.rtvReview(ldname,"");
    }

    @Override
    public void chgHouseSts(String ldname, String houseid, String status) {
        landlordRepo.chgHouseSts(ldname,houseid,status);
    }

    @Override
    public List<HouseInfo> rtvAllPhouse(String ldname) {
        return landlordRepo.findByName(ldname).getHouseOwned();
    }
}
