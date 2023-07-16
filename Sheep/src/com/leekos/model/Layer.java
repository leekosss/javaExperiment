package com.leekos.model;


/**
 * 图层类：代表很多行列，包含很多单元格对象
 */
public class Layer {

    private Integer colNum;  // 有多少列
    private Integer rowNum;  // 有多少行
    private Integer capacity; //容量，可以放多少牌
    private Integer size;  //实际有多少牌，需要动态改变

    private Cell[][] cells = null;

    public Layer(Integer rowNum, Integer colNum) throws Exception {
        this.colNum = colNum;
        this.rowNum = rowNum;
        this.capacity = colNum * rowNum;
        if(this.capacity % 3 !=0) {
            throw new Exception("牌容量不是3的倍数！");
        }


        this.size = 0;
        this.cells = new Cell[rowNum][colNum];
    }

    public Integer getColNum() {
        return colNum;
    }

    public void setColNum(Integer colNum) {
        this.colNum = colNum;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}
