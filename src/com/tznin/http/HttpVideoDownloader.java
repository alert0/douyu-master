//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tznin.http;

import name.yumao.douyu.mina.LoginMinaThread;
import okhttp3.*;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class HttpVideoDownloader {



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


	public static  void download(int inNum, String url, int time) throws Exception {



		Request request = new Request.Builder()
				.url(url)
				.build();


		final Call call  	= HttpClientFactory.get().getOkclient().newCall(request);
		final Response response =  call.execute();
		try {



			if (response.isSuccessful()) {

				//final ResponseBody body = response.body();

				BufferedSource source = response.body().source();


				File file = getDownFileName(inNum);
				BufferedSink sink = Okio.buffer(Okio.sink(file));
				Buffer sinkBuffer = sink.buffer();

				long totalBytesRead = 0;
				long cacheBytes = 0;
				long bufferSize =  20* 1024 * 1024;
				//long ctime = 0;

				loginMina(inNum, file.getPath().replace("flv", "ass"));

				for (long bytesRead; (bytesRead = source.read(sinkBuffer, bufferSize)) != -1; ) {

					totalBytesRead += bytesRead;
					cacheBytes += bytesRead;

					if (cacheBytes > bufferSize) {
						sink.emit();

						final  Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));

						System.out.println(simpleDateFormat.format(calendar.getTime() ) + " 正在下载房间 ：" + inNum + "，已下载大小: " + totalBytesRead / 1048576L + "m");

						//ctime++;

						if (time!=-1 && time > totalBytesRead / 1048576L) { //new file
							sink.flush();
							sink.close();
							source.close();
							//singleThreadPool.shutdown();
							//DateeventBus.post(new DataEvent(inNum, DataEvent.TYPE_END, ""));
						}

						cacheBytes = 0;
					}

				}

				sink.flush();
			//	body.close();
				sink.close();
				source.close();
				//DateeventBus.post(new DataEvent(inNum, DataEvent.TYPE_END, ""));
				//singleThreadPool.shutdown();

			}


		} catch (Exception e){
			throw  new Exception(inNum+  e.getMessage() );
		}finally {
			if(response!=null)

				response.close();

			call.cancel();
		}


    }

//    private static void down(JTextField inNum,JButton butnSure, HttpResponse response, HttpEntity entity, HttpGet httpget) throws IOException, FileNotFoundException {
//        long downloadedSize = 0L;
//        InputStream is = entity.getContent();
//        FileOutputStream fileout=null;
//        byte[] buffer = new byte[20480000*4];
//        boolean ch = false;
//
//        File file = getDownFileName(inNum);
//
//        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,20,50,TimeUnit.MILLISECONDS,bqueue);
//
//        try {
//            Date ex = new Date();
//           // Date ex2 = new Date();
//            int ch1;
//            long time = 0 ;
//            while((ch1 = is.read(buffer)) != -1 && ch1 > 0) {
//
//
//            		if(!file.getParentFile().exists()) {
//            			file.getParentFile().mkdirs();
//            		}
//
//	        		if( fileout == null){
//	        			fileout =new FileOutputStream(file);
//	        		}
//
////	        		if(!ch) {
////	        			 String a = file.getPath();
////	        			 loginMina(inNum, butnSure, a.replace("flv", "ass") ,pool);
////	        			 ch =true;
////	        		}
////
//
//	                fileout.write(buffer, 0, ch1);
//	                downloadedSize += (long)ch1;
//	                Date now = new Date();
//	                if((now.getTime() - ex.getTime()) / 1000L >= 10L) {
//	                    System.out.println(now + " 正在下载房间：" + inNum.getText() + "，已下载大小: " + downloadedSize / 1048576L + "m");
//	                    ex = now;
//	                    time = time + 10;
//
//
//	                    if(Config.TIMEOUT != -1 && time >= (long)(60 * Config.TIMEOUT) ) {
//	                    	httpget.abort();
//		                      if(response != null) {
//		                          EntityUtils.consumeQuietly(response.getEntity());
//		                      }
//		                     // DouyuAssistantMain.e.post("end");
//	                    }
//	                }
//
//            }
//        } catch (IOException var16) {
//        	var16.printStackTrace();
//            throw var16;
//        } finally {
//        	if(fileout != null) {
//                fileout.flush();
//                fileout.close();
//        	}
//            is.close();
//            //DouyuAssistantMain.e.post("end" + inNum.getText());
//            pool.shutdown();
//        }
//
//    }

	public static File getDownFileName(int inNum) {
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd^HH-mm-ss");
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		
		//Paths.get("record", inNum.getText(),simpleDateFormat2.format(calendar.getTime() )).toFile().mkdirs();
		Path path = Paths.get("record", inNum+"",
				simpleDateFormat2.format(calendar.getTime()),
				inNum +"^"+simpleDateFormat.format(calendar.getTime()) + ".flv");
		
		File file =path.toFile() ;
		
		
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		return file;
	}

    private static void loginMina(int roomid, String filePath ) {
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
}
