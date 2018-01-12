package com.tznin.http

import name.yumao.douyu.mina.LoginMinaThread
import okhttp3.Request
import okhttp3.Response
import okio.Okio
import org.apache.commons.lang3.StringUtils
import java.io.Closeable
import java.io.File
import java.nio.file.Paths
import java.text.SimpleDateFormat
import java.util.*
import javax.swing.JTextField


class HttpVideoDownloader3(private val inNum: Int, private val url: String,private val date:String) : Runnable {


    //	public static OkHttpClient client = new OkHttpClient();
    //	.Builder()
    //										.connectTimeout(Config.CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
    //										.readTimeout(Config.SO_TIMEOUT, TimeUnit.MILLISECONDS)
    //										.writeTimeout(Config.SO_TIMEOUT, TimeUnit.MILLISECONDS)
    //										.retryOnConnectionFai()lure(true)
    //										.build();


    //static ExecutorService singleThreadPool  = Executors.newSingleThreadExecutor();

     var  playfile: File?  = null





    fun download() {


        val request = Request.Builder()
                .url(url)
                .build()

        var response: Response? = null



            try {

                response = HttpClientFactory.get().okclient.newCall(request).execute()


                if (response!!.isSuccessful) {

                   // val body = response.body()

                    val source = response.body()?.source();


//                    if(this.file == null) {
//                        file = getDownFileName(inNum)
//                    }

                    val file = getDownFileName(inNum,url,date)

                    val sink = Okio.buffer(Okio.appendingSink(file) )


                    if(playfile == null) {
                        playfile = File("${file.parentFile}${File.separator}play.m3u8")
                    }

                    val playsink = Okio.buffer(Okio.appendingSink( playfile) )

                  //  val playsink = Okio.buffer(Okio.appendingSink(file) )

                    val sinkBuffer = sink.buffer()
                    //
                    //				long totalBytesRead = 0;
                    //				//long cacheBytes = 0;
                    val bufferSize = (4* 1024 * 1024).toLong()
                    //				//long ctime = 0;

                    //loginMina(inNum, file.getPath().replace("flv", "ass"));

                //    var bytesRead: Long ?

                    var totalBytesRead: Long = 0
                    var bytesRead :Long? = 0


                    while (source?.read(sinkBuffer, bufferSize).apply { bytesRead = this  } != -1L  ) {
                     //   val bytesRead =  source?.read(sinkBuffer, bufferSize)


                             sink.emit()



                            totalBytesRead = totalBytesRead + (bytesRead!!)

                           //   System.out.println("${totalBytesRead} , ${bytesRead}" )
//                             if (totalBytesRead > Config.SIZE * 1024 * 1024) {
//                                 sink.flush()
//                                 sink.close()
//                                 //new file
//                                 file = getDownFileName(inNum)
//                                 sink = Okio.buffer(Okio.appendingSink(file))
//                             }


                    }

                    sink.flush()
                    sink.close()

                    //source?.close()
                    closeQuietly(sink);
                    closeQuietly(source);


                    val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"))
                    val date = simpleDateFormat.format(calendar.time)
                    playsink.writeUtf8("#${date}\r\n")
                    playsink.writeUtf8("${url}\r\n")

                    System.out.println("下载 ${url} 完毕:${totalBytesRead/1024/1024} m ")

                    closeQuietly(playsink);

                }


            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (response != null) response.body()!!.close()
            }


    }

    override fun run() {
        download()
    }


    fun closeQuietly(closeable: Closeable?) {

        if (closeable != null) {

            try {

                closeable.close()

            } catch (rethrown: RuntimeException) {

                throw rethrown

            } catch (ignored: Exception) {

                    ignored.printStackTrace()

            }

        }

    }

    companion object {

        //public static final int TIME_OUT = 10;

        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd^HH-mm-ss")
        val simpleDateFormat2 = SimpleDateFormat("yyyy-MM-dd")

        fun getDownFileName(inNum: Int,url:String,date:String): File {



            val calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"))



           var name = StringUtils.substringAfterLast(url, "/")
               name = StringUtils.substringBefore(name, "?")
            //System.out.println(name);

            //Paths.get("record", inNum.getText(),simpleDateFormat2.format(calendar.getTime() )).toFile().mkdirs();
            val path = Paths.get("record", inNum.toString() ,
                    simpleDateFormat2.format(calendar.time),
                    date + ".ts"
                   // name

            )

            val file = path.toFile()


            if (!file.parentFile.exists()) {
                file.parentFile.mkdirs()
                //loginMina(inNum, file.path.replace("ts", "ass") )
            }

            if(!file.exists() ) {  //没有的时候生成文件
                loginMina(inNum, "${file.parentFile}${File.separator}${date}.ass")
            }


            return file
        }

        fun loginMina(roomid: Int, filePath: String) {
            try {
                val inNum2 = JTextField(10)
                inNum2.text = roomid.toString() + ""
                Thread(LoginMinaThread(filePath, inNum2)).start()
                //	singleThreadPool.execute(e);
                //            Thread loginMinaThread = new Thread(e);
                //            loginMinaThread.start();

            } catch (var6: Exception) {
                var6.printStackTrace()
                //singleThreadPool.shutdown();
            }

        }
    }
}
