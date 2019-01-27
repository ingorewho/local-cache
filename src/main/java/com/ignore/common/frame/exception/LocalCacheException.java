package com.ignore.common.frame.exception;

import com.ignore.common.frame.enumeration.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 17:59 2019/1/15
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class LocalCacheException extends RuntimeException{
    private String msg;
    private ExceptionEnum exception;
}
