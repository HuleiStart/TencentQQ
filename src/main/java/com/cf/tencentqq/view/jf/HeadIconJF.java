package com.cf.tencentqq.view.jf;

import com.cf.tencentqq.dao.UserinfoDao;
import com.cf.tencentqq.entity.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

@Component
public class HeadIconJF extends JFrame {

    @Autowired
    UserinfoDao userinfoDao;

    @Autowired
    QQMainJFrame qqMainJFrame;

    public void changeIcon(Userinfo userinfo){
        //设置界面大小
        this.setSize(420, 450);
        //设置界面登录框居中
        this.setLocationRelativeTo(null);
        //设置界面不可拉伸
        this.setResizable(false);
        //设置界面可见
        this.setVisible(true);
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
        bgJP.setBounds(0,0,420,450);
        //添加背景容器
        this.getContentPane().add(bgJP);
        //背景容器绝对布局
        bgJP.setLayout(null);
        for(int i = 0;i < 100;i++){
            JLabel HeadIcon = new JLabel(i+1+"");
            //设置容器大小位置
            HeadIcon.setBounds(40*(i%10),i/10*40,40,40);
            try {
                HeadIcon.setIcon(new ImageIcon(ImageIO.read(new ClassPathResource("static/via/online/" + (i + 1) + ".png").getInputStream())));
            } catch (IOException e) {
                e.printStackTrace();
            }
            HeadIcon.setBorder(BorderFactory.createLineBorder(new Color(180, 179, 179),1));

            HeadIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getClickCount() == 2){

                        if(userinfo.getFaceid() == Integer.parseInt(HeadIcon.getText())){
                            return;
                        }
                        //获取头像ID，实时更新
                        try {
                            qqMainJFrame.updataIcon(HeadIcon.getText());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
//                        JOptionPane.showMessageDialog(null,"修改头像成功！");

                        Userinfo user = new Userinfo();
                        //获取当前用户的id
                        user.setId(userinfo.getId());
                        //获取当前用户头像ID
                        user.setFaceid(Integer.parseInt(HeadIcon.getText()));
                        //根据用户ID更改头像ID
                        userinfoDao.update(user);

                        //让界面隐藏
//                        HeadIconJF.this.setVisible(false);

                        //让界面消失
                        HeadIconJF.this.dispose();

                    }
                }
            });
            //将图片容器放入背景容器
            bgJP.add(HeadIcon);
        }
    }
}
