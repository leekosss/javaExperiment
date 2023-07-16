package com.leekos.model;


import sun.awt.image.ToolkitImage;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Brand类代表游戏中的一张牌
 */
public class Brand extends Component {  // 继承Component，从而才能实现牌绘制的效果

    private String name; //牌的名字

    private Boolean isGray; //牌是否置灰

    private Image image;   // 图片

    private Image grayImage;   // 灰色的图片

    private Integer x; // 图片左上角x坐标

    private Integer y;

    private Integer width;

    private Integer height;  // 图片高度





    // name属性与图片名称有关
    public Brand(String name) {
        this.name = name;
        this.image = Toolkit.getDefaultToolkit().getImage("images/" + name + ".png");  // 获取图片
        this.grayImage = Toolkit.getDefaultToolkit().getImage("images/" + name + "_gray.png");
        this.isGray = false;
        this.width = 50;
        this.height = 50;

        this.x = 0;
        this.y = 0;

        this.addMouseListener(new MouseAdapter() {  // 给牌添加鼠标点击事件
            @Override
            public void mouseClicked(MouseEvent e) {
                Brand brand = (Brand)e.getSource();
                brand.getParent().remove(brand);    // 调用父容器删除自己
            }
        });

    }

    @Override
    public void paint(Graphics g) {  // 实现图片绘制
        if(this.isGray) {
            g.drawImage(grayImage,x,y,null); // 绘制灰色图片
        } else {
            g.drawImage(image,x,y,null);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getGray() {
        return isGray;
    }

    public void setGray(Boolean gray) {
        isGray = gray;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getGrayImage() {
        return grayImage;
    }

    public void setGrayImage(Image grayImage) {
        this.grayImage = grayImage;
    }

//    public Integer getX() {
//        return x;
//    }
//
//    public void setX(Integer x) {
//        this.x = x;
//    }
//
//    public Integer getY() {
//        return y;
//    }
//
//    public void setY(Integer y) {
//        this.y = y;
//    }
//
//    public Integer getWidth() {
//        return width;
//    }
//
//    public void setWidth(Integer width) {
//        this.width = width;
//    }
//
//    public Integer getHeight() {
//        return height;
//    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
