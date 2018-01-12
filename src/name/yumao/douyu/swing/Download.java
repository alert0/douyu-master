package name.yumao.douyu.swing;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;


import com.tznin.http.Config;
import com.tznin.http.DownloaderThead;
import name.yumao.douyu.utils.HexUtils;
import name.yumao.douyu.utils.NumUtils;
import org.apache.mina.util.Base64;

public class Download extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	static Point origin = new Point();
	private JLabel titleLabel=new JLabel("斗鱼录制小助手170726");
	private JButton smallButton=new JButton("_");
	private JButton closeButton=new JButton("x");
	private JLabel nameLabel=new JLabel("请输入房间号：");
	private JButton butnSure=new JButton();
	private JLabel supLabel=new JLabel("陈一发儿(67373) 感谢微信赞助,点击录制");
	private JTextField inNum=new JTextField(10);
	private JPanel titlePanel = new JPanel();
	private JPanel bodyPanel = new JPanel();
	public Download(){
		super("斗鱼TV录制小助手");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		setIconImage(toolkit.createImage(HexUtils.HexString2Bytes("89504E470D0A1A0A0000000D49484452000000300000003008060000005702F9870000040A4944415478DAED5A5D884C511C3FCB2EA125928F658B9DD9B9F79C29F9286D59421E90F2E23379525E3C294979584FB229691177CEC70AB1294929F222495192105949618B5D33F79C6BC75A96EB7F66F60ECB2C967BE7DEA93D759E7666EFEFF7BFFFFFEFFF3508FD74DC2634C23D131F2F05DEE808F2350A372BCC351A93EBA20A34D87111AA70ADBA098E95687444D2CD5D9EFCA444D20EF36A0C053C804D1BF857F0C0ACBBB57E6EE18382F43A9C74388C7014F2D118725834268DEDA4B128CB8D9A8104B4E53DE082B42B81DB50C48EE2F89CE4E4A36764ED52059F0786FD6E43DA51848F36AC12A427EFDEA4314F009878D6873FB6A1881FC593E73C7772AFA34A94579B1CA30E5426271F13495771B20AE5A44A473A0F3F6087408079EA9423A0E50A95D901EBCB6102E12A1224B9E137304C60D885FE4CA08B1BD532656CB053F8147CE94C29AE64F8804CE115FAD9FF4DE05113192585B1CE66F80924902FDF2BD6602E00CB2A06350FC50D2E3CDB17177A4B674F05AB34C3FD103401A8381F4A96D8F4EAD0CC31BE05B16E76243596C33FBF09055F5F600438492B4A5ADE5AF198EF2AF4E6D4D4719219BB2525997CAB1708813B8A265643895F19880A65A8314732F3023CE893EFAE23C86B49F1DE3707635302CB03EE7A3412D4681B7447CF7D0D6830889D32AF281A6FD0EE1A6822D31692D43C0EF1D0E317019BE3A78A25B6DEB5505549121948DC6AB0C06DA8C93FFB607D2939669DA2AEBE64A584BB1D55412CEC075792FF17D0E42BF8FD039B1A6B4B5E0B29461642937D353F29F83712A0689D3ABF741DA9AD09A51682ECBC13DEC4AB7F0B68D2670B7C2B63251A43AB46D374C64C78FDBA7E793FB4B700CFA4E44586E21D1D4DD3C7865A4E43865E0760EE0F25A0154F6665CA3CEF580933F472FA590B1AED307C1862E22F333494229C3C4E03F1C834340E4D2CB6A979B330BFFC3D01099F3D9A3E16AB8D544706C96D4FFF1076F0800637B319B99339819744AE2393504182245E0412D9E2AEA4359F7402815DE996FEC16CD47AE20CADDF0CCAD2AE8ACA2AE905D9BDFCCE9A65FAF1AC400874354FAE56DC4C015035F02DE464F3659A1B1BAE2FFD73A91C6A53AFB7281986EF39031B9F5E09C4BA5B674D8BFC584597C3A032FBA040EBF2765C101B0F6C2BB6AC6CE6423DBCBE0EDEC2B5BC2291BE0C4DEC49B74C1AEF2B81A0E7422A656C510CA7C1FA37FC0ADC924EE65C6BE204004FA18F5EAFCBEF400904B5E0502C16F7DB7572422188282C38F412B95C574CDDAD64E5F7255F9910782F9267072CF9745AF7B6F2D05D5D8AF644BAD89AD5451552E0F95EBA07124FF552397A96C7670BE07F5C747B24B22C3EAFD07008F2510F9AF4363002FECE34168D4963FBA07F6A701A4F2F9A41CBF6C71EBF6AF8822AE8B056063D891EC2C87D95C6540CEB372AC55E42460893970000000049454E44AE426082")));
		setUndecorated(true);
		//主体大框
		Dimension dimension=toolkit.getScreenSize();
		setBounds((dimension.width-320)/2, (dimension.height-180)/2, 320, 180);

		setResizable(false); 
		setLayout(null);
		addWindowListener(new WindowHandler());
		//分层背景丢上去
		titlePanel.setBounds(0, 0, 320, 30);
		titlePanel.setBackground(new Color(240,150,50));
		titlePanel.setBorder(new MatteBorder(0, 1, 0, 1, new Color(240,150,50)));
		add(titlePanel);
		bodyPanel.setBounds(0, 30, 320, 150);
		bodyPanel.setBackground(new Color(255,255,255));
		bodyPanel.setBorder(new MatteBorder(0, 1, 1, 1, new Color(240,150,50)));
		add(bodyPanel);
		//标题栏
		titleLabel.setBounds(10, 0, 160, 30);
		titleLabel.setFont(new Font("Microsoft Yahei",Font.BOLD,13));
		titleLabel.setForeground(new Color(255,255,255));
		add(titleLabel,0);
		//最小化以及关闭
		smallButton.setBounds(270, 0, 20, 30);
		smallButton.setFont(new Font("Microsoft Yahei",Font.BOLD,12));
		smallButton.setForeground(new Color(255,255,255));
		smallButton.setMargin(new Insets(0, 0, 0, 0));
		smallButton.setBorder(null);
		smallButton.setOpaque(false);
		smallButton.setIconTextGap(0);
		smallButton.setContentAreaFilled(false);
		smallButton.setFocusable(false);
		smallButton.addActionListener(this);
		add(smallButton,0);
		closeButton.setBounds(290, 0, 20, 30);
		closeButton.setFont(new Font("Microsoft Yahei",Font.BOLD,12));
		closeButton.setForeground(new Color(255,255,255));
		closeButton.setMargin(new Insets(0, 0, 0, 0));
		closeButton.setBorder(null);
		closeButton.setOpaque(false);
		closeButton.setIconTextGap(0);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusable(false);
		closeButton.addActionListener(this);
		add(closeButton,0);
		//body部分
		nameLabel.setBounds(45, 50, 100, 25);
		nameLabel.setFont(new Font("微软雅黑",Font.BOLD,13));
		nameLabel.setForeground(new Color(240,150,50));
		add(nameLabel,0);
		inNum.setBounds(45, 80, 120, 60);
		inNum.setFont(new Font("微软雅黑",Font.BOLD,32));
		inNum.setBorder(new MatteBorder(1, 1, 1, 1, new Color(240,150,50)));
		inNum.setText("67373");
		inNum.setEditable(true);
		add(inNum,0);
		
		
		butnSure.setBounds(180,40,109,106);
		//butnSure.setFont(new Font("微软雅黑",Font.BOLD,32));
//		butnSure.setForeground(new Color(240,150,50));
//		butnSure.setMargin(new Insets(0, 0, 0, 0));
//		butnSure.setBorder(new MatteBorder(1, 1, 1, 1, new Color(240,150,50)));
//		butnSure.setOpaque(false);
//		butnSure.setIconTextGap(0);
//		butnSure.setContentAreaFilled(false);
		butnSure.setFocusable(false);
		butnSure.addActionListener(this);
		butnSure.setEnabled(true);
		
		String data = "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";
		byte[] byteArray = Base64.decodeBase64(data.getBytes() );
		ImageIcon icon = new ImageIcon(byteArray);
		butnSure.setIcon(icon);
//		
		add(butnSure,0);
		supLabel.setFont(new Font("微软雅黑",Font.BOLD,13));
		supLabel.setBounds(45,115,240,80);
		supLabel.setForeground(new Color(240,150,50));
		add(supLabel,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//最小化到任务栏
		PopupMenu popupMenu = new PopupMenu();
		MenuItem openDouyuContent = new MenuItem("打开");
		MenuItem exitDouyuContent = new MenuItem("退出");
		//打开按钮
		openDouyuContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 setExtendedState(JFrame.NORMAL);
                 setVisible(true);
			}
		});
		//退出按钮
		exitDouyuContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		//添加到菜单
		popupMenu.add(openDouyuContent);
		popupMenu.add(exitDouyuContent);
		SystemTray tray = SystemTray.getSystemTray();
	    TrayIcon trayIcon = new TrayIcon(toolkit.createImage(HexUtils.HexString2Bytes("89504E470D0A1A0A0000000D49484452000000100000001008060000001FF3FF61000001554944415478DA63F8385BD3E2D31CAD799FE769377F9AAB598A8CBFCCD32AF908C4E834104FFE344FABF2FF12153E0690E68FB3D4DD5F2C12E766201280D47E9CAB550C34249D0164F37F1234231BF2619ED64606905319C8041FE769EFA09E01676632B07E9CAB7111E8AF7F9FE669FFC78EB5FE7D9CA3B9E23F502D5617BC9BA228FF618ED61B5C06BC9FA375E7FD7C0101141780A206D9591FE66874E33640A308C30B1FD10CF8BA504DFAE35CCD0F1806CCD5BCF17EBE82008601E82E00BB62AE7AD887B95A3F609A8171FEE9ED0C154BAC81F8118B01FF27A9B00335ED831B304F6BE5FE7A0616AC06607301242CD49C41AE001AF4EEF3744D1D9CD1F8118701600573B4267F9CA79E8F371D7C9EAB350957527E375390FF75A7082F36B95753B578802E0426E5795A6D9FE668DA919299409A3F02A3149299A62B8B01B374F687B91A1B81FEDD4E0C06D90CD2FC7F950C2700BDDD29FCCB1525150000000049454E44AE426082")),"斗鱼TV录制小助手",popupMenu);

		MouseAdapter iconAdap = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2){
					setExtendedState(JFrame.NORMAL);
					setVisible(true);
				}
			}
		};
		trayIcon.addMouseListener(iconAdap);
		//防止程序崩溃 甩出错误信息
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		//拖拽功能
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				origin.x = e.getX();
				origin.y = e.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
			}
		});
		setVisible(true);
		
		InfoThead infoThead = new InfoThead(inNum,false);
		Thread infoWrite = new Thread(infoThead);
		infoWrite.start();
