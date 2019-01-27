package com.ignore.common.cache.local.support.annotation.wraper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.Signature;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 15:56 2019/1/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CacheKey {
    /**执行对象**/
    private Object target;
    /**方法对象**/
    private Signature signature;
    /**参数数组**/
    private Object[] params;
}
