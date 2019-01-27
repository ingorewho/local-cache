package com.ignore.common.cache.local.support.container;

/**
 * 缓存容器
 */
public interface CacheContainer<K> extends Iterable{

    String put(K key, String value);

    String get(K key);

    String remove(K key);
}