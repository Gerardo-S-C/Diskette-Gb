/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author illum
 */
import Modelo.Usuario;
import java.sql.*;
import java.util.*;

public class accionesUsu extends Conexion{
    
    public boolean inicioSesion(String correo, String pass){
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String consulta="select * from usuario where cor_usu = ? and con_usu = ?";
            ps=getConexion().prepareStatement(consulta);
            ps.setString(1, correo);
            ps.setString(2, pass);
            
            rs=ps.executeQuery();
            
            Usuario usu = null;
            
            if(rs.next()){
                usu = new Usuario();
                usu.setNombre(rs.getString("nom_usu"));
                usu.setCorreo(correo);
            }
            
            while(rs.next()){
                int id_usu = rs.getInt(1);
                //System.out.println(id_usu);
                //Asigna los bloques y actividades al usuario si es nuevo
                //Si no lo es, pasa por alto este parametro
                String p = "INSERT INTO asignacion (`id_usu`, `id_blo`) "
                        + "VALUES (?, '1'),(?, '2')";
                ps=getConexion().prepareStatement(p);
                ps.setInt(1, id_usu);
                ps.setInt(2, id_usu);
                estatus=ps.executeUpdate();
            }
            if(rs.absolute(1)){
                return true;
            }
            
            
        }catch(Exception e){
            System.out.println("Error al consultar la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(ps != null) ps.close();
                if(rs != null) rs.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
        }
        
        return false;
    }
    public String getNameByEmail(String email) throws SQLException{
        String sql = "SELECT * FROM usuario WHERE cor_usu=?";
        PreparedStatement ps = getConexion().prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            return rs.getString("nom_usu");
        }

        return null;
    }
    
    public static List<Usuario> consultaGral(){
        List<Usuario> lista = new ArrayList<Usuario>();
        try{
            Connection con = Conexion.getConexion();
            String q = "SELECT * FROM usuario";
            //DELETE FROM `diskettegb`.`usuario` WHERE (`id_usu` = '2');
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
//            while (rs.next()){
//                Usuario u = new Usuario ();
//                u.setNombre(rs.getString("nom_usu"));
//            }
            
        }catch(Exception ed){
            
        }
        return lista;
    }
    
}
