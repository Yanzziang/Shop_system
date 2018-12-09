package db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conn {
    private final static String ClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//数据库驱动
    private final static String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DB_shop";//连接数据库的URL

    private final static String user = "sa";//连接数据库用户名
    private final static String password = "8874123";

    private static Connection connection;//数据库连接类 

    static {
        try {
            Class.forName(ClassName);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private Conn() {
    }

    public static Connection getInstance() { 
    	try {  
    	connection = DriverManager.getConnection(URL, user, password);//获取连接
    	    } catch (SQLException e1) {   
    	    	connection = null; 
    	        e1.printStackTrace();  
    	        }
    return connection;
}
 

}
