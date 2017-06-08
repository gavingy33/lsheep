package com.lsheep.middleware.cache.factory;

import com.lsheep.middleware.cache.Cache;
import com.lsheep.middleware.cache.CacheConfig;

public interface CacheFactory {

	Cache getCache(CacheConfig cacheConfig);

}
