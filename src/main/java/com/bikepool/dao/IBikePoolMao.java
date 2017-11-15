package com.bikepool.dao;

import com.bikepool.dto.BikeShareUserModel;
import com.bikepool.dto.CityDTO;

/**
 * Created by rampal on 7/11/17.
 */
public interface IBikePoolMao {
    CityDTO getCities();
    BikeShareUserModel getBikeShareUsers();
}
