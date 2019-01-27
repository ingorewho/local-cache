package com.ignore.common.frame.enumeration;

/**
 * Description： TODO
 * Author: ignore1992
 * Date: Created in 2018/12/30 16:21
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
public enum ExceptionEnum {
    CACHE_PUT_ERROR(001, "本地缓存put异常"),
    CACHE_GET_ERROR(002, "本地缓存get异常"),
    CACHE_REMOVE_ERROR(003, "本地缓存remove异常");

    private int code;
    private String desc;

    private ExceptionEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "ExceptionEnum{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
