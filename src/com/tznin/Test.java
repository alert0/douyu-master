package com.tznin;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.tznin.http.HttpVideoDownloader3;

import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 2017/8/7.
 */
public class Test {





    public static void main(String[] a) throws InterruptedException {


//        CacheBuilder cacheBuilder = CacheBuilder.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES);
//        Cache<String,String> cache = cacheBuilder.build();
////        for(int i=0; i<10000; i++){
////            cache.put("7C74B32C-34C4-2C35-0DC0-C252E24D10F5"+i,i);
////        }
//
//        cache.put("7C74B32C-34C4-2C35-0DC0-C252E24D10F510","10");
//
//        System.out.println(cache.getIfPresent("7C74B32C-34C4-2C35-0DC0-C252E24D10F510"));
//
//        System.out.println(cache.getIfPresent("7C74B32C-34C4-2C35-0DC0-C252E24D10F510"));
//
//        TimeUnit.MILLISECONDS.sleep(1000* 61);
//
//        System.out.println(cache.getIfPresent("7C74B32C-34C4-2C35-0DC0-C252E24D10F510"));
//
//        System.out.println(cache.getIfPresent("7C74B32C-34C4-2C35-0DC0-C252E24D10F510"));

        HttpVideoDownloader3.Companion.loginMina(67373,"D:\\eclipse-workspace\\douyu\\aaa.txt");


    }







}
