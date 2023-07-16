package like.one;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class App {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("Login");


    }
}
class MyFrame extends Frame {

    Label lb1 ,lb2;
    TextField t_u;
    Button login;
    JPasswordField t_p;
    public MyFrame(String title) {
        Deal deal = new Deal();
        deal.setMyFrame(this);
        this.setSize(600,100);
        this.setLayout(new FlowLayout());
        this.setLocation(400,300);
        this.setTitle(title);
        lb1 = new Label("username");
        this.add(lb1);
        t_u = new TextField(14);
        add(t_u);
        lb2 = new Label("password");
        this.add(lb2);
        t_p = new JPasswordField(14);
        add(t_p);
        login = new Button("login");
        this.add(login);
        login.addActionListener(deal);
        this.addWindowListener(deal);
        this.setVisible(true);
    }
}

class Deal implements ActionListener, WindowListener {
    Frame f;
    private MyFrame myFrame;
    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f = new Frame();
        f.setSize(300,100);
        f.setLocation(600,300);
        f.setLayout(new FlowLayout());
        Label label;


        if(e.getSource() == myFrame.login) {
            if(myFrame.t_u.getText().equals("like")&&myFrame.t_p.getText().equals("666")) {
                f.setTitle("Login Success!");
                label = new Label("Login Success!");
                f.add(label);
            } else {
                f.setTitle("Login Fail!");
                label = new Label("Login Fail!");
                f.add(label);
            }
        }
        f.addWindowListener(this);
        f.setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
