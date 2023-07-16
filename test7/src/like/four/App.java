package like.four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {
    public static void main(String[] args) {
            MyJFrame myJFrame = new MyJFrame();
            Deal deal = new Deal();
            myJFrame.setDeal(deal);
            deal.setService(myJFrame);
    }
}

class MyJFrame extends JFrame {
    JPanel jPanel;
    JLabel jLabel;
    JButton red,green,blue;

    Deal deal;
    public void setDeal(Deal deal) {
        this.deal = deal;
        this.red.addActionListener(deal);
        this.green.addActionListener(deal);
        this.blue.addActionListener(deal);
        this.red.addMouseListener(deal);
        this.green.addMouseListener(deal);
        this.blue.addMouseListener(deal);


    }


    public MyJFrame() {
        this.setSize(300,120);
        this.setLocation(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,1));
        jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        this.add(jPanel);
        red = new JButton("red");
        green = new JButton("green");
        blue = new JButton("blue");
        jPanel.add(red);
        jPanel.add(green);
        jPanel.add(blue);
        jLabel = new JLabel();
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setVerticalAlignment(JLabel.CENTER);
        this.add(jLabel);
        this.setVisible(true);
    }

}

class Deal extends MouseAdapter implements ActionListener {

    private MyJFrame  myJFrame;
    public void setService(MyJFrame myJFrame) {
        this.myJFrame = myJFrame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Font font = new Font("宋体",Font.BOLD,20);
        myJFrame.jLabel.setFont(font);
        if(e.getSource() == myJFrame.red) {
            myJFrame.jPanel.setBackground(Color.RED);
            myJFrame.jLabel.setText("This is Red!");
        }
        if(e.getSource() == myJFrame.green) {
            myJFrame.jPanel.setBackground(Color.GREEN);
            myJFrame.jLabel.setText("This is green!");
        }
        if(e.getSource() == myJFrame.blue) {
            myJFrame.jPanel.setBackground(Color.BLUE);
            myJFrame.jLabel.setText("This is Blue!");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == myJFrame.red) {
            myJFrame.red.setBackground(Color.red);
        }
        if(e.getSource() == myJFrame.green) {
            myJFrame.green.setBackground(Color.green);
        }
        if(e.getSource() == myJFrame.blue) {
            myJFrame.blue.setBackground(Color.blue);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == myJFrame.red) {
            myJFrame.red.setBackground(myJFrame.blue.getBackground());
        }
        if(e.getSource() == myJFrame.blue) {
            myJFrame.blue.setBackground(myJFrame.green.getBackground());
        }
        if(e.getSource() == myJFrame.green) {
            myJFrame.green.setBackground(myJFrame.red.getBackground());
        }
    }
}