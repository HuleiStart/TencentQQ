package com.cf.tencentqq.view.jf;

import com.cf.tencentqq.dao.UserinfoDao;
import com.cf.tencentqq.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

@Component
public class EditJF extends JFrame {

    @Autowired
    UserinfoDao userinfoDao;

    @Autowired
    InfoJF infoJF;

    private Userinfo userinfo;

    public void Edit(Userinfo userinfo){
        this.userinfo = userinfo;
        //设置界面大小
        this.setSize(472, 926);
        //设置界面登录框居中
        this.setLocationRelativeTo(null);
        //设置界面不可拉伸
        this.setResizable(false);
        try {
            this.setIconImage(ImageIO.read(new ClassPathResource("static/images/1.jpg").getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //背景容器
        JPanel bgJP = new JPanel();
        //设置背景色
        bgJP.setBackground(new Color(255,255,255));
        //给背景容器设置大小
        bgJP.setBounds(0,0,472,926);
        //添加背景容器
        this.getContentPane().add(bgJP);
        //背景容器绝对布局
        bgJP.setLayout(null);

        JPanel infoJP = new JPanel();
        infoJP.setBounds(0,0,472,260);
        infoJP.setBackground(new Color(255,255,255));
        infoJP.setLayout(null);
        bgJP.add(infoJP);

        //定义昵称容器
        JLabel infoJL = new JLabel();
        //设置容器大小位置
        infoJL.setBounds(20, 15, 100, 15);
        //设置容器默认文本
        infoJL.setText("基础信息");
        //设置容器文字字体
        infoJL.setFont(new Font("黑体", Font.BOLD, 16));
        //设置文字颜色
        infoJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        infoJP.add(infoJL);

        JLabel lineJL = new JLabel();
        lineJL.setBounds(20,40,430,1);
        lineJL.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        infoJP.add(lineJL);

        //定义昵称容器
        JLabel nickJL = new JLabel();
        //设置容器大小位置
        nickJL.setBounds(20, 55, 60, 20);
        //设置容器默认文本
        nickJL.setText("昵   称");
        //设置容器文字字体
        nickJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        nickJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        infoJP.add(nickJL);
        infoJP.setFocusable(true);

        JTextField nickJT = new JTextField(userinfo.getNickname());
        //设置用户名输入框位置
        nickJT.setBounds(70,55,140,30);
        //把输入框放进背景容器
        infoJP.add(nickJT);

        //定义性别容器
        JLabel sexJL = new JLabel();
        //设置容器大小位置
        sexJL.setBounds(240, 55, 60, 20);
        //设置容器默认文本
        sexJL.setText("性    别");
        //设置容器文字字体
        sexJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        sexJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        infoJP.add(sexJL);

        //设置下拉列表
        JComboBox<Object> sexJC = new JComboBox<>();
        //将数组数据加载到下拉框中
        sexJC.addItem("男");
        sexJC.addItem("女");
        sexJC.setOpaque(false);
        //设置输入框位置
        sexJC.setBounds(300,55,140,30);
        //把输入框放进背景容器
        infoJP.add(sexJC);



        //定义年龄容器
        JLabel ageJL = new JLabel();
        //设置容器大小位置
        ageJL.setBounds(20, 100, 60, 20);
        //设置容器默认文本
        ageJL.setText("年    龄");
        //设置容器文字字体
        ageJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        ageJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        infoJP.add(ageJL);

        JTextField ageJT = new JTextField(userinfo.getAge()+"");
        //设置用户名输入框位置
        ageJT.setBounds(70,100,140,30);
        //把输入框放进背景容器
        infoJP.add(ageJT);

        //定义血型容器
        JLabel bloodJL = new JLabel();
        //设置容器大小位置
        bloodJL.setBounds(240, 100, 60, 20);
        //设置容器默认文本
        bloodJL.setText("血  型");
        //设置容器文字字体
        bloodJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        bloodJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        infoJP.add(bloodJL);

        //设置下拉列表
        JComboBox<Object> bloodJC = new JComboBox<>();
        //将数组数据加载到下拉框中
        bloodJC.addItem("A型");
        bloodJC.addItem("B型");
        bloodJC.addItem("AB型");
        bloodJC.addItem("O型");
        bloodJC.addItem("其他血型");
        bloodJC.setOpaque(false);
        //设置用户名输入框位置
        bloodJC.setBounds(300,100,140,30);
        //把输入框放进背景容器
        infoJP.add(bloodJC);


        //定义签名容器
        JLabel signJL = new JLabel();
        //设置容器大小位置
        signJL.setBounds(20, 145, 60, 20);
        //设置容器默认文本
        signJL.setText("签   名");
        //设置容器文字字体
        signJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        signJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        infoJP.add(signJL);

        JTextField signJT = new JTextField(userinfo.getSignature());
        //设置用户名输入框位置
        signJT.setBounds(70,145,360,60);
        //把输入框放进背景容器
        infoJP.add(signJT);




        JPanel eduJP = new JPanel();
        eduJP.setBounds(0,260,472,140);
        eduJP.setBackground(new Color(255,255,255));
        eduJP.setLayout(null);
        bgJP.add(eduJP);

        //定义教育容器
        JLabel eduJL = new JLabel();
        //设置容器大小位置
        eduJL.setBounds(20, 10, 200, 15);
        //设置容器默认文本
        eduJL.setText("填写教育经历发现校友");
        //设置容器文字字体
        eduJL.setFont(new Font("黑体", Font.BOLD, 16));
        //设置文字颜色
        eduJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        eduJP.add(eduJL);

        //定义昵称容器
        JLabel addeduJL = new JLabel();
        //设置容器大小位置
        addeduJL.setBounds(330, 10, 150, 15);
        //设置容器默认文本
        addeduJL.setText("+添加教育经历");
        //设置容器文字字体
        addeduJL.setFont(new Font("黑体", Font.BOLD, 16));
        //设置文字颜色
        addeduJL.setForeground(new Color(55,143,207));
        //将文本添加至第一次面板
        eduJP.add(addeduJL);

        JLabel seclineJL = new JLabel();
        seclineJL.setBounds(20,35,430,1);
        seclineJL.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        eduJP.add(seclineJL);

        //定义内容容器
        JLabel contentJL = new JLabel();
        //设置容器大小位置
        contentJL.setBounds(160, 80, 150, 15);
        //设置容器默认文本
        contentJL.setText("尚未添加教育经历");
        //设置容器文字字体
        contentJL.setFont(new Font("黑体", Font.BOLD, 16));
        //设置文字颜色
        contentJL.setForeground(new Color(127,127,127));
        //将文本添加至第一次面板
        eduJP.add(contentJL);


        JPanel moreJP = new JPanel();
        moreJP.setBounds(0,400,472,430);
        moreJP.setBackground(new Color(255,255,255));
        moreJP.setLayout(null);
        bgJP.add(moreJP);

        //定义更多资料容器
        JLabel moreJL = new JLabel();
        //设置容器大小位置
        moreJL.setBounds(20, 10, 150, 15);
        //设置容器默认文本
        moreJL.setText("更多资料");
        //设置容器文字字体
        moreJL.setFont(new Font("黑体", Font.BOLD, 16));
        //设置文字颜色
        moreJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        moreJP.add(moreJL);

        JLabel thirdlineJL = new JLabel();
        thirdlineJL.setBounds(20,35,430,1);
        thirdlineJL.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        moreJP.add(thirdlineJL);

        //定义职业容器
        JLabel jobJL = new JLabel();
        //设置容器大小位置
        jobJL.setBounds(20, 45, 60, 25);
        //设置容器默认文本
        jobJL.setText("职       业");
        //设置容器文字字体
        jobJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        jobJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        moreJP.add(jobJL);
        //设置下拉列表
        JComboBox<Object> jobJC = new JComboBox<>();
        //将数组数据加载到下拉框中
        jobJC.addItem("教育/培训");
        jobJC.addItem("公务员/行政/事业单位");
        jobJC.addItem("模特");
        jobJC.addItem("空姐");
        jobJC.addItem("学生");
        jobJC.addItem("其他");
        jobJC.setOpaque(false);
        //设置输入框位置
        jobJC.setBounds(85,45,360,25);
        //把输入框放进背景容器
        moreJP.add(jobJC);



        //定义公司容器
        JLabel comJL = new JLabel();
        //设置容器大小位置
        comJL.setBounds(20, 90, 60, 25);
        //设置容器默认文本
        comJL.setText("公       司");
        //设置容器文字字体
        comJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        comJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        moreJP.add(comJL);

        JTextField comJT = new JTextField();
        //设置输入框位置
        comJT.setBounds(85,90,360,25);
        //把输入框放进背景容器
        moreJP.add(comJT);

        //定义地址容器
        JLabel addressJL = new JLabel();
        //设置容器大小位置
        addressJL.setBounds(20, 135, 60, 25);
        //设置容器默认文本
        addressJL.setText("公司地址");
        //设置容器文字字体
        addressJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        addressJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        moreJP.add(addressJL);

        JTextField addressJT = new JTextField(userinfo.getAddress());
        //设置输入框位置
        addressJT.setBounds(85,135,360,25);
        //把输入框放进背景容器
        moreJP.add(addressJT);

        //定义故乡容器
        JLabel homeJL = new JLabel();
        //设置容器大小位置
        homeJL.setBounds(20, 180, 60, 25);
        //设置容器默认文本
        homeJL.setText("故       乡");
        //设置容器文字字体
        homeJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        homeJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        moreJP.add(homeJL);

        JTextField homeJT = new JTextField(userinfo.getAddress());
        //设置用户名输入框位置
        homeJT.setBounds(85,180,360,25);
        //把输入框放进背景容器
        moreJP.add(homeJT);

        //定义手机容器
        JLabel mobJL = new JLabel();
        //设置容器大小位置
        mobJL.setBounds(20, 225, 60, 25);
        //设置容器默认文本
        mobJL.setText("手       机");
        //设置容器文字字体
        mobJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        mobJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        moreJP.add(mobJL);

        JTextField mobJT = new JTextField();
        //设置用户名输入框位置
        mobJT.setBounds(85,225,360,25);
        //把输入框放进背景容器
        moreJP.add(mobJT);

        //定义邮箱容器
        JLabel emailJL = new JLabel();
        //设置容器大小位置
        emailJL.setBounds(20, 270, 60, 25);
        //设置容器默认文本
        emailJL.setText("邮       箱");
        //设置容器文字字体
        emailJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        emailJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        moreJP.add(emailJL);

        JTextField emailJT = new JTextField();
        //设置用户名输入框位置
        emailJT.setBounds(85,270,360,25);
        //把输入框放进背景容器
        moreJP.add(emailJT);

        //定义个人说明容器
        JLabel personJL = new JLabel();
        //设置容器大小位置
        personJL.setBounds(20, 315, 60, 25);
        //设置容器默认文本
        personJL.setText("个人说明");
        //设置容器文字字体
        personJL.setFont(new Font("方正仿宋简体", Font.BOLD, 14));
        //设置文字颜色
        personJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        moreJP.add(personJL);

        JTextField personJT = new JTextField();
        //设置用户名输入框位置
        personJT.setBounds(85,315,360,80);
        //把输入框放进背景容器
        moreJP.add(personJT);



        JPanel footJP = new JPanel();
        footJP.setBounds(0,830,472,56);
        footJP.setBackground(new Color(221,221,221));
        footJP.setLayout(null);
        bgJP.add(footJP);

        JButton submit = new JButton("保存");
        submit.setBounds(260, 10, 70, 30);
        //设置容器文字字体
        submit.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        submit.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        footJP.add(submit);



        submit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String sex = sexJC.getSelectedItem().toString();
                Userinfo useredit = new Userinfo();
                useredit.setId(userinfo.getId());
                useredit.setNickname(nickJT.getText());
                useredit.setSex(sex);
                useredit.setAge(Integer.parseInt(ageJT.getText()));
                useredit.setSignature(signJT.getText());
                useredit.setAddress(addressJT.getText());
                userinfoDao.update(useredit);
                //让界面消失
                EditJF.this.dispose();

            }
        });



        JButton close = new JButton("关闭");
        close.setBounds(360, 10, 70, 30);
        //设置容器文字字体
        close.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        close.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        footJP.add(close);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //让界面消失
                EditJF.this.dispose();
            }
        });

        this.setVisible(true);
    }

}
