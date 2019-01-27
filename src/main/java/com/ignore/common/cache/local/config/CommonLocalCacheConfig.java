package com.ignore.common.cache.local.config;

import com.ignore.common.cache.local.support.annotation.EnableLocalCache;
import com.ignore.common.cache.local.support.config.LocalCacheConfigSupport;
import com.ignore.common.cache.local.support.scheduler.LocalCacheScheduler;
import com.ignore.common.cache.local.support.scheduler.impl.RegularLocalCacheScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ignore1992
 * @Description: 本地缓存配置类
 * @Date: Created In 14:48 2019/1/14
 */
@Configuration
@EnableLocalCache(enable = true)
public class CommonLocalCacheConfig extends LocalCacheConfigSupport {

    @Override
    @Bean
    public LocalCacheScheduler localCacheScheduler() {
        RegularLocalCacheScheduler scheduler = new RegularLocalCacheScheduler();
        return scheduler;
    }
}
