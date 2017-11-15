package com.bikepool.dao.impl;

import com.bikepool.dao.IBikePoolMao;
import com.bikepool.dto.BikeShareUserModel;
import com.bikepool.dto.CityDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rampal on 7/11/17.
 */
@Repository("bikePoolMao")
public class BikePoolMaoImpl implements IBikePoolMao {

    private static final Logger LOG = LoggerFactory.getLogger(BikePoolMaoImpl.class);

    @Autowired
    @Qualifier("mongoTemplateBikePool")
    private MongoOperations mongoOperations;

    @Override
    public CityDTO getCities() {

        if (!mongoOperations.collectionExists(CityDTO.class)) {
            return null;
        }
        List<CityDTO> list = mongoOperations.findAll(CityDTO.class);
        if (list != null && list.isEmpty()) {
            return new CityDTO();
        }
        return list.get(0);
    }

    @Override
    public BikeShareUserModel getBikeShareUsers() {

        if (!mongoOperations.collectionExists(BikeShareUserModel.class)) {
            return null;
        }
        List<BikeShareUserModel> list = mongoOperations.findAll(BikeShareUserModel.class);
        if (list != null && list.isEmpty()) {
            return new BikeShareUserModel();
        }
        return list.get(0);
    }
}
