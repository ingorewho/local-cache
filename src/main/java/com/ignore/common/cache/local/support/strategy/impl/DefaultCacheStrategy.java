package com.ignore.common.cache.local.support.strategy.impl;

import com.ignore.common.cache.local.service.impl.AbstractLocalCacheService;
import com.ignore.common.cache.local.service.impl.DefaultCacheService;
import com.ignore.common.cache.local.support.annotation.LocalCacheable;

/**
 * @Author: ignore1992
 * @Description: 默认缓存策略
 * @Date: Created In 16:03 2019/1/15
 */
public class DefaultCacheStrategy extends AbstractCacheStrategy{

    public DefaultCacheStrategy(LocalCacheable localCacheable){
        super(localCacheable);
    }

    @Override
    public Class<? extends AbstractLocalCacheService> getCacheServiceClass() {
        return DefaultCacheService.class;
    }
}
