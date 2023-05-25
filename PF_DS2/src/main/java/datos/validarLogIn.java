package datos;

import pantallas.*;
import varios.ConexionBD;
import javax.swing.*;
import java.sql.*;
import pantallas.Menu;

public class validarLogIn {


    public void validar(JTextField user, JPasswordField pass) {

        String permisoUser;

        try {
            ResultSet rs = null;
            PreparedStatement ps = null;
            ConexionBD conn = new ConexionBD();

            String query = "SELECT * FROM usuarios u WHERE u.`user` = ? AND u.`password` = ? ;";
            ps = conn.conectando().prepareStatement(query);

            String pw = String.valueOf(pass.getPassword());

            ps.setString(1, user.getText());
            ps.setString(2, pw);
            rs = ps.executeQuery();

            if (rs.next()){

                if (user!= null && pass != null){

                    permisoUser = rs.getString("permiso");

                    switch (permisoUser){

                        case "Administrador":
                            JOptionPane.showMessageDialog(null, "Ingresando al sistema en modo ADMINISTRADOR");
                            Menu menu = new Menu();
                            menu.setVisible(true);
                            break;
                        case "Edición":
                            JOptionPane.showMessageDialog(null, "Ingresando al sistema en modo EDICIÓN");
                            ProductosED ED = new ProductosED();
                            ED.setVisible(true);
                            break;
                        case "Solo lectura":
                            JOptionPane.showMessageDialog(null, "Ingresando al sistema en modo SOLO LECTURA");
                            MovimientosSL SL = new MovimientosSL();
                            SL.setVisible(true);
                            break;
                    }
                }

            }else{
                JOptionPane.showMessageDialog(null,"El usuario o contraseña es incorrecto. Vuelva a intentar");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }
    }
}

