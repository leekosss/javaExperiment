package com.leekos.util;

import com.leekos.model.Brand;
import com.leekos.model.Cell;
import com.leekos.model.Layer;

public class LayerUtil {


    public static Layer createLayer(Integer r, Integer c) {  // 创建图层
        Layer layer = null;
        try {
            layer = new Layer(r, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert layer != null;
        Brand[] brands = BrandUtil.createBrands(layer.getCapacity());

        int flag = 0;

        Cell[][] cells = layer.getCells();
        for (int row = 0; row < cells.length; row++) {
            for (int col = 0; col < cells[row].length; col++) {
                Brand brand = brands[flag++];
                Cell cell = new Cell();
                cell.setStatus(1);
                cell.setBrand(brand);
                cells[row][col] = cell;
            }
        }
        return layer;
    }
}
