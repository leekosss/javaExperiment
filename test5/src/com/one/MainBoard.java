package com.one;

public class MainBoard {
    private PCI pci[];
    public MainBoard() {
        this(5);
    }
    public MainBoard(int size) {
        pci = new PCI[size];
    }

    /**
     * 主板中插入PCI设备
     * @param p
     */
    public void add(PCI p) {
        for(int i=0;i< pci.length;i++) {
            if(pci[i] == null) {
                pci[i] = p;
                break;
            }
        }
    }
    public void start() {
        System.out.println("主板启动~~");
        for (PCI value : pci) {
            if (value != null) {
                value.start();
            }
        }
    }
    public void run() {
        System.out.println("主板运行~~");
        for(PCI p:pci) {
            if(p!=null) {
                p.run();
            }
        }
    }
    public void stop() {
        System.out.println("主板停止~~");
        for(PCI p : pci) {
            if (p!=null) {
                p.stop();
            }
        }
    }

}
