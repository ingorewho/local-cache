package com.ignore.common.cache.local.support.interceptor.generator;

import com.ignore.common.cache.local.support.annotation.wraper.CacheKey;

/**
 * @Author: ignore1992
 * @Description: 缓存key生成接口
 * @Date: Created In 15:41 2019/1/14
 */
public interface CacheKeyGenerator {
    String generate(CacheKey cacheKey);
}
