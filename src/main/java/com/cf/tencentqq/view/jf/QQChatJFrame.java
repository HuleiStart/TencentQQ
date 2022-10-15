package com.cf.tencentqq.view.jf;


import com.cf.tencentqq.dao.MessagesinfoDao;
import com.cf.tencentqq.entity.Messagesinfo;
import com.cf.tencentqq.entity.Userinfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.*;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
//import com.cf.beans.UserInfo;
import javax.swing.SwingUtilities;




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

public class QQChatJFrame extends javax.swing.JFrame  implements Runnable{
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JLabel jLabel3;
	private JButton jButton1;
	private JButton jButton2;
	private JTextArea jTextArea2;
	private JPanel jPanel6;
	private JPanel jPanel5;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JPanel jPanel4;
	private JTextArea jTextArea1;
	private JPanel jPanel3;
	private JPanel jPanel2;
	//用户信息
//	private UserInfo userInfo;
	//好友id
	private String friendId;
	//好友name
	private String fNickName;
	//控制是否结束循环读取消息
	private boolean flag = true;
	private Userinfo userinfo;

	@Autowired
	MessagesinfoDao messagesinfoDao;

	/**
	* Auto-generated main method to display this JFrame
	*/
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				QQChatJFrame inst = new QQChatJFrame(null,"1","1");
//				inst.setLocationRelativeTo(null);
//				inst.setVisible(true);
//			}
//		});
//	}
	
	public void initGUI(Userinfo userinfo, String friendId, String fNickName) {
		this.userinfo = userinfo;
		this.friendId=friendId;
		this.fNickName=fNickName;
		//窗体不能改变大小
		this.setResizable(false);

		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
				
				{
					jTextArea2 = new JTextArea();
					jPanel1.add(jTextArea2);
					jTextArea2.setBounds(0, 499, 878, 96);
				}
				{
					jButton1 = new JButton();
					jPanel1.add(jButton1);
					jButton1.setText("发送");
					jButton1.setBounds(538, 607, 102, 31);

					jButton1.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Messagesinfo messagesinfo = new Messagesinfo();
							messagesinfo.setFromuserid(userinfo.getId());
							messagesinfo.setTouserid(Integer.parseInt(friendId));
							messagesinfo.setMessage(jTextArea2.getText());
							messagesinfoDao.addMessage(messagesinfo);
							jTextArea2.setText("");
						}
					});
				}
				{
					jButton2 = new JButton();
					jPanel1.add(jButton2);
					jButton2.setText("关闭");
					jButton2.setBounds(658, 607, 102, 31);

					jButton2.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {

							QQChatJFrame.this.dispose();

						}
					});

				}
				{
					jLabel1 = new JLabel();
					//图片自动调整，适应jlabel的大小
					ImageIcon image1 = new ImageIcon("images/FormImage/QQ秀15.jpg");
					image1.setImage(image1.getImage().getScaledInstance(177, 198, Image.SCALE_DEFAULT));
					jLabel1.setIcon(image1);
					jPanel1.add(jLabel1);
					jLabel1.setBounds(696, 64, 177, 198);
				}
				{
					jLabel2 = new JLabel();
					//图片自动调整，适应jlabel的大小
					ImageIcon image2 = new ImageIcon("images/FormImage/QQ秀16.jpg");
					image2.setImage(image2.getImage().getScaledInstance(177, 198, Image.SCALE_DEFAULT));
					jLabel2.setIcon(image2);
					jPanel1.add(jLabel2);
					jLabel2.setBounds(696, 268, 177, 198);
				}
				{
					jScrollPane1 = new JScrollPane();
					jPanel1.add(jScrollPane1);
					jScrollPane1.setBounds(0, 64, 691, 402);
					{
						jTextArea1 = new JTextArea();
						//激活自动换行功能
						jTextArea1.setLineWrap(true);
						//激活断行不断字功能
						jTextArea1.setWrapStyleWord(true);
						//jTextArea1.setPreferredSize(new java.awt.Dimension(691, 399));
					}
				}
				{
					jLabel3 = new JLabel();
					jLabel3.setText("您正在和:"+fNickName+"("+friendId+")聊天");
					jLabel3.setFont(new Font("方正仿宋", 1, 30));
					jLabel3.setForeground(Color.blue);
					jPanel1.add(jLabel3);
					jLabel3.setBounds(38, 16, 500, 36);
				}
			}
			pack();
			setSize(900, 700);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}

	@SneakyThrows
	@Override
	public void run() {
		Thread.sleep(1000);
		while(true){
			Messagesinfo messagesinfo = new Messagesinfo();
			messagesinfo.setFromuserid(userinfo.getId());
			messagesinfo.setTouserid(Integer.parseInt(friendId));
			//查询聊天记录
			List<Messagesinfo> messagesinfos = messagesinfoDao.sel(messagesinfo);
			//聊天记录拼接
			StringBuffer stb = new StringBuffer();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:hh:mm:ss");
			for(Messagesinfo msg: messagesinfos){
				String fnickName = "";
				if(msg.getFromuserid() == Integer.parseInt(friendId)){
					fnickName = this.fNickName;
				}else{
					fnickName = userinfo.getNickname();
				}
				stb.append(fnickName+"\t");
				stb.append(msg.getMessage()+"\n");
				String format = sdf.format(msg.getMessagedate());
				stb.append("\t\t"+format+"\n");
			}
			jTextArea1.setText(stb.toString());
			jTextArea1.setSelectionStart(jTextArea1.getText().length());
			jScrollPane1.setViewportView(jTextArea1);
			SwingUtilities.updateComponentTreeUI(jTextArea1);
			Thread.sleep(1000);
		}

	}
}
