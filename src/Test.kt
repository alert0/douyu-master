
import okhttp3.*
import java.util.HashMap
import okhttp3.Cookie
import okhttp3.HttpUrl
import java.util.ArrayList


/**
 * Created by PC on 2017/7/4.
 */



//isfirst=0&STBType=EC6108V9U_pub_zjzdx&STBID=001004990060893017118421F185AD8C&areaId=57601&UserID=5760000101&NetUserID=snowiptv%40itv&NetPwd=iptv95%40%21&Pwd=111111
val AuthenticationURL  = "http://61.175.74.146:8082/"
val STBType     = "EC6108V9U_pub_zjzdx"
val STBID       = "001004990060893017118421F185AD8C"
var areaId      = "57601"
var UserID      ="5760000101"
var NetUserID   ="snowiptv@itv"
var NetPwd      ="iptv95@!"
var Pwd         ="111111"
var isfirst     ="0"

//object  Cook : CookieJar {
//
//    private val cookieStore = HashMap<HttpUrl, MutableList<Cookie>>()
//
//    override fun saveFromResponse(url: HttpUrl, p1: MutableList<Cookie>) {
//        cookieStore.put(HttpUrl.parse(url.host())!!, p1);
//    }
//
//    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
//        val cookies = cookieStore.get(HttpUrl.parse(url.host()))
//        return cookies ?: ArrayList<Cookie>()
//    }
//
//}
//
//
//fun  authLoginHWCTCformBody(): FormBody {
//
//
//   return  FormBody.Builder()
//            .add("isfirst", isfirst)
//           .add("STBType",STBType)
//           .add("STBID",STBID)
//           .add("areaId",areaId)
//           .add("UserID",UserID)
//           .add("NetUserID",NetUserID)
//           .add("NetPwd",NetPwd)
//           .add("Pwd",Pwd)
//            .build();
//
//}
//
//
fun authLoginHWCTC()   {

    var okHttpBuilder =  okhttp3.OkHttpClient.Builder()
    val TIME_OUT = 2000

    val URL = "${AuthenticationURL}EPG/jsp/AuthenticationURL?UserID=${UserID}&Action=Login&SampleId=1331";



    var client = okHttpBuilder
            .hostnameVerifier { hostname, session -> true }
            .cookieJar(object : CookieJar {
                private val cookieStore =  HashMap<String, List<Cookie>>()

                override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                        cookieStore.put(url.host(), cookies)
                }

                override fun loadForRequest(url: HttpUrl): List<Cookie> {
                    val cookies = cookieStore.get(url.host())
                    return cookies ?: ArrayList()
                }
            })
            .retryOnConnectionFailure(true)
            .build();


//
//    val request = Request.Builder().url(URL).post(authLoginHWCTCformBody() ).build()
//
//
//
//    val response = client.newCall(request).execute()
//    if (response.isSuccessful) {
//
//        val downloadedFile = File("sdfsdf.txt")
//        val sink = Okio.buffer(Okio.sink(downloadedFile))
////        sink.writeAll(response.body()?.source() )
//
//        val source = response.body()?.source()
//        //val sink = Okio.buffer(Okio.sink(destFile))
//        val sinkBuffer = sink.buffer()
//
//        var totalBytesRead: Long = 0
//        val bufferSize = 8 * 1024
//        var bytesRead: Long
//        while ((bytesRead = source.read(sinkBuffer, bufferSize)) != -1) {
//            sink.emit()
//            totalBytesRead += bytesRead
////            val progress = (totalBytesRead * 100 / contentLength) as Int
////            publishProgress(progress)
//        }
//
//        println(response.body()?.string() )
//        println(response.headers() );
//
//    } else {
//        throw IOException("Unexpected code " + response)
//    }

}



fun  main(args: Array<String>) {

        //for (i in 0..250000000000) {

//            val inNum2 = JTextField(10)
//            inNum2.text = "2461752"
//            Thread(DownloaderThead(inNum2, Config.cdn, Config.rate) ).start()
//


                ///    TimeUnit.SECONDS.sleep(1);
            //1000 milliseconds is one second.
       // }



}

