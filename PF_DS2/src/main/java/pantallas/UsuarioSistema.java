package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import datos.implementar_Usuarios;

public class UsuarioSistema extends JFrame implements ActionListener {

    JTable tb_usuarios;
    JButton bt_vm, bt_newUs;


    implementar_Usuarios iu = new implementar_Usuarios();
    public UsuarioSistema(){


        //Configuracion frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(330,50);
        setSize(900,700);
        setTitle("USUARIOS DEL SISTEMA");
        setLayout(null);
        setResizable(false);

        //componentes
        Font ft1 = new Font("Serif", Font.BOLD, 20);
        Font ft2 = new Font("Serif", Font.BOLD, 16);


            //tabla usuarios
        tb_usuarios = new JTable();
        tb_usuarios.setBounds(360,25,500,600);
        tb_usuarios.setBackground(Color.white);
        tb_usuarios.setFont(ft2);
        add(tb_usuarios);
        iu.mostrarUsers(tb_usuarios);

            //botones
        bt_vm = new JButton("IR AL MENU");
        bt_newUs = new JButton("NUEVO USUARIO");
        //bt_borrar = new JButton("BORRAR USUARIO");

        bt_vm.setFont(ft1);
        bt_newUs.setFont(ft1);
        //bt_borrar.setFont(ft1);

        bt_vm.setBounds(60,427,230,50);
        bt_newUs.setBounds(60,360,230,50);
        //bt_borrar.setBounds(60,494,230,50);

        add(bt_vm);
        add(bt_newUs);
        //add(bt_borrar);

        //imagen
        JLabel ic = new JLabel();
        ic.setBounds(80,100,200,200);
        ImageIcon icono = new ImageIcon("src/main/java/imagenes/user.png");
        Icon img = new ImageIcon(icono.getImage().getScaledInstance(ic.getWidth(), ic.getHeight(), Image.SCALE_DEFAULT));
        ic.setIcon(img);
        add(ic);
        this.repaint();

        // accionlistener
        bt_vm.addActionListener(this);
        bt_newUs.addActionListener(this);


        // colores
        bt_vm.setBackground(Color.cyan);
        bt_newUs.setBackground(Color.yellow);
        //bt_borrar.setBackground(Color.red);
        this.getContentPane().setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bt_vm){
            Menu mn = new Menu();
            this.setVisible(false);
        }

        if (e.getSource() == bt_newUs){
            NuevoUsuario us = new NuevoUsuario();
            this.setVisible(false);
        }

    }
}
