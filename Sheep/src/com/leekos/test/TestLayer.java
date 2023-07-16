package com.leekos.test;


import com.leekos.model.Brand;
import com.leekos.model.Cell;
import com.leekos.model.Layer;

import java.util.Random;

/**
 * 测试图层数据构建
 */
public class TestLayer {
    public static Random random = new Random();

    public static String[] brandNames = {
            "刷子", "剪刀", "叉子",
            "手套", "水桶", "火",
            "玉米", "球", "瓶子",
            "白菜", "稻草", "肉腿",
            "胡萝卜", "苹果", "苹果",
            "铃铛", "青草"
    };

    public static String getRandomName() {
        int randomIndex = random.nextInt(brandNames.length);
        return brandNames[randomIndex];
    }

    public static void main(String[] args) {
        Layer layer = null;
        try {
            layer = new Layer(3,5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Brand[] brands = new Brand[layer.getCapacity()];
        for (int i = 0; i < brands.length; i+=3) {
            String randomName = getRandomName();
            Brand brand1 = new Brand(randomName);
            Brand brand2 = new Brand(randomName);
            Brand brand3 = new Brand(randomName);
            brands[i] = brand1;
            brands[i+1] = brand2;
            brands[i+2] = brand3;

        }


        for (int i = 0; i < brands.length; i++) {
            System.out.print(brands[i].getName() +" ");
        }
        System.out.println("\n------------------------------");
        for (int i = 0; i < brands.length; i++) {
            int randomIndex = random.nextInt(brands.length);
            Brand temp = brands[i];
            brands[i] = brands[randomIndex];
            brands[randomIndex] = temp;
        }

        for (int i = 0; i < brands.length; i++) {
            System.out.print(brands[i].getName() +" ");
        }

        int flag=0;

        Cell[][] cells = layer.getCells();
        for(int row=0;row<cells.length;row++) {
            for (int col=0;col<cells[row].length;col++) {
                Brand brand = brands[flag++];
                Cell cell = new Cell();
                cell.setStatus(1);
                cell.setBrand(brand);
                cells[row][col] = cell;
            }
        }
        System.out.println("------------------");
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].getBrand().getName() + "\t\t");
            }
            System.out.println();
        }

    }


}
