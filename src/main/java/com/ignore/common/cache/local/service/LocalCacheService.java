package com.ignore.common.cache.local.service;

/**
 * @Author: ignore1992
 * @Description: 本地缓存接口类
 * @Date: Created In 16:57 2019/1/11
 */
public interface LocalCacheService {
    /**
     * 执行put操作，返回value值
     * @param key
     * @param value
     * @return
     */
    String put(String key, String value);

    /**
     * 执行remove操作，返回value值
     * @param key
     * @return
     */
    String remove(String key);

    /**
     * 删除容器中所有元素
     * @see com.ignore.common.cache.local.support.container.CacheContainer
     */
    void removeAll();
    /**
     * 执行get操作，返回value值
     * @param key
     * @return
     */
    String get(String key);
}
