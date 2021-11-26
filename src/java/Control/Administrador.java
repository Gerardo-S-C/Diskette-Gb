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

import static Control.Conexion.getConexion;
import Modelo.Actividades;
import Modelo.Bloques;
import Modelo.Usuario;
import Modelo.UsuarioConsulta;
import java.sql.*;
import java.util.*;
public class Administrador{
    
    public static int registrarUsuario(Usuario e){
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            Connection con = Conexion.getConexion();
                String q = "INSERT ignore INTO `usuario` (`nom_usu`, `con_usu`, `cor_usu`)"
                        + "values(?,?,?)";
                
                ps = con.prepareStatement(q);
                
                ps.setString(1, e.getNombre());
                ps.setString(2, e.getPassword());
                ps.setString(3, e.getCorreo());
                
                estatus = ps.executeUpdate();
                String q3 = "SET foreign_key_checks = 1;";
                ps= con.prepareStatement(q3);
                rs=ps.executeQuery();
                String q4 = "SET sql_safe_updates=1;";
                ps= con.prepareStatement(q4);
                rs=ps.executeQuery();
                System.out.println("Usuario Registrado");

            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public static int borrarUsuariotablaUsuario(int id){
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        
        try{
            Connection con = Conexion.getConexion();
            String q1 = "SET foreign_key_checks = 0;";
            ps= con.prepareStatement(q1);
            rs=ps.executeQuery();
            String q2 = "SET sql_safe_updates=0;";
            ps= con.prepareStatement(q2);
            rs=ps.executeQuery();
            String q = "delete from usuario where id_usu= ?";
            
            ps = con.prepareStatement(q);
            
            ps.setInt(1, id);

            estatus = ps.executeUpdate();
            String q3 = "SET foreign_key_checks = 1;";
            ps= con.prepareStatement(q3);
            rs=ps.executeQuery();
            String q4 = "SET sql_safe_updates=1;";
            ps= con.prepareStatement(q4);
            rs=ps.executeQuery();
            System.out.println("Eliminacion del usuario exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error, usuario no encontrado");
            System.out.println(ed.getMessage());
        }
    return estatus;
    }
    
    public static int borrarUsuariotablaAsignacion(int id){
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
              
        try{
            Connection con = Conexion.getConexion();
            String q1 = "SET foreign_key_checks = 0;";
            ps= con.prepareStatement(q1);
            rs=ps.executeQuery();
            String q2 = "SET sql_safe_updates=0;";
            ps= con.prepareStatement(q2);
            rs=ps.executeQuery();
            String q = "delete from asignacion where id_usu= ?";
            ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
          
            estatus = ps.executeUpdate();
            String q3 = "SET foreign_key_checks = 1;";
            ps= con.prepareStatement(q3);
            rs=ps.executeQuery();
            String q4 = "SET sql_safe_updates=1;";
            ps= con.prepareStatement(q4);
            rs=ps.executeQuery();
            System.out.println("Eliminacion del usuario exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error, usuario no encontrado");
            System.out.println(ed.getMessage());
        }
    return estatus;
    }
    public static int borrarUsuariotablaConsulta(String nom){
        int estatus=0;
        
        try{
            Connection con = Conexion.getConexion();
            String q =  "delete from consultas where nom_usu= ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, nom);
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminacion del usuario exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error, usuario no encontrado");
            System.out.println(ed.getMessage());
        }
    return estatus;
    }
    public boolean inicioSesion(String correo, String pass){
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String consulta="select * from administrador where nom_adm = ? and con_adm = ?";
            ps=getConexion().prepareStatement(consulta);
            ps.setString(1, correo);
            ps.setString(2, pass);
            
            rs=ps.executeQuery();
            
            Usuario usu = null;
            
            if(rs.next()){
                usu = new Usuario();
                usu.setNombre(rs.getString("nom_adm"));
                usu.setCorreo(correo);
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
    public String getAdminName(String name) throws SQLException{
        String sql = "SELECT * FROM administrador WHERE nom_adm=?";
        PreparedStatement ps = getConexion().prepareStatement(sql);
        ps.setString(1, name);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            return rs.getString("nom_adm");
        }

        return null;
    }
    
    
    //Resultado de la consulta de los usuarios:
    /*
        | id_usu | nom_usu | nom_blo | nom_act | dif_dif | pro_dif | id_asig | id_act_blo |
    */
    //necesita arreglarse para obtener los datos a mostrar en la consulta de 
    //usuarios, los bloques con sus actividades y progresos correspondientes
    //desde el administrador
    public static List<Usuario> getAllUsuarios() throws SQLException{
        List<Usuario> listaUsu = new ArrayList<Usuario>();
        //List<UsuarioConsulta> listCon = new ArrayList<UsuarioConsulta>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        
        try{
            String q1 = "select * from usuario";
            ps = getConexion().prepareStatement(q1);
            rs = ps.executeQuery();
            while(rs.next()){
                
                Usuario usu = new Usuario();
                usu.setId(rs.getInt(1));
                usu.setNombre(rs.getString(2));
                listaUsu.add(usu);
                
            }
            System.out.println("Exito");
        }catch(Exception e){
            System.out.println("Error al buscar");
        }
        
    return listaUsu;
    }
    //Esta es para la parte de actividades del administrador
    //solo mostrará lo que hay asignado, aun no se moveran de lugar
    //las actividades ni bloques ni dificultades, solo será visual
    public static List<Bloques> getBloques() throws SQLException{
        List<Bloques> listblo = new ArrayList<Bloques>();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String q = "SELECT nom_blo, nom_act, dif_dif FROM bloques\n" +
                        "inner join act_blo on act_blo.id_blo = bloques.id_blo\n" +
                        "inner join act_dif on act_dif.id_act_dif = act_blo.id_act_dif\n" +
                        "inner join actividades on actividades.id_act = act_dif.id_act\n" +
                        "inner join dificultades on dificultades.id_dif = act_dif.id_dif";
            ps = getConexion().prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Bloques blo = new Bloques ();
                blo.setNom_blo(rs.getString(1));
                blo.setNom_act(rs.getString(2));
                blo.setDif_dif(rs.getString(3));
                listblo.add(blo);
            }
            System.out.println("Bloques consultados");
        }catch(Exception e){
            System.out.println("Error al consultar bloques");
        }
        return listblo;
    }
}
