package com.leekos.test;

import com.leekos.model.Brand;
import com.leekos.model.Cell;
import com.leekos.model.Layer;
import com.leekos.util.LayerUtil;
import com.leekos.view.Start;

import javax.swing.*;

public class TestRenderLayer extends JFrame {
    private Layer layer = LayerUtil.createLayer(6, 6);

    public TestRenderLayer() {
        init();
    }

    public static void main(String[] args) {
        new TestRenderLayer();
    }

    private void init() {
        this.setTitle("羊了个羊");
        this.setSize(400, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 关闭后结束程序
        this.setLocationRelativeTo(null);  // 设置程序居中
        Cell[][] cells = layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brand = cells[row][col].getBrand();
                int x = row * 50;
                int y = col * 50;
                brand.setBounds(x, y, 50, 50);
                this.getContentPane().add(brand);
            }
        }

        this.setVisible(true);  //默认隐藏，需显示
        this.setLayout(null);
        this.setBounds(0, 0, 450, 800);

        autoRefresh();
    }

    private void autoRefresh() {
        TestRenderLayer testRenderLayer = this;
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(40);
                        testRenderLayer.repaint();  // 40ms重新绘制一次画面
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


}
