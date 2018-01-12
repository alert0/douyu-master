package name.yumao.douyu.mina;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;

import com.tznin.http.Config;
import com.tznin.http.HttpClientFromDouyu;
import name.yumao.douyu.mina.factory.DouyuCodecFactory;
import name.yumao.douyu.utils.MD5Util;
import name.yumao.douyu.utils.SttDecoder;
import name.yumao.douyu.utils.SttEncoder;
import name.yumao.douyu.vo.DouyuApiDataVo;
import name.yumao.douyu.vo.DouyuApiServersVo;

import org.apache.log4j.Logger;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import com.google.common.io.Files;
import org.jetbrains.annotations.NotNull;

//import com.google.common.eventbus.EventBus;

public class LoginMinaThread implements Runnable {
    private static Logger logger = Logger.getLogger(LoginMinaThread.class);
    private String Server1_Host;
    private int Server1_Port;
    private String filepath;
    private JTextField inNum;
    //	private JButton butnSure;
    private SttEncoder sttEncoder;
    private Properties properties;

    // EventBus eventBus ;
    public LoginMinaThread(String filepath, JTextField inNum/*,   EventBus eventBus*/) {
        //拉起进程同时随机选择登陆服务器

        //初始化
        this.inNum = inNum;
        //	this.butnSure = butnSure;
        this.sttEncoder = new SttEncoder();
        this.filepath = filepath;
        //this.eventBus = eventBus;
        //设置配置文件读取路径
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream("conf" + File.separator + "auth.properties"));
            this.properties = new Properties();
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {


        DouyuApiDataVo api = getDouyuApiDataVo();
        boolean isLogin =   login(api);

        while (!isLogin) {
            api = getDouyuApiDataVo();
            isLogin = login(api);
        }

    }






    private boolean login(DouyuApiDataVo api) {
        try {

            writeRoomInfo(api);


            IoConnector connector = new NioSocketConnector();
            DefaultIoFilterChainBuilder chain = connector.getFilterChain();
            chain.addLast("codec", new ProtocolCodecFilter(new DouyuCodecFactory()));
            connector.setHandler(new LoginMinaHandler(filepath, inNum, properties));
            IoSession session = null;

            ConnectFuture future = connector.connect(new InetSocketAddress(Server1_Host, Server1_Port));
            future.awaitUninterruptibly();
            session = future.getSession();
            SttDecoder sttDecoder = new SttDecoder();
            sttDecoder.Parse(inNum.getText());
            if (sttDecoder.GetItem("type") != null) {
                session.write(inNum.getText());
                inNum.setText(sttDecoder.GetItem("roomid"));
            } else {
                //发送匿名登录信息
                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();
                long nowTime = date.getTime() / 1000;
                sttEncoder.Clear();
                sttEncoder.AddItem("type", "loginreq");

                sttEncoder.AddItem("username", "");
                sttEncoder.AddItem("password", "");

                String uuid = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                String timestamp = Long.toString(nowTime);
                sttEncoder.AddItem("roomid", inNum.getText());
                sttEncoder.AddItem("ct", "2");
                sttEncoder.AddItem("devid", uuid);
                sttEncoder.AddItem("ver", "20150526");
                sttEncoder.AddItem("rt", timestamp);
                sttEncoder.AddItem("vk", MD5Util.MD5(timestamp + "7oE9nPEG9xXV69phU31FYCLUagKeYtsF" + uuid));
                session.write(sttEncoder.GetResualt());
            }


        } catch (Exception e) {

            logger.info("登录服务器通讯失败 " + e.toString());
            return  false;

        }

        return  true;
    }

    private void writeRoomInfo(DouyuApiDataVo api) {
        try {

            Pattern pattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
            Matcher matcher = pattern.matcher(api.getRoom_name());
            String fileName = matcher.replaceAll(""); // 将匹配到的非法字符以空替换
            Path path = Paths.get(filepath).getParent().resolve(fileName);
            File file = path.toFile();
            Files.write(api.toString().getBytes(), file);
        } catch (IOException fileIoEx) {
            fileIoEx.printStackTrace();
        }
    }

    @NotNull
    private DouyuApiDataVo getDouyuApiDataVo() {
        DouyuApiDataVo api = HttpClientFromDouyu.Companion.QueryDouyuDownloadUrl(Integer.valueOf(inNum.getText()), Config.cdn);
        DouyuApiServersVo loginServerVo = api.getServers().get((int) (Math.random() * api.getServers().size()));
        Server1_Host = loginServerVo.getIp();
        Server1_Port = Integer.parseInt(loginServerVo.getPort());
        logger.info("随机选择登陆服务器 " + Server1_Host + ":" + Server1_Port);
        return api;
    }

}
