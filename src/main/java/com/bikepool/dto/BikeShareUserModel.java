package com.bikepool.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Created by rampal on 15/11/17.
 */
@Document(collection="bikeShareUserModel")
public class BikeShareUserModel implements Serializable{
    List<BikeShareUser> shareUsers;

    public List<BikeShareUser> getShareUsers() {
        return shareUsers;
    }

    public void setShareUsers(List<BikeShareUser> shareUsers) {
        this.shareUsers = shareUsers;
    }
}
