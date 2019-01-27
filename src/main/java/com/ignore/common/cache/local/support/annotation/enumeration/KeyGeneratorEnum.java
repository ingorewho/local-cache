package com.ignore.common.cache.local.support.annotation.enumeration;

import com.ignore.common.cache.local.support.interceptor.generator.impl.AbstractLocalCacheKeyGenerator;
import com.ignore.common.cache.local.support.interceptor.generator.impl.DefaultLocalCacheKeyGenerator;
import com.ignore.common.cache.local.support.interceptor.generator.impl.SimpleLocalCacheKeyGenerator;

/**
 * @Author: ignore1992
 * @Description: key生成器枚举
 * @Date: 2019/1/13
 */
public enum KeyGeneratorEnum {
    DEFAULT("default", DefaultLocalCacheKeyGenerator.class),
    SIMPLE("simple", SimpleLocalCacheKeyGenerator.class);

    private String name;
    private Class<? extends AbstractLocalCacheKeyGenerator> keyGenerator;

    private KeyGeneratorEnum(String name, Class<? extends AbstractLocalCacheKeyGenerator> keyGenerator){
        this.name = name;
        this.keyGenerator = keyGenerator;
    }
}
