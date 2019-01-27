package com.ignore.common.cache.local.support.config;

import com.ignore.common.cache.local.support.scheduler.LocalCacheScheduler;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:48 2019/1/16
 */
public class LocalCacheConfigSupport implements LocalCacheConfig{
    @Override
    public LocalCacheScheduler localCacheScheduler() {
        return null;
    }
}
