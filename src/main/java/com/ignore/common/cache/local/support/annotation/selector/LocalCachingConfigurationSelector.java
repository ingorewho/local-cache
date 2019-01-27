package com.ignore.common.cache.local.support.annotation.selector;

import com.ignore.common.cache.local.support.annotation.EnableLocalCache;
import com.ignore.common.cache.local.support.annotation.enumeration.CacheApsectEnum;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

/**
 * @Author: ignore1992
 * @Description: 本地缓存选择器
 * @Date: 2019/1/13
 */
public class LocalCachingConfigurationSelector implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        MultiValueMap<String, Object> attributes = metadata.getAllAnnotationAttributes(
                EnableLocalCache.class.getName(), false);
        boolean enable = attributes == null ? false
                : (Boolean) attributes.getFirst("enable");
        if (enable){
            CacheApsectEnum aspect = attributes == null ? null
                    : (CacheApsectEnum) attributes.getFirst("aspect");
            if (aspect != null){
                return new String[]{aspect.getAspect().getName()};
            }
        }
        return new String[]{};
    }
}
