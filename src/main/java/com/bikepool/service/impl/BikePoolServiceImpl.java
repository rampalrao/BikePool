package com.bikepool.service.impl;

import com.bikepool.dao.IBikePoolMao;
import com.bikepool.dto.CityDTO;
import com.bikepool.service.BikePoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rampal on 7/11/17.
 */
@Service("bikePoolService")
public class BikePoolServiceImpl implements BikePoolService {

    @Autowired
    private IBikePoolMao bikePoolMao;

    @Override
    public List<String> getCities() {
        CityDTO city = bikePoolMao.getCities();
        return city.getCityList();
    }
}
