package com.ignore.common.cache.local.support.interceptor.resolver.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ignore.common.cache.local.support.entity.CacheValue;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: ignore1992
 * @Description: simple缓存解析器
 * @Date: 2019/1/12
 */
public class SimpleCacheVauleResolver extends AbstractCacheValueResolver{

    public SimpleCacheVauleResolver(Class<?> valueType){
        super(valueType);
    }
    @Override
    public String serialValue(Object value, int expireInterval) {
        //计算有效期
        long expireTime = System.currentTimeMillis() + expireInterval * 1000L;
        CacheValue cacheValue = new CacheValue(value, expireTime);
        return JSON.toJSONString(cacheValue);
    }

    @Override
    public CacheValue deserialValue(String value) {
        if (StringUtils.isNotBlank(value)){
            CacheValue cacheValue = JSONObject.toJavaObject(JSON.parseObject(value), CacheValue.class);
            Class clzz = valueType.getClass();
            cacheValue.setValue(JSONObject.parseObject(JSONObject.toJSONString(cacheValue.getValue()), valueType));
            if (cacheValue.getExpireTime() < System.currentTimeMillis()){
                return emptyCacheValue;
            }
            return cacheValue;
        }
        return emptyCacheValue;
    }
}
