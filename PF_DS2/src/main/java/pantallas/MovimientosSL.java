package pantallas;

import datos.implementar_Movimientos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovimientosSL extends JFrame implements ActionListener {

    JTable tb_movs;
    JButton bt_sal;
    public MovimientosSL(){

        implementar_Movimientos im = new implementar_Movimientos();

        //Configuracion frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(330,50);
        setSize(900,700);
        setTitle("MOVIMIENTOS");
        setLayout(null);
        setResizable(false);

        //componentes
        Font ft1 = new Font("Serif", Font.BOLD, 20);
        Font ft2 = new Font("Serif", Font.BOLD, 16);

            //tabla

        tb_movs = new JTable();
        tb_movs.setBounds(360,25,500,600);
        tb_movs.setBackground(Color.white);
        tb_movs.setFont(ft2);
        add(tb_movs);
        im.mostrarMovs(tb_movs);

            //boton
        bt_sal = new JButton("SALIR");
        bt_sal.setFont(ft1);
        bt_sal.setBounds(70,427,200,50);
        bt_sal.setBackground(Color.cyan);
        add(bt_sal);

            //imagen
        JLabel ic = new JLabel();
        ic.setBounds(80,150,200,200);
        ImageIcon icono = new ImageIcon("src/main/java/imagenes/logo2.png");
        Icon img = new ImageIcon(icono.getImage().getScaledInstance(ic.getWidth(), ic.getHeight(), Image.SCALE_DEFAULT));
        ic.setIcon(img);
        add(ic);
        this.repaint();


        // accionlistener

        bt_sal.addActionListener(this);

        // colores
        this.getContentPane().setBackground(Color.white);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt_sal){
            LogIn li = new LogIn();
            li.setVisible(true);
            this.setVisible(false);
        }
    }
}
