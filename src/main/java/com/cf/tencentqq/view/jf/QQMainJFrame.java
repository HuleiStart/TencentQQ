package com.cf.tencentqq.view.jf;

import com.cf.tencentqq.dao.FriendsinfoDao;
import com.cf.tencentqq.dao.UserinfoDao;
import com.cf.tencentqq.entity.Friendsinfo;
import com.cf.tencentqq.entity.Userinfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.awt.Point;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/

@Component
public class QQMainJFrame extends javax.swing.JFrame implements WindowListener,Runnable{
	@Autowired
	UserinfoDao userinfoDao;

	@Autowired
	FriendsinfoDao friendsinfoDao;

	@Autowired
	HeadIconJF headIconJF;

	@Autowired
	FindFriendsJF findFriendsJF;
	@Autowired
	InfoJF infoJF;

	@Autowired
	QQChatJFrame qqChatJFrame;
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	private Userinfo userinfo;
	private JLabel headPortraitJL;
	private JPanel friendListJP;

	public  void  loadData(Userinfo userinfo){
		this.userinfo = userinfo;
		initGUI();
		this.setResizable(false);//窗口大小不变
		//当窗口关闭的时候，不操作
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		try {
			this.setIconImage(ImageIO.read(new ClassPathResource("static/images/1.jpg").getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//绑定窗体退出事件
		this.addWindowListener(this);
	}

	/**
	 * 传入更改后的头像id,修改主页面上的头像
	 * @param faceId
	 * @throws IOException
	 */
	public void updataIcon(String faceId) throws IOException {
		//定义头像容器
		ImageIcon updateID = new ImageIcon(ImageIO.read(new ClassPathResource("static/via/online/" +faceId+".png").getInputStream()));
		//设置头像容器大小
		updateID.setImage(updateID.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		//将头像容器放入头像标签中
		headPortraitJL.setIcon(updateID);
		//组件更新
		SwingUtilities.updateComponentTreeUI(headPortraitJL);
		this.userinfo.setFaceid(Integer.parseInt(faceId));
	}


	private void initGUI() {

		try {
			//修改关闭方式为：关闭窗口，退出程序
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			//固定窗口大小
			this.setResizable(false);
			//给窗口定位
			BorderLayout thisLayout = new BorderLayout();
			//控制组件位置
			this.setLocation(new Point(800, 30));
			//获取内容面板
			getContentPane().setLayout(thisLayout);
			{
				/**
				 * 第一层面板容器
				 */

				//	设置第一层面板 “昵称”+“头像”+“背景图片”
				JPanel firstJP = new JPanel();
				//将第一层面板容器加入到内容面板中
				getContentPane().add(firstJP, BorderLayout.NORTH);
				//清空布局
				firstJP.setLayout(null);
				//setSize是设定的固定大小，而setPreferredSize仅仅是设置最好的大小，这个不一定与实际显示出来的控件大小一致（根据界面整体的变化而变化）
				firstJP.setPreferredSize(new java.awt.Dimension(400, 200));
				{
					/**
					 * 设置头像
					 */

					//定义头像标签
					headPortraitJL = new JLabel();
					updataIcon(userinfo.getFaceid()+"");
					//将头像标签放入第一层面板中
					firstJP.add(headPortraitJL);
					//设置头像容器位置大小
					headPortraitJL.setBounds(15, 50, 60, 60);
					//添加点击头像事件
					headPortraitJL.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							headIconJF.changeIcon(userinfo);
						}
					});


					/**
					 * 设置QQ左上角LOGO
					 */

					//定义左上角LOGO容器
					JLabel QQLLogoJL = new JLabel();
					//定义LOGO容器
					ImageIcon bgLOGO = new ImageIcon(ImageIO.read(new ClassPathResource("static/images/QQLOGO.png").getInputStream()));
					//设置LOGO容器大小
					bgLOGO.setImage(bgLOGO.getImage().getScaledInstance(23, 25, Image.SCALE_DEFAULT));
					//将照片放入LOGO容器
					QQLLogoJL.setIcon(bgLOGO);
					//将LOGO容器放入第一层面板
					firstJP.add(QQLLogoJL);
					//设置LOGO容器位置
					QQLLogoJL.setBounds(5, 5, 23, 25);

					/**
					 * 添加窗体QQnav
					 */

					//定义右上角导航栏容器
					JLabel qqNav= new JLabel();
					//设置导航栏图片大小位置
					qqNav.setBounds(200,5,200,31);
					//设置导航栏图片
					try {
						qqNav.setIcon(new ImageIcon(ImageIO.read(new ClassPathResource("static/images/QQnav.png").getInputStream()))
						);
					} catch (IOException e) {
						e.printStackTrace();
					}
					//将图片导入第一层面板
					firstJP.add(qqNav);
				}


				{

					/**
					 * 设置昵称
					 */

					//定义昵称容器
					JLabel nicknameJL = new JLabel();
					//设置容器大小位置
					nicknameJL.setBounds(80, 60, 250, 40);
					//设置容器默认文本
					nicknameJL.setText(userinfo.getNickname());
					//设置容器文字字体
					nicknameJL.setFont(new Font("华文彩云", Font.BOLD, 18));
					//设置文字颜色
					nicknameJL.setForeground(new Color(255,255,255));
					//将文本添加至第一次面板
					firstJP.add(nicknameJL);
					//添加点击头像事件
					nicknameJL.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							super.mouseClicked(e);
							infoJF.Info(userinfo);
						}
					});

					/**
					 * qq在线状态
					 */

					//定义在线状态
					JLabel stateJL = new JLabel();
					//将在线容器放入第一层面板
					firstJP.add(stateJL);
					//设置容器大小位置
					stateJL.setBounds(75, 100, 100, 25);
					//设置文本字体
					stateJL.setFont(new Font("仿宋简体", Font.BOLD, 12));

					switch (userinfo.getStateid()){
						case 1:
							stateJL.setText("离线");
							stateJL.setForeground(Color.GRAY);
							break;
						case 2:
							stateJL.setText("在线");
							stateJL.setForeground(Color.green);
							break;
						case 3:
							stateJL.setText("聊天中");
							stateJL.setForeground(Color.cyan);
							break;
						case 4:
							stateJL.setText("做饭中");
							stateJL.setForeground(Color.yellow);
							break;
						case 5:
							stateJL.setText("恋爱中");
							stateJL.setForeground(Color.red);
							break;
						case 6:
							stateJL.setText("干饭中");
							stateJL.setForeground(Color.pink);
							break;
					}

					/**
					 * 个性签名
					 */

					//个性签名容器
					JTextField  signatureJT = new JTextField();
					//将个性签名加入第一次面板
					firstJP.add(signatureJT);
					//去除输入框焦点，转移至firstJP
					firstJP.setFocusable(true);
					//设置容器大小位置
					signatureJT.setBounds(120, 100, 235, 25);
					//设置文字字体
					signatureJT.setFont(new Font("华文琥珀", Font.PLAIN, 12));
					//设置容器透明
					signatureJT.setOpaque(false);
					//设置字体颜色
					signatureJT.setForeground(new Color(255, 255, 255));
					//判断个性签名是否为空
					if(userinfo.getSignature() == null){
						//如果为空就显示“编辑个性签名”
						signatureJT.setText("编辑个性签名");
					}else{
						//不为空就显示个性签名
						signatureJT.setText(userinfo.getSignature());
					}

					//修改个性签名		监听焦点事件
					signatureJT.addFocusListener(new FocusAdapter() {
						//焦点获取
						@Override
						public void focusGained(FocusEvent e) {
							//判断是否为空
							if(signatureJT.getText().trim().equals("编辑个性签名")){
								//为空，当点击的时候就显示空白
								signatureJT.setText("");
							}
//							if(userinfo.getSignature() == null){
//								signatureJT.setText("");
//							}

						}
						//焦点丢失
						@Override
						public void focusLost(FocusEvent e) {
							//判断是否为空
							if(signatureJT.getText().trim().length() == 0){
								//如果为空，当鼠标移出时，显示“编辑个性签名”
								signatureJT.setText("编辑个性签名");
							}else{
								//不为空，创建一个userinfo1对象来更改数据库内容
								Userinfo userinfo1 = new Userinfo();
								//获取当前用户的id
								userinfo1.setId(userinfo.getId());
								//获取当前用户输入的个性签名
								userinfo1.setSignature(signatureJT.getText());
								//通过查询当前用户id来更改用户个性签名
								userinfoDao.update(userinfo1);

							}
						}
					});

					/**
					 * 设置QQ主页背景
					 */

					//定义主页背景容器
					JLabel QQRLogoJL = new JLabel();
					//创建背景容器并引入照片
					ImageIcon bgImage = new ImageIcon(ImageIO.read(new ClassPathResource("static/images/bailan.jpg").getInputStream()));
					//设置图片容器大小
					bgImage.setImage(bgImage.getImage().getScaledInstance(400, 225, Image.SCALE_DEFAULT));
					//将图片容器放入主页背景容器
					QQRLogoJL.setIcon(bgImage);
					//将主页背景容器放入第一层面板
					firstJP.add(QQRLogoJL);
					//设置图片容器大小位置
					QQRLogoJL.setBounds(0 , 0, 400, 225);
				}
			}

