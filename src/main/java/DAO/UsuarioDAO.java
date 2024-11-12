/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DB.cn;
import Entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jimmy
 */
public class UsuarioDAO {
    private cn CN;

    public UsuarioDAO() {
        CN = new cn();
    }

    public ArrayList consultarUsuarios() {
        ArrayList<Usuario> listadoUsuarios = new ArrayList<>();
        String sSQL = "CALL sp_consultar_usuarios()";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("idusuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getInt("edad"),
                        rs.getString("region"),
                        rs.getString("rol"),
                        rs.getString("usuario"),
                        rs.getString("contraseña")
                );

                listadoUsuarios.add(usuario);
            }

            return listadoUsuarios;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        }

        return listadoUsuarios;
    }

    public void insertarUsuario(Usuario usuario) {
        String sSQL = "CALL sp_insertar_usuario(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            cs.setString(1, usuario.getNombre());
            cs.setString(2, usuario.getApellido());
            cs.setString(3, usuario.getEmail());
            cs.setInt(4, usuario.getEdad());
            cs.setString(5, usuario.getRegion());
            cs.setString(6, usuario.getRol());
            cs.setString(7, usuario.getUsuario());
            cs.setString(8, usuario.getContraseña());

            cs.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El usuario se ha INSERTADO correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean editarUsuario(Usuario usuario) {
        String sSQL = "CALL sp_actualizar_usuario(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            
            cs.setInt(1, usuario.getIDUsuario());
            cs.setString(2, usuario.getNombre());
            cs.setString(3, usuario.getApellido());
            cs.setString(4, usuario.getEmail());
            cs.setInt(5, usuario.getEdad());
            cs.setString(6, usuario.getRegion());
            cs.setString(7, usuario.getRol());            
            cs.setString(8, usuario.getUsuario());
            cs.setString(9, usuario.getContraseña());

            cs.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El usuario se ha EDITADO correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }
    
    public void eliminarUsuario(int IDUsuario) {
        String sSQL = "CALL sp_eliminar_usuario(?)";

        try{
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);

            cs.setInt(1, IDUsuario);

            cs.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "El usuario se ha ELIMINADO correctamente", "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList buscarUsuarios(String nombreUsuario) {
        ArrayList<Usuario> listadoUsuarios = new ArrayList<>();
        String sSQL = "CALL sp_buscar_usuarios(?)";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);

            cs.setString(1, nombreUsuario);
            
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("idusuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getInt("edad"),
                        rs.getString("region"),
                        rs.getString("rol"),
                        rs.getString("usuario"),
                        rs.getString("contraseña")
                );

                listadoUsuarios.add(usuario);
            }

            return listadoUsuarios;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return listadoUsuarios;
    }
    
    public Usuario iniciarSesion(String usuario, String contraseña) {
        Usuario usuarioEncontrado = new Usuario();
        String sSQL = "CALL sp_login(?, ?)";

        usuarioEncontrado.setRol("");
        
        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);

            cs.setString(1, usuario);
            cs.setString(2, contraseña);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                usuarioEncontrado = new Usuario(
                        rs.getInt("idusuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getInt("edad"),
                        rs.getString("region"),
                        rs.getString("rol"),
                        rs.getString("usuario"),
                        rs.getString("contraseña")
                );
            }

            return usuarioEncontrado;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡¡ERROR!!", JOptionPane.ERROR_MESSAGE);
        }

        return usuarioEncontrado;
    }
    
    public int obtenerUltimoIDUsuario(){
        int IDUsuario = 0;        
        String sSQL = "CALL sp_consultar_usuarios()";

        try {
            CallableStatement cs = CN.getConexion().prepareCall(sSQL);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                IDUsuario = rs.getInt("idusuario");
            }

            return IDUsuario;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        }      
        
        return IDUsuario;
    }
}
