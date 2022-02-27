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
import Modelo.*;
import java.sql.*;
import java.util.*;
public class Administrador{
    //Inicio de sesion exclusivo del administrador
    public boolean inicioSesion(String correo, String pass){
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            //query para comparar datos del form con la BD
            String consulta="select * from administrador where nom_adm = ? and con_adm = ?";
            ps=con.prepareStatement(consulta);
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
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Admin login)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Admin login)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Admin login)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return false;
    }
    
    //Registra a cualquier usuario nuevo en el sistema
    public static int registrarUsuario(Usuario e){
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            //inserta al usuario nuevo en la BD
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
        }catch(Exception ed){
            System.out.println("Error al registar");
            System.out.println(ed.getMessage());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (User register)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (User register)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (User register)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return estatus;
        
    }
    //Borra a cualquier usuario del sistema
    public static int borrarUsuariotablaUsuario(int id){
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
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
        }catch(Exception ed){
            System.out.println("Error, usuario no encontrado");
            System.out.println(ed.getMessage());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (User del TBUsu)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (User del TBUsu)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (User del TBUsu)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
    return estatus;
    }
    //Borra las asignaciones del usuario borrado
    public static int borrarUsuariotablaAsignacion(int id){
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;  
        try{
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
            System.out.println("Eliminacion de sus asignaciones exitoso");
        }catch(Exception ed){
            System.out.println("Error, usuario no encontrado");
            System.out.println(ed.getMessage());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (User del TBAsig)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (User del TBAsig)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (User del TBAsig)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
    return estatus;
    }
    //Borra la asignacion de todas las actividades para consulta del sistema
    public static int borrarUsuariotablaConsulta(String nom){
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        int estatus=0;
        try{
            String q =  "delete from consultas where nom_usu= ?";
            ps = con.prepareStatement(q);
            ps.setString(1, nom);
            
            estatus = ps.executeUpdate();
            System.out.println("Eliminacion de las consultas exitoso");
        }catch(Exception ed){
            System.out.println("Error, usuario no encontrado");
            System.out.println(ed.getMessage());
        }finally{
            try{
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (User del TBConsulta)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (User del TBConsulta)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
    return estatus;
    }
    
    //Obtiene en correo del administrador para asignar la sesion
    public String getAdminName(String name) throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM administrador WHERE nom_adm=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            System.out.println("Admin: "+name+" encontrado");
            
            if(rs.next()){
                return rs.getString("nom_adm");
            }
            
        }catch(Exception ed){
            System.out.println("Error al registar");
            System.out.println(ed.getMessage());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Admin log name)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Admin log name)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Admin log name)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
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
        Connection con=null;
        int estatus = 0;
        try{
            con = Conexion.getConexion();
            String q1 = "select * from usuario";
            ps = con.prepareStatement(q1);
            rs = ps.executeQuery();
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setId(rs.getInt(1));
                usu.setNombre(rs.getString(2));
                listaUsu.add(usu);
                System.out.println("Exito en la consulta de "+usu.getNombre());
            }
            System.out.println("Exito en la consulta de los usuarios");
        }catch(Exception e){
            System.out.println("Error al buscar");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Consulta USU)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Consulta USU)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Consulta USU)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        
    return listaUsu;
    }
    

    //Esta es para la parte de actividades del administrador
    //solo mostrará lo que hay asignado, aun no se moveran de lugar
    //las actividades ni bloques ni dificultades, solo será visual
    public static List<Bloques> getBloques() throws SQLException{
        List<Bloques> listblo = new ArrayList<Bloques>();
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String q = "SELECT nom_blo, nom_act, dif_dif FROM bloques\n" +
                        "inner join act_blo on act_blo.id_blo = bloques.id_blo\n" +
                        "inner join act_dif on act_dif.id_act_dif = act_blo.id_act_dif\n" +
                        "inner join actividades on actividades.id_act = act_dif.id_act\n" +
                        "inner join dificultades on dificultades.id_dif = act_dif.id_dif";
            ps = con.prepareStatement(q);
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
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Consulta BLO)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Consulta BLO)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Consulta BLO)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return listblo;
    }
    
    
    //Este ultimo metodo esta incompletos, aun no se les asigna un uso real//
    /*--------------------------------------------------------------------------*/
    //Estos metodos son un conjunto individual de las tablas para consultar sus datos y poder moverlos
    //desde el administrador (Varios son de prueba para verificar que el sistema funcione como debe)
    /*[Bloques][Actividades][Dificultades](con los siguientes datos)
    Bloques : {1}[Estafas]{2}[Virus]
    Actividades : {1}[phishing]{2}[spamming]{3}[.exe]
    Dificultades : {1}[facil]{2}[dificil]*/
    
    public static List<Bloques> ConsBloques() throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        List<Bloques> lista = new ArrayList<Bloques>();
            try{
                String q = "SELECT * FROM bloques";
                ps = con.prepareStatement(q);
                rs = ps.executeQuery();
                while(rs.next()){
                    Bloques blo = new Bloques();
                    blo.setId_blo(rs.getInt(1));
                    blo.setNom_blo(rs.getString(2));
                    lista.add(blo);
            }
            System.out.println("Actividades consultadas correctamente");
        }catch(Exception e){
            System.out.println("Error al buscar y asignar");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Consulta BLOGEN)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Consulta BLOGEN)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Consulta BLOGEN)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return lista;
    }
    
    //Metodos para pura consulta (Mostrar en admin y usuario los datos desde la BD)
    public static List<Actividades> ConsActividades() throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        List<Actividades> lista = new ArrayList<Actividades>();
        try{
            String q = "SELECT * FROM actividades";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while(rs.next()){
                Actividades act = new Actividades();
                act.setId_act(rs.getInt(1));
                act.setNom_act(rs.getString(2));
                lista.add(act);
            }
            System.out.println("Actividades consultadas correctamente");
        }catch(Exception e){
            System.out.println("Error al buscar y asignar");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Consulta ACTGEN)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Consulta ACTGEN)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Consulta ACTGEN)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return lista;
    }
    
    
    public static List<Dificultades> ConsDificultadess() throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        List<Dificultades> lista = new ArrayList<Dificultades>();
            try{
                String q = "SELECT * FROM dificultades";
                ps = con.prepareStatement(q);
                rs = ps.executeQuery();
                while(rs.next()){
                    Dificultades dif = new Dificultades();
                    dif.setId_dif(rs.getInt(1));
                    dif.setDif_dif(rs.getString(3));
                    lista.add(dif);
            }
            System.out.println("Dificultades consultadas correctamente");
        }catch(Exception e){
            System.out.println("Error al buscar y asignar");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Consulta DIFGEN)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Consulta DIFGEN)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Consulta DIFGEN)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return lista;
    }

    //Regresa las actividades con su respectivo bloque asignandolo a solo una dificultad
    //para evitar duplicados en la consulta
    public static List<Act_Blo> ActividadesXBloque(int bloque) throws SQLException{
        List<Act_Blo> actblo = new ArrayList<Act_Blo>();
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
         String q = "SELECT id_act_blo,act_dif.id_act_dif,bloques.id_blo,nom_act  FROM bloques\n" +
                    "inner join act_blo on act_blo.id_blo = bloques.id_blo\n" +
                    "inner join act_dif on act_dif.id_act_dif = act_blo.id_act_dif\n" +
                    "inner join actividades on actividades.id_act = act_dif.id_act\n" +
                    "inner join dificultades on dificultades.id_dif = act_dif.id_dif\n" +
                    "where bloques.id_blo=? and dificultades.id_dif=1";   
         ps = con.prepareStatement(q);
         ps.setInt(1, bloque);
         rs = ps.executeQuery();
         while(rs.next()){
             Act_Blo info = new Act_Blo();
             info.setId_act_blo(rs.getInt(1));
             info.setId_act_dif(rs.getInt(2));
             info.setId_blo(rs.getInt(3));
             info.setNom_act(rs.getString(4));
             actblo.add(info);
         }
            System.out.println("Select ACTxBLO exitoso");
            
        }catch(Exception e){
            System.out.println("Error al buscar al usuario asignado");
            System.out.println(e.getMessage()); 
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (ACT_BLO)");
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (ACT_BLO)");
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Consulta ACT_BLO)");
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return actblo;
    }
    
    
    //Metodos para cambiar los valores de estas tablas sin alterar la ID de cada
    //una porque se trabaja con PKs y FKs
    //Actualizar la dificultad de una actividad:
    public static Dificultades ActualizarDificultad() throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String q = "UPDATE dificultades SET dif_dif= '' WHERE (id_dif = '')";
            ps = getConexion().prepareStatement(q);
            estatus = ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al actualizar la dificultad");
        }
        return null;
    }
    
    public static void CambioDif(String dif, int id) throws SQLException{
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
        String sql = "UPDATE dificultades SET dif_dif = ? WHERE (id_dif = ?)";
        ps = getConexion().prepareStatement(sql);
        ps.setString(1, dif);
        ps.setInt(2, id);
        estatus = ps.executeUpdate();
        }catch(Exception ed){
            System.out.println("Error al actualizar");
            System.out.println(ed.getMessage());
        }
       
    }
    
}
