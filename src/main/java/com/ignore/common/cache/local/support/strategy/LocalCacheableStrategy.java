package com.ignore.common.cache.local.support.strategy;

import com.ignore.common.cache.local.service.impl.AbstractLocalCacheService;
import com.ignore.common.cache.local.support.interceptor.generator.CacheKeyGenerator;
import com.ignore.common.cache.local.support.interceptor.resolver.CacheVauleResolver;

/**
 * @Author: ignore1992
 * @Description: 本地缓存策略接口
 * @Date: 2019/1/13
 */
public interface LocalCacheableStrategy {
    CacheKeyGenerator getKeyGenerator();

    CacheVauleResolver getCacheResolver();

    Class<? extends AbstractLocalCacheService> getCacheServiceClass();
}
