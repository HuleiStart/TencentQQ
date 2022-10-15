package com.cf.tencentqq;


import com.cf.tencentqq.dao.StateinfoDao;
import com.cf.tencentqq.dao.UserinfoDao;
import com.cf.tencentqq.entity.Stateinfo;
import com.cf.tencentqq.entity.Userinfo;
import com.cf.tencentqq.view.jf.QQMainJFrame;
import com.cf.tencentqq.view.jf.RegisterJF;
import lombok.var;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.io.ClassPathResource;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

//springboot 启动项
@SpringBootApplication
@MapperScan("com.cf.tencentqq.dao")
public class LoginJF extends JFrame {


    /**
     * 下拉列表框
     * stateJC 在线状态
     */
    private JComboBox stateJC;
    //获取注册界面
    @Autowired
    RegisterJF registerJF;

    @Autowired
    UserinfoDao userinfoDao;

    @Autowired
    StateinfoDao stateinfoDao;

    @Autowired
    QQMainJFrame qqMainJFrame;



    //定义变量-设置窗体的宽度
    int width = 400;
    //设置元素高度
    int height = 30;

    //设置全局变量 状态的id
    private int stateid = 1;


    /**
     * 构造方法加载界面
     */
    public LoginJF() throws IOException {
        //给窗体添加绝对定位
        this.getContentPane().setLayout(null);
        //背景容器
        JPanel bgJP = new JPanel();
        //设置背景色
        bgJP.setBackground(new Color(255,255,255));
        //给背景容器设置大小
        bgJP.setBounds(0,0,width,450);
        //添加背景容器
        this.getContentPane().add(bgJP);
        //背景容器绝对布局
        bgJP.setLayout(null);


    /**
     * 用户名
     * 默认值“10000”
     */
        JTextField usernameJT = new JTextField("10000");
        //设置用户名输入框位置
        usernameJT.setBounds(120,220,150,height);
        //把输入框放进背景容器
        bgJP.add(usernameJT);

        //设置下拉列表
        stateJC = new JComboBox();
        //设置下拉列表位置
        stateJC.setBounds(280,220,90,height);
        //添加至背景容器
        bgJP.add(stateJC);
        //设置提示文本
        JLabel usernameJL = new JLabel("用户名：");
        //设置字体
        usernameJL.setFont(new Font("宋体",Font.BOLD,14));
        //设置提示文本位置
        usernameJL.setBounds(55,220,80,height);
        //把提示文本框放进背景容器
        bgJP.add(usernameJL);


    /**
     * 密码
     * 默认值 ”000000“
     */
        //设置密码输入框
        JPasswordField passwordJT = new JPasswordField("000000");
        //设置密码输入框位置
        passwordJT.setBounds(120,260,150,height);
        //把密码输入框放进背景容器
        bgJP.add(passwordJT);

        //设置提示文本
        JLabel passwordJL = new JLabel("密  码：");
        //设置字体
        passwordJL.setFont(new Font("宋体",Font.BOLD,14));
        //设置提示文本位置
        passwordJL.setBounds(55,260,80,height);
        //把提示文本框放进背景容器
        bgJP.add(passwordJL);


    /**
     * 单选框
     * 默认选中
     */
        //创建自动登录单选按钮
        JRadioButton autoLogin = new JRadioButton("自动登录");
        //设置按钮位置
        autoLogin.setBounds(45,295,90,20);
        //设置按钮字体
        autoLogin.setFont(new Font("微软雅黑",Font.BOLD,13));
        //将按钮添加至背景容器
        bgJP.add(autoLogin);


    /**
     * 单选框
     * 默认未选中
     */
        //创建记住密码单选按钮
        JRadioButton keePwd = new JRadioButton("记住密码");
        //设置按钮位置
        keePwd.setBounds(145,295,90,20);
        //设置按钮字体
        keePwd.setFont(new Font("微软雅黑",Font.BOLD,13));
        //将按钮添加至背景容器
        bgJP.add(keePwd);


    /**
     *忘记密码
     */
        //创建忘记密码标签
        JLabel forgetPwd = new JLabel("忘记密码");
        //设置字体
        forgetPwd.setFont(new Font("微软雅黑",Font.BOLD,13));
        //设置字体颜色
        forgetPwd.setForeground(new Color(104, 18, 196));
        //设置提示文本位置
        forgetPwd.setBounds(255,295,80,20);
        //把提示文本框放进背景容器
        bgJP.add(forgetPwd);
        //添加鼠标划入事件
        forgetPwd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //点击
                //设置文本颜色
                forgetPwd.setForeground(new Color(252,1,26));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //滑入
                //设置文本颜色
                forgetPwd.setForeground(new Color(2,123,254));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //退出
                //设置文本颜色
                forgetPwd.setForeground(new Color(104, 18, 196));
            }
        });


    /**
     * 登录按钮
     */

        JButton loginBTn = new JButton("安全登录");
        //设置字体
        loginBTn.setFont(new Font("宋体",Font.BOLD,16));
        //修改字体颜色
        loginBTn.setBackground(new Color(166,166,166));
        //修改背景颜色
        loginBTn.setBackground(new Color(4,186,251));
        //设置提示文本位置
        loginBTn.setBounds(120,330,120,height);
        //把提示文本框放进背景容器
        bgJP.add(loginBTn);

        //添加登陆点击事件
        loginBTn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取界面用户名和密码
                String username = usernameJT.getText();
                String password = passwordJT.getText();
                //实例化对象
                Userinfo user = new Userinfo();

                user.setId(Integer.parseInt(username));
                user.setLoginpwd(password);
                Userinfo userinfo = userinfoDao.login(user);



                if(userinfo == null){
                    JOptionPane.showMessageDialog(null,"用户名或者密码错误！");
                } else {
                    if(userinfo.getStateid() != 1){
                        JOptionPane.showMessageDialog(null,"用户已在线，请勿重复登录！");
                        return;
                    }
                    //获取用户状态
                    userinfo.setStateid(stateid);

                    //修改数据库用户状态
                    Userinfo userinfo1 = new Userinfo();
                    userinfo1.setId(userinfo.getId());
                    userinfo1.setStateid(stateid);
                    userinfoDao.update(userinfo1);


                    //开启界面线程
                    Thread thread = new Thread(qqMainJFrame);
                    //启动线程
                    thread.start();

                    //显示主界面
                    qqMainJFrame.loadData(userinfo);

                    //设置登录界面不可见
                    LoginJF.this.setVisible(false);
                }

            }
        });

        //添加注册账号按钮
        JLabel registJL = new JLabel("注册账号");
        //设置字体
        registJL.setFont(new Font("宋体",Font.BOLD,14));
        //设置提示文本位置
        registJL.setBounds(10,365,100,height);
        //设置文本颜色
        registJL.setForeground(new Color(160,160,160));
        //把提示文本框放进背景容器
        bgJP.add(registJL);

        //添加鼠标划入事件
        registJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //点击
                registerJF.ShowJFrame();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e); //滑入
                //设置文本颜色
                registJL.setForeground(new Color(2,123,254));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); //退出
                //设置文本颜色
                registJL.setForeground(new Color(160,160,160));
            }
        });

        //创建图片容器
        JLabel QRcodeJL = new JLabel();
        //引入图片
        ImageIcon QRcodeImg = new ImageIcon(ImageIO.read(new ClassPathResource("static/images/QRcode.png").getInputStream()));
        //设置图片大小
        QRcodeImg.setImage(QRcodeImg.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
        //将图片放入图片容器
        QRcodeJL.setIcon(QRcodeImg);
        //将图片容器添加至背景容器
        bgJP.add(QRcodeJL);
        //设置图片容器位置大小
        QRcodeJL.setBounds(335,355,40,40);

        //创建图片容器
        JLabel loginBgJL = new JLabel();
        //引入图片
        ImageIcon bgImage = new ImageIcon(ImageIO.read(new ClassPathResource("static/images/eve-2.jpg").getInputStream()));
        //设置图片大小
        bgImage.setImage(bgImage.getImage().getScaledInstance(400,200, Image.SCALE_DEFAULT));
        //将图片放入图片容器
        loginBgJL.setIcon(bgImage);
        //将图片容器添加至背景容器
        bgJP.add(loginBgJL);
        //设置图片容器位置大小
        loginBgJL.setBounds(0, 0, 400, 200);
    }


    /**
    * 登录界面
    */
    public void loadJFrame(){
        //设置界面大小
        this.setSize(width,450);
        //设置界面登录框居中
        this.setLocationRelativeTo(null);
        //设置界面不可拉伸
        this.setResizable(false);

        try {
            this.setIconImage(ImageIO.read(new ClassPathResource("static/images/1.jpg").getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //下拉列表加载数据
        List<Stateinfo> stateinfos = stateinfoDao.selAll();
        //定义String类型数组
        Vector<String> states = new Vector<>();
        //遍历数组数据
        for(Stateinfo state:stateinfos ){
            states.add(state.getState());
        }
        //将数组数据加载到下拉框中
        DefaultComboBoxModel model = new DefaultComboBoxModel(states);
        stateJC.setModel(model);

        //添加监听事件  监听选择的用户状态
        stateJC.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                //将用户状态赋值给全局变量stateid
                stateid = stateJC.getSelectedIndex() + 1;

                //打印输出用户状态 获得用户状态id
//                System.out.println(stateid);

            }
        });
        //设置界面可见
        this.setVisible(true);
    }


    public static void main(String[] args){
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

        var ctx = new SpringApplicationBuilder(LoginJF.class)
                .headless(false).run(args);
        EventQueue.invokeLater(() -> {
            var ex = ctx.getBean(LoginJF.class);
            ex.loadJFrame();
        });

    }
}
