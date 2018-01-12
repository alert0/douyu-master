package name.yumao.douyu.vo;

/**
 * Created by PC on 2017/8/4.
 */

public class H5Api {


    /**
     * error : 0
     * data : {"hls_url":"http://hls3a.douyucdn.cn/live/276685rw4aN23gpF_550/playlist.m3u8?wsSecret=f03bbda1a36756f73ed1533fec81c972&wsTime=1501845423&token=h5-douyu-0-276685-f3dc1a0b377233066b7f374379be753c&did=h5_did"}
     */

    private int error;
    private DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * hls_url : http://hls3a.douyucdn.cn/live/276685rw4aN23gpF_550/playlist.m3u8?wsSecret=f03bbda1a36756f73ed1533fec81c972&wsTime=1501845423&token=h5-douyu-0-276685-f3dc1a0b377233066b7f374379be753c&did=h5_did
         */

        private String hls_url;

        public String getHls_url() {
            return hls_url;
        }

        public void setHls_url(String hls_url) {
            this.hls_url = hls_url;
        }
    }
}
