package varios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    /*public static void main(String[] args) {
        ConexionBD CBD = new ConexionBD();
        CBD.conectando();
    }*/

    public Connection conectando() {

        Connection conectar = null;
        String usuario = "root";
        String password = "111213";
        String urlConexion = "jdbc:mysql://localhost:3306/desarrollo2";

        try {
            System.out.println("Conectando... -_-");
            conectar = DriverManager.getConnection(urlConexion, usuario, password);
            System.out.println("Conectado. :D");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return conectar;
    }
}
