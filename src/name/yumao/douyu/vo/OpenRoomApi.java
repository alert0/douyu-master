package name.yumao.douyu.vo;

import java.util.List;

/**
 * Created by PC on 2017/8/3.
 */

public class OpenRoomApi {


    /**
     * error : 0
     * data : {"room_id":"67373","room_thumb":"https://rpic.douyucdn.cn/a1708/03/01/67373_170803015152.jpg","cate_id":"19","cate_name":"主机游戏","room_name":"陈一发儿：神秘海域 4","room_status":"2","owner_name":"陈一发儿","avatar":"https://apic.douyucdn.cn/upload/avatar/002/28/65/01_avatar_big.jpg?rltime?rltime","online":0,"owner_weight":"765.83t","fans_num":"5612287","start_time":"2017-08-02 21:01","gift":[{"id":"1005","name":"超级火箭","type":"2","pc":2000,"gx":20000,"desc":"赠送全站广播并派送鱼丸宝箱","intro":"","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/674c98b8acde7b7791512c82adfdf68d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/c3f3f69e1fdc4f9b2c02a7bcd30334eb.gif"},{"id":"196","name":"火箭","type":"2","pc":500,"gx":5000,"desc":"赠送网站广播并派送出神秘宝箱","intro":"我们的征途是星辰大海","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/26f802520cf0e4d8a645259bbc1aadf3.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/39b578b3cb8645b54f9a1001c392a237.gif"},{"id":"195","name":"飞机","type":"2","pc":100,"gx":1000,"desc":"赠送房间广播并赠送道具宝箱","intro":"主播带我飞","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/76dd0d8c803b133467e4f0196c7d071d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/93daef170894a9d6bd8495fa0f81e165.gif"},{"id":"750","name":"办卡","type":"2","pc":6,"gx":60,"desc":"","intro":"老板，来办张卡吧！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1704/74c75c59a1e9338d0b25b62546b84b1d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1704/130dc639eadd4f79b3d9e24ead4b9ced.gif"},{"id":"268","name":"发财","type":"2","pc":0.8,"gx":8,"desc":"","intro":"我爱发发！！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1608/f261f5b316befb817b54b4026deaa9f2.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1608/28d154a7ed6e5deb77e10bfcb525f86f.gif"},{"id":"192","name":"赞","type":"2","pc":0.1,"gx":1,"desc":"","intro":"赞一个！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/d1ebe78032472a3146b5f8e717ead680.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/b09488ff5ebe85c4f66e72e27b53d517.gif"},{"id":"191","name":"100鱼丸","type":"1","pc":100,"gx":1,"desc":"","intro":"绝佳的增重美食","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/37a913eb1d9b3e8e6278d8a309696d58.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/072dc9aea67fb42f095f973c8e0a183e.png"}]}
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


        @Override
        public String toString() {
            return "DataBean{" +
                    "room_id='" + room_id + '\'' +
                    ", room_thumb='" + room_thumb + '\'' +
                    ", cate_id='" + cate_id + '\'' +
                    ", cate_name='" + cate_name + '\'' +
                    ", room_name='" + room_name + '\'' +
                    ", room_status='" + room_status + '\'' +
                    ", owner_name='" + owner_name + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", online=" + online +
                    ", owner_weight='" + owner_weight + '\'' +
                    ", fans_num='" + fans_num + '\'' +
                    ", start_time='" + start_time + '\'' +
                    '}';
        }

        /**
         * room_id : 67373
         * room_thumb : https://rpic.douyucdn.cn/a1708/03/01/67373_170803015152.jpg
         * cate_id : 19
         * cate_name : 主机游戏
         * room_name : 陈一发儿：神秘海域 4
         * room_status : 2
         * owner_name : 陈一发儿
         * avatar : https://apic.douyucdn.cn/upload/avatar/002/28/65/01_avatar_big.jpg?rltime?rltime
         * online : 0
         * owner_weight : 765.83t
         * fans_num : 5612287
         * start_time : 2017-08-02 21:01
         * gift : [{"id":"1005","name":"超级火箭","type":"2","pc":2000,"gx":20000,"desc":"赠送全站广播并派送鱼丸宝箱","intro":"","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/674c98b8acde7b7791512c82adfdf68d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/c3f3f69e1fdc4f9b2c02a7bcd30334eb.gif"},{"id":"196","name":"火箭","type":"2","pc":500,"gx":5000,"desc":"赠送网站广播并派送出神秘宝箱","intro":"我们的征途是星辰大海","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/26f802520cf0e4d8a645259bbc1aadf3.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/39b578b3cb8645b54f9a1001c392a237.gif"},{"id":"195","name":"飞机","type":"2","pc":100,"gx":1000,"desc":"赠送房间广播并赠送道具宝箱","intro":"主播带我飞","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/76dd0d8c803b133467e4f0196c7d071d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/93daef170894a9d6bd8495fa0f81e165.gif"},{"id":"750","name":"办卡","type":"2","pc":6,"gx":60,"desc":"","intro":"老板，来办张卡吧！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1704/74c75c59a1e9338d0b25b62546b84b1d.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1704/130dc639eadd4f79b3d9e24ead4b9ced.gif"},{"id":"268","name":"发财","type":"2","pc":0.8,"gx":8,"desc":"","intro":"我爱发发！！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1608/f261f5b316befb817b54b4026deaa9f2.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1608/28d154a7ed6e5deb77e10bfcb525f86f.gif"},{"id":"192","name":"赞","type":"2","pc":0.1,"gx":1,"desc":"","intro":"赞一个！","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/d1ebe78032472a3146b5f8e717ead680.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/b09488ff5ebe85c4f66e72e27b53d517.gif"},{"id":"191","name":"100鱼丸","type":"1","pc":100,"gx":1,"desc":"","intro":"绝佳的增重美食","mimg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/37a913eb1d9b3e8e6278d8a309696d58.png","himg":"https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1606/072dc9aea67fb42f095f973c8e0a183e.png"}]
         */

