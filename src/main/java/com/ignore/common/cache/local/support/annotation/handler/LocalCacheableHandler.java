package com.ignore.common.cache.local.support.annotation.handler;

import com.ignore.common.cache.local.service.LocalCacheService;
import com.ignore.common.cache.local.support.annotation.LocalCacheable;
import com.ignore.common.cache.local.support.annotation.wraper.CacheKeyUtils;
import com.ignore.common.cache.local.support.entity.CacheValue;
import com.ignore.common.cache.local.support.interceptor.generator.CacheKeyGenerator;
import com.ignore.common.cache.local.support.interceptor.resolver.CacheVauleResolver;
import com.ignore.common.cache.local.support.strategy.CacheStrategyUtils;
import com.ignore.common.cache.local.support.strategy.LocalCacheableStrategy;
import com.ignore.common.frame.ioc.CommonContextAware;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: ignore1992
 * @Description: LocalCacheable注解处理器
 * @Date: 2019/1/13
 */
@Component
public class LocalCacheableHandler{
    @Autowired
    private CommonContextAware commonContextAware;
    private Logger logger = LogManager.getLogger();

    /**
     * 缓存处理
     * @param joinPoint
     * @param localCacheable
     * @return
     * @throws Throwable
     */
    public Object handle(ProceedingJoinPoint joinPoint, LocalCacheable localCacheable)throws Throwable{
        //1.生成缓存策略
        LocalCacheableStrategy strategy = CacheStrategyUtils.getCacheableStrategy(localCacheable);
        CacheKeyGenerator keyGenerator = strategy.getKeyGenerator();
        CacheVauleResolver cacheResolver = strategy.getCacheResolver();
        Class cacheServiceClass = strategy.getCacheServiceClass();
        LocalCacheService localCacheService = (LocalCacheService)commonContextAware.getSelfApplicationContext().getBean(cacheServiceClass);

        //2.生成key
        String key = localCacheable.key();
        if (keyGenerator != null){
            key = keyGenerator.generate(CacheKeyUtils.getCacheKey(joinPoint));
        }

        //3.从本地缓存中获取结果
        String result = localCacheService.get(key);
        //4.解析结果
        CacheValue cacheValue = cacheResolver.deserialValue(result);
        Object value = cacheValue.getValue();
        if (value != null){
            logger.info("查询本地缓存成功, key={}, value={}", key, cacheValue.getValue());
        }
        else {
            //本地缓存未命中，执行方法，然后缓存
            value = joinPoint.proceed();
            if (value != null){
                //5.使用解析器生成value值
                String newValue = cacheResolver.serialValue(value, localCacheable.expireInterval());
                //6.缓存结果
                localCacheService.put(key, newValue);
            }
        }
        return value;
    }

}
