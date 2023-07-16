package com.leekos.util;


import com.leekos.model.Brand;

import java.util.Random;

/**
 * 创建Brand牌的工具类
 */
public class BrandUtil {
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

    public static Brand[] createBrands(Integer capacity) {
        Brand[] brands = new Brand[capacity];
        for (int i = 0; i < brands.length; i += 3) {
            String randomName = getRandomName();
            Brand brand1 = new Brand(randomName);
            Brand brand2 = new Brand(randomName);
            Brand brand3 = new Brand(randomName);
            brands[i] = brand1;
            brands[i + 1] = brand2;
            brands[i + 2] = brand3;
        }
        for (int i = 0; i < brands.length; i++) {  // 将牌打乱顺序
            int randomIndex = random.nextInt(brands.length);
            Brand temp = brands[i];
            brands[i] = brands[randomIndex];
            brands[randomIndex] = temp;
        }
        return brands;


    }


}
