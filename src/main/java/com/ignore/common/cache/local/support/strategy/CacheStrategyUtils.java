package com.ignore.common.cache.local.support.strategy;

import com.ignore.common.cache.local.support.annotation.LocalCacheable;
import com.ignore.common.cache.local.support.strategy.impl.DefaultCacheStrategy;
import com.ignore.common.cache.local.support.strategy.impl.SafeMapCacheStrategy;

/**
 * @Author: ignore1992
 * @Description: 获取缓存策略工具类
 * @Date: Created In 16:23 2019/1/15
 */
public class CacheStrategyUtils {

    public static LocalCacheableStrategy getCacheableStrategy(LocalCacheable localCacheable){
        switch (localCacheable.type()){
            case SAFE_MAP:
                return new SafeMapCacheStrategy(localCacheable);
            default:
                return new DefaultCacheStrategy(localCacheable);
        }
    }
}
