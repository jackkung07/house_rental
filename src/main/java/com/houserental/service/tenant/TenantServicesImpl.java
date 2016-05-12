package com.houserental.service.tenant;

import com.houserental.entity.HouseSchCri;
import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.landlord.Landlord;
import com.houserental.entity.review.Review;
import com.houserental.entity.tenant.Favorite;
import com.houserental.entity.tenant.Tenant;
import com.houserental.repository.landlord.LandlordRepo;
import com.houserental.repository.review.ReviewRepo;
import com.houserental.repository.tenant.TenantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cheyikung on 4/19/16.
 */

@Service
public class TenantServicesImpl implements TenantServices {

    @Autowired
    private LandlordRepo landlordRepo;

    @Autowired
    private TenantRepo tenantRepo;

    @Autowired
    private ReviewRepo reviewRepo;


    @Override
    public Tenant findTenantByFbId(String fbId) {
        return tenantRepo.findByFbId(fbId);
    }

    @Override
    public void addTenant(Tenant tenant) {
        tenantRepo.save(tenant);
    }

    @Override
    public void overrideTenant(Tenant tenant) {
        tenantRepo.save(tenant);
    }


    @Override
    public List<HouseInfo> listAllHouseInfo() {
        List<HouseInfo> houseInfos = new ArrayList<HouseInfo>();
        Iterable<Landlord> landlords = landlordRepo.findAll();
        for (Landlord landlord : landlords) {
            houseInfos.addAll(landlord.getHouseInfoList());
        }
        return houseInfos;
    }

    @Override
    public List<HouseInfo> searchByLocation(double lat, double lng, double distance) {
        List<HouseInfo> houseInfos = new ArrayList<HouseInfo>();
        Iterable<Landlord> landlords = landlordRepo.findAll();
        for (Landlord landlord : landlords) {
            houseInfos.addAll(landlord.getHouseInfoList());
        }

        for (Iterator<HouseInfo> iterator = houseInfos.iterator(); iterator.hasNext(); ) {
            HouseInfo houseInfo = iterator.next();
            double dist = distanceCalculator(lat, lng, houseInfo.getAddress().getLatitude(), houseInfo.getAddress().getLongitude());
            if (dist > distance) {
                iterator.remove();
            }
        }

        return houseInfos;
    }

    public void addressmatching(List<HouseInfo> houseInfos, String content){

        Pattern r = null;
        String pattern = "(.*)";
        content = content.toLowerCase();
        Iterable<Landlord> landlords = landlordRepo.findAll();
        for (Landlord landlord : landlords) {
            houseInfos.addAll(landlord.getHouseInfoList());
        }
        for (Iterator<HouseInfo> iterator = houseInfos.iterator(); iterator.hasNext(); ) {
            HouseInfo houseInfo = iterator.next();
            String fulladd = houseInfo.getAddress().getAddress()+" "+houseInfo.getAddress().getCity() + " "+houseInfo.getAddress().getState();
            fulladd=fulladd.toLowerCase();
            r = Pattern.compile(pattern+content+pattern);
            Matcher m = r.matcher(fulladd);
            if(!m.find()){
                iterator.remove();
            }
        }
    }

    @Override
    public List<HouseInfo> searchByCriteria(HouseSchCri criteria) {
        List<HouseInfo> houseInfos=new ArrayList<HouseInfo>();
        Iterable<Landlord> landlords = null;
        String pattern = "(.*)";
        String content="";
        if(criteria.getAddress()==null||criteria.getAddress().equals(""))//user search by clicking the search button in detail searching screen
        {
            if((criteria.getCity()==null||criteria.getCity().equals(""))&&(criteria.getState()==null||criteria.getState().equals("")))
            {
                houseInfos = searchByLocation(criteria.getLat(), criteria.getLng(), 1000);
            }
            else
            {
                String city = criteria.getCity()==null?"":criteria.getCity().trim();
                String state = criteria.getState()==null?"":criteria.getState().trim();
                content = city+pattern+state;
                addressmatching(houseInfos, content);
            }
        }
        else    //user search by clicking the description searching on the top of screen
        {
            content = criteria.getAddress();
            addressmatching(houseInfos, content);
        }

        for (Iterator<HouseInfo> iterator = houseInfos.iterator(); iterator.hasNext(); ) {
            HouseInfo houseInfo = iterator.next();
            if(criteria.getPropertyType()!=null&&!criteria.getPropertyType().equals("")&&!criteria.getPropertyType().equals("All")&&!criteria.getPropertyType().equals(houseInfo.getPropertyType())
                    || criteria.getPriceL()>0&&criteria.getPriceL()>houseInfo.getPrice()
                    || criteria.getPriceH()>0&&criteria.getPriceH()<houseInfo.getPrice()
                    || houseInfo.getStatus()!=null&&houseInfo.getStatus().equals("Cancelled")
                    )
            {
                iterator.remove();
            }
        }
        return houseInfos;
    }

    @Override
    public String incrementViewCount(String houseId, String landlordFbId) {
        Landlord landlord = landlordRepo.findByFbId(landlordFbId);
        List<HouseInfo> houseInfoList = landlord.getHouseInfoList();
        boolean isFound = false;
        for(int i = 0; i < houseInfoList.size(); i++){
            HouseInfo houseInfo = houseInfoList.get(i);
            if(houseInfo.getHouseId().equals(houseId)){
                int numOfViews = houseInfo.getNumOfViews();
                numOfViews++;
                houseInfo.setNumOfViews(numOfViews);
                houseInfoList.set(i, houseInfo);
                isFound = true;
                break;
            }
        }
        if(isFound) {
            landlord.setHouseInfoList(houseInfoList);
            landlordRepo.save(landlord);
            return null;
        }
        return "can't add view count";
    }


    private static double distanceCalculator(double lat1, double lng1, double lat2, double lng2) {
        double theta = lng1 - lng2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        return dist;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }


}
