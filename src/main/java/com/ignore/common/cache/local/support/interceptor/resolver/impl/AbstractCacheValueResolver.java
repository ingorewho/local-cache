package com.ignore.common.cache.local.support.interceptor.resolver.impl;

import com.ignore.common.cache.local.support.entity.CacheValue;
import com.ignore.common.cache.local.support.interceptor.resolver.CacheVauleResolver;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:32 2019/1/16
 */
public abstract class AbstractCacheValueResolver implements CacheVauleResolver{
    protected Class<?> valueType;
    /**空对象.**/
    protected CacheValue emptyCacheValue = new CacheValue();

    public AbstractCacheValueResolver(Class<?> valueType){
        this.valueType = valueType;
    }
}
