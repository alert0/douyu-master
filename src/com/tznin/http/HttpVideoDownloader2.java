//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tznin.http;


import name.yumao.douyu.mina.LoginMinaThread;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;



public class HttpVideoDownloader2   implements Runnable {



	private int inNum;
	private String url;

	public HttpVideoDownloader2(int inNum, String url) {
		this.inNum = inNum;
		this.url = url;
	}

//public static final int TIME_OUT = 10;

	public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


//	public static OkHttpClient client = new OkHttpClient();
//	.Builder()
//										.connectTimeout(Config.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
//										.readTimeout(Config.SO_TIMEOUT, TimeUnit.MILLISECONDS)
//										.writeTimeout(Config.SO_TIMEOUT, TimeUnit.MILLISECONDS)
//										.retryOnConnectionFai()lure(true)
//										.build();


	//static ExecutorService singleThreadPool  = Executors.newSingleThreadExecutor();


	public   void download()  {



		Request request = new Request.Builder()
				.url(url)
				.build();

		  Response response  = null; ;

		File file = getDownFileName(inNum,url);

		if(!file.exists() )

		try {

			response	= HttpClientFactory.get().getOkclient().newCall(request).execute();
			if (response.isSuccessful()) {

				final ResponseBody body = response.body();

				BufferedSource source = body.source();





				BufferedSink sink = Okio.buffer(Okio.sink(file));
				Buffer sinkBuffer = sink.buffer();
//
//				long totalBytesRead = 0;
//				//long cacheBytes = 0;
				long bufferSize =  1024 * 1024;
//				//long ctime = 0;

				//loginMina(inNum, file.getPath().replace("flv", "ass"));

				for (long bytesRead; (bytesRead = source.read(sinkBuffer, bufferSize)) != -1; ) {

					//totalBytesRead += bytesRead;

					sink.emit();

				}

				sink.flush();
				sink.close();
				source.close();


			}


		} catch (Exception e){
			e.printStackTrace();
		}finally {
			if(response!=null) response.body().close();
		}


    }


	public static File getDownFileName(int inNum,String url) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));

		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

		String name = StringUtils.substringAfterLast(url,"/");
		name = StringUtils.substringBefore(name,"?");
		//System.out.println(name);

		//Paths.get("record", inNum.getText(),simpleDateFormat2.format(calendar.getTime() )).toFile().mkdirs();
		Path path = Paths.get("record", inNum+"",
				simpleDateFormat2.format(calendar.getTime()),name
				);
		
		File file =path.toFile() ;
		
		
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
			loginMina(inNum,file.getPath().replace("ts","ass") );

		}
		
		return file;
	}

    public static void loginMina(int roomid, String filePath ) {
        try {
			JTextField inNum2=new JTextField(10);
			inNum2.setText(roomid+"");
          new Thread(new LoginMinaThread(filePath,inNum2) ).start();
		//	singleThreadPool.execute(e);
//            Thread loginMinaThread = new Thread(e);
//            loginMinaThread.start();

        } catch (Exception var6) {
            var6.printStackTrace();
			//singleThreadPool.shutdown();
        }

    }

	@Override
	public void run() {
		download();
	}
}
