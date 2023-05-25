package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import datos.implementar_Usuarios;

public class NuevoUsuario extends JFrame implements ActionListener, ItemListener{

    JLabel lb_user, lb_passw, lb_per;
    JTextField txt_user;
    JPasswordField txt_passw;
    JComboBox cb_per;
    JButton bt_new_user, bt_menu, bt_listUser;

    implementar_Usuarios iu = new implementar_Usuarios();

    public NuevoUsuario(){

        //Configuracion frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(330,50);
        setSize(900,700);
        setTitle("NUEVO USUARIO");
        setLayout(null);
        setResizable(false);

        //componentes
        Font ft1 = new Font("Serif", Font.BOLD, 28);
        Font ft2 = new Font("Serif", Font.ITALIC, 28);
        Font ft3 = new Font("Serif", Font.BOLD, 25);



        //label
        lb_user = new JLabel("Usuario:");
        lb_passw = new JLabel("Contraseña:");
        lb_per = new JLabel("Permiso:");

        lb_user.setFont(ft1);
        lb_passw.setFont(ft1);
        lb_per.setFont(ft1);

        lb_user.setBounds(200, 260,200,50);
        lb_passw.setBounds(160,340,200,50);
        lb_per.setBounds(200,420,200,50);

        add(lb_user);
        add(lb_passw);
        add(lb_per);

            //textfield
        txt_user = new JTextField();
        txt_passw = new JPasswordField();

        txt_user.setFont(ft2);
        txt_passw.setFont(ft2);

        txt_user.setBounds(320,260,300,50);
        txt_passw.setBounds(320,340,300,50);

        add(txt_user);
        add(txt_passw);

            //comboBox
        cb_per = new JComboBox<>();
        cb_per.setFont(ft2);
        cb_per.setBounds(320,420,300,50);
        add(cb_per);

        cb_per.addItem("Administrador");
        cb_per.addItem("Edición");
        cb_per.addItem("Solo lectura");
        cb_per.addItemListener( this);


            //botones
        bt_menu = new JButton("IR AL MENU");
        bt_listUser = new JButton("LISTA USUARIOS");
        bt_new_user = new JButton("GUARDAR");

        bt_new_user.setFont(ft3);
        bt_menu.setFont(ft3);
        bt_listUser.setFont(ft3);

        bt_listUser.setBounds(50,530,280,50);
        bt_new_user.setBounds(355, 530,200,50);
        bt_menu.setBounds(580,530,260,50);

        add(bt_new_user);
        add(bt_listUser);
        add(bt_menu);

            //imagen
        JLabel ic = new JLabel();
        ic.setBounds(350,10,200,250);
        ImageIcon icono = new ImageIcon("src/main/java/imagenes/logo.png");
        Icon img = new ImageIcon(icono.getImage().getScaledInstance(ic.getWidth(), ic.getHeight(), Image.SCALE_DEFAULT));
        ic.setIcon(img);
        add(ic);
        this.repaint();

        // accionlistener
        bt_menu.addActionListener(this);
        bt_listUser.addActionListener(this);
        bt_new_user.addActionListener(this);


        // colores
        bt_new_user.setBackground(Color.green);
        bt_listUser.setBackground(Color.orange);
        bt_menu.setBackground(Color.CYAN);
        this.getContentPane().setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bt_menu){
            Menu mn = new Menu();
            this.setVisible(false);
        }

        if (e.getSource() == bt_listUser){
            UsuarioSistema us = new UsuarioSistema();
            this.setVisible(false);
        }

        if (e.getSource() == bt_new_user){
            iu.guardarUser(txt_user,txt_passw,cb_per);
            txt_user.setText("");
            txt_passw.setText("");
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