			{
				/**
				 * 底部内容面板
				 */

				// 定义第三层底部栏
				JPanel footJP = new JPanel();
				//将底部面板放入内容面板中
				getContentPane().add(footJP, BorderLayout.SOUTH);
				//清空布局
				footJP.setLayout(null);
				//面板大小随内容改变
				footJP.setPreferredSize(new java.awt.Dimension(400, 62));

				//设置底部栏背景
				JLabel menuJL = new JLabel(new ImageIcon(ImageIO.read(new ClassPathResource("static/images/menu.png").getInputStream())));
				//将底部背景容器放进底部容器中
				footJP.add(menuJL);
				//设置图标的位置
				menuJL.setBounds(0, 0, 60, 62);

				//设置底部栏背景
				JLabel findJL = new JLabel(new ImageIcon(ImageIO.read(new ClassPathResource("static/images/find.png").getInputStream())));
				//将底部背景容器放进底部容器中
				footJP.add(findJL);
				//设置图标的位置
				findJL.setBounds(55, 0, 51, 62);
				//打开添加好友界面
				findJL.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						findFriendsJF.Find(userinfo.getId());
					}
				});


				//设置底部栏背景
				JLabel footerJL = new JLabel(new ImageIcon(ImageIO.read(new ClassPathResource("static/images/footer-2.png").getInputStream())));
				//将底部背景容器放进底部容器中
				footJP.add(footerJL);
				//设置图标的位置
				footerJL.setBounds(100, 0, 288, 62);



			}
			//中间表格层		“好友”+“群组”+“空间”
			{

				/**
				 * 中间表格层
				 */

				//设置好友表格容器
				JTabbedPane friendJT = new JTabbedPane();
				//获取面板内容
				getContentPane().add(friendJT, BorderLayout.CENTER);
				{

					/**
					 * 第二层面板
					 */

					//设置第二次面板
				    JPanel secondJP = new JPanel();
					//获取面板内容
				    BorderLayout secondJPLayout = new BorderLayout();
					//设置联系人标签
					friendJT.addTab("联系人", null, secondJP, null);
					//设置字体大小
					friendJT.setFont(new Font("华文中宋",Font.BOLD,14));
					//设置边框颜色
					friendJT.setBackground(new Color(215, 211, 211, 255));
					//清空布局
					secondJP.setLayout(secondJPLayout);


					{

						JButton friendJB = new JButton();
						secondJP.add(friendJB, BorderLayout.NORTH);
						friendJB.setForeground(new Color(96, 92, 89));
						friendJB.setFont(new Font("华文彩云",Font.PLAIN,13));
						friendJB.setText("好 友");

					}


					{
						JScrollPane friendJSP = new JScrollPane();
						secondJP.add(friendJSP, BorderLayout.CENTER);
						{
							friendListJP = new JPanel();
							//new GridLayout(行数, 列数, 水平间距,垂直间距);
							GridLayout friendListJPLayout = new GridLayout(7, 1, 0,15);

							friendListJP.setLayout(friendListJPLayout);
							
							//把面板放到滚动面板里
							friendJSP.setViewportView(friendListJP);
							
							//创建右键菜单 ： 删除好友,删除所有好友
							JPopupMenu rightClickJP = new JPopupMenu();
							//创建2个右键菜单项目
							JMenuItem item = new JMenuItem();
							item.setText("删除好友");
							
//							JMenuItem item2 = new JMenuItem();
//							item2.setText("删除所有好友");

							rightClickJP.add(item);
//							rightClickJP.add(item2);
							
							//把jPopupMenu放到jsp1里
							friendJSP.setComponentPopupMenu(rightClickJP);
							//把jPopupMenu放到jphy2里
							friendListJP.setComponentPopupMenu(rightClickJP);
						}
					}

					{
						JPanel thirdJP = new JPanel();
						GridLayout thirdJPLayout = new GridLayout(3, 1);
						thirdJPLayout.setColumns(1);
						thirdJPLayout.setRows(2);
						secondJP.add(thirdJP, BorderLayout.SOUTH);
						thirdJP.setLayout(thirdJPLayout);
						thirdJP.setPreferredSize(new java.awt.Dimension(389, 75));

						{
							JButton strangerJB = new JButton();
							thirdJP.add(strangerJB);
							strangerJB.setText("陌生人");
							strangerJB.setPreferredSize(new java.awt.Dimension(389, 31));
							strangerJB.setFont(new Font("华文彩云",Font.BOLD,13));
						}

						{
							JButton blacklistJB = new JButton();
							thirdJP.add(blacklistJB);
							blacklistJB.setText("黑名单");
							blacklistJB.setPreferredSize(new java.awt.Dimension(389, 33));
							blacklistJB.setFont(new Font("华文彩云",Font.BOLD,13));
						}

					}
				}

				{
					JPanel messageJP = new JPanel();
					friendJT.addTab("消 息", null, messageJP, null);
					messageJP.setLayout(null);
				}

				{
					JPanel spaceJP = new JPanel();
					friendJT.addTab("空 间", null, spaceJP, null);
					spaceJP.setLayout(null);
				}
			}
			pack();
			setSize(400, 800);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		int isClose = JOptionPane.showConfirmDialog(QQMainJFrame.this,"确定关闭QQ?","",2);
