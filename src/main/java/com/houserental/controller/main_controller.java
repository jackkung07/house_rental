package com.houserental.controller;

import com.houserental.entity.landlord.Address;
import com.houserental.entity.landlord.HouseInfo;
import com.houserental.entity.landlord.Landlord;
import com.houserental.entity.tenant.Favorite;
import com.houserental.entity.tenant.Tenant;
import com.houserental.service.landlord.LandlordServices;
import com.houserental.service.tenant.TenantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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


    @RequestMapping(value="/tenant", method = RequestMethod.GET)
    public Tenant tenant_testing() {

        System.out.println("xxx");
        Favorite test_favorite = new Favorite();
        test_favorite.setHouseId("0001");
        test_favorite.setLandlordName("ivan");
        List<Favorite> fl = new ArrayList<Favorite>();
        fl.add(test_favorite);

        test_favorite = new Favorite();
        test_favorite.setHouseId("0002");
        test_favorite.setLandlordName("ivan");
        fl.add(test_favorite);

        Tenant test_tenant = new Tenant("Petter");
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
        test_landlord.setHouseOwned(house_list);

        return test_landlord;
    }

    @RequestMapping(value="/house_list", method = RequestMethod.GET)
    public List<HouseInfo> house_list_testing() {

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

        if(tenantServices.listAllHouseInfo().size()==0)
            return house_list;
        else
            return tenantServices.listAllHouseInfo();



    }

    @RequestMapping(value="/addhouse/{ldname}/{address}/{city}", method = RequestMethod.POST)
    public void addhouse(@PathVariable("ldname") String ldname, @PathVariable("address") String address,@PathVariable("city") String city) {
        HouseInfo test_house = new HouseInfo();
        test_house.setlandlordName(ldname);
        test_house.setStatus("open");
        Address test_address = new Address();
        test_address.setAddress(address);
        test_address.setCity(city);
        test_address.setState("ca");
        test_house.setAddress(test_address);
        landlordServices.addHousing(ldname, test_house);
    }

    @RequestMapping(value="/addlandlord/{name}", method = RequestMethod.POST)
    public Landlord addLandlord(@PathVariable("name") String name) {

        Landlord landlord=new Landlord();
        landlord.setName(name);
        return landlordServices.newLandlord(landlord);

    }


}
