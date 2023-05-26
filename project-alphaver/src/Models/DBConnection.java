package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection mysqlconfig;
    public static Connection configDB()throws SQLException{
        String url="jdbc:mysql://localhost/cbt_pbo";
        String user="root";
        String pass="";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        mysqlconfig = DriverManager.getConnection(url, user, pass);        
        return mysqlconfig;
    }
}
