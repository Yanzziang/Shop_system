package db;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conn {
    private final static String ClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//���ݿ�����
    private final static String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=DB_shop";//�������ݿ��URL

    private final static String user = "sa";//�������ݿ��û���
    private final static String password = "8874123";

    private static Connection connection;//���ݿ������� 

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
    	connection = DriverManager.getConnection(URL, user, password);//��ȡ����
    	    } catch (SQLException e1) {   
    	    	connection = null; 
    	        e1.printStackTrace();  
    	        }
    return connection;
}
 

}
