package com.wl.test;

import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.wl.entity.DeskInformation;

/**
 * Created by Vincent on 2018-06-29.
 */
public class GuavaCachDemo {

    private LoadingCache<String, DeskInformation> loadingCache;

    public void InitLoadingCache(){

        //指定一个如果数据不存在获取数据的方法
        CacheLoader<String, DeskInformation> cacheLoader = new CacheLoader<String, DeskInformation>() {
            @Override
            public DeskInformation load(String key) throws Exception {
                return null;
            }
        };

    }
}
