/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author elelt
 */
public class cn {

    Connection conexion;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/dbestudiantes", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexión con la base de datos", "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
}
