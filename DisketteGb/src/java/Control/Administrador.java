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
public class Administrador{
    
    public static int registrarUsuario(Usuario e){
        int estatus = 0;
        try{
            Connection con = Conexion.getConexion();
            String q = "INSERT INTO `diskettegb`.`usuario` (`nom_usu`, `con_usu`, `cor_usu`)"
                    + "values(?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getPassword());
            ps.setString(3, e.getCorreo());
            
            estatus = ps.executeUpdate();
          
            System.out.println("Usuario Registrado");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al registar");
            System.out.println(ed.getMessage());
        
        }
        return estatus;
        
    }
    
    public static int borrarUsuario(int id){
        int estatus=0;
        
        try{
            Connection con = Conexion.getConexion();
            String q = "delete from usuario where id_usu = ?"
                    + "delete from asignacion where id_usu = ?";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, id);
            ps.setInt(2, id);
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminacion del usuario exitoso");
            con.close();
        }catch(Exception ed){
            System.out.println("Error, usuario no encontrado");
            System.out.println(ed.getMessage());
        }
    return estatus;
    }
    
    
    //Resultado de la consulta de los usuarios:
    /*
        | id_usu | nom_usu | id_asig | id_blo | nom_blo | id_act_blo | nom_act | dif_dif |
    */
    //necesita arreglarse para obtener los datos a mostrar en la consulta de 
    //usuarios, los bloques con sus actividades y progresos correspondientes
    //desde el administrador
    public static List<Usuario> getAllUsuarios(){
        List<Usuario> lista = new ArrayList<Usuario>();
        try{
            Connection con = Conexion.getConexion();
            String q = "select usuario.id_usu ,nom_usu, id_asig,  bloques.id_blo ,nom_blo, id_act_blo, nom_act, dif_dif\n" +
                        "from diskettegb.asignacion\n" +
                        "inner join diskettegb.usuario on diskettegb.usuario.id_usu = diskettegb.asignacion.id_usu\n" +
                        "inner join diskettegb.bloques on diskettegb.bloques.id_blo = diskettegb.asignacion.id_blo\n" +
                        "inner join diskettegb.act_blo on diskettegb.act_blo.id_blo = diskettegb.bloques.id_blo\n" +
                        "inner join (diskettegb.act_dif \n" +
                        "inner join diskettegb.actividades on diskettegb.actividades.id_act = diskettegb.act_dif.id_act\n" +
                        "inner join diskettegb.dificultades on diskettegb.dificultades.id_dif = diskettegb.act_dif.id_dif)\n" +
                        "on diskettegb.act_dif.id_act_dif = diskettegb.act_blo.id_act_dif";
            
            PreparedStatement ps = con.prepareStatement(q);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario e = new Usuario();
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setPassword(rs.getString(3));
                e.setCorreo(rs.getString(4));
                lista.add(e);
            }
            System.out.println("Se encontro a los usuarios");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al consultar la tabla");
            System.out.println(ed.getMessage());
        
        }
        return lista;
        
    }
    
}
