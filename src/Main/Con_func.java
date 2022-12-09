package Main;
import java.sql.*;
import java.util.*;

public class Con_func {
    private static final String username = "root";
    private static final String password = "Mysql@123";
    private static final String url = "jdbc:mysql://localhost:3306/projectm";

    public static Connection getConnection(){
        Connection con = null;
        try {
            Properties connectionProperties = new Properties();
            connectionProperties.put("user",username);
            connectionProperties.put("password",password);
            con = DriverManager.getConnection(url,connectionProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
    
}