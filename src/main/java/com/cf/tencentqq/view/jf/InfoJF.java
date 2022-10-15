package com.cf.tencentqq.view.jf;

import com.cf.tencentqq.dao.UserinfoDao;
import com.cf.tencentqq.entity.Userinfo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

@Component
public class InfoJF extends JFrame {

    @Autowired
    UserinfoDao userinfoDao;

    @Autowired
    EditJF editJF;
    private Userinfo userinfo;


    @SneakyThrows
    public void Info(Userinfo userinfo){
        this.userinfo = userinfo;
        //设置界面大小
        this.setSize(900, 690);
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
        bgJP.setBounds(0,0,900,690);
        //添加背景容器
        this.getContentPane().add(bgJP);
        //背景容器绝对布局
        bgJP.setLayout(null);

        JPanel infobgJP = new JPanel();
        infobgJP.setBounds(0,0,450,690);
        infobgJP.setBackground(new Color(255,255,255));

        infobgJP.setLayout(null);
        bgJP.add(infobgJP);


        JLabel infobgJL = new JLabel();
        try {
            infobgJL.setIcon(new ImageIcon(ImageIO.read(new ClassPathResource("static/expand/QQfm.png").getInputStream())));
        } catch (IOException o) {
            o.printStackTrace();
        }
        infobgJL.setBounds(0, 0, 450, 450);
        infobgJP.add(infobgJL);


        /**
         * 设置头像
         */
        //定义头像标签
        JLabel headPortraitJL = new JLabel();
        //定义头像容器
        ImageIcon updateID = new ImageIcon(ImageIO.read(new ClassPathResource("static/via/online/" +userinfo.getFaceid()+".png").getInputStream()));
        //设置头像容器大小
        updateID.setImage(updateID.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
        //将头像容器放入头像标签中
        headPortraitJL.setIcon(updateID);
        //设置头像容器位置大小
        headPortraitJL.setBounds(65, 510, 60, 60);
        //将头像标签放入第一层面板中
        infobgJP.add(headPortraitJL);


    /**
     * 设置昵称
     */

        //定义昵称容器
        JLabel nicknameJL = new JLabel();
        //设置容器大小位置
        nicknameJL.setBounds(140, 500, 250, 50);
        //设置容器默认文本
        nicknameJL.setText(userinfo.getNickname());
        //设置容器文字字体
        nicknameJL.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        nicknameJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        infobgJP.add(nicknameJL);
/**
 * 个性签名
 */
        //个性签名容器
        JTextField  signatureJT = new JTextField();
        //将个性签名加入第一次面板
        infobgJP.add(signatureJT);
        //去除输入框焦点，转移至infobgJP
        infobgJP.setFocusable(true);
        //设置容器大小位置
        signatureJT.setBounds(140, 535, 300, 30);
        //设置文字字体
        signatureJT.setFont(new Font("华文琥珀", Font.PLAIN, 12));
        //设置容器透明
        signatureJT.setOpaque(false);
        //设置字体颜色
        signatureJT.setForeground(new Color(43,43,43));
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


        JPanel editJP = new JPanel();
        editJP.setBounds(450,0,450,690);
        editJP.setBackground(new Color(255,255,255));

        editJP.setLayout(null);
        bgJP.add(editJP);


        //定义昵称容器
        JLabel QQIDJL = new JLabel();
        //设置容器大小位置
        QQIDJL.setBounds(50, 45, 100, 25);
        //设置容器默认文本
        QQIDJL.setText("ID: "+userinfo.getId());
        //设置容器文字字体
        QQIDJL.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        QQIDJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        editJP.add(QQIDJL);


        //定义昵称容器
        JLabel editJL = new JLabel();
        //设置容器大小位置
        editJL.setBounds(340, 45, 100, 25);
        //设置容器默认文本
        editJL.setText("编辑资料");
        //设置容器文字字体
        editJL.setFont(new Font("华文彩云", Font.BOLD, 18));
        //设置文字颜色
        editJL.setForeground(new Color(0,155,219));
        //将文本添加至第一次面板
        editJP.add(editJL);

        editJL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                editJF.Edit(userinfo);
            }
        });


        //定义昵称容器
        JLabel sexJL = new JLabel();
        //设置容器大小位置
        sexJL.setBounds(50, 75, 50, 25);
        //设置容器默认文本
        sexJL.setText(userinfo.getSex());
        //设置容器文字字体
        sexJL.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        sexJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        editJP.add(sexJL);

        //定义昵称容器
        JLabel ageJL = new JLabel();
        //设置容器大小位置
        ageJL.setBounds(100, 75, 200, 25);
        //设置容器默认文本
        ageJL.setText(userinfo.getAge()+"岁");
        //设置容器文字字体
        ageJL.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        ageJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        editJP.add(ageJL);

        //定义昵称容器
        JLabel starJL = new JLabel();
        //设置容器大小位置
        starJL.setBounds(50, 100, 200, 25);
        //设置容器默认文本

        switch (userinfo.getStarid()){
            case 1:
                starJL.setText("白羊座");
                break;
            case 2:
                starJL.setText("双鱼座");
                break;
            case 3:
                starJL.setText("双子座");
                break;
            case 4:
                starJL.setText("金牛座");
                break;
            case 5:
                starJL.setText("天蝎座");
                break;
            case 6:
                starJL.setText("处女座");
                break;
            case 7:
                starJL.setText("射手座");
                break;
            case 8:
                starJL.setText("狮子座");
                break;
            case 9:
                starJL.setText("巨蝎座");
                break;
            case 10:
                starJL.setText("天秤座");
                break;
            case 11:
                starJL.setText("水瓶座");
                break;
            case 12:
                starJL.setText("魔羯座");
                break;
        }
        //设置容器文字字体
        starJL.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        starJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        editJP.add(starJL);


        //定义昵称容器
        JLabel animalJL = new JLabel();
        //设置容器大小位置
        animalJL.setBounds(160, 75, 200, 25);
        //设置容器默认文本

        switch (userinfo.getAnimalyearid()){
            case 1:
                animalJL.setText("龙");
                break;
            case 2:
                animalJL.setText("虎");
                break;
            case 3:
                animalJL.setText("兔");
                break;
            case 4:
                animalJL.setText("鼠");
                break;
            case 5:
                animalJL.setText("狗");
                break;
            case 6:
                animalJL.setText("牛");
                break;
            case 7:
                animalJL.setText("马");
                break;
            case 8:
                animalJL.setText("蛇");
                break;
            case 9:
                animalJL.setText("猪");
                break;
            case 10:
                animalJL.setText("猴");
                break;
            case 11:
                animalJL.setText("鸡");
                break;
            case 12:
                animalJL.setText("羊");
                break;

        }
        //设置容器文字字体
        animalJL.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        animalJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        editJP.add(animalJL);


        //定义昵称容器
        JLabel addressJL = new JLabel();
        //设置容器大小位置
        addressJL.setBounds(140, 100, 200, 25);
        //设置容器默认文本
        addressJL.setText(userinfo.getAddress());
        //设置容器文字字体
        addressJL.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        addressJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        editJP.add(addressJL);

        //定义头像标签
        JLabel QQlvJL = new JLabel();
        //定义头像容器
        ImageIcon QQlvIcon = new ImageIcon(ImageIO.read(new ClassPathResource("static/images/QQLv.png").getInputStream()));
        //设置头像容器大小
        QQlvIcon.setImage(QQlvIcon.getImage().getScaledInstance(218, 25, Image.SCALE_DEFAULT));
        //将头像容器放入头像标签中
        QQlvJL.setIcon(QQlvIcon);
        //设置头像容器位置大小
        QQlvJL.setBounds(50, 150, 218, 25);
        //将头像标签放入第一层面板中
        editJP.add(QQlvJL);

        JButton moreJB = new JButton("更多资料");
        moreJB.setBounds(175, 230, 100, 30);
        //设置容器文字字体
        moreJB.setFont(new Font("华文彩云", Font.BOLD, 16));
        //设置文字颜色
        moreJB.setForeground(new Color(0,155,219));
        //将文本添加至第一次面板
        editJP.add(moreJB);

        JLabel lineJL = new JLabel();
        lineJL.setBounds(20,280,400,1);
        lineJL.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        editJP.add(lineJL);


        JLabel photoJL = new JLabel("照片墙");
        photoJL.setBounds(20, 290, 100, 30);
        //设置容器文字字体
        photoJL.setFont(new Font("华文彩云", Font.BOLD, 18));
        //设置文字颜色
        photoJL.setForeground(new Color(43,43,43));
        //将文本添加至第一次面板
        editJP.add(photoJL);


        JLabel upphotoJL = new JLabel("上传照片");
        upphotoJL.setBounds(340, 290, 100, 30);
        //设置容器文字字体
        upphotoJL.setFont(new Font("华文彩云", Font.BOLD, 18));
        //设置文字颜色
        upphotoJL.setForeground(new Color(0,155,219));
        //将文本添加至第一次面板
        editJP.add(upphotoJL);


        //定义头像标签
        JLabel photowallJL = new JLabel();
        //定义头像容器
        ImageIcon photoIcon = new ImageIcon(ImageIO.read(new ClassPathResource("static/expand/QQ-4.jpg").getInputStream()));
        //设置头像容器大小
        photoIcon.setImage(photoIcon.getImage().getScaledInstance(400, 280, Image.SCALE_DEFAULT));
        //将头像容器放入头像标签中
        photowallJL.setIcon(photoIcon);
        //设置头像容器位置大小
        photowallJL.setBounds(20, 325, 400, 280);
        //将头像标签放入第一层面板中
        editJP.add(photowallJL);


        //设置界面可见
        this.setVisible(true);
    }


}
