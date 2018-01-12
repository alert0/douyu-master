//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tznin.http;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;



public class HttpClientFactory {
	private static HttpClientFactory factory;

    private  OkHttpClient okclient;


    public HttpClientFactory() {
        if(okclient == null) {

           okclient = new OkHttpClient.Builder()
				.connectTimeout(Config.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
				.readTimeout(Config.SO_TIMEOUT, TimeUnit.MILLISECONDS)
				.writeTimeout(Config.SO_TIMEOUT, TimeUnit.MILLISECONDS)
				.retryOnConnectionFailure(true)
				.build();

        }
        

    }
    
    

	public OkHttpClient getOkclient() {
		return okclient;
	}




	public static synchronized HttpClientFactory get() {

    	if(factory == null) 
    		factory = new HttpClientFactory();
        return factory;
    }
}
