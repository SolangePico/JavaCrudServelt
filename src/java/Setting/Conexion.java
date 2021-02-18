/*
 * El siguiente programa coorresponde a un ejercicio práctico enviado 
 * por la empresa AltioraCorp. 
 * Todo su uso es privado. 
 */
package Setting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Solange Pico 
 */
public class Conexion {

    Connection connection;
    String url = "jdbc:mysql://localhost:3306/altiorapicosolange?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String user = "root";
    String password = "";

    public Connection Conexion() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Conexión a base de datos funcionando");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectarse con la base de datos." + e);
        } catch (ClassNotFoundException e) 
        {
            System.out.println(e);               
        }
        return connection;
    }
}
