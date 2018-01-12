package com.tznin.http

import com.google.gson.Gson
import com.tznin.util.MD5Util
import name.yumao.douyu.vo.DouyuApiDataVo
import name.yumao.douyu.vo.DouyuApiVo
import name.yumao.douyu.vo.H5Api
import name.yumao.douyu.vo.OpenRoomApi
import okhttp3.Request
import okhttp3.Response
import java.io.Closeable
import java.util.ArrayList
import java.util.logging.Logger



class HttpClientFromDouyu {
    companion object {

        private val logger = Logger.getLogger(HttpClientFromDouyu::class.java.toString())

        // private static OkHttpClient client = new OkHttpClient();


        fun roomApiH5(roomNum: Int): H5Api {
            var vo = H5Api()
            //        HttpEntity entity = null;
            //        HttpGet get = null;
            var response: Response? = null

            try {

                val apiurl = String.format("http://m.douyu.com/html5/live?roomId=%s", roomNum)
                //            get = new HttpGet(apiurl);
                //           // get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36");
                //            HttpResponse response = HttpClientFactory.getHttpClient().execute(get);
                //            if(response.getStatusLine().getStatusCode() == 200) {
                //                entity = response.getEntity();
                //           //     String htmlEntity = EntityUtils.toString(entity);
                //
                //             //   logger.debug(htmlEntity);
                //               // System.out.println(htmlEntity);
                //                vo = ServerUtils.QueryDouyuDownloadUrl(EntityUtils.toString(entity) );
                //            }

                ///ogger.info(vo.getServers() );

                //


                val request = Request.Builder()
                        .url(apiurl)
                        .build()

                response = HttpClientFactory.get().okclient.newCall(request).execute()


                if (response!!.isSuccessful) {

                    val body = response.body()!!.string()

                    val gson = Gson()
                    vo = gson.fromJson(body, H5Api::class.java)


                }


                return vo

            } catch (var13: Exception) {
                var13.printStackTrace()
            } finally {
                if (response != null) response.body()!!.close()
                //            get.abort();
                //            if(entity != null) {
                //                EntityUtils.consumeQuietly(entity);
                //            }

            }

            return vo
        }


        fun roomApi(roomNum: Int): OpenRoomApi {
            var vo = OpenRoomApi()
            //        HttpEntity entity = null;
            //        HttpGet get = null;
            var response: Response? = null

            try {

                val apiurl = String.format("http://open.douyucdn.cn/api/RoomApi/room/%s", roomNum)
                //            get = new HttpGet(apiurl);
                //           // get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36");
                //            HttpResponse response = HttpClientFactory.getHttpClient().execute(get);
                //            if(response.getStatusLine().getStatusCode() == 200) {
                //                entity = response.getEntity();
                //           //     String htmlEntity = EntityUtils.toString(entity);
                //
                //             //   logger.debug(htmlEntity);
                //               // System.out.println(htmlEntity);
                //                vo = ServerUtils.QueryDouyuDownloadUrl(EntityUtils.toString(entity) );
                //            }

                ///ogger.info(vo.getServers() );

                //


                val request = Request.Builder()
                        .url(apiurl)
                        .build()

                response = HttpClientFactory.get().okclient.newCall(request).execute()


                if (response!!.isSuccessful) {

                    val body = response.body()!!.string()

                    val gson = Gson()
                    vo = gson.fromJson(body, OpenRoomApi::class.java)


                }


                return vo

            } catch (var13: Exception) {
                var13.printStackTrace()
            } finally {
                if (response != null) response.body()!!.close()
                //            get.abort();
                //            if(entity != null) {
                //                EntityUtils.consumeQuietly(entity);
                //            }

            }

            return vo
        }


        fun QueryDouyuDownloadUrl(roomNum: Int, cdn: String): DouyuApiDataVo {
            var vo = DouyuApiDataVo()
            //        HttpEntity entity = null;
            //        HttpGet get = null;
            var response: Response? = null

            try {

                //        	const getSwfApi = (rid) => {
                //        		  const API_KEY = 'bLFlashflowlad92'
                //        		  const tt = Math.round(new Date().getTime() / 60 / 1000)
                //        		  const signContent = [rid, API_KEY, tt].join('')
                //        		  const sign = md5(signContent)
                //        		  return fetch(`http://www.douyutv.com/swf_api/room/${rid}?cdn=&nofan=yes&_t=${tt}&sign=${sign}`)
                //        		  .then(res => res.json())
                //        		  .then(r => r.data)
                //        		}


                //            def douyu_api_android_hd(rid):
                //                APPKEY = 'Y237pxTx2In5ayGz'
                //                to_sign = 'room/{0}?aid=androidhd1&cdn={1}&client_sys=android&time={2}'.format(rid, 'ws', int(time.time()))
                //                sign = hashlib.md5(bytes(to_sign+APPKEY, 'utf8')).hexdigest()
                //                endpoint = 'https://capi.douyucdn.cn/api/v1/{0}&auth={1}'.format(to_sign, sign)
                //                json_data = requests.get(endpoint).json()
                //                if json_data['error'] != 0:
                //                    raise Exception(json_data['data'])
                //                return json_data['data']['rtmp_url'] + '/' + json_data['data']['rtmp_live']


                //http://capi.douyucdn.cn/api/v1/room/2001499?aid=androidhd1&cdn=ws&client_sys=android&time=1500983542&auth=0dde0536c5b91923614fca4705606677

                //http://www.douyu.com/swf_api/room/141371?cdn=&nofan=yes&_t=24487156&sign=c2c0e502375e6425e32a6d40929d70cd


//                http.headers.update({'User-Agent': useragents.WINDOWS_PHONE_8})
//
//                cdns = ["ws", "tct", "ws2", "dl"]
//
//                ts = int(time.time())
//
//                suffix = "room/{0}?aid=wp&cdn={1}&client_sys=wp&time={2}".format(channel, cdns[0], ts)
//
//                sign = hashlib.md5((suffix + API_SECRET).encode()).hexdigest()
//
//
//
//                res = http.get(API_URL.format(suffix, sign))


                val API_SECRET = "zNzMV1y4EMxOHS6I5WKm"
                val time = java.lang.Long.valueOf(System.currentTimeMillis() / 1000)!!.toString() + ""
                //http://capi.douyucdn.cn/api/v1/room/145201?aid=android1&client_sys=android&ne=1&support_pwd=1&time=1469155020&auth=b6f26683a970c5b0e524c47516b6c4f1
                val e = String.format("room/%s?aid=wp&cdn=%s&client_sys=wp&time=%s", roomNum, cdn, time)
                val auth = MD5Util.MD5(e + API_SECRET)!!.toLowerCase()
                //String apiurl = "https://www.douyu.com/swf_api/room/"+roomNum+"?cdn=&nofan=yes&_t="+time+"&sign="+auth;

                val apiurl = String.format("http://capi.douyucdn.cn/api/v1/%s&auth=%s", e, auth)
                //            get = new HttpGet(apiurl);
                //           // get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.0.2403.157 Safari/537.36");
                //            HttpResponse response = HttpClientFactory.getHttpClient().execute(get);
                //            if(response.getStatusLine().getStatusCode() == 200) {
                //                entity = response.getEntity();
                //           //     String htmlEntity = EntityUtils.toString(entity);
                //
                //             //   logger.debug(htmlEntity);
                //               // System.out.println(htmlEntity);
                //                vo = ServerUtils.QueryDouyuDownloadUrl(EntityUtils.toString(entity) );
                //            }

                ///ogger.info(vo.getServers() );

                //


                val request = Request.Builder()
                        .url(apiurl)
                        .build()

                response = HttpClientFactory.get().okclient.newCall(request).execute()


                if (response!!.isSuccessful) {

                    val body = response.body()!!.string()

                    vo = QueryDouyuDownloadUrl(body)
                }


                return vo

            } catch (var13: Exception) {
                vo = DouyuApiDataVo()
            } finally {
                if (response != null) response.body()!!.close()
                //            get.abort();
                //            if(entity != null) {
                //                EntityUtils.consumeQuietly(entity);
                //            }

            }

            return vo
        }


        @Throws(Exception::class)
        fun QueryDouyuDownloadUrl(roomApiStr: String): DouyuApiDataVo {

            val gson = Gson()
            val roomApiVo = gson.fromJson(roomApiStr, DouyuApiVo::class.java)

            //logger.debug(roomApiVo);

            return roomApiVo.data //.getRtmp_url() + "/" + roomApiVo.getData().getRtmp_live();
        }


        @Throws(Exception::class)
        fun getList(url: String): List<String> {
            val list = ArrayList<String>()
            val request = Request.Builder()
                    .url(url)
                    .build()
            var response: Response? = null
            try {


                response = HttpClientFactory.get().okclient.newCall(request).execute()


                if (response!!.isSuccessful) {

                    val bufferedSource = response.body()!!.source()


                    var line: String? = "";


                    while (bufferedSource.readUtf8Line().apply { line = this } != null) {


                        line?.let {



                          if(!it.startsWith("#")) {

                                if (!it.startsWith("http") )  {

                                    // val baseUrl = getBaseUrl(url)
                                    list.add(getBaseUrl(url) + it)

                                } else {
                                    list.add(it)
                                }

                            }


                        }
//
//
//
//                         if(!line!!.startsWith("#") ){
//
//                            if (line!!.startsWith("http") )  {
//
//                               // val baseUrl = getBaseUrl(url)
//                                list.add(getBaseUrl(url) + line)
//
//                            } else {
//                                list.add(line!!)
//                            }
//
//
////                            else {
////                                list.add(line)
////                            }
//
//                        }

                    }

                    closeQuietly(bufferedSource)
                }
                return list

            } catch (var13: Exception) {
                var13.printStackTrace()
            } finally {

                response?.close()

            }

            return list

        }


        fun getBaseUrl(urlString: String): String {
            //  String urlString = url.toString();
            var index = urlString.lastIndexOf('/')
            return urlString.substring(0, ++index)
        }

        fun closeQuietly(closeable: Closeable?) {

            if (closeable != null) {

                try {

                    closeable.close()

                } catch (rethrown: RuntimeException) {

                    throw rethrown

                } catch (ignored: Exception) {

                }

            }

        }
    }


}