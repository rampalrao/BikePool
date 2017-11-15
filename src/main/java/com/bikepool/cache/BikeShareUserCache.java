package com.bikepool.cache;

import com.bikepool.annotation.Cache;
import com.bikepool.dto.BikeShareUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rampal on 15/11/17.
 */
@Cache(name="shareUserCache")
public class BikeShareUserCache implements Serializable{

    private List<BikeShareUser> shareUser=new ArrayList<>();

    public List<BikeShareUser> getShareUser() {
        return shareUser;
    }

    public void setShareUser(List<BikeShareUser> shareUser) {
        this.shareUser = shareUser;
    }
}
