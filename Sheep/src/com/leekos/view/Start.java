package com.leekos.view;

import com.leekos.model.Brand;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏启动入口
 */
public class Start extends JFrame {
    Brand brand = new Brand("111");

    public Start() throws HeadlessException {
        this.setTitle("羊了个羊");
        this.setSize(400, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 关闭后结束程序
        this.setLocationRelativeTo(null);  // 设置程序居中


        this.setVisible(true);  //默认隐藏，需显示


        // 添加自定义组件，到窗体中
//        this.getContentPane().add(component);
        this.getContentPane().add(brand);
        autoRepaint();
    }

    public void autoRepaint() { //  自动刷新线程，在牌位置变化时，可以让组件及时显示出来
        Start start = this;
        new Thread(){
            @Override
            public void run() {
                while(true) {
                    try {
                        sleep(40);
                        start.repaint();  // 40ms重新绘制一次画面
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }



    public static void main(String[] args) {
        new Start();
    }

}
