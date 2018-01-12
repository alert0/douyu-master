package name.yumao.douyu.mina;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.JTextField;

import name.yumao.douyu.swing.ToolSub2;
import name.yumao.douyu.swing.ToolTipInterface;
import name.yumao.douyu.utils.ClassUtils;
import name.yumao.douyu.utils.SttDecoder;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

public class ContentMinaHandler implements IoHandler {
	

	
	private ToolSub2 sub = null;
	private ToolTipInterface tti = null;
	private String filepath;
	private JTextField inNum;
	//private JButton butnSure;
	private IoSession loginSession;
	private SttDecoder sttDecoder;
	private SttDecoder suiDecoder;
	private Calendar calendar;
	private static Logger logger = Logger.getLogger(ContentMinaHandler.class);
	public ContentMinaHandler(String filepath,JTextField inNum,ToolTipInterface tti,IoSession loginSession){
		this.filepath = filepath;
		this.inNum = inNum;
		//this.butnSure = butnSure;
		this.tti = tti;
		this.loginSession = loginSession;
		this.sttDecoder = new SttDecoder();
		this.suiDecoder = new SttDecoder();
		this.calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dabPath = "logs"+File.separator+"dab"+File.separator+simpleDateFormat.format(calendar.getTime())+"-"+inNum.getText()+".dab";

	}
	@Override
	public void exceptionCaught(IoSession session, Throwable arg1)
			throws Exception {
	}
	@Override
	public void messageReceived(IoSession session, Object message) throws Exception{
		String msgStr = (String)message;
       
		//评论解析操作

		sttDecoder.Parse(msgStr);
		
//		if(!sttDecoder.GetItem("type").equals("chatmessage") ) {
//			// logger.info("DanmuServer:" + msgStr);
//		}
		
		//收到评论
		if(sttDecoder.GetItem("type").equals("chatmsg")){
			if(filepath!=null&&(!filepath.equals(""))){
				//进行弹幕分析 拉起字幕转储进程
				
				String content = sttDecoder.GetItem("txt");
				//logger.info("DanmuServer:" + content);
				sub.addSubString(content.replace("=", "-"));

				logger.debug( inNum.getText()+": " +content ) ;
			}else{
				//进行弹幕分析 拉起气泡进程
				String content = sttDecoder.GetItem("content");
				String snick = sttDecoder.GetItem("snick");
				logger.info("接收到弹幕消息\t" + snick + " : " +content);
				
				
				
				if(tti == null){
					tti = ClassUtils.getInstance().getTTI();;
				}
				
				tti.setToolTip(snick + " : " +content);

			}
			
//			String content = sttDecoder.GetItem("content");
//			String snick = sttDecoder.GetItem("snick");
//			logger.debug( inNum.getText()+":"+snick + " : " +content ) ;
		}
		
	}
	@Override
	public void messageSent(IoSession session, Object massage) throws Exception {
//		String msg =new String(HexUtils.HexString2Bytes(massage.toString()),"utf-8") ;
//		logger.info("Send Danmu Server " + msg);
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		sub.close();
		inNum.setEditable(true);
		//butnSure.setEnabled(true);
		loginSession.close(true);
		tti.setToolTip("失去与弹幕服务器的连接");
		logger.info("失去与弹幕服务器的连接");
		
	}




	@Override
	public void sessionCreated(IoSession session) throws Exception {
		if(filepath!=null&&(!filepath.equals(""))){
			//录制模式建立连接的同时建立字幕文件
			if(sub == null){
				sub = new ToolSub2(filepath);
			}
		}
		
	}
	@Override
	public void sessionIdle(IoSession session, IdleStatus arg1) throws Exception {
	}
	@Override
	public void sessionOpened(IoSession session) throws Exception {
	}
}
