package com.bikepool.service;

import com.bikepool.cache.BikeShareUserCache;
import com.bikepool.cache.CacheManager;
import com.bikepool.dao.IBikePoolMao;
import com.bikepool.dto.BikeShareUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rampal on 15/11/17.
 */
@Service("bikeShareCacheLoader")
public class BikeShareCacheLoader {

    @Autowired
    private IBikePoolMao bikePoolMao;

    public void loadBikeShareUserCache() {
        BikeShareUserCache cache = new BikeShareUserCache();
        BikeShareUserModel shareUserModel = bikePoolMao.getBikeShareUsers();
        cache.setShareUser(shareUserModel.getShareUsers());
        CacheManager.getInstance().setCache(cache);
    }
}
