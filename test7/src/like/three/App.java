package like.three;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static void main(String[] args) {
        MyJFrame myJFrame = new MyJFrame();
        Deal deal = new Deal();
        deal.setServer(myJFrame);
        myJFrame.setDeal(deal);
    }
}

class MyJFrame extends JFrame {
    JTextField num1,num2,ope,result;
    JButton button;
    JLabel msg;
    JPanel panel,p2;
    Deal deal;
    public void setDeal(Deal deal) {
        this.deal = deal;
        button.addActionListener(deal);
    }


    public MyJFrame() {
        super("简易计算器");
        this.setLocation(600,300);
        this.setSize(400,120);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,1));
        panel = new JPanel();
        this.add(panel);
        num1 = new JTextField(5);
        panel.add(num1);
        ope = new JTextField(2);
        panel.add(ope);
        num2 = new JTextField(5);
        panel.add(num2);
        button = new JButton(" = ");
        panel.add(button);
        result = new JTextField(5);
        panel.add(result);
        p2 = new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(p2);
        msg = new JLabel();
        Font f = new Font("微软雅黑",Font.PLAIN,18);
        msg.setFont(f);
        msg.setOpaque(true);
        p2.add(msg);
        this.setVisible(true);

    }

}

class Deal implements ActionListener {

    private MyJFrame frame;
    public void setServer(MyJFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.button) {
            try {
                if(frame.num1.getText().trim().equals("") || frame.num2.getText().trim().equals("")) {
                    throw new NullTextFieldException();
                }
                int num1 = Integer.parseInt(frame.num1.getText());
                int num2 = Integer.parseInt(frame.num2.getText());
                int rel=0;
                if(frame.ope.getText().trim().equals("+")) {
                    rel = num1+num2;
                }else if(frame.ope.getText().trim().equals("-")) {
                    rel = num1-num2;
                }else if(frame.ope.getText().trim().equals("*")) {
                    rel = num1*num2;
                }else if(frame.ope.getText().trim().equals("/")) {
                    rel = num1/num2;
                }else {
                    throw new opeException();
                }
                frame.result.setText(rel+"");
                frame.msg.setText("success");

            } catch (ArithmeticException e1) {
                frame.msg.setText("被除数不能为0！");
            } catch(NumberFormatException e1) {
                frame.msg.setText("数据格式错误！");
            } catch (opeException e1) {
                frame.msg.setText("运算符错误！");
            } catch (NullTextFieldException e1) {
                frame.msg.setText("文本框不能为空！");
            }
        }
    }
}

class opeException extends Exception {
    public opeException() {

    }
    public opeException(String msg) {
        super(msg);
    }
}
class NullTextFieldException extends Exception {
    public NullTextFieldException() {

    }
    public NullTextFieldException(String msg) {
        super(msg);
    }
}