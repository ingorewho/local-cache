package com.ignore.common.cache.local.support.interceptor.resolver;


import com.ignore.common.cache.local.support.entity.CacheValue;

/**
 * @Author: ignore1992
 * @Description: 本地缓存解析器
 * @Date: 2019/1/12
 */
public interface CacheVauleResolver {
    String serialValue(Object value, int expireInterval);

    CacheValue deserialValue(String value);
}