//		
//		DownloaderThead downloader = new DownloaderThead(inNum,Config.cdn,Config.rate);
//		Thread downloaderThead = new Thread(downloader);
//		downloaderThead.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == smallButton){
			this.setExtendedState(JFrame.ICONIFIED);
		}
		if(e.getSource() == closeButton){
			System.exit(0);
		}
		if (e.getSource() == butnSure) {
			inNum.setEditable(false);
			butnSure.setEnabled(false);
			if(NumUtils.isNumeric(inNum.getText())){
			}else{
				// 进行房间参数的号码转换
				//inNum.setText(HttpClientFromDouyu.QueryDouyuRoomNum(inNum.getText()));
			}
			
			InfoThead infoThead = new InfoThead(inNum,true);
			Thread infoWrite = new Thread(infoThead);
			infoWrite.start();
			//PlaylistDownloader.go(inNum.getText() );
			//开始拉起录制进
		
			DownloaderThead downloader =
					new DownloaderThead(Integer.valueOf(inNum.getText()),Config.cdn, Config.rate);
			Thread downloaderThead = new Thread(downloader);
			downloaderThead.start();
		}
	}
	//窗口最小化将面板可见性关闭
	class WindowHandler extends WindowAdapter {
		public void windowIconified(WindowEvent e) {
			dispose();
		}
	}
}
