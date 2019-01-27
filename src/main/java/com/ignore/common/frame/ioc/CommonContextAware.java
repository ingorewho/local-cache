package com.ignore.common.frame.ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Description： 获取spring容器
 * Author: ignore1992
 * Date: Created in 2018/11/20 21:39
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 */
@Component
public class CommonContextAware implements ApplicationContextAware {
    private Logger logger = LogManager.getLogger();

    private ApplicationContext selfApplicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (selfApplicationContext == null){
            selfApplicationContext = applicationContext;
        }
        logger.info("获取到spring容器:{}", selfApplicationContext.getApplicationName());
    }

    /**
     * 提供外部获取spring容器
     * @return
     */
    public ApplicationContext getSelfApplicationContext() {
        return selfApplicationContext;
    }
}
