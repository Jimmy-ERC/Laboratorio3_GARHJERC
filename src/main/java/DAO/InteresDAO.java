/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.cn;
import Entidades.Interes;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jimmy
 */
public class InteresDAO {
    private cn CN;

    public InteresDAO() {
        CN = new cn();
    }
    
    public ArrayList consultarIntereses(int IDUsuario) {
        ArrayList<Interes> listadoIntereses = new ArrayList<>();
        String sSQL = "CALL sp_consultar_intereses(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);

            cs.setInt(1, IDUsuario);
            
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                Interes interes = new Interes(
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
    
    public void insertarInteres(Interes intereses) {
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
    
    public ArrayList consultarInteresadosPorFecha(int IDCarrera){
        ArrayList<Interes> listadoDeInteresesPorFecha = new ArrayList<>();
        String sSQL = "CALL sp_consultar_interesados_por_fecha(?)";

        try{
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);

            cs.setInt(1, IDCarrera);

            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                Interes interes = new Interes(
                        rs.getInt("cantidad_interesados"),
                        rs.getDate("fecha_seleccion")
                );

                listadoDeInteresesPorFecha.add(interes);
            }

            return listadoDeInteresesPorFecha;         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
        
        return listadoDeInteresesPorFecha;
    }
    
    public ArrayList consultarCantidadInteresados() {
        ArrayList<Interes> listadoCantidadIntereses = new ArrayList<>();
        String sSQL = "CALL sp_consultar_cantidad_interesados()";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                Interes interes = new Interes(
                        rs.getInt("cantidad"),
                        rs.getString("nombre_carrera")                        
                );

                listadoCantidadIntereses.add(interes);
            }

            return listadoCantidadIntereses;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listadoCantidadIntereses;
    }
    
    public ArrayList consultarLas15CarrerasConMasInteresados() {
        ArrayList<Interes> listadoCantidadIntereses = new ArrayList<>();
        String sSQL = "CALL sp_consultar_las_15_carreras_mas_interesantes()";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                Interes interes = new Interes(
                        rs.getInt("idcarrera"),
                        rs.getInt("cantidad_interesados"),
                        rs.getString("nombre_carrera")                        
                );

                listadoCantidadIntereses.add(interes);
            }

            return listadoCantidadIntereses;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listadoCantidadIntereses;
    }
}
