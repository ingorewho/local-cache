package com.ignore.common.cache.local.support.scheduler.impl;

import com.ignore.common.cache.local.service.LocalCacheService;
import com.ignore.common.cache.local.support.scheduler.LocalCacheScheduler;
import com.ignore.common.frame.ioc.CommonContextAware;
import org.apache.commons.collections.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 16:43 2019/1/16
 */
public class RegularLocalCacheScheduler implements LocalCacheScheduler, ApplicationListener<ApplicationReadyEvent>{
    private Logger logger = LogManager.getLogger();
    @Autowired
    private CommonContextAware contextAware;

    private List<String> cacheNames = new ArrayList<>(16);


    @Override
    @Scheduled(cron = "0 0 0 ? * *")
    public void clearTask() {
        logger.info("定时执行删除本地内存数据.");
        //定时每小时执行一次
        if (CollectionUtils.isEmpty(cacheNames)){
            init();
        }
        //并行执行删内存数据
        cacheNames.parallelStream().forEach(beanName ->{
            ((LocalCacheService)(contextAware.getSelfApplicationContext().getBean(beanName))).removeAll();
        });
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        init();
    }

    private void init(){
        Map<String, LocalCacheService> beans = contextAware.getSelfApplicationContext().getBeansOfType(LocalCacheService.class);
        if (beans.isEmpty()){
            return;
        }
        Iterator<String> beanNames = beans.keySet().iterator();
        while (beanNames.hasNext()){
            cacheNames.add(beanNames.next());
        }
    }
}
