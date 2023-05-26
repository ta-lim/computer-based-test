package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection mysqlconfig;
    public static Connection configDB()throws SQLException{
        String url="jdbc:mysql://51.79.215.17/db_cbt_pbo";
        String user="pbo_cbt";
        String pass="db@cbtAdmin@1321";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        mysqlconfig = DriverManager.getConnection(url, user, pass);        
        return mysqlconfig;
    }
}
