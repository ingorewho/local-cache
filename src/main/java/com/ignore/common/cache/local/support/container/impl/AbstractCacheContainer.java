package com.ignore.common.cache.local.support.container.impl;

import com.ignore.common.cache.local.support.container.CacheContainer;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @Author: ignore1992
 * @Description: 缓存容器抽象类
 * @Date: 2019/1/12
 */
public abstract class AbstractCacheContainer<K> implements CacheContainer<K>{

    protected abstract void initContainer(int containerSize);

    @Override
    public void forEach(Consumer action) {
        throw new UnsupportedOperationException("forEach");
    }

    @Override
    public Spliterator spliterator() {
        throw new UnsupportedOperationException("spliterator");
    }
}
