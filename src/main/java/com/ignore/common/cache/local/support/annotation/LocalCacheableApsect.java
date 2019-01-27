package com.ignore.common.cache.local.support.annotation;

import com.ignore.common.cache.local.support.annotation.handler.LocalCacheableHandler;
import com.ignore.common.frame.exception.LocalCacheException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: ignore1992
 * @Description: 本地缓存注解aop处理类
 * @Date: 2019/1/13
 */
@Aspect
public class LocalCacheableApsect {
    private Logger logger = LogManager.getLogger();
    @Autowired
    private LocalCacheableHandler localCacheableHandler;

    @Around("@annotation(localCacheable)")
    public Object localCache(ProceedingJoinPoint point, LocalCacheable localCacheable)throws Throwable{
        try {
            return localCacheableHandler.handle(point, localCacheable);
        }catch (Throwable e){
            if (e instanceof LocalCacheException){
                LocalCacheException cacheException = (LocalCacheException) e;
                logger.error("处理本地缓存出现异常. 异常信息:{}", cacheException.getException());
            }
            throw e;
        }
    }
}
