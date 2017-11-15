package com.bikepool.dto;

import org.luaj.vm2.ast.Str;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by rampal on 15/11/17.
 */
public class BikeShareUser implements Serializable {
    private String userName;
    private String origin;
    private String destination;
    private String viaRoute;
    private String travelDays;
    private String startTime;
    private String returnTime;
    private String mobileNo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getViaRoute() {
        return viaRoute;
    }

    public void setViaRoute(String viaRoute) {
        this.viaRoute = viaRoute;
    }

    public String getTravelDays() {
        return travelDays;
    }

    public void setTravelDays(String travelDays) {
        this.travelDays = travelDays;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
