package com.houserental.service.landlord;

import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.landlord.Landlord;
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
    public Landlord findLandlordByFbId(String fbId) {
        return landlordRepo.findByFbId(fbId);
    }

    @Override
    public void addLandlord(Landlord landlord) {
        landlordRepo.save(landlord);
    }

    @Override
    public void addHouse(String landlordFbId, HouseInfo house) {
        landlordRepo.addHouse(landlordFbId,house);
    }

    @Override
    public void editHouse(String landlordFbId, String houseId, HouseInfo houseInfo) {
        landlordRepo.editHouse(landlordFbId, houseId, houseInfo);
    }

    @Override
    public void changeHouseStatus(String landlordFbId, String houseId, String status) {
        landlordRepo.changeHouseStatus(landlordFbId, houseId, status);
    }

    @Override
    public void overrideLandlord(Landlord landlord) {
        landlordRepo.save(landlord);
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
    public List<HouseInfo> rtvAllPhouse(String ldname) {
        return landlordRepo.findByName(ldname).getHouseInfoList();
    }

    @Override
    public Landlord newLandlord(Landlord ld) {
        return landlordRepo.save(ld);
    }


}
