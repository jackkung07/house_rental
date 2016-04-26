package com.houserental.repository.landlord;

import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.landlord.Landlord;
import com.houserental.entity.review.Review;
import com.houserental.repository.review.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheyikung on 4/19/16.
 */
public class LandlordRepoImpl implements LandlordRepoCustom {
    @Autowired
    LandlordRepo landlordRepo;
    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public void addHouse(String landlordFbId, HouseInfo houseInfo) {
        Landlord landlord = landlordRepo.findByFbId(landlordFbId);
        landlord.addHouse(houseInfo);
        landlordRepo.save(landlord);
    }

    @Override
    public void editHouse(String landlordFbId, String houseId, HouseInfo houseInfo) {
        Landlord landlord = landlordRepo.findByFbId(landlordFbId);
        List<HouseInfo> houseInfoList = landlord.getHouseInfoList();
        houseInfoList.set(Integer.parseInt(houseId), houseInfo);
        landlord.setHouseInfoList(houseInfoList);
        landlordRepo.save(landlord);
    }


    @Override
    public void changeHouseStatus(String landlordFbId, String houseId, String status) {
        Landlord landlord = landlordRepo.findByFbId(landlordFbId);
        for (int i = 0; i < landlord.getHouseInfoList().size(); i++) {
            if (landlord.getHouseInfoList().get(i).getHouseId().equals(houseId)) {
                landlord.getHouseInfoList().get(i).setStatus(status);
                break;
            }
        }
        landlordRepo.save(landlord);
    }

    @Override
    public List<Review> rtvReview(String ldname, String houseid) {
        Landlord landlord = landlordRepo.findByName(ldname);
        List<Review> rstlst = new ArrayList<Review>();

        if (houseid.length() == 0) //need to retrieve all the review for this landlord
        {
            List<HouseInfo> houseInfoList = landlord.getHouseInfoList();
            for (int i = 0; i < houseInfoList.size(); i++) {
                List<Review> tmplst = new ArrayList<Review>(reviewRepo.findByHouseId(houseInfoList.get(i).getHouseId()));
                rstlst.addAll(tmplst);
            }
        } else    //just need to retrieve reviews under the specific house posting
        {
            List<Review> tmplst = new ArrayList<Review>(reviewRepo.findByHouseIdnLid(houseid, ldname));
            rstlst.addAll(tmplst);
        }
        return rstlst;
    }
}
