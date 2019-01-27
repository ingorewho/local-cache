package com.ignore.common.cache.local.support.config;

import com.ignore.common.cache.local.support.scheduler.LocalCacheScheduler;

/**
 * @Author: ignore1992
 * @Description: 本地缓存配置支持类
 * @Date: Created In 16:38 2019/1/16
 */
public interface LocalCacheConfig {

    LocalCacheScheduler localCacheScheduler();
}
