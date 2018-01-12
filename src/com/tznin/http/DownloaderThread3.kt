package com.tznin.http

import com.google.common.cache.Cache
import com.google.common.cache.CacheBuilder
import com.sun.javafx.binding.StringFormatter
import org.apache.commons.lang3.StringUtils
import org.apache.log4j.Logger
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Created by PC on 2017/8/7.
 */
class DownloaderThread3 : Runnable {

    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd^HH-mm-ss")

    private val logger = Logger.getLogger(DownloaderThead::class.java)

    var inNum: Int = 0
    var outTime :Int = 0 ;
    var  playTime: Int= 0

     internal var time = 1

   //  lateinit var file: File

  //   var isfirst = true

    var  startDate : String = "";


     val threadPool = Executors.newSingleThreadExecutor()

  //  internal var cacheBuilder: CacheBuilder<*, *> = CacheBuilder.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES)

    val cacheplaylist: Cache<String, String> =CacheBuilder
                                                    .newBuilder()
                                                    .expireAfterWrite(60, TimeUnit.MINUTES)
                                                    .build<String,String>()


    constructor(roomId :Int) {
            inNum = roomId

    }

//
    fun getTime() :Int {
        return if (time > 10) time else time++
    }

    override fun run() {

       logger.info("开始${inNum}")

        while (true) {

            try {


                val vo = HttpClientFromDouyu.QueryDouyuDownloadUrl(this.inNum, Config.cdn)

                logger.debug("返回 hls ${vo.hls_url}")


                if (vo != null && !StringUtils.isBlank(vo.hls_url)) {

                    val playList = HttpClientFromDouyu.getList(vo.hls_url)

                    logger.debug("返回 playlist ${playList}")

                    if(! playList.isEmpty() ) {



                        logger.debug(" 开始 ${playList}")

                        downPlaylist(playList)

                    } else {

                        outTime = outTime + 1

                        if(outTime > 5) {

                            startDate = ""
                            outTime = 0

                            logger.debug("新的开始")

                        } else {
                            time = 1
                        }

                    }

                }

                TimeUnit.MILLISECONDS.sleep(getTime() * 500L )

                //logger.debug(Integer.valueOf(time))


            } catch (e1: Exception) {
                logger.info(e1.message)
                e1.printStackTrace()
            }


        }
    }

    private fun downPlaylist(playList: List<String>) {


        //分段
        playTime = playTime+1

        logger.debug("playTime${playTime}")

        if(Config.PLAYLIST!=-1 && playTime> Config.PLAYLIST){
            playTime = 1
            startDate = ""

        }


        if(StringUtils.isBlank(startDate) ) {
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"))
            startDate = "${simpleDateFormat.format(calendar.time)}^${inNum}"
        }

        for (url in playList) {



            if (cacheplaylist.getIfPresent(url) == null) {

                cacheplaylist.put(url, url)

                try {
                    threadPool.execute(HttpVideoDownloader3(inNum, url,startDate ) )

                } catch (e: Exception) {
                    e.printStackTrace()
                    logger.info("下载" + url + "失败 ")
                }

            }
        }
    }


}