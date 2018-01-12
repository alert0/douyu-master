package name.yumao.douyu;


import com.google.common.eventbus.EventBus;
import com.tznin.http.Config;
import com.tznin.http.DownloaderThead;
import com.tznin.http.DownloaderThead2;
import com.tznin.http.DownloaderThread3;
import name.yumao.douyu.swing.Download;
import name.yumao.douyu.swing.InfoThead;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.util.concurrent.TimeUnit;


public class DouyuAssistantMain extends JFrame{
	private static final long serialVersionUID = 1L;
	//public static final EventBus e = new EventBus();
	@SuppressWarnings("unused")

	public static EventBus DateeventBus = new EventBus();

	public static void main(String[] args) throws Exception{




//		DouyuApiDataVo vo = HttpClientFromDouyu.QueryDouyuDownloadUrl("2001499");
//		

//		DateeventBus.register(new DyBulletScreenClient() );
//		
//		System.out.println(vo);
		//GET /api/v1/room/2001499?aid=androidhd1&cdn=ws&client_sys=android&time=1500984245&auth=79646ff13cc5afeb43f59a705ed5bc62 HTTP/1.1
//		 ScheduledExecutorService executor = Executors.newScheduledThreadPool(100);  
//		
//		final ExecutorService executorService = Executors.newCachedThreadPool();
//    	
//    	
//    	executorService.submit(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//		        JsInServer.jsrun("67373"); 
//		        HttpClientFromDouyu.getHTML5DownUrl();
//			}
//		});
//	
		JTextField inNum2=new JTextField(10);
		InfoThead infoThead = new InfoThead(inNum2,false);
		Thread infoWrite = new Thread(infoThead);
		infoWrite.start();
//		

		TimeUnit.MILLISECONDS.sleep(2000);
		//HttpClientFromDouyu.QueryDouyuDownloadUrl(inNum.getText(),Config.cdn)
		
//
//		if(args[0].equals("-content")){
//			Danmu danmu = new Danmu();
//		}else

		if(args[0].equals("-download")){
			Download download = new Download();
		}else


			if(args[0].equals("-start") ) {
			
			int lenght = args.length;
			
			for(int i = 1; i < args.length ;i++) {
//				PlaylistDownloader.go(args[i] );

				int  room = Integer.valueOf(args[i]);
		//		http://www.douyu.com/lapi/live/getPlay/632223
				(new Thread(new DownloaderThead(room, Config.cdn, Config.rate))).start();
				//pool.execute( new DownloaderThead(inNum,Config.cdn,Config.rate) );
//			    JButton butnSure=new JButton("录像");
//			    EventBus eventBus = new EventBus();
//				PlaylistDownloader33333 downloader = new PlaylistDownloader33333(inNum,eventBus);
//				downloader.go();

//				executor.scheduleAtFixedRate(
//						new DownloaderThead(inNum),
//						0,
//						30,
//						TimeUnit.MINUTES);
			    
			}

		}
		else {
			System.out.print("错误的传入参数！");
		}
		
			

	}	
}
