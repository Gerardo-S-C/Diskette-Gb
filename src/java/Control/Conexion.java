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

import java.net.URI;
import java.sql.*;
import java.sql.DriverManager;

public class Conexion {
        public static Connection getConexion(){
        try{
            
            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

            return DriverManager.getConnection(dbUrl, username, password);

        
        }catch(SQLException sq){
            System.out.println("Error al conectar con la BD");
            System.out.println(sq.getMessage());
        
        }catch(Exception e){
            System.out.println("No encuentra la clase");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
