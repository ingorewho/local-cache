package com.ignore.common.cache.local.support.annotation.wraper;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:02 2019/1/14
 */
public class CacheKeyUtils {

    public static CacheKey getCacheKey(ProceedingJoinPoint point){
        return new CacheKey(point.getTarget(), point.getSignature(),point.getArgs());
    }
}
