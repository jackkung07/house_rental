package com.houserental.repository.tenant;

import com.houserental.entity.review.Review;
import com.houserental.entity.tenant.Favorite;

/**
 * Created by cheyikung on 4/19/16.
 */
public interface TenantRepoCustom {
    public void addFavorite(String tenantName, String landlordName, String houseId, Favorite favorite);
    public void addReview(String tenantName, String landlordName, String houseId, Review review);
}
