//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tznin.http;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import name.yumao.douyu.vo.DouyuApiDataVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DownloaderThead2 implements Runnable {
	private static Logger logger = Logger.getLogger(DownloaderThead2.class);
	private int inNum;
	private static int time = 1;

	ExecutorService threadPool = Executors.newSingleThreadExecutor();

	CacheBuilder cacheBuilder = CacheBuilder.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES);

	Cache<String,String> cacheplaylist = cacheBuilder.build();

	public DownloaderThead2(int inNum, String cdn, String rate) {
		logger.info("Sub:初始化录像进程");
		this.inNum = inNum;
	}

	public static synchronized int getTime() {
		return time > 5 ? time : time++;
	}



		public synchronized  void run() {


			System.out.println("开始：" + this.inNum);

			while (true) {

				try {



						DouyuApiDataVo vo = HttpClientFromDouyu.Companion.QueryDouyuDownloadUrl(this.inNum, Config.cdn);

						if (vo != null &&
								!StringUtils.isBlank(vo.getHls_url())
								) {


								List<String> playList = HttpClientFromDouyu.Companion.getList(vo.getHls_url());

								for (String url : playList) {

									if(cacheplaylist.getIfPresent(url)  == null) {

										cacheplaylist.put(url, url);

										try {
											threadPool.execute(new HttpVideoDownloader2(inNum, url));

										} catch (Exception e) {
											logger.info("下载" + url + "失败 ");
										}
									}
								}


						}

						TimeUnit.MILLISECONDS.sleep(3000 );
						logger.debug(Integer.valueOf(time));


				} catch (Exception e1) {
					logger.debug(e1.getMessage());
					e1.printStackTrace();
				}


			}
		}

}
