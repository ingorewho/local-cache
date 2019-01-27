package com.ignore.common.cache.local.support.container;

import lombok.ToString;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: ignore1992
 * @Description: 二级缓存容器枚举
 * @Date: 2019/1/12
 */
@ToString
public enum  CacheContainerEnum {
    SAFEMAP_CACHE_CONTAINER("ConcurrentHashMap", ConcurrentHashMap.class);

    /**缓存容器名称.**/
    private String name;
    /**缓存容器类型.**/
    private Class<?> clazz;

    private CacheContainerEnum(String name, Class<?> clazz){
        this.name = name;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
