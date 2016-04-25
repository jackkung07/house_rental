package com.houserental.entity.review;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by cheyikung on 4/17/16.
 */
@Document(collection = "review")
public class Review {
    @Id
    private String reviewId;

    private String landlordfbId;

    private String houseId;

    private String tenantfbId;

    private String date;

    private String rating;

    private String description;

    public Review() {}

    @PersistenceConstructor
    public Review(String landlordfbId, String houseId, String tenantfbId, String date, String rating, String description) {
        super();
        this.landlordfbId = landlordfbId;
        this.houseId = houseId;
        this.tenantfbId = tenantfbId;
        this.date = date;
        this.rating = rating;
        this.description = description;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getLandlordfbId() {
        return landlordfbId;
    }

    public void setLandlordfbId(String landlordfbId) {
        this.landlordfbId = landlordfbId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getTenantfbId() {
        return tenantfbId;
    }

    public void setTenantfbId(String tenantfbId) {
        this.tenantfbId = tenantfbId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
