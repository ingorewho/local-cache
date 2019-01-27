package com.ignore.common.cache.local.support.interceptor.generator.impl;

import com.ignore.common.cache.local.support.annotation.wraper.CacheKey;
import com.ignore.common.frame.utils.Md5Utils;

/**
 * @Author: ignore1992
 * @Description: 本地缓存key生成器
 * @Date: 2019/1/12
 */
public class SimpleLocalCacheKeyGenerator extends AbstractLocalCacheKeyGenerator{
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
        String md5Str = Md5Utils.md5(sb.toString());
        //加密后是32位，为了减少key的长度，顺序取偶数位得到16位的key
        return appendEvenChar(md5Str);
    }

    /**
     * 拼接偶数位字符
     * @param src
     * @return
     */
    private String appendEvenChar(String src){
        StringBuffer buffer = new StringBuffer();
        char[] chars = src.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if ((i % 2) == 0){
                buffer.append(chars[i]);
            }
        }
        return buffer.toString();
    }
}
