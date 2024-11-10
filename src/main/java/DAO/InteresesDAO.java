/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.cn;
import Entidades.Intereses;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author jimmy
 */
public class InteresesDAO {
    private cn CN;

    public InteresesDAO() {
        CN = new cn();
    }
    
    public void insertarInteres(Intereses intereses) {
        String sSQL = "CALL sp_insertar_interes(?, ?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, intereses.getIDCarrera());
            cs.setInt(2, intereses.getIDUsuario());

            cs.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Su interes se ha AÑADIDO correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
