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
import Modelo.UsuarioConsulta;
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
            
            while(rs.next()){
                int id_usu = rs.getInt(1);
                System.out.println(id_usu);
                //Asigna los bloques y actividades al usuario si es nuevo
                //Si no lo es, pasa por alto este parametro
                String p = "INSERT INTO asignacion (`id_usu`, `id_blo`) "
                        + "VALUES (?, '1'),(?, '2');";
                ps=getConexion().prepareStatement(p);
                ps.setInt(1, id_usu);
                ps.setInt(2, id_usu);
                estatus=ps.executeUpdate();
//                System.out.println(estatus);
            }
            if(rs.next()){
                usu = new Usuario();
                usu.setNombre(rs.getString("nom_usu"));
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
    
    public String AsignarSimulaciones () throws SQLException{
        String q ="insert into consultas (nom_usu, nom_blo, nom_act, dif_dif, pro_dif, id_asig, id_act_blo)\n" +
                "select nom_usu, nom_blo, nom_act, dif_dif, pro_dif, id_asig, id_act_blo\n" +
                "from asignacion\n" +
                "inner join usuario on usuario.id_usu = asignacion.id_usu\n" +
                "inner join bloques on bloques.id_blo = asignacion.id_blo\n" +
                "inner join act_blo on act_blo.id_blo = bloques.id_blo\n" +
                "inner join (act_dif \n" +
                "inner join actividades on actividades.id_act = act_dif.id_act\n" +
                "inner join dificultades on dificultades.id_dif = act_dif.id_dif)\n" +
                "on act_dif.id_act_dif = act_blo.id_act_dif\n" +
                "\n" +
                "\n" +
                "where not exists (select nom_usu, nom_blo, nom_act, id_asig, id_act_blo\n" +
                "from consultas where usuario.nom_usu = consultas.nom_usu \n" +
                "AND bloques.nom_blo = consultas.nom_blo \n" +
                "AND actividades.nom_act = consultas.nom_act);";
        PreparedStatement ps = getConexion().prepareStatement(q);
        int estatus = ps.executeUpdate();
        
        return null;
    }
    
    public static UsuarioConsulta buscarUsuAsigProm(String nombre) throws SQLException{
        UsuarioConsulta usu = new UsuarioConsulta();
        
        try{
            Connection con = Conexion.getConexion();
            String q = "SELECT *, AVG(pro_dif) FROM consultas \n" +
                       "where nom_usu = ? and nom_blo = 'Estafas' and nom_act = 'phishing';";
            PreparedStatement ps = getConexion().prepareStatement(q);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                usu.setId(rs.getInt(1));
                usu.setNom_usu(rs.getString(2));
                usu.setDif_dif(rs.getString(5));
                usu.setPro_dif_dif1(rs.getString(6));
                usu.setPro_dif(rs.getString(9));
            }
            System.out.println("Usuario asignado, encontrado");
            con.close(); 
        }catch(Exception ed){
            System.out.println("Error al buscar al usuario asignado");
            System.out.println(ed.getMessage());
        }
        return usu;
    }
    public static UsuarioConsulta buscarUsuDif_dificil(String nombre) throws SQLException{
        UsuarioConsulta usu = new UsuarioConsulta();
        
        try{
            Connection con = Conexion.getConexion();
            String q = "SELECT * FROM consultas \n" +
                       "where nom_usu = ? and nom_blo = 'Estafas' and nom_act = 'phishing' and dif_dif = 'dificil';";
            PreparedStatement ps = getConexion().prepareStatement(q);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                usu.setPro_dif_dif2(rs.getString(6));
            }
            System.out.println("Usuario asignado, encontrado");
            con.close(); 
        }catch(Exception ed){
            System.out.println("Error al buscar al usuario asignado");
            System.out.println(ed.getMessage());
        }
        return usu;
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
