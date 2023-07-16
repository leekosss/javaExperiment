package like.two;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        MyJFrame myJFrame = new MyJFrame("开关灯");
        Deal deal = new Deal();
        deal.setService(myJFrame);
        myJFrame.setDeal(deal);
    }
}

class MyJFrame extends JFrame {
    JLabel status,lamp;
    JButton open,close;
    Font f;
    Deal deal;
    public void setDeal(Deal deal) {
        this.deal = deal;
        this.open.addActionListener(deal);
        this.close.addActionListener(deal);

    }


    public MyJFrame(String name) {
        super(name);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500,100);
        this.setLocation(500,300);
        this.setLayout(new FlowLayout());
        status = new JLabel("Status: ");
        f = new Font("宋体",Font.BOLD,16);
        status.setFont(f);
        this.add(status);
        lamp = new JLabel("      ");
        lamp.setOpaque(true);
        lamp.setBackground(Color.BLACK);

        this.add(lamp);
        open = new JButton("open");
        close = new JButton("close");
        close.setEnabled(false);
        this.add(open);
        this.add(close);
        this.setVisible(true);
    }
}

class Deal implements ActionListener {
    private MyJFrame myJFrame;
    public void setService(MyJFrame myJFrame) {
        this.myJFrame = myJFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == myJFrame.open) {
            myJFrame.lamp.setBackground(Color.RED);
            myJFrame.open.setEnabled(false);
            myJFrame.close.setEnabled(true);
        }
        if(e.getSource() == myJFrame.close) {
            myJFrame.lamp.setBackground(Color.BLACK);
            myJFrame.open.setEnabled(true);
            myJFrame.close.setEnabled(false);
        }
    }
}

