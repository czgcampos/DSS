/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author user
 */
public class Connect {
    
    //Responsabilidade de fechar a ligação fica do lado de quem invoca
    public static Connection connect() throws SQLException{
        Connection con = null;
        try{
        String USERNAME = "root";
        String PASSWORD = "24121996";
        String CON_STRING = "jdbc:mysql://localhost:3306/dss";
        con = (com.mysql.jdbc.Connection) DriverManager.getConnection(CON_STRING, USERNAME, PASSWORD);
        }
        catch(SQLException e){
        }
        return con;
    }
}
