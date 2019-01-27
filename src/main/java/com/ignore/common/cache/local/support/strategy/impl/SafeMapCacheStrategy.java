package com.ignore.common.cache.local.support.strategy.impl;

import com.ignore.common.cache.local.service.impl.AbstractLocalCacheService;
import com.ignore.common.cache.local.service.impl.SafeMapCacheService;
import com.ignore.common.cache.local.support.annotation.LocalCacheable;

/**
 * @Author: ignore1992
 * @Description: 安全map缓存策略
 * @Date: 2019/1/13
 */
public class SafeMapCacheStrategy extends AbstractCacheStrategy{
    public SafeMapCacheStrategy(LocalCacheable localCacheable){
        super(localCacheable);
    }

    @Override
    public Class<? extends AbstractLocalCacheService> getCacheServiceClass() {
        return SafeMapCacheService.class;
    }
}
