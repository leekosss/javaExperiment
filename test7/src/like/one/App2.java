package like.one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class App2 {
    public static void main(String[] args) {
        MyJFrame myJFrame = new MyJFrame("Login~");
    }
}
class MyJFrame extends JFrame implements ActionListener, WindowListener {
    JLabel lb1 ,lb2;
    JTextField t_u;
    JButton login;
    JPasswordField t_p;
    Frame f;

    public MyJFrame(String title) {


        this.setSize(600,100);
        this.setLayout(new FlowLayout());
        this.setLocation(400,300);
        this.setTitle(title);
        lb1 = new JLabel("username");
        this.add(lb1);
        t_u = new JTextField(14);
        add(t_u);
        lb2 = new JLabel("password");
        this.add(lb2);
        t_p = new JPasswordField(14);
        add(t_p);
        login = new JButton("login");
        this.add(login);
        login.addActionListener(this);
        this.addWindowListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        f = new Frame();
        f.setSize(300,100);
        f.setLocation(600,300);
        f.setLayout(new FlowLayout());
        Label label;
        if(e.getSource() == login) {
            if(t_u.getText().equals("like")&&t_p.getText().equals("666")) {
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
        if(f!=null) {
            f.dispose();
        }else {
            this.dispose();
        }

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
