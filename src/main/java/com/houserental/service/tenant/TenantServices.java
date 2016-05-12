package com.houserental.service.tenant;

import com.houserental.entity.HouseSchCri;
import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.review.Review;
import com.houserental.entity.tenant.Favorite;
import com.houserental.entity.tenant.Tenant;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cheyikung on 4/19/16.
 */

public interface TenantServices {

    //find landlord by fbId
    public Tenant findTenantByFbId(String fbId);

    //add landlord info
    public void addTenant(Tenant tenant);

    //override tenant information
    public void overrideTenant(Tenant tenant);

    public List<HouseInfo> listAllHouseInfo();

    public List<HouseInfo> searchByLocation(double lat, double lng, double radius);
    public List<HouseInfo> searchByCriteria(HouseSchCri criteria);

    public String incrementViewCount(String houseId, String landlordFbId);
}
