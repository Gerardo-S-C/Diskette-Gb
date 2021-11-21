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

import java.sql.*;
import java.sql.DriverManager;

public class Conexion {
        public static Connection getConexion(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            String url, userName, password;
            
            url = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_c1d2b8ca4113e8c";
            userName = "b3f24c256c95db";
            password= "6dc6cf58";
            
            return DriverManager.getConnection(url, userName, password);
        
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
