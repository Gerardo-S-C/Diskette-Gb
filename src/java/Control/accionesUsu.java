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
import Modelo.*;
import java.sql.*;
import java.util.*;

public class accionesUsu extends Conexion{
    //Inicia la sesión del usuario verificando que esté en la BD
    public boolean inicioSesion(String correo, String pass){
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String consulta="select * from usuario where cor_usu = ? and con_usu = ?";
            ps=con.prepareStatement(consulta);
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
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (User login) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (User login) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (User login) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return false;
    }
    
    //Obtiene el nombre del usuario mediante el correo con el que ingresa
    //Y lo asigna como parametro de la sesión
    public String getNameByEmail(String email) throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            String sql = "SELECT * FROM usuario WHERE cor_usu=?";    
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            if(rs.next()){
            return rs.getString("nom_usu");
            }
        }catch(Exception ed){
            System.out.println("Error al registar");
            System.out.println(ed.getMessage());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (User log name) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (User log name) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (User log name) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return null;
    }
    public static String getEmailByName(String name) throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            String sql = "SELECT cor_usu FROM usuario WHERE nom_usu=?";    
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            
            if(rs.next()){
            return rs.getString("cor_usu");
            }
        }catch(Exception ed){
            System.out.println("Error al consultar");
            System.out.println(ed.getMessage());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (User email by name) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (User email by name) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (User email by name) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return null;
    }
    public static String getPassByEmail(String email) throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            String sql = "SELECT con_usu FROM usuario WHERE cor_usu=?";    
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            if(rs.next()){
            return rs.getString("con_usu");
            }
        }catch(Exception ed){
            System.out.println("Error al consultar");
            System.out.println(ed.getMessage());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (User pass by email) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (User pass by email) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (User pass by email) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return null;
    }
    //Cuando un usuario ingresa por primera vez, se le asigna las actividades
    //Si ya estaba registrado, este mismo proceso se ejecuta, pero no hay cambios    
    public String AsignarSimulaciones () throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        
        try{
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
                "where not exists (select nom_usu, nom_blo, nom_act, id_asig, id_act_blo, estatus\n" +
                "from consultas where usuario.nom_usu = consultas.nom_usu \n" +
                "AND bloques.nom_blo = consultas.nom_blo \n" +
                "AND actividades.nom_act = consultas.nom_act);";
            ps = con.prepareStatement(q);
            estatus = ps.executeUpdate();
        }catch(Exception e){
            System.out.println("Error al consultar la base de datos");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Asignacion Simu) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Asignacion Simu) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Asignacion Simu) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }

        return null;
    }
    
    //Aumenta el progreso en la dificultad fácil de cualquier actividad (supuestamente)
    public static int AumentarProgresoEZ(UsuarioConsulta usucon) throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            abrir();
            String q2 = "update consultas \n" +
                        "SET consultas.pro_dif = ? \n" +
                        "WHERE nom_usu = ? \n" +
                        "AND nom_blo = ? \n" +
                        "AND nom_act = ? \n" +
                        "AND dif_dif = ? \n";
            ps = con.prepareStatement(q2);
            String progresoEZ=usucon.getPro_dif_dif1();
            int progreso = Integer.parseInt(progresoEZ);
            ps.setInt(1, progreso);
            ps.setString(2, usucon.getNom_usu());
            ps.setString(3, usucon.getNom_blo());
            ps.setString(4, usucon.getNom_act());
            ps.setString(5, usucon.getDif_dif());
            estatus = ps.executeUpdate();
            cerrar();
            System.out.println("Progreso aumentado exitosamente en 'fácil' ");
        }catch(Exception e){
            System.out.println("Error, en la sintaxis");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Aumento EZ) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Aumento EZ) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Aumento EZ) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }

        return estatus;
    }
    
    //Aumenta el progreso en la dificultad difícil de cualquier actividad (supuestamente)
    /*Aunque AumentarProgresoEZ sea la misma sentencia, los datos no lo son, por eso
    son 2 metodos diferentes*/
    public static int AumentarProgresoHD(UsuarioConsulta usucon) throws SQLException{
        Connection con=Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            abrir();
            String q2 = "update consultas \n" +
                        "SET consultas.pro_dif = ? \n" +
                        "WHERE nom_usu = ? \n" +
                        "AND nom_blo = ? \n" +
                        "AND nom_act = ? \n" +
                        "AND dif_dif = ? \n";
            ps = con.prepareStatement(q2);
            String progresoHD=usucon.getPro_dif_dif2();
            int progreso = Integer.parseInt(progresoHD);
            ps.setInt(1, progreso);
            ps.setString(2, usucon.getNom_usu());
            ps.setString(3, usucon.getNom_blo());
            ps.setString(4, usucon.getNom_act());
            ps.setString(5, usucon.getDif_dif());
            estatus = ps.executeUpdate();
            cerrar();
            System.out.println("Progreso aumentado exitosamente en 'difícil' ");
        }catch(Exception e){
            System.out.println("Error, en la sintaxis");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Aumento HD) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Aumento HD) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Aumento HD) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return estatus;
    }

    //Se busca al usuario para obtener el promedio de las actividades de un bloque
    //En este caso solo sería el de Estafas y de la actividad de phishing porque
    //Es la única actividad que se tiene funcionando en el sistema a pesar de haber otras
    //en la BD
    
    //Actualizar este metodo para que sea en los diferentes bloques y actividades
    public static UsuarioConsulta buscarUsuAsigPromUsu(String nombre, String blo, String act) throws SQLException{
        UsuarioConsulta usu = new UsuarioConsulta();
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String q = "SELECT *, AVG(pro_dif) FROM consultas \n" +
                       "where nom_usu = ? and nom_blo = ? and nom_act = ?;";
            ps = con.prepareStatement(q);
            ps.setString(1, nombre);
            ps.setString(2, blo);
            ps.setString(3, act);
            rs = ps.executeQuery();

            if(rs.next()){
                usu.setId(rs.getInt(1));
                usu.setNom_usu(rs.getString(2));
                usu.setDif_dif(rs.getString(5));
                usu.setPro_dif_dif1(rs.getString(6));   
                usu.setPro_dif(rs.getString(10));
            }
            System.out.println("Usuario asignado, encontrado para el promedio");
        }catch(Exception e){
            System.out.println("Error al buscar al usuario asignado buscarUsuAsigProm");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Asig Prom) "+rs);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Asig Prom) "+con);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Asig Prom) "+ps);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return usu;
    }
    public static UsuarioConsulta buscarUsuAsigPromUsuTOT(String nombre) throws SQLException{
        UsuarioConsulta usu = new UsuarioConsulta();
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String q = "SELECT *, AVG(pro_dif) FROM consultas \n" +
                       "where nom_usu = ? ;";
            ps = con.prepareStatement(q);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if(rs.next()){
                usu.setId(rs.getInt(1));
                usu.setNom_usu(rs.getString(2));
                usu.setDif_dif(rs.getString(5));
                usu.setPro_dif_dif1(rs.getString(6));   
                usu.setPro_dif(rs.getString(10));
            }
        }catch(Exception e){
            System.out.println("Error al buscar al usuario asignado buscarUsuAsigProm");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Asig Prom) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Asig Prom) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Asig Prom) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return usu;
    }
    
    //Este metodo debe solicitar el nombre del usuario, el bloque a consultar y la actividad a consultar de dicho bloque
    public static UsuarioConsulta buscarUsuAsig(String nombre, String blo, String act) throws SQLException{
        UsuarioConsulta usu = new UsuarioConsulta();
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String q = "SELECT * FROM consultas \n" +
                       "where nom_usu = ? and nom_blo = ? and nom_act = ?;";
            ps = con.prepareStatement(q);
            ps.setString(1, nombre);
            ps.setString(2, blo);
            ps.setString(3, act);
            rs = ps.executeQuery();

            if(rs.next()){
                usu.setId(rs.getInt(1));
                usu.setNom_usu(rs.getString(2));
                usu.setNom_blo(rs.getString(3));
                usu.setNom_act(rs.getString(4));
                usu.setDif_dif(rs.getString(5));
                usu.setPro_dif_dif1(rs.getString(6));   
//                usu.setPro_dif(rs.getString(9));
            }
            System.out.println("Usuario asignado, encontrado para la dificultad facil de las ");
        }catch(Exception e){
            System.out.println("Error al buscar al usuario asignado buscarUsuAsigProm");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Asig Prom) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Asig Prom) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Asig Prom) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return usu;
    }
    
    public static UsuarioConsulta buscarUsuAsigPromEZ(String nombre,String blo, String act) throws SQLException{
        UsuarioConsulta usu = new UsuarioConsulta();
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            String q = "SELECT *, AVG(pro_dif) FROM consultas \n" +
                       "where nom_usu = ? and nom_blo = ? and nom_act = ? and dif_dif='facil';";
            ps = con.prepareStatement(q);
            ps.setString(1, nombre);
            ps.setString(2, blo);
            ps.setString(3, act);

            rs = ps.executeQuery();

            if(rs.next()){
                usu.setId(rs.getInt(1));
                usu.setNom_usu(rs.getString(2));
                usu.setDif_dif(rs.getString(5));
                usu.setPro_dif_dif1(rs.getString(6));   
                usu.setPro_dif(rs.getString(9));
            }
            System.out.println("Usuario asignado, encontrado para el promedio PH");
        }catch(Exception e){
            System.out.println("Error al buscar al usuario asignado buscarUsuAsigProm");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Asig Prom) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Asig Prom) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Asig Prom) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return usu;
    }
    //Busca el progreso de la dificultad "dificil" por separado porque el metodo anterior
    //buscarUsuAsigProm ya obtiene el valor de la dificultad "facil"
    
    //Igual actualizar este metodo para que busque y obtenga valores de las diferentes
    //dificultades con diferentes bloques
    public static UsuarioConsulta buscarUsuDif_dificil(String nombre,String blo, String act) throws SQLException{
        UsuarioConsulta usu = new UsuarioConsulta();
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            con = Conexion.getConexion();
            String q = "SELECT * FROM consultas \n" +
                       "where nom_usu = ? and nom_blo = ? and nom_act = ? and dif_dif = 'dificil';";
            ps = con.prepareStatement(q);
            ps.setString(1, nombre);
            ps.setString(2, blo);
            ps.setString(3, act);

            rs = ps.executeQuery();

            if(rs.next()){
                usu.setPro_dif_dif2(rs.getString(6));
            }
            System.out.println("Usuario asignado, encontrado para la dificultad dificil PH");
        }catch(Exception e){
            System.out.println("Error al buscar al usuario asignado buscarUsuDif_dificl");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Usu_DifHD) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Usu_DifHD) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Usu_DifHD) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return usu;
    }
    
    public static int UsuActivo(String nombre) throws SQLException{
        Connection con=Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            abrir();
            String q2 = "update consultas set estatus = 0 where nom_usu = ?";
            ps = con.prepareStatement(q2);
            ps.setString(1, nombre);
            estatus = ps.executeUpdate();
            cerrar();
            System.out.println("Estado del usuario cambiado a \"Activo\" ");
        }catch(Exception e){
            System.out.println("Error, en la sintaxis, no se pudo actualizar el estado");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Activo) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Activo) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Activo) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return estatus;
    }
    
    public static int UsuInactivo(String nombre) throws SQLException{
        Connection con=Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        int estatus = 0;
        try{
            abrir();
            String q2 = "update consultas set estatus = 1 where nom_usu = ?";
            ps = con.prepareStatement(q2);
            ps.setString(1, nombre);
            estatus = ps.executeUpdate();
            cerrar();
            System.out.println("Estado del usuario cambiado a \"Inactivo\" ");
        }catch(Exception e){
            System.out.println("Error, en la sintaxis, no se pudo actualizar el estado");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (Inactivo) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (Inactivo) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (Inactivo) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }
        return estatus;
    }
    //Este metodo es para consultar la lista de usuarios registrados, sin importar si hayan iniciado 
    //sesion o no para su asignacion de bloques y actividades
