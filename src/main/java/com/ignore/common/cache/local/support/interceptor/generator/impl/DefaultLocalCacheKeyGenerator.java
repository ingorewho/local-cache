package com.ignore.common.cache.local.support.interceptor.generator.impl;

import com.ignore.common.cache.local.support.annotation.wraper.CacheKey;
import com.ignore.common.frame.utils.*;

/**
 * @Author: ignore1992
 * @Description: 默认key生成器
 * @Date: 2019/1/13
 */
public class DefaultLocalCacheKeyGenerator extends AbstractLocalCacheKeyGenerator{
    @Override
    public String generate(CacheKey cacheKey) {
        //根据类名+方法名+参数名作为key
        StringBuffer sb = new StringBuffer();
        sb.append(cacheKey.getTarget().getClass().getName());
        sb.append(cacheKey.getSignature().getName());
        for (Object obj : cacheKey.getParams()) {
            sb.append(obj.toString());
        }
        //对得到的key进行md5加密
        return Md5Utils.md5(sb.toString());
    }
}
