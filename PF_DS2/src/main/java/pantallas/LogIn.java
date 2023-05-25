package pantallas;

import datos.validarLogIn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame implements ActionListener {

    JPanel panel;
    JLabel lb_user, lb_pass, ic;
    JTextField txt_user;
    JPasswordField txt_pass;
    JButton bt_Login;
        validarLogIn vli = new validarLogIn();
    public LogIn(){
        setLocation(330,50);
        setSize(900,700);
        setTitle("LOG IN");
        setLayout(null);
        setResizable(false);
        Font ft1 = new Font("Serif", Font.BOLD, 28);
        Font ft2 = new Font("Serif", Font.ITALIC, 24);
        panel = new JPanel();
        lb_user=new JLabel("Usuario:");
        lb_pass=new JLabel("Contraseña:");
        ic = new JLabel();
        txt_user = new JTextField();
        txt_pass = new JPasswordField();
        bt_Login = new JButton("LOG IN");
        setBackground(Color.white);
        ic.setBounds(350,100,200,200);
        lb_user.setBounds(290,350, 200,50);
        lb_user.setFont(ft1);
        add(lb_user);
        txt_user.setBounds(400,350, 200,50);
        txt_user.setFont(ft2);
        add(txt_user);
        lb_pass.setBounds(245, 420,200,50);
        lb_pass.setFont(ft1);
        add(lb_pass);
        txt_pass.setBounds(400,420, 200,50);
        txt_pass.setFont(ft2);
        add(txt_pass);
        bt_Login.setBounds(350,500,200,50);
        bt_Login.setFont(ft1);
        bt_Login.setBackground(Color.cyan);
        add(bt_Login);
        ImageIcon icono = new ImageIcon("src/main/java/imagenes/logo2.png");
        Icon img = new ImageIcon(icono.getImage().getScaledInstance(ic.getWidth(), ic.getHeight(), Image.SCALE_DEFAULT));
        ic.setIcon(img);
        add(ic);
        this.repaint();

        bt_Login.addActionListener(this);

        this.getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

            if (e.getSource() == bt_Login){
                vli.validar(txt_user, txt_pass);
                this.setVisible(false);
            }
    }
}
