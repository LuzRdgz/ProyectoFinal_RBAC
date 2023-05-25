package datos;

import varios.ConexionBD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class implementar_Usuarios {

    public void guardarUser(JTextField user, JPasswordField pass, JComboBox perm) {

        ConexionBD con = new ConexionBD();

        String query = "INSERT INTO usuarios (user, password, permiso) VALUES(?,?,?);";

        try {

            CallableStatement cs = con.conectando().prepareCall(query);
            cs.setString(1, user.getText());
            cs.setString(2, pass.getText());
            cs.setString(3, (String) perm.getSelectedItem());

            cs.execute();

            JOptionPane.showMessageDialog(null, "Se guardo correctamente el Nuevo Usuario");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el Nuevo Usuario, Error: " + e.toString());
        }

    }

    public void mostrarUsers(JTable tabla) {

        ConexionBD conn = new ConexionBD();

        DefaultTableModel modelo = new DefaultTableModel();

        String SQL = "";

        modelo.addColumn("ID");
        modelo.addColumn("Usuario");
        modelo.addColumn("Permiso");

        tabla.setModel(modelo);

        SQL = "SELECT id, user, permiso FROM usuarios;";


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

    public void seleccionarUser(JTextField id, JTable tabla ) {

        try {

            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                id.setText(tabla.getValueAt(fila, 0).toString());


            } else {

                JOptionPane.showMessageDialog(null, "No se selecciono ningun registro");

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error de Seleccion, error: " + e.toString());

        }

    }

    public void eliminarUser(JTextField id) {

        ConexionBD con = new ConexionBD();

        String query = "DELETE FROM usuarios WHERE ID = ?;";

        try {

            CallableStatement cs = con.conectando().prepareCall(query);
            cs.setInt(1, Integer.parseInt(id.getText()));
            cs.execute();

            JOptionPane.showMessageDialog(null, "Se elimino correctamente el Producto seleccionado");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar, error: " + e.toString());

        }

    }

}