//		System.out.println(isClose);
		if(isClose == 0){

			//修改数据库用户状态
			Userinfo userinfo1 = new Userinfo();
			userinfo1.setId(userinfo.getId());
			userinfo1.setStateid(1);
			userinfoDao.update(userinfo1);
			System.exit(0);
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}


	@SneakyThrows
	@Override
	public void run() {

		QQMainJFrame that = this;
		//令线程晚些启动
		Thread.sleep(1000);
		//死循环实现不断刷新
		while (true) {
			//移除上次生成的组件内容
			friendListJP.removeAll();

			//
			List<Friendsinfo> friends = friendsinfoDao.getFriendsById(userinfo.getId());

			List<Userinfo> friendsList = new ArrayList<>();
			for (Friendsinfo friendsinfo : friends) {
				Userinfo userinfo = userinfoDao.queryById(friendsinfo.getFriendid());

				if (userinfo.getStateid() == 1) {
					friendsList.add(userinfo);
				} else {
					friendsList.add(0, userinfo);
				}
			}


			//循环创建25个好友
			JLabel[] jls = new JLabel[25];
			for (int i = 0; i < friends.size(); i++) {
				Userinfo userinfo = friendsList.get(i);
				String stateVia = "";

				if (userinfo.getStateid() == 1) {
					stateVia = "offline/";
				} else {
					stateVia = "online/";
				}

				ImageIcon friendsHead = new ImageIcon(ImageIO.read(new ClassPathResource("static/via/" + stateVia + userinfo.getFaceid() + ".png").getInputStream()));

				friendsHead.setImage(friendsHead.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				//new JLabel(文本,图片地址,放的位置);
				jls[i] = new JLabel(userinfo.getNickname()+"("+userinfo.getId()+")", friendsHead, JLabel.LEFT);
				jls[i].setFont(new Font("华文彩云", Font.PLAIN, 14));
				jls[i].setForeground(new Color(0, 0, 0));

				jls[i].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						super.mouseClicked(e);
						JLabel label = (JLabel) e.getSource();
						String str = label.getText();
						int index = str.indexOf('(');
						String fid = str.substring(index+1,str.length()-1);
						String fname = str.substring(0,index);
						if(e.getClickCount() == 2){

							Thread thread = new Thread(qqChatJFrame);
							thread.start();
							qqChatJFrame.initGUI(that.userinfo,fid,fname);
						}

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						JLabel label = (JLabel) e.getSource();
						label.setOpaque(true);
						label.setBackground(new Color(204, 203, 203));
						label.setForeground(new Color(8, 100, 238));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						JLabel label = (JLabel) e.getSource();
						label.setOpaque(true);
						label.setBackground(new Color(250, 250, 250));
						label.setForeground(new Color(0, 0, 0));
					}
				});

				friendListJP.add(jls[i]);

			}

			//更新组件内容
			SwingUtilities.updateComponentTreeUI(friendListJP);
			//让内容停留一秒钟
			Thread.sleep(2000);

		}

	}
}
