package com.bikepool.controller;

import com.bikepool.cache.BikeShareUserCache;
import com.bikepool.cache.CacheManager;
import com.bikepool.dto.BikeShareUser;
import com.bikepool.service.BikePoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by rampal on 7/11/17.
 */
@Controller
public class BikePoolController {

    private static final Logger logger = LoggerFactory.getLogger(BikePoolController.class);

    @Autowired
    private BikePoolService bikePoolService;

    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping(value = "/service/getCities")
    @GET
    @ResponseBody
    public List<String> getCities() {
        logger.info("Getting city list...");
        return bikePoolService.getCities();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping(value = "/service/getAllBikeShares")
    @GET
    @ResponseBody
    public List<BikeShareUser> getAllBikeShares() {
        logger.info("Getting BikeShare list...");
        BikeShareUserCache cache=CacheManager.getInstance().getCache(BikeShareUserCache.class);
        return cache.getShareUser();
    }
}
