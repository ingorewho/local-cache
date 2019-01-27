package com.ignore.common.cache.local.support.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:14 2019/1/11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheResult{
    /**缓存key.**/
    private String key;
    /**缓存value.**/
    private Object value;
    /**缓存是否成功.**/
    private boolean success;
    /**缓存异常信息.**/
    private String message;
}
