package name.yumao.douyu;

import name.yumao.douyu.mina.ContentMinaThread;
import name.yumao.douyu.swing.ToolTipInterface;
import name.yumao.douyu.utils.ClassUtils;

public class Test {

    public static void main(String[] args) throws Exception {
         ToolTipInterface tti =null;
        if(tti == null){
            tti = ClassUtils.getInstance().getTTI();
        }
//        tti.setToolTip("获取的登录用户名为: "+nickname);
//        logger.info("获取的登录用户名为: "+nickname);
//        Thread.sleep(100);
//        tti.setToolTip("登陆的房间编号为: "+inNum.getText()+" 床");
//        logger.info("登陆的房间编号为: "+inNum.getText()+" 床");
//        Thread.sleep(100);
//        tti.setToolTip("加入的讨论群组为: "+gid+" 组");
//        logger.info("加入的讨论群组为: "+gid+" 组");
//        Thread.sleep(100);
//        if(filepath!=null&&(!filepath.equals(""))){
//            tti.setToolTip("启动录制进程...");
//        }else{
//            //启动弹幕获取进程
//            tti.setToolTip("启动弹幕获取进程...");
//        }
//			ContentMinaThread contentMina = new ContentMinaThread("aa.txt",contentServerList,inNum,username,"-9999",tti,session);
//			Thread contentMinaThead = new Thread(contentMina);
//			contentMinaThead.start();
//			 DouyuAssistantMain.e.register(contentMina);
    }

}
