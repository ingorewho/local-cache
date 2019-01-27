package com.ignore.common.cache.local.service.impl;

import com.ignore.common.cache.local.service.LocalCacheService;
import com.ignore.common.cache.local.support.container.CacheContainer;
import com.ignore.common.frame.enumeration.ExceptionEnum;
import com.ignore.common.frame.exception.LocalCacheException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.Assert;

/**
 * @Author: ignore1992
 * @Description: 本地缓存抽象类
 * @Date: Created In 16:57 2019/1/11
 */
public abstract class AbstractLocalCacheService implements LocalCacheService{
    private Logger logger = LogManager.getLogger();
    /**二级缓存序号.**/
    private String cacheNo;
    /**二级缓存有效期.**/
    protected int expireInterval;
    /**二级缓存基础容器.**/
    protected CacheContainer container;
    /**二级缓存初始容量大小.**/
    protected int cacheInitSize;

    public AbstractLocalCacheService(){
        //初始化容器
        initialize();
    }

    protected abstract void initialize();

    @Override
    public String put(String key , String value) {
        Assert.notNull(key , "存放数据到本地缓存,key为null.");

        try {
            return container.put(key, value);
        }catch (Exception e){
            logger.error("存放数据到本地缓存发生异常.", e);
            throw new LocalCacheException("存放本地缓存异常", ExceptionEnum.CACHE_PUT_ERROR);
        }
    }

    @Override
    public String remove(String key) {
        Assert.notNull(key, "删除本地缓存,key为null.");

        try {
            return container.remove(key);
        }catch (Exception e){
            logger.error("移除本地缓存发生异常.", e);
            throw new LocalCacheException("移除本地缓存异常", ExceptionEnum.CACHE_PUT_ERROR);
        }
    }

    @Override
    public String get(String key) {
        Assert.notNull(key, "获取本地缓存,key为null.");

        try {
            return container.get(key);
        }catch (Exception e){
            logger.error("获取本地缓存发生异常.", e);
            throw new LocalCacheException("获取本地缓存异常", ExceptionEnum.CACHE_GET_ERROR);
        }
    }

    @Override
    public void removeAll() {
        throw new UnsupportedOperationException("removeAll");
    }
}
