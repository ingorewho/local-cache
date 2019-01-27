package com.ignore.common.cache.local.support.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:33 2019/1/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheValue{
    /**缓存value值.**/
    private Object value;
    /**缓存有效期时间戳.**/
    private long expireTime;
}
