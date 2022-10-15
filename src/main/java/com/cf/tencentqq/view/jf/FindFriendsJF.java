package com.cf.tencentqq.view.jf;

import com.cf.tencentqq.dao.FriendsinfoDao;
import com.cf.tencentqq.dao.UserinfoDao;
import com.cf.tencentqq.entity.Friendsinfo;
import com.cf.tencentqq.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;


@Component
public class FindFriendsJF extends JFrame {

    @Autowired
    UserinfoDao userinfoDao;

    @Autowired
    FriendsinfoDao friendsinfoDao;



    public void Find(int userinfoid){
        //设置界面大小
        this.setSize(1122, 747);
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
        bgJP.setBackground(new Color(255, 255, 255));
        //给背景容器设置大小
        bgJP.setBounds(0,0,1122,747);
        //添加背景容器
        this.getContentPane().add(bgJP);
        //背景容器绝对布局
        bgJP.setLayout(null);


        //创建昵称输入框
        JTextField search = new JTextField();
        //设置用户名输入框位置
        search.setBounds(24,100,480,35);
        //设置字体
        search.setFont(new Font("宋体",Font.PLAIN,14));
        //让输入框失去焦点
        bgJP.setFocusable(true);
        //把输入框放进背景容器
        bgJP.add(search);


        /**
         * 单选框
         * 默认选中
         */
        //创建在线单选按钮
        JRadioButton searchJR = new JRadioButton("在线");
        //设置按钮位置
        searchJR.setBounds(500,100,100,35);

        searchJR.setForeground(new Color(0, 0, 0));
        //设置透明
        searchJR.setOpaque(false);
        //设置按钮字体
        searchJR.setFont(new Font("宋体",Font.BOLD,18));
        //将按钮添加至背景容器
        bgJP.add(searchJR);


        //设置提示文本
        JLabel sexJL = new JLabel("性 别");
        //设置字体
        sexJL.setFont(new Font("宋体",Font.BOLD,18));
        sexJL.setForeground(new Color(0, 0, 0));
        //设置提示文本位置
        sexJL.setBounds(24,145,80,30);
        //把提示文本框放进背景容器
        bgJP.add(sexJL);

        //设置下拉列表
        JComboBox sexJC = new JComboBox();
        //将数组数据加载到下拉框中
        sexJC.addItem("不限");
        sexJC.addItem("男");
        sexJC.addItem("女");
        //设置下拉列表位置
        sexJC.setBounds(94,145,80,30);
        sexJC.setOpaque(false);
        //添加至背景容器
        bgJP.add(sexJC);

        //设置提示文本
        JLabel ageJL = new JLabel("年 龄");
        //设置字体
        ageJL.setFont(new Font("宋体",Font.BOLD,18));
        ageJL.setForeground(new Color(0, 0, 0));
        //设置提示文本位置
        ageJL.setBounds(250,145,80,30);
        //把提示文本框放进背景容器
        bgJP.add(ageJL);

        //设置下拉列表
        JComboBox ageJC = new JComboBox();
        //将数组数据加载到下拉框中
        ageJC.addItem("不限");
        ageJC.addItem("1-10");
        ageJC.addItem("11-20");
        ageJC.addItem("21-30");
        ageJC.addItem("31-40");
        //设置下拉列表位置
        ageJC.setBounds(320,145,90,30);
        ageJC.setOpaque(false);
        //添加至背景容器
        bgJP.add(ageJC);

        JButton searchJB = new JButton("查找");
        //设置字体
        searchJB.setFont(new Font("宋体",Font.BOLD,16));
//        searchJB.setOpaque(false);
        //修改字体颜色
        searchJB.setBackground(new Color(168,158,193));
        //修改背景颜色
//        searchJB.setBackground(new Color(4,186,251));
        //设置提示文本位置
        searchJB.setBounds(500,145,145,30);
        //把提示文本框放进背景容器
        bgJP.add(searchJB);


        //添加注册窗体背景
        JLabel logoImage = new JLabel();
        //设置左上角小企鹅大小
        logoImage.setBounds(0,0,1122,250);

        logoImage.setBackground(new Color(253,250,235));
        //设置小企鹅
        try {
            logoImage.setIcon(new ImageIcon(ImageIO.read(new ClassPathResource("static/images/daji.png").getInputStream()))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        //添加进容器
        bgJP.add(logoImage);


        JPanel friendsJP = new JPanel();
        friendsJP.setBounds(0,250,1122,500);
        friendsJP.setBackground(new Color(190, 156, 199));

        friendsJP.setLayout(null);




        searchJB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nickname = search.getText();
//                System.out.println(Nickname);
                List<Userinfo> userinfoList = userinfoDao.searchUserinfosBYNickName(Nickname);
                String sex = sexJC.getSelectedItem().toString();

                friendsJP.removeAll();

                int all = 0;
                int online = 0;
                int sen = 0;
                int snv = 0;


                for(int i = 0; i < userinfoList.size();i++){
                    Userinfo userinfo = userinfoList.get(i);
                    JPanel friendJP = new JPanel();
                    friendJP.setBackground(new Color(190, 156, 199));
                    friendsJP.add(friendJP);
                    friendJP.setLayout(null);

                    if(searchJR.isSelected() && userinfo.getStateid()!=1){

                        if(sex.equals("不限")){
                            friendJP.setBounds(280*(online%4),online/4*120,280,100);
                            online++;
                        }else if(sex.equals("男")){
                            if(userinfo.getSex().equals("男")){
                                friendJP.setBounds(280*(sen%4),sen/4*120,280,100);
                                sen++;
                            }else {
                                continue;
                            }
                        }else if(sex.equals("女")){
                            if(userinfo.getSex().equals("女")){
                                friendJP.setBounds(280*(snv%4),snv/4*120,280,100);
                                snv++;
                            }else {
                                continue;
                            }
                        }
                    }

                    if(!searchJR.isSelected()){
                        if(sex.equals("不限")){
                            friendJP.setBounds(280*(all%4),all/4*120,280,100);
                            all++;
                        }else if(sex.equals("男")){
                            if(userinfo.getSex().equals("男")){
                                friendJP.setBounds(280*(sen%4),sen/4*120,280,100);
                                sen++;
                            }else {
                                continue;
                            }
                        }else if(sex.equals("女")){
                            if(userinfo.getSex().equals("女")){
                                friendJP.setBounds(280*(snv%4),snv/4*120,280,100);
                                snv++;
                            }else {
                                continue;
                            }
                        }
                    }

                    //设置好友头像容器
                    JLabel friendIconJL = new JLabel(userinfo.getId()+"");

                    try {
                        friendIconJL.setIcon(new ImageIcon(ImageIO.read(new ClassPathResource("static/via/online/"+userinfo.getFaceid()+".png").getInputStream())));
                    } catch (IOException o) {
                        o.printStackTrace();
                    }

                    //设置图标的位置
                    friendIconJL.setBounds(30, 30, 60, 60);
                    //将底部背景容器放进底部容器中
                    friendJP.add(friendIconJL);

                    //设置底部栏背景
                    JLabel nickJL = new JLabel(userinfo.getNickname());
                    //设置图标的位置
                    nickJL.setBounds(100, 32, 150, 15);
                    nickJL.setOpaque(false);
                    nickJL.setFont(new Font("华文彩云",Font.PLAIN,14));
                    //将底部背景容器放进底部容器中
                    friendJP.add(nickJL);

                    //设置底部栏背景
                    JLabel ageJL = new JLabel(userinfo.getAge()+"岁|在"+userinfo.getAddress());
                    //设置图标的位置
                    ageJL.setBounds(100, 45, 120, 15);

                    nickJL.setFont(new Font("华文彩云",Font.PLAIN,14));
                    //将底部背景容器放进底部容器中
                    friendJP.add(ageJL);

                    JButton addJB = new JButton("+好友");
                    //设置图标的位置
                    addJB.setBounds(100, 65, 100, 25);
                    addJB.setFont(new Font("简体",Font.BOLD,14));
                    friendJP.add(addJB);

                    addJB.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            Friendsinfo friendsinfo1 = new Friendsinfo();
                            friendsinfo1.setHostid(userinfoid);
                            friendsinfo1.setFriendid(Integer.parseInt(friendIconJL.getText()));
                            friendsinfoDao.insert(friendsinfo1);

                            Friendsinfo friendsinfo2 = new Friendsinfo();
                            friendsinfo2.setHostid(Integer.parseInt(friendIconJL.getText()));
                            friendsinfo2.setFriendid(userinfoid);

                            friendsinfoDao.insert(friendsinfo2);

                        }
                    });


                    SwingUtilities.updateComponentTreeUI(friendsJP);

                }
            }
        });



        bgJP.add(friendsJP);
        //设置界面可见
        this.setVisible(true);
    }

}
