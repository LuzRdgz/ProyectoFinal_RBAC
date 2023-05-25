package datos;

import pantallas.Productos;
import varios.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDateTime;

public class implementar_Productos {

    public void guardarProd(JTextField prod, JTextField dinero, JTextField cant, JComboBox tipo) {

        ConexionBD con = new ConexionBD();

        String query = "INSERT INTO productos (nombre, precio) VALUES(?,?);";
        String query2 = "INSERT INTO movimientos (producto, cantidad, tipo) VALUES(?,?,?);";


        try {

            CallableStatement cs = con.conectando().prepareCall(query);
            cs.setString(1, prod.getText());
            cs.setString(2, dinero.getText());
            cs.execute();

            CallableStatement cs2 = con.conectando().prepareCall(query2);
            cs2.setString(1, prod.getText());
            cs2.setString(2, cant.getText());
            cs2.setString(3, (String) tipo.getSelectedItem());
            cs2.execute();

            JOptionPane.showMessageDialog(null, "Se guardo correctamente el Nuevo Producto");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el Nuevo Producto, Error: " + e.toString());
        }

    }

    public void mostrarProductos(JTable tabla) {

        ConexionBD conn = new ConexionBD();

        DefaultTableModel modelo = new DefaultTableModel();

        String SQL = "";

        modelo.addColumn("ID");
        modelo.addColumn("Producto");
        modelo.addColumn("Precio");

        tabla.setModel(modelo);

        SQL = "SELECT * FROM productos;";


        String[] datos = new String[3];

        Statement st;

        try {
            st = conn.conectando().createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);

                modelo.addRow(datos);

            }

            tabla.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se mostraron los registros, error: " + e.toString());
        }
    }

    public void seleccionarProd(JTextField producto, JTextField precio, JTable tabla, JTextField id ) {

        try {

            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                id.setText(tabla.getValueAt(fila, 0).toString());
                producto.setText(tabla.getValueAt(fila, 1).toString());
                precio.setText(tabla.getValueAt(fila, 2).toString());

            } else {

                JOptionPane.showMessageDialog(null, "No se selecciono ningun registro");

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Seleccion, error: " + e.toString());

        }

    }

    public void eliminarProd(JTextField id) {

        ConexionBD con = new ConexionBD();

        String query = "DELETE FROM productos WHERE ID = ?;";

        try {

            CallableStatement cs = con.conectando().prepareCall(query);
            cs.setInt(1, Integer.parseInt(id.getText()));
            cs.execute();

            JOptionPane.showMessageDialog(null, "Se elimino correctamente el Producto seleccionado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar, error: " + e.toString());

        }

    }

    public void modificarProd(JTextField prod, JTextField prec, JTextField id) {
        try {

            ConexionBD con = new ConexionBD();

            String query = "UPDATE productos SET nombre = ?, precio = ? WHERE ID =?";

            CallableStatement cs = con.conectando().prepareCall(query);

            cs.setString(1, prod.getText());
            cs.setString(2, prec.getText());
            cs.setInt(3, Integer.parseInt(id.getText()));

            cs.execute();

            JOptionPane.showMessageDialog(null, "Se modifico correctamente el Producto");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al modificar, error: " + e.toString());

        }

    }


}
