package com.houserental.controller;

import com.houserental.entity.HouseSchCri;
import com.houserental.entity.landlord.Address;
import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.landlord.Landlord;
import com.houserental.entity.tenant.Favorite;
import com.houserental.entity.tenant.Tenant;
import com.houserental.service.landlord.LandlordServices;
import com.houserental.service.tenant.TenantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by ivanybma on 4/16/16.
 */
@RestController
public class main_controller {

    @Autowired
    LandlordServices landlordServices;
    @Autowired
    TenantServices tenantServices;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome() {
        return "hello";
    }

    @RequestMapping(value = "/landlordLogin", method = RequestMethod.POST)
    public ResponseEntity landlordLogIn(@RequestBody Landlord landlord){
        String fbId = landlord.getFacebookId();

        if(findLandlordByFbId(fbId) == false){
            landlordServices.addLandlord(landlord);
        }else{
            Landlord localLandlord = landlordServices.findLandlordByFbId(fbId);
            landlord.setLandlordId(localLandlord.getLandlordId());
            landlordServices.overrideLandlord(landlord);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    private boolean findLandlordByFbId(String fbId){
        if(landlordServices.findLandlordByFbId(fbId)!= null){
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/landlordAddHouse", method = RequestMethod.POST)
    public ResponseEntity<?> landlordAddHouse(@RequestBody HouseInfo houseInfo){
        landlordServices.addHouse(houseInfo.getLandlordFbId(), houseInfo);
        return new ResponseEntity<Objects>(null, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/landlordUpdateHouse/{houseId}", method = RequestMethod.POST)
    public ResponseEntity<?> landlordUpdateHouse(@RequestBody HouseInfo houseInfo, @PathVariable("houseId") String houseId){
        landlordServices.editHouse(houseInfo.getLandlordFbId(), houseId, houseInfo);
        return new ResponseEntity<Objects>(null, null, HttpStatus.OK);
    }

    @RequestMapping(value = "/landlordChangeHouseStatus/{houseId}/{status}", method = RequestMethod.POST)
    public ResponseEntity<?> landlordChangeHouseStatus(@RequestBody HouseInfo houseInfo, @PathVariable("houseId") String houseId, @PathVariable("status") String status){
        landlordServices.changeHouseStatus(houseInfo.getLandlordFbId(), houseId, status);
        return new ResponseEntity<Objects>(null, null, HttpStatus.OK);
    }

    /* ------------------------- */

    @RequestMapping(value = "/tenantLogin", method = RequestMethod.POST)
    public ResponseEntity tenantLogIn(@RequestBody Tenant tenant){
        String fbId = tenant.getFacebookId();

        if(findTenantdByFbId(fbId) == false){
            tenantServices.addTenant(tenant);
        }else{
            Tenant localTenant = tenantServices.findTenantByFbId(fbId);
            tenant.setTenantId(localTenant.getTenantId());
            tenantServices.overrideTenant(tenant);
        }

        return new ResponseEntity(HttpStatus.OK);
    }

    private boolean findTenantdByFbId(String fbId){
        if(tenantServices.findTenantByFbId(fbId)!= null){
            return true;
        }
        return false;
    }




    @RequestMapping(value="/tenant", method = RequestMethod.GET)
    public Tenant tenant_testing() {

        System.out.println("xxx");
        Favorite test_favorite = new Favorite();
        test_favorite.setHouseId("0001");
        test_favorite.setLandlordfbId("ivan");
        List<Favorite> fl = new ArrayList<Favorite>();
        fl.add(test_favorite);

        test_favorite = new Favorite();
        test_favorite.setHouseId("0002");
        test_favorite.setLandlordfbId("ivan");
        fl.add(test_favorite);

        Tenant test_tenant = new Tenant();
        test_tenant.setName("Peter");
        test_tenant.setTenantId("0001");
        test_tenant.setFavoriteList(fl);

        return test_tenant;
//        return new ResponseEntity<Tenant>(test_tenant, HttpStatus.OK);
    }

    @RequestMapping(value="/landlord", method = RequestMethod.GET)
    public Landlord landlord_testing() {


        List<HouseInfo> house_list = new ArrayList<HouseInfo>();
        HouseInfo test_house = new HouseInfo();
        test_house.setHouseId("0001");
        test_house.setStatus("open");
        Address test_address = new Address();
        test_address.setAddress("1 Washington Sq");
        test_address.setCity("san jose");
        test_address.setState("ca");
        test_house.setAddress(test_address);

        house_list.add(test_house);

        test_house = new HouseInfo();
        test_house.setHouseId("0002");
        test_house.setStatus("open");
        test_address = new Address();
        test_address.setAddress("1300 Evans Ave");
        test_address.setCity("San Francisco");
        test_address.setState("ca");
        test_house.setAddress(test_address);
        house_list.add(test_house);

        Landlord test_landlord = new Landlord();
        test_landlord.setName("ivan");
        test_landlord.setEmail("ivanybma@yahoo.com");
        test_landlord.setPhoneNum("415-361-2832");
        test_landlord.setHouseInfoList(house_list);

        return test_landlord;
    }

    @RequestMapping(value="/house_list", method = RequestMethod.GET)
    public List<HouseInfo> house_list_testing() {

        List<HouseInfo> house_list = new ArrayList<HouseInfo>();
        HouseInfo test_house = new HouseInfo();
        test_house.setDescription("This room is for short term renting, tenant need to move out before end of year");
        test_house.setHouseId("0001");
        test_house.setStatus("open");
        Address test_address = new Address();
        test_address.setAddress("1 Washington Sq");
        test_address.setCity("san jose");
        test_address.setState("ca");
        test_house.setAddress(test_address);

        house_list.add(test_house);

        test_house = new HouseInfo();
        test_house.setHouseId("0002");
        test_house.setStatus("open");
        test_house.setDescription("This house need to be rent at least 6 months");
        test_address = new Address();
        test_address.setAddress("1300 Evans Ave");
        test_address.setCity("San Francisco");
        test_address.setState("ca");
        test_house.setAddress(test_address);
        house_list.add(test_house);

        if(tenantServices.listAllHouseInfo().size()==0)
            return house_list;
        else
            return tenantServices.listAllHouseInfo();



    }


    @RequestMapping(value="/search_house_list", method = RequestMethod.POST)
    public List<HouseInfo> search_house_list(@RequestBody HouseSchCri criteria) {

        criteria.getLat();
        criteria.getLng();
        criteria.getAddress();
        criteria.getCity();
        criteria.getPriceH();
        criteria.getPriceL();
        criteria.getPropertyType();

        List<HouseInfo> schlst  = tenantServices.searchByCriteria(criteria);


            return schlst;

    }



    @RequestMapping(value="/addhouse/{fbid}/{address}/{city}/{price}", method = RequestMethod.POST)
    public void addhouse(@PathVariable("fbid") String fbid, @PathVariable("address") String address,@PathVariable("city") String city, @PathVariable("price") String price) {
        HouseInfo test_house = new HouseInfo();
        test_house.setLandlordFbId(fbid);
        test_house.setStatus("open");
        Address test_address = new Address();
        test_address.setAddress(address);
        test_address.setCity(city);
        test_address.setState("ca");
        test_house.setAddress(test_address);
        test_house.setPrice(Double.valueOf(price));
        landlordServices.addHouse(fbid, test_house);
    }

    @RequestMapping(value="/addlandlord/{name}/{fbid}", method = RequestMethod.POST)
    public Landlord addLandlord(@PathVariable("name") String name, @PathVariable("fbid") String fbid) {

        Landlord landlord=new Landlord();
        landlord.setName(name);
        landlord.setFacebookId(fbid);
        return landlordServices.newLandlord(landlord);

    }


    @RequestMapping(value = "/testLandlordLogin", method = RequestMethod.GET)
    public void testLandLordLogin(){
        Landlord landlord = new Landlord("000", "jack", "12345678", "jack@gmail.com");
        landlordLogIn(landlord);
    }


}
