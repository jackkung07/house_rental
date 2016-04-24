package com.houserental.service.tenant;

import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.review.Review;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cheyikung on 4/19/16.
 */

public interface TenantServices {
    public List<HouseInfo> listAllHouseInfo();

    public List<HouseInfo> searchByLocation(double lat, double lng, double radius);

    public List<HouseInfo> searchByReviewId(String reviewId);

    public void addFavorite(String tenantName, String landlordName, String houseId);

    public void addReview(String tenantName, String landlordName, String houseId);

    public List<Review> listAllReview(String tenantName);
}
