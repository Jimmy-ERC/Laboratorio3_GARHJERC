/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.cn;
import Entidades.Carrera;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author jimmy
 */
public class CarreraDAO {
    private cn CN;

    public CarreraDAO() {
        CN = new cn();
    }
    
    public ArrayList consultarCarreras() {
        ArrayList<Carrera> listadoCarreras = new ArrayList<>();
        String sSQL = "CALL sp_consultar_carreras()";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Carrera usuario = new Carrera(
                        rs.getInt("idcarrera"),
                        rs.getString("nombre_carrera"),
                        rs.getString("descripcion")
                );

                listadoCarreras.add(usuario);
            }

            return listadoCarreras;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        }

        return listadoCarreras;
    }
    
    public void insertarCarrera(Carrera carrera) {
        String sSQL = "CALL sp_insertar_carrera(?, ?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setString(1, carrera.getNombreCarrera());
            cs.setString(2, carrera.getDescripcion());

            cs.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "La carrera se ha INSERTADO correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarCarrera(Carrera carrera) {
        String sSQL = "CALL sp_actualizar_carrera(?, ?, ?)";

        try{
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            
            cs.setInt(1, carrera.getIDCarrera());
            cs.setString(2, carrera.getNombreCarrera());
            cs.setString(3, carrera.getDescripcion());

            cs.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "La carrera se ha EDITADO correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminarCarrera(int IDCarrera) {
        String sSQL = "CALL sp_eliminar_carrera(?)";

        try{
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);

            cs.setInt(1, IDCarrera);

            cs.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "La carrera se ha ELIMINADO correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList buscarCarreras(String nombreCarrera) {
        ArrayList<Carrera> listadoCarreras = new ArrayList<>();
        String sSQL = "CALL sp_buscar_carreras(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);

            cs.setString(1, nombreCarrera);
            
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                Carrera carrera = new Carrera(
                        rs.getInt("idcarrera"),
                        rs.getString("nombre_carrera"),
                        rs.getString("descripcion")
                );

                listadoCarreras.add(carrera);
            }

            return listadoCarreras;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listadoCarreras;
    }
}
