package com.bikepool.dao;

import com.bikepool.dto.BikeUser;

/**
 * Created by rampal on 5/11/17.
 */
public interface BikeUserDao {
    BikeUser getBikeUser(String username);
}
