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
            String consulta = "Select * from usuario where cor_usu = ?";
            ps=con.prepareStatement(consulta);
            ps.setString(1, e.getCorreo());
            System.out.println(e.getCorreo());
            rs=ps.executeQuery();
            
            while(rs.next()){
                String q = "INSERT INTO `usuario` (`nom_usu`, `con_usu`, `cor_usu`)"
                        + "values(?,?,?)";

                ps = con.prepareStatement(q);

                ps.setString(1, e.getNombre());
                ps.setString(2, e.getPassword());
                ps.setString(3, e.getCorreo());
                
                estatus = ps.executeUpdate();
                
                System.out.println("Usuario Registrado");
                estatus=ps.executeUpdate();
            }

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
            String q = "SET foreign_key_checks = 0;\n" +
                        "delete from asignacion where (id_usu=?);\n" +
                        "delete from usuario where (id_usu=?);\n" +
                        "SET foreign_key_checks = 1;";
            
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
            
//            Datos del inicio de usuario
//                while(rs.next()){
//                int id_usu = rs.getInt(1);
//                String p = "INSERT INTO asignacion (`id_usu`, `id_blo`) "
//                        + "VALUES (?, '1'),(?, '2')";
//                ps=getConexion().prepareStatement(p);
//                ps.setInt(1, id_usu);
//                ps.setInt(2, id_usu);
//                estatus=ps.executeUpdate();
//            }
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
    public static List<UsuarioConsulta> getAllUsuarios(){
        List<UsuarioConsulta> lista = new ArrayList<UsuarioConsulta>();
        try{
            Connection con = Conexion.getConexion();
//            String q = "select usuario.id_usu ,nom_usu, id_asig,  bloques.id_blo ,nom_blo, id_act_blo, nom_act, dif_dif\n" +
//                        "from diskettegb.asignacion\n" +
//                        "inner join diskettegb.usuario on diskettegb.usuario.id_usu = diskettegb.asignacion.id_usu\n" +
//                        "inner join diskettegb.bloques on diskettegb.bloques.id_blo = diskettegb.asignacion.id_blo\n" +
//                        "inner join diskettegb.act_blo on diskettegb.act_blo.id_blo = diskettegb.bloques.id_blo\n" +
//                        "inner join (diskettegb.act_dif \n" +
//                        "inner join diskettegb.actividades on diskettegb.actividades.id_act = diskettegb.act_dif.id_act\n" +
//                        "inner join diskettegb.dificultades on diskettegb.dificultades.id_dif = diskettegb.act_dif.id_dif)\n" +
//                        "on diskettegb.act_dif.id_act_dif = diskettegb.act_blo.id_act_dif";
            
            String q = "select * from consultas";

            PreparedStatement ps = con.prepareStatement(q);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                UsuarioConsulta uc = new UsuarioConsulta();
                uc.setId(rs.getInt(1));
                uc.setNom_usu(rs.getString(2));
                uc.setNom_blo(rs.getString(3));
                uc.setNom_act(rs.getString(4));
                uc.setDif_dif(rs.getString(5));
                uc.setPro_dif(rs.getString(6));
                uc.setId_asig(rs.getInt(7));
                uc.setId_act_blo(rs.getInt(8));
                
//                u.setPassword(rs.getString(3));
//                u.setCorreo(rs.getString(4));
                System.out.println(1+"\n"+2+"\n"+3+"\n"+4+"\n");
                System.out.println(5+"\n"+6+"\n"+7+"\n"+8+"\n");
                lista.add(uc);
            }
            System.out.println("Se encontraron a los usuarios");
            con.close();
        }catch(Exception ed){
            System.out.println("Error al consultar la tabla");
            System.out.println(ed.getMessage());
        
        }
        return lista;
        
    }
    
}
