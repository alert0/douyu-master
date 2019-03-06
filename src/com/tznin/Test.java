package com.tznin;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.tznin.http.HttpVideoDownloader3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 2017/8/7.
 */
public class Test {

//
//    static class GPS {
//       public  double x  =  0;
//        public double y =  0 ;
//    }
//
//
//    double startrange = 20;
//    double step = 10;
//    double maxrage = 40;
//    int rangenum = 6;
//    int outposrangecount = 4;
//
//
//    private String meangps(double x, double y, double startrange, double step,
//                           double maxrage, int rangenum, ArrayList<GPS> listdate) {
//
//
//        if(startrange > maxrage) {
//            return "";
//        }
//
//        int count = 0 ;
//        double tempx = 0 ;
//        double tempy = 0 ;
//        for(int i = 0 ; i  < listdate.size() ; i ++) {
//            tempx = tempx +  listdate.get(i).x;
//            tempy = tempy +   listdate.get(i).y;
//            count = count+ 1;
//        }
//
//        if(count < rangenum) {
//
//        }
//
//
//        return  "";
//    }


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

        HttpVideoDownloader3.Companion.loginMina(67373, "D:\\eclipse-workspace\\douyu\\aaa.txt");


    }


}
