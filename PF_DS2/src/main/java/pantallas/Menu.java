package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JMenuBar menu = new JMenuBar();
    JMenu me_pr, me_mov, me_cl, me_us;
    JMenuItem listUs, cr_us, prod, cls, movs;
    public Menu(){
        //Configuracion frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(330,50);
        setSize(900,700);
        setTitle("MENU");
        setLayout(null);
        setResizable(false);

        //Menu
        Font ft1 = new Font("Serif", Font.BOLD, 28);
        Font ft2 = new Font("Serif", Font.ITALIC, 24);
        setJMenuBar(menu);
        me_pr = new JMenu("Productos");
        me_mov = new JMenu("Movimientos");
        me_us = new JMenu("Usuarios");
        me_cl = new JMenu("Salir");
        listUs = new JMenuItem("Usuarios del Sistema");
        cr_us = new JMenuItem("Nuevo Usuario");
        prod = new JMenuItem("Ir a productos");
        movs = new JMenuItem("Ver movimientos");
        cls = new JMenuItem("Cerrar");
        me_us.setFont(ft1);
        me_pr.setFont(ft1);
        me_mov.setFont(ft1);
        me_cl.setFont(ft1);
        listUs.setFont(ft2);
        cr_us.setFont(ft2);
        prod.setFont(ft2);
        movs.setFont(ft2);
        cls.setFont(ft2);
        me_us.add(cr_us);
        me_us.add(listUs);
        me_pr.add(prod);
        me_mov.add(movs);
        me_cl.add(cls);
        menu.add(me_pr);
        menu.add(me_mov);
        menu.add(me_us);
        menu.add(me_cl);

        //imagen
        JLabel ic = new JLabel();
        ic.setBounds(0,0,900,700);
        ImageIcon icono = new ImageIcon("src/main/java/imagenes/fondo1.png");
        Icon img = new ImageIcon(icono.getImage().getScaledInstance(ic.getWidth(), ic.getHeight(), Image.SCALE_DEFAULT));
        ic.setIcon(img);
        add(ic);
        this.repaint();

        // actionlistener
        prod.addActionListener(this);
        movs.addActionListener(this);
        cls.addActionListener(this);
        listUs.addActionListener(this);
        cr_us.addActionListener(this);

        // colores
        menu.setBackground(Color.CYAN);
        cr_us.setBackground(Color.CYAN);
        listUs.setBackground(Color.CYAN);
        movs.setBackground(Color.CYAN);
        prod.setBackground(Color.CYAN);
        cls.setBackground(Color.CYAN);
        this.getContentPane().setBackground(Color.white);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


            if (e.getSource() == prod){
                Productos prd = new Productos();
                this.setVisible(false);
            }

            if (e.getSource() == movs){
                Movimientos ms = new Movimientos();
                this.setVisible(false);
            }
            if (e.getSource() == listUs){
                UsuarioSistema us = new UsuarioSistema();
                this.setVisible(false);
            }
            if (e.getSource() == cr_us){
                NuevoUsuario nu = new NuevoUsuario();
                this.setVisible(false);
            }
            if (e.getSource() == cls){
                LogIn li = new LogIn();
                this.setVisible(false);
            }
    }
}
