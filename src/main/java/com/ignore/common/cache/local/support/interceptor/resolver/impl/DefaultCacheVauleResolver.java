package com.ignore.common.cache.local.support.interceptor.resolver.impl;


import com.ignore.common.cache.local.support.entity.CacheValue;

/**
 * @Author: ignore1992
 * @Description: 默认缓存解析器
 * @Date: Created In 16:11 2019/1/15
 */
public class DefaultCacheVauleResolver extends AbstractCacheValueResolver{

    public DefaultCacheVauleResolver(Class<?> valueType){
        super(valueType);
    }

    @Override
    public String serialValue(Object value , int expireInterval) {
        if (value == null){
            return null;
        }
        return value.toString();
    }

    @Override
    public CacheValue deserialValue(String value) {
        CacheValue cacheValue = new CacheValue();
        cacheValue.setValue(value);
        return cacheValue;
    }
}
