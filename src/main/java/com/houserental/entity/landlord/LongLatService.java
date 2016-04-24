package com.houserental.entity.landlord;

/**
 * Created by cheyikung on 4/19/16.
 */

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LongLatService {

    private static final String GEOCODE_REQUEST_URL = "http://maps.googleapis.com/maps/api/geocode/json?sensor=false&";

    private double lat;
    private double lng;

    private static LongLatService instance;

    private LongLatService() {
    }

    public static synchronized LongLatService getInstance() {
        if (instance == null) {
            instance = new LongLatService();
        }
        return instance;
    }

    public void setAddress(String address) {
        StringBuilder urlBuilder = new StringBuilder(GEOCODE_REQUEST_URL);
        if (StringUtils.isNotBlank(address)) {
            try {
                urlBuilder.append("&address=").append(URLEncoder.encode(address, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(urlBuilder.toString(), String.class);
            JSONObject jsonObj = new JSONObject(result);
            if (jsonObj.get("status").toString().equals("OK")) {
                JSONArray jsonArray = jsonObj.getJSONArray("results");


                JSONObject result1 = new JSONObject(jsonArray.get(0).toString());

                JSONObject geometry = result1.getJSONObject("geometry");

                JSONObject location = geometry.getJSONObject("location");


                lat = location.getDouble("lat");
                lng = location.getDouble("lng");
            }
        }
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}

