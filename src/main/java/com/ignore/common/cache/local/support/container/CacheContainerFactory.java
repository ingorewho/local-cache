package com.ignore.common.cache.local.support.container;

import com.ignore.common.cache.local.support.container.impl.SafeMapCacheContainer;

/**
 * @Author: ignore1992
 * @Description: 二级缓存容器工厂
 * @Date: 2019/1/12
 */
public final class CacheContainerFactory {
    public static CacheContainer getContainer(CacheContainerDefinition containerDefinition){
        switch (containerDefinition.getContainerEnum()){
            case SAFEMAP_CACHE_CONTAINER:
                return new SafeMapCacheContainer(containerDefinition.getContainerSize());
            default:
                return null;
        }
    }
}
