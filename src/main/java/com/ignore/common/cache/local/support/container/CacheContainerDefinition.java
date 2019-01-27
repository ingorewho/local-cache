package com.ignore.common.cache.local.support.container;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: ignore1992
 * @Description: 缓存容器元定义类
 * @Date: 2019/1/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CacheContainerDefinition {
    /**容器枚举类.**/
    private CacheContainerEnum containerEnum;
    /**容器大小.**/
    private int containerSize;
}
