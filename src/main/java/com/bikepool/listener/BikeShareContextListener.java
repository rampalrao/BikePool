package com.bikepool.listener;

import com.bikepool.cache.IAerospikeService;
import com.bikepool.properties.BikeShareProperties;
import com.bikepool.service.BikeShareCacheLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by rampal on 15/11/17.
 */
public class BikeShareContextListener implements ServletContextListener {
    private static final Logger LOG = LoggerFactory.getLogger(BikeShareContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("Context initialized event started...");
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        loadAerospikeClient(context);
        loadCache(context);
        sce.getServletContext().setAttribute("contextInitialized", "true");
        LOG.info("Context initialized event completed...");
    }

    private void loadCache(WebApplicationContext context) {
        BikeShareCacheLoader cacheLoader=context.getBean(BikeShareCacheLoader.class);
        cacheLoader.loadBikeShareUserCache();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
     //default implementation
    }

    public void loadAerospikeClient(WebApplicationContext context) {
        IAerospikeService aerospikeService = context.getBean(IAerospikeService.class);
        BikeShareProperties properties = context.getBean(BikeShareProperties.class);
        try {
            LOG.info("Starting to load aerospike client");
            aerospikeService.loadAerospikeClient(properties.getProperty("aerospike.hosts"));
            LOG.info("Aerospike client loaded successfully ");
        } catch (Exception e) {
            throw new RuntimeException("Could not initialise aerospike client", e);
        }
    }
}
