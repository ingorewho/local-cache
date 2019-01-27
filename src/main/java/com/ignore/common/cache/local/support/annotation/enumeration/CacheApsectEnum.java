package com.ignore.common.cache.local.support.annotation.enumeration;

import com.ignore.common.cache.local.support.annotation.LocalCacheableApsect;

/**
 * @Author: ignore1992
 * @Description: 缓存切面扫描枚举类
 * @Date: 2019/1/13
 */
public enum CacheApsectEnum {

    DEFAULT_ASPECT(LocalCacheableApsect.class);

    private Class<?> aspect;

    private CacheApsectEnum(Class<?> aspect){
        this.aspect = aspect;
    }

    public Class<?> getAspect() {
        return aspect;
    }
}
