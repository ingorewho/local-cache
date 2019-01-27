package com.ignore.common.cache.local.support.annotation;

import com.ignore.common.cache.local.support.annotation.enumeration.CacheResolverEnum;
import com.ignore.common.cache.local.support.annotation.enumeration.CacheServiceEnum;
import com.ignore.common.cache.local.support.annotation.enumeration.KeyGeneratorEnum;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @Author: ignore1992
 * @Description: 本地缓存注解
 * @Date: 2019/1/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Inherited
@Documented
public @interface LocalCacheable{
    @AliasFor("type")
    CacheServiceEnum value() default CacheServiceEnum.SAFE_MAP;

    @AliasFor("value")
    CacheServiceEnum type() default CacheServiceEnum.SAFE_MAP;

    /**
     * 指定key的生成器
     * @return
     */
    KeyGeneratorEnum keyGenerator() default KeyGeneratorEnum.SIMPLE;

    /**
     * 指定缓存解析器
     * @return
     */
    CacheResolverEnum cacheResolver() default CacheResolverEnum.SIMPLE;

    /**
     * 显示地指定key值
     * @return
     */
    String key() default "";

    /**
     * 默认十秒有效期
     * @return
     */
    int expireInterval() default 10;

    /**
     * value类型
     * @return
     */
    Class<?> valueType() default String.class;
}
