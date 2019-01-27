package com.ignore.common.cache.local.support.annotation;

import com.ignore.common.cache.local.support.annotation.enumeration.CacheApsectEnum;
import com.ignore.common.cache.local.support.annotation.selector.LocalCachingConfigurationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: ignore1992
 * @Description: 启用本地缓存注解
 * @Date: 2019/1/13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Documented
@Import({LocalCachingConfigurationSelector.class})
public @interface EnableLocalCache {
    /**
     * 是否开启本地缓存
     * @return
     */
    boolean enable() default false;

    /**
     * 扫描@Cacheable切面类配置
     * @return
     */
    CacheApsectEnum aspect() default CacheApsectEnum.DEFAULT_ASPECT;
}
