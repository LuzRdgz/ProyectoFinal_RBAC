package datos;

import varios.ConexionBD;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;

public class implementar_Movimientos {

    public void mostrarMovs(JTable tabla) {

        ConexionBD conn = new ConexionBD();

        DefaultTableModel modelo = new DefaultTableModel();

        String SQL = "";

        modelo.addColumn("ID");
        modelo.addColumn("Producto");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Tipo");

        tabla.setModel(modelo);

        SQL = "SELECT * FROM movimientos;";


        String[] datos = new String[4];

        Statement st;

        try {
            st = conn.conectando().createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);

            }

            tabla.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se mostraron los registros, error: " + e.toString());
        }
    }

}
