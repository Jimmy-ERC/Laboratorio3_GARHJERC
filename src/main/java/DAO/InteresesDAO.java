/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.cn;
import Entidades.Intereses;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
    
    public ArrayList consultarIntereses(int IDUsuario) {
        ArrayList<Intereses> listadoIntereses = new ArrayList<>();
        String sSQL = "CALL sp_consultar_intereses(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);

            cs.setInt(1, IDUsuario);
            
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                Intereses interes = new Intereses(
                        rs.getInt("idinteres"),
                        rs.getString("nombre_carrera"),
                        rs.getString("descripcion")
                );

                listadoIntereses.add(interes);
            }

            return listadoIntereses;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listadoIntereses;
    }
    
    public void insertarInteres(Intereses intereses) {
        String sSQL = "CALL sp_insertar_interes(?, ?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setInt(1, intereses.getIDUsuario());
            cs.setInt(2, intereses.getIDCarrera());

            cs.executeUpdate();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarInteres(int IDInteres) {
        String sSQL = "CALL sp_eliminar_interes(?)";

        try{
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);

            cs.setInt(1, IDInteres);

            cs.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El interes se ha ELIMINADO correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
