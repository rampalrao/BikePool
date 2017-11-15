package com.bikepool.cache;

import com.bikepool.annotation.Cache;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by rampal on 15/11/17.
 */
public class CacheManager {
    private static final Logger LOG = LoggerFactory.getLogger(CacheManager.class);
    private static CacheManager _instance = new CacheManager();
    private Map<String, Object> _caches = new ConcurrentHashMap();
    private static final List<CacheChangeListner> _listners = new ArrayList();

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        return _instance;
    }

    public Object getCache(String cacheName) {
        Object cache = this._caches.get(cacheName);
        return cache;
    }

    public Object getCacheByName(String cacheName) {
        return this.getCache(cacheName);
    }

    public <T> T getCache(Class<T> cacheClass) {
        if(cacheClass.isAnnotationPresent(Cache.class)) {
            return (T)this.getCache(((Cache)cacheClass.getAnnotation(Cache.class)).name());
        } else {
            throw new IllegalArgumentException("@Cache annotation should be present for cache class:" + cacheClass.getName());
        }
    }

    public synchronized void setCache(Object cache) {
        Class<? extends Object> cacheClass = cache.getClass();
        if(cacheClass.isAnnotationPresent(Cache.class)) {
            Method[] arr$ = cacheClass.getDeclaredMethods();
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Method m = arr$[i$];
                if("freeze".equals(m.getName())) {
                    try {
                        m.invoke(cache, new Object[0]);
                    } catch (Exception var8) {
                        LOG.error("unable to freeze cache:" + cacheClass.getName(), var8);
                    }
                }
            }

            Cache annotation = (Cache)cacheClass.getAnnotation(Cache.class);
            this._caches.put(annotation.name(), cache);
            this.signalListners();
        } else {
            throw new IllegalArgumentException("@Cache annotation should be present for cache class:" + cache.getClass().getName());
        }
    }

    private void signalListners() {
        Iterator i$ = _listners.iterator();

        while(i$.hasNext()) {
            CacheManager.CacheChangeListner listner = (CacheManager.CacheChangeListner)i$.next();

            try {
                listner.reloadCache();
            } catch (Exception var4) {
                LOG.error("Error while signalling {} listner for cache change. Error: {}", listner.getClass().getName(), ExceptionUtils.getFullStackTrace(var4));
            }
        }

    }

    public static void registerListner(CacheManager.CacheChangeListner listner) {
        _listners.add(listner);
    }

    public interface CacheChangeListner {
        void reloadCache();
    }
}
