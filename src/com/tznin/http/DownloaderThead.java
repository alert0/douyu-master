//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tznin.http;

import name.yumao.douyu.vo.DouyuApiDataVo;
import name.yumao.douyu.vo.OpenRoomApi;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static name.yumao.douyu.DouyuAssistantMain.DateeventBus;

public class DownloaderThead implements Runnable {
	private static Logger logger = Logger.getLogger(DownloaderThead.class);
	private int inNum;
	private static int time = 1;
	private static boolean closed = false;
	private String  cdn;
	private String rate;

	public  DownloaderThead(int inNum,String cdn, String rate) {
		logger.info("Sub:初始化录像进程");
		this.inNum = inNum;
		this.cdn = cdn;
		this.rate = rate;
	}

	public static synchronized int getTime() {
		return time > 5 ? time : time++;
	}

	public static synchronized void setclosed(boolean b) {
		closed = b;
	}

	public static synchronized boolean getclosed(boolean b) {
		return closed;
	}

	public static synchronized void setTime() {
		time = 1;
	}

	public synchronized  void run() {


		System.out.println("开始：" + this.inNum);

		while (true) {

			try {


			//	OpenRoomApi openRoomApi = HttpClientFromDouyu.roomApi(this.inNum);

//				String online = api.getOnline();
//
//				if (online != null && !online.equals("0")) {


//				H5Api openRoomApi = HttpClientFromDouyu.roomApiH5(this.inNum);
//
//				if (openRoomApi != null && openRoomApi.getError() == 0  //判断开播
//						&& openRoomApi.getData().getRoom_status().equals("1")
//						) {


					DouyuApiDataVo vo = HttpClientFromDouyu.Companion.QueryDouyuDownloadUrl(this.inNum, Config.cdn);

					if (vo != null &&  !StringUtils.isBlank(vo.getRtmp_url() ) ) {

						HttpVideoDownloader.download(inNum,vo.getRtmp_url() +"/"+ vo.getRtmp_live(),Config.TIMEOUT );
					}
				//}




				try {
					TimeUnit.MILLISECONDS.sleep(500 * getTime());
					logger.debug(Integer.valueOf(time));
				} catch (Exception var7) {
					var7.printStackTrace();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
