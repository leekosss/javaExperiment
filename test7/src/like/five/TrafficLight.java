package like.five;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLight {
    public static void main(String[] args) {
        MyJFrame myJFrame = new MyJFrame("交通灯");
        Deal deal = new Deal();
        deal.setService(myJFrame);
        myJFrame.setDeal(deal);
    }
}

class MyJFrame extends JFrame {
    JButton row,col;
    JPanel jPanel,traffic;
    JLabel[][] jLabels = new JLabel[5][6];
    private Deal deal;
    public void setDeal(Deal deal) {
        this.deal = deal;
        row.addActionListener(deal);
        col.addActionListener(deal);
    }


    public MyJFrame(String s) {
        super(s);
        this.setSize(400,300);
        this.setLocation(500,300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        row = new JButton("横向通行");
        row.setEnabled(false);
        col = new JButton("纵向通行");
        jPanel.add(row);
        jPanel.add(col);
        this.add(jPanel,BorderLayout.NORTH);
        traffic = new JPanel();
        traffic.setLayout(new GridLayout(5,6));
        for(int i=0;i<5;i++) {
            for(int j=0;j<6;j++) {
                if(i==3) {
                    jLabels[i][j] = new JLabel( );
                    jLabels[i][j].setBackground(Color.green);
                }
                else if(j==4) {
                    jLabels[i][j] = new JLabel();
                    jLabels[i][j].setBackground(Color.red);
                }
                else {
                    jLabels[i][j] = new JLabel("   ");
                    jLabels[i][j].setBackground(Color.WHITE);
                }
                jLabels[i][j].setOpaque(true);
                //设置为不透明
                traffic.add(jLabels[i][j]);
            }
        }
        this.add(traffic,BorderLayout.CENTER);


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
        if(e.getSource() == myJFrame.row) {
            for(int i=0;i<5;i++) {
                for(int j=0;j<6;j++) {
                    if(j==4) {
                        myJFrame.jLabels[i][j].setBackground(Color.red);
                    }
                    if(i==3) {
                        myJFrame.jLabels[i][j].setBackground(Color.green);
                    }

                    myJFrame.row.setEnabled(false);
                    myJFrame.col.setEnabled(true);
                }
            }
        }
        if(e.getSource() == myJFrame.col) {
            for(int i=0;i<5;i++) {
                for(int j=0;j<6;j++) {
                    myJFrame.row.setEnabled(true);
                    if(i==3) {
                        myJFrame.jLabels[i][j].setBackground(Color.red);
                    }
                    if(j==4) {
                        myJFrame.jLabels[i][j].setBackground(Color.green);
                    }
                    myJFrame.col.setEnabled(false);
                }
            }
        }
    }
}
