package com.bikepool.schedular;

import com.bikepool.service.BikeShareCacheLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Created by rampal on 15/11/17.
 */
@Component("bikeShareSchedular")
public class BikeShareSchedular {
    private static final Logger LOG = LoggerFactory.getLogger(BikeShareSchedular.class);

    @Autowired
    private BikeShareCacheLoader cacheLoader;

    private static boolean contextInitialized;

    @Scheduled(fixedRate = 3 * 60 * 1000)
    public void loadCache() {
        if (isContextInitialized()) {
            LOG.info("Started loading cache..");
            cacheLoader.loadBikeShareUserCache();
            LOG.info("Finished loading cache.");
        }
    }

    private boolean isContextInitialized() {
        if (contextInitialized)
            return true;
        if (null != ContextLoader.getCurrentWebApplicationContext() && null != ContextLoader.getCurrentWebApplicationContext().getServletContext()) {
            WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(ContextLoader.getCurrentWebApplicationContext().getServletContext());
            String context = (String) applicationContext.getServletContext().getAttribute("contextInitialized");
            contextInitialized = Boolean.parseBoolean(context);
        }
        return contextInitialized;
    }
}