//    public static List<Usuario> consultaGral(){
//        List<Usuario> lista = new ArrayList<Usuario>();
//        Connection con = Conexion.getConexion();
//        PreparedStatement ps=null;
//        ResultSet rs=null;
//        int estatus = 0;
//        try{
//            String q = "SELECT * FROM usuario";
//            //DELETE FROM `diskettegb`.`usuario` WHERE (`id_usu` = '2');
//            ps = con.prepareStatement(q);
//            rs = ps.executeQuery();
////            while (rs.next()){
////                Usuario u = new Usuario ();
////                u.setNombre(rs.getString("nom_usu"));
////            }
//        }catch(Exception e){
//            System.out.println("Error al buscar al usuario asignado consultaGral");
//            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
//        }finally{
//            try{
//                if(rs != null){
//                    rs.close();
//                    System.out.println("ResultSet closed (Usu_GEN)");
//                }
//                if(ps != null){
//                    ps.close();
//                    System.out.println("PreparedStatement closed (Usu_GEN)");
//                }
//                if(con != null){
//                    con.close();
//                    System.out.println("Connection closed (Usu_GEN)");
//                }
//            }catch(Exception e2){
//                System.out.println(e2.getMessage());
//                System.out.println(e2.getStackTrace());
//            }
//        }
//        return lista;
//    }    
    //Estos metodos son para deshabilitar y rehabilitar las actualizaciones con FK 
    //dentro de MySql
    public static void abrir() throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String q1 = "SET sql_safe_updates=0";
            ps = con.prepareStatement(q1);
            rs = ps.executeQuery();
        }catch(Exception e){
            System.out.println("Error en sql_safe_update");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (open) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (open) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (open) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }

    }
    public static void cerrar() throws SQLException{
        Connection con = Conexion.getConexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            String q1 = "SET sql_safe_updates=1";
            ps = con.prepareStatement(q1);
            rs = ps.executeQuery();
        }catch(Exception e){
            System.out.println("Error en sql_safe_update");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }finally{
            try{
                if(rs != null){
                    rs.close();
                    System.out.println("ResultSet closed (close) "+rs);
                }
                if(ps != null){
                    ps.close();
                    System.out.println("PreparedStatement closed (close) "+ps);
                }
                if(con != null){
                    con.close();
                    System.out.println("Connection closed (close) "+con);
                }
            }catch(Exception e2){
                System.out.println(e2.getMessage());
                System.out.println(e2.getStackTrace());
            }
        }   
    }
}
