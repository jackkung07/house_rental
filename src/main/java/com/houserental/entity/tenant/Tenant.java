package com.houserental.entity.tenant;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by cheyikung on 4/17/16.
 */
@Document(collection = "tenant")
public class Tenant {

    @Id
    private String tenantId;

    //unique
    private String name;

    private List<String> reviewIdList;

    private List<Favorite> favoriteList;

    private List<String> reviewIds;

    public  Tenant() {

    }

    @PersistenceConstructor
    public Tenant(String name) {
        super();
        this.name = name;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getReviewIdList() {
        return reviewIdList;
    }

    public void setReviewIdList(List<String> reviewIdList) {
        this.reviewIdList = reviewIdList;
    }

    public List<Favorite> getFavoriteList() {
        return favoriteList;
    }

    public void setFavoriteList(List<Favorite> favoriteList) {
        this.favoriteList = favoriteList;
    }

    public void addFavorite(Favorite favorite){
        favoriteList.add(favorite);
    }

    public List<String> getReviewRefList() {
        return reviewIds;
    }

    public void setReviewRefList(List<String> reviewRefList) {
        this.reviewIds = reviewIds;
    }

    public void addReviewId(String reviewId){
        reviewIdList.add(reviewId);
    }
}
