package pantallas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.Date;

import datos.implementar_Productos;

public class Productos extends JFrame implements ActionListener, ItemListener, MouseListener {

    implementar_Productos ip = new implementar_Productos();
    JTable tb_prod;
    JLabel lb_prd, lb_precio, lb_tipo, lb_cant, lb_id;
    JTextField txt_prod, txt_precio, txt_cant, txt_id;
    JComboBox cb_tipo;
    JButton bt_edit, bt_del, bt_insert, bt_volver;
    JScrollBar sb_tabla;

    public Productos(){



        //Configuracion frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(330,50);
        setSize(900,700);
        setTitle("PRODUCTOS");
        setLayout(null);
        setResizable(false);

        //componentes
        Font ft1 = new Font("Serif", Font.BOLD, 30);
        Font ft2 = new Font("Serif", Font.ITALIC, 30);
        Font ft3 = new Font("Serif", Font.ITALIC, 24);
        Font ft4 = new Font("Serif", Font.BOLD, 17);



            //label
        lb_id = new JLabel("ID:");
        lb_prd = new JLabel("Producto:");
        lb_precio = new JLabel("$");
        lb_cant = new JLabel("Cantidad:");
        lb_tipo = new JLabel("Tipo:");
        lb_id.setFont(ft1);
        lb_prd.setFont(ft1);
        lb_precio.setFont(ft1);
        lb_cant.setFont(ft1);
        lb_tipo.setFont(ft1);
        lb_id.setBounds(120,20,200,50);
        lb_prd.setBounds(30,100,200,50);
        lb_precio.setBounds(140, 180,200,50);
        lb_cant.setBounds(30,260,200,50 );
        lb_tipo.setBounds(90,340,200,50);
        add(lb_id);
        add(lb_prd);
        add(lb_precio);
        add(lb_cant);
        add(lb_tipo);

            //textfield
        txt_id = new JTextField();
        txt_prod = new JTextField();
        txt_precio = new JTextField();
        txt_cant = new JTextField();
        txt_id.setEnabled(false);
        txt_id.setFont(ft2);
        txt_prod.setFont(ft2);
        txt_precio.setFont(ft2);
        txt_cant.setFont(ft2);
        txt_id.setBounds(170,20,250,50);
        txt_prod.setBounds(170,100,250,50);
        txt_precio.setBounds(170,180,250,50);
        txt_cant.setBounds(170,260,250,50);
        add(txt_id);
        add(txt_prod);
        add(txt_precio);
        add(txt_cant);

            //comboBox
        cb_tipo = new JComboBox();
        cb_tipo.setFont(ft2);
        cb_tipo.setBounds(170,340,250,50);
        add(cb_tipo);

        cb_tipo.addItem("Ingreso");
        cb_tipo.addItem("Devolución");
        cb_tipo.addItem("Salida");
        cb_tipo.addItem("Merma");
        cb_tipo.addItem("Robo");
        cb_tipo.addItemListener( this);

            //tabla

        tb_prod = new JTable();
        tb_prod.setBounds(470,25,390,600);
        tb_prod.setFont(ft4);
        add(tb_prod);
        ip.mostrarProductos(tb_prod);
        //Botones
        bt_insert = new JButton("INSERTAR");
        bt_del = new JButton("ELIMINAR");
        bt_edit = new JButton("EDITAR");
        bt_volver = new JButton("IR AL MENU");
        bt_insert.setFont(ft4);
        bt_edit.setFont(ft4);
        bt_del.setFont(ft4);
        bt_volver.setFont(ft4);
        bt_insert.setBounds(30,480,200,50);
        bt_edit.setBounds(245,480,200,50);
        bt_del.setBounds(30,550,200,50);
        bt_volver.setBounds(245,550,200,50);
        add(bt_insert);
        add(bt_edit);
        add(bt_del);
        add(bt_volver);

        // accionlistener
        bt_volver.addActionListener(this);
        bt_insert.addActionListener(this);
        tb_prod.addMouseListener(this);
        bt_del.addActionListener(this);
        bt_edit.addActionListener(this);

        // colores
        bt_del.setBackground(Color.red);
        bt_insert.setBackground(Color.green);
        bt_volver.setBackground(Color.cyan);
        bt_edit.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().setBackground(Color.white);
        tb_prod.setBackground(Color.white);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt_volver){
            Menu mn = new Menu();
            this.setVisible(false);
        }

        if (e.getSource() == bt_insert){
            ip.guardarProd(txt_prod, txt_precio, txt_cant, cb_tipo);
            ip.mostrarProductos(tb_prod);
            txt_cant.setText("");
            txt_prod.setText("");
            txt_precio.setText("");
        }

        if (e.getSource() == bt_del){
            ip.eliminarProd(txt_id);
            ip.mostrarProductos(tb_prod);
        }

        if (e.getSource() == bt_edit){
            ip.modificarProd(txt_prod, txt_precio, txt_id);
            ip.mostrarProductos(tb_prod);
            txt_cant.setText("");
            txt_prod.setText("");
            txt_precio.setText("");
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == tb_prod){
            ip.seleccionarProd(txt_prod,txt_precio,tb_prod,txt_id);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
