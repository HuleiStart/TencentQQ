package com.cf.tencentqq.view.jf;

import com.cf.tencentqq.dao.UserinfoDao;
import com.cf.tencentqq.entity.Userinfo;
import lombok.var;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//@SpringBootApplication
@Component
public class RegisterJF extends JFrame {

    @Autowired
    UserinfoDao userinfoDao;

    RegisterJF that = this;


    //密码组成规则
//    String pwd="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";


    private JLabel jLabel;
    private JLabel jLabel2;

    public RegisterJF() throws IOException {

        //开启窗体绝对定位
        this.getContentPane().setLayout(null);

        //设置一个背景容器
        JPanel backgroundJP = new JPanel();
        //为背景设置颜色
        backgroundJP.setBackground(new Color(200,206,218));
        //设置背景容器位置大小
        backgroundJP.setBounds(0,0,540,996);
        //背景添加到背景容器中
        this.getContentPane().add(backgroundJP);
        //开启背景绝对定位
        backgroundJP.setLayout(null);


        //添加注册窗体背景
        JLabel logoImage = new JLabel();
        //设置左上角小企鹅大小
        logoImage.setBounds(15,15,25,30);
        //设置小企鹅
        try {
            logoImage.setIcon(new ImageIcon(ImageIO.read(new ClassPathResource("static/images/Qq-2.png").getInputStream()))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        //添加进容器
        backgroundJP.add(logoImage);

        //设置文本“QQ”
        JLabel qqJL = new JLabel("QQ");
        //设置字体样式
        qqJL.setFont(new Font("黑体",Font.BOLD,30));
        //设置字体颜色
        qqJL.setForeground(new Color(0, 0, 0));
        //设置提示文本位置
        qqJL.setBounds(45,15,60,30);
        //把提示文本框放进背景容器
        backgroundJP.add(qqJL);

        //创建图片容器
        JLabel jLabel2 = new JLabel();
        //引入图片
        ImageIcon qqLHImge = new ImageIcon(ImageIO.read(new ClassPathResource("static/images/QQLH.png").getInputStream()));
        //设置图片大小
        qqLHImge.setImage(qqLHImge.getImage().getScaledInstance(90,30,Image.SCALE_DEFAULT));
        //设置容器大小位置
        jLabel2.setBounds(280,12,90,30);
        //将图片放入图片容器
        jLabel2.setIcon(qqLHImge);
        //将图片容器放入背景容器
        backgroundJP.add(jLabel2);


        //设置语言提示
        JLabel languageJL = new JLabel("简体中文");
        //设置字体样式
        languageJL.setFont(new Font("简体",Font.BOLD,14));
        //设置文本颜色
        languageJL.setForeground(new Color(0, 0, 0));
        //设置提示文本位置
        languageJL.setBounds(380,15,85,30);
        //把提示文本框放进背景容器
        backgroundJP.add(languageJL);

        //设置意见反馈
        JLabel opinionJL = new JLabel("意见反馈");
        //设置字体样式
        opinionJL.setFont(new Font("简体",Font.BOLD,14));
        //设置文本颜色
        opinionJL.setForeground(new Color(0, 0, 0));
        //设置提示文本位置
        opinionJL.setBounds(450,15,85,30);
        //把提示文本框放进背景容器
        backgroundJP.add(opinionJL);



        //设置欢迎文本
        JLabel welcomeJL = new JLabel("欢迎注册QQ");
        //设置字体样式
        welcomeJL.setFont(new Font("宋体",Font.BOLD,40));
        //设置文本颜色
        welcomeJL.setForeground(new Color(0, 0, 0));
        //设置提示文本位置
        welcomeJL.setBounds(160,300,250,40);
        //把提示文本框放进背景容器
        backgroundJP.add(welcomeJL);

        //设置副标题
        JLabel subheadJL = new JLabel("每一天，乐在沟通。");
        //设置字体样式
        subheadJL.setFont(new Font("宋体",Font.BOLD,20));
        //设置文本颜色
        subheadJL.setForeground(new Color(5, 5, 5));
        //设置提示文本位置
        subheadJL.setBounds(160,350,250,35);
        //把提示文本框放进背景容器
        backgroundJP.add(subheadJL);


        //设置提示文本
        JLabel usernameJL = new JLabel("昵 称：");
        //设置字体样式
        usernameJL.setFont(new Font("宋体",Font.BOLD,18));
        //设置文本颜色
        usernameJL.setForeground(new Color(0, 0, 0));
        //设置提示文本位置
        usernameJL.setBounds(100,565,100,45);
        //把提示文本框放进背景容器
        backgroundJP.add(usernameJL);

        //设置昵称输入框
        JTextField nicknameJT = new JTextField();
        //设置文本框透明
        nicknameJT.setOpaque(false);
        //设置字体样式
        nicknameJT.setFont(new Font("简体",Font.BOLD,18));
        //设置文本框边框颜色以及厚度
        nicknameJT.setBorder(BorderFactory.createLineBorder(new Color(86, 86, 86),2));
        //设置文本颜色
        nicknameJT.setForeground(new Color(0, 0, 0));
        //设置昵称输入框位置
        nicknameJT.setBounds(160,565,250,45);
        //把输入框放进背景容器
        backgroundJP.add(nicknameJT);

        //设置提示文本
        JLabel passwordJL = new JLabel("密 码：");
        //设置字体样式
        passwordJL.setFont(new Font("宋体",Font.BOLD,18));
        //设置文本颜色
        passwordJL.setForeground(new Color(0, 0, 0));
        //设置提示文本位置
        passwordJL.setBounds(100,620,100,45);
        //把提示文本框放进背景容器
        backgroundJP.add(passwordJL);

        //设置密码输入框
        JPasswordField passwordJT = new JPasswordField();
        //设置文本框透明
        passwordJT.setOpaque(false);
        //设置字体样式
        passwordJT.setFont(new Font("简体",Font.BOLD,18));
        //设置文本颜色
        passwordJT.setForeground(new Color(0, 0, 0));
        //设置文本框边框颜色以及厚度
        passwordJT.setBorder(BorderFactory.createLineBorder(new Color(86, 86, 86),2));
        //设置昵称输入框位置
        passwordJT.setBounds(160,620,250,45);
        //把输入框放进背景容器
        backgroundJP.add(passwordJT);

        //设置提示文本
        JLabel telephoneJL = new JLabel("电 话：");
        //设置字体样式
        telephoneJL.setFont(new Font("宋体",Font.BOLD,18));
        //设置文本颜色
        telephoneJL.setForeground(new Color(0, 0, 0));
        //设置提示文本位置
        telephoneJL.setBounds(100,675,100,45);
        //把提示文本框放进背景容器
        backgroundJP.add(telephoneJL);

        //设置电话输入框
        JTextField telephoneJT = new JTextField();
        telephoneJT.setOpaque(false);
        //设置电话输入框位置
        telephoneJT.setBounds(160,675,250,45);
        //设置字体样式
        telephoneJT.setFont(new Font("简体",Font.BOLD,18));
        //设置字体颜色
        telephoneJT.setForeground(new Color(2, 2, 2));
        //设置输入框边框颜色以及厚度
        telephoneJT.setBorder(BorderFactory.createLineBorder(new Color(86, 86, 86),2));
        //把输入框放进背景容器
        backgroundJP.add(telephoneJT);


        backgroundJP.setFocusable(true);

        //设置协议文本
        JCheckBox agreementJL = new JCheckBox("我已阅读并同意服务协议和QQ隐私保护指引");
        //设置字体样式
        agreementJL.setFont(new Font("宋体",Font.BOLD,11));
        //设置字体颜色
        agreementJL.setForeground(new Color(51, 51, 51));
        //设置输入框透明
        agreementJL.setOpaque(false);
        //设置提示文本位置
        agreementJL.setBounds(160,740,300,20);
        //把提示文本框放进背景容器
        backgroundJP.add(agreementJL);

        //注册按钮
        JButton loginBTn = new JButton("立即注册");
        //设置字体样式
        loginBTn.setFont(new Font("宋体",Font.BOLD,20));
        //修改字体颜色
        loginBTn.setForeground(new Color(14, 14, 14));
        //修改背景颜色
//        loginBTn.setBackground(new Color(0,133,255));
        loginBTn.setOpaque(false);
        //设置边框颜色以及厚度
        loginBTn.setBorder(BorderFactory.createLineBorder(new Color(255,255,255),3));
        //设置提示文本位置
        loginBTn.setBounds(160,780,180,55);
        //把提示文本框放进背景容器
        backgroundJP.add(loginBTn);
        //添加注册点击事件
        loginBTn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {


               boolean isAgree = agreementJL.isSelected();
               if(isAgree == false){
                   JOptionPane.showMessageDialog(null,"请同意协议");
                   return;
               }
               //获取用户输入的用户名、密码和电话号码
               String nickname = nicknameJT.getText();
               String loginpwd = passwordJT.getText();
               String telephone = telephoneJT.getText();

               Userinfo newUser = new Userinfo();
               newUser.setNickname(nickname);
               newUser.setLoginpwd(loginpwd);
               newUser.setSex("男");
               newUser.setAge(18);
               newUser.setFaceid((int)(Math.random()*100));
               newUser.setQuestionid(3);
               userinfoDao.insert(newUser);
               JOptionPane.showMessageDialog(null,"恭喜您！\n"+newUser.getNickname() +"\n您的账号是：\n" + newUser.getId());

//               newUser.setFaceid(newUser.getId());
//               userinfoDao.update(newUser);
//               System.out.println(newUser.getFaceid());
               //控制台打印输出
//               System.out.println("nickname:" + nickname + "\t, loginpwd:" + loginpwd + "\t,telephone:" + telephone);
           }
       });

        //添加注册窗体背景图片容器
        jLabel = new JLabel();
        //添加图片
        ImageIcon qqRegisterImge = new ImageIcon(ImageIO.read(new ClassPathResource("static/images/QQregister.jpg").getInputStream()));
        //设置图片大小
        qqRegisterImge.setImage(qqRegisterImge.getImage().getScaledInstance(540,996,Image.SCALE_DEFAULT));
        //将图片添加至图片容器
        jLabel.setIcon(qqRegisterImge);
        //图片容器添加进背景容器
        backgroundJP.add(jLabel);
        //设置图片容器位置大小
        jLabel.setBounds(0,0,540,996);

    }
    /**
     * 注册窗口
     */
    public void ShowJFrame(){

        // 设置图像界面外观
        // 设置本属性将改变窗口边框样式定义
        BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
        UIManager.put("RootPane.setupButtonVisible", false);
        // 启用皮肤
        try {
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //设置窗口大小
        this.setSize(540,996);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置界面不可拉伸
        this.setResizable(false);
        //设置窗口可见
        this.setVisible(true);
        try {
            this.setIconImage(ImageIO.read(new ClassPathResource("static/images/QQLOGO.png").getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        var ctx = new SpringApplicationBuilder(RegisterJF.class)
                .headless(false).run(args);
        EventQueue.invokeLater(() -> {
            var ex = ctx.getBean(RegisterJF.class);
            ex.ShowJFrame();
        });
    }
}