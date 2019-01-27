package com.ignore.common.cache.local.support.strategy.impl;

import com.ignore.common.cache.local.support.annotation.LocalCacheable;
import com.ignore.common.cache.local.support.interceptor.generator.CacheKeyGenerator;
import com.ignore.common.cache.local.support.interceptor.generator.impl.DefaultLocalCacheKeyGenerator;
import com.ignore.common.cache.local.support.interceptor.generator.impl.SimpleLocalCacheKeyGenerator;
import com.ignore.common.cache.local.support.interceptor.resolver.CacheVauleResolver;
import com.ignore.common.cache.local.support.interceptor.resolver.impl.DefaultCacheVauleResolver;
import com.ignore.common.cache.local.support.interceptor.resolver.impl.SimpleCacheVauleResolver;
import com.ignore.common.cache.local.support.strategy.LocalCacheableStrategy;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:05 2019/1/15
 */
public abstract class AbstractCacheStrategy implements LocalCacheableStrategy{
    protected LocalCacheable localCacheable;

    public AbstractCacheStrategy(LocalCacheable localCacheable){
        this.localCacheable = localCacheable;
    }

    @Override
    public CacheKeyGenerator getKeyGenerator() {
        if (StringUtils.isNotBlank(localCacheable.key())){
            //指定了key值则不使用key生成器
            return null;
        }
        switch (localCacheable.keyGenerator()){
            case SIMPLE:
                return new SimpleLocalCacheKeyGenerator();
            default:
                return new DefaultLocalCacheKeyGenerator();
        }
    }

    @Override
    public CacheVauleResolver getCacheResolver() {
        switch (localCacheable.cacheResolver()){
            case SIMPLE:
                return new SimpleCacheVauleResolver(localCacheable.valueType());
            default:
                return new DefaultCacheVauleResolver(localCacheable.valueType());
        }
    }
}