        private String room_id;
        private String room_thumb;
        private String cate_id;
        private String cate_name;
        private String room_name;
        private String room_status;
        private String owner_name;
        private String avatar;
        private int online;
        private String owner_weight;
        private String fans_num;
        private String start_time;
       // private List<GiftBean> gift;

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getRoom_thumb() {
            return room_thumb;
        }

        public void setRoom_thumb(String room_thumb) {
            this.room_thumb = room_thumb;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRoom_status() {
            return room_status;
        }

        public void setRoom_status(String room_status) {
            this.room_status = room_status;
        }

        public String getOwner_name() {
            return owner_name;
        }

        public void setOwner_name(String owner_name) {
            this.owner_name = owner_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public String getOwner_weight() {
            return owner_weight;
        }

        public void setOwner_weight(String owner_weight) {
            this.owner_weight = owner_weight;
        }

        public String getFans_num() {
            return fans_num;
        }

        public void setFans_num(String fans_num) {
            this.fans_num = fans_num;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

//        public List<GiftBean> getGift() {
//            return gift;
//        }
//
//        public void setGift(List<GiftBean> gift) {
//            this.gift = gift;
//        }

        public static class GiftBean {
            /**
             * id : 1005
             * name : 超级火箭
             * type : 2
             * pc : 2000
             * gx : 20000
             * desc : 赠送全站广播并派送鱼丸宝箱
             * intro :
             * mimg : https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/674c98b8acde7b7791512c82adfdf68d.png
             * himg : https://staticlive.douyucdn.cn/storage/webpic_resources/upload/dygift/1707/c3f3f69e1fdc4f9b2c02a7bcd30334eb.gif
             */

            private String id;
            private String name;
            private String type;
            private int pc;
            private int gx;
            private String desc;
            private String intro;
            private String mimg;
            private String himg;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public int getPc() {
                return pc;
            }

            public void setPc(int pc) {
                this.pc = pc;
            }

            public int getGx() {
                return gx;
            }

            public void setGx(int gx) {
                this.gx = gx;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getMimg() {
                return mimg;
            }

            public void setMimg(String mimg) {
                this.mimg = mimg;
            }

            public String getHimg() {
                return himg;
            }

            public void setHimg(String himg) {
                this.himg = himg;
            }
        }
    }
}
