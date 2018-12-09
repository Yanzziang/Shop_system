package db;

import java.sql.*;

public class DB {
    public DB() {
    }

    //��ѯ���ݿ�Ĳ�����һ��ResultSet
    //����δ�����⣬���᷵��һ��ResultSet = null;
    public static ResultSet executeQuery(String sql, Connection conn , Statement stmt)throws SQLException {
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();//����
            rs = stmt.executeQuery(sql);//����ѯ������ؽ����
        }catch(SQLException e) {
            rs = null;
            e.printStackTrace();
            throw e;
        }
        return rs;
    }

    //�����������ݿ��еļ�¼
    //���û�и���ʧ�������᷵�� -1
    public static int executeUpdate(String sql, Connection conn, Statement stmt) throws
            SQLException {
        int result = -1;
        stmt = conn.createStatement();
        result = stmt.executeUpdate(sql);
        return result;
    }

    public static void closeRs(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException ex) {
            }
        }
    }

    public static void closeStmt(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
                stmt = null;
            } catch (SQLException ex) {
            }
        }

    }

    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException ex) {
            }
        }
    }

    public static void close( ResultSet rs, Statement stmt, Connection conn) {
        closeRs(rs);
        closeStmt(stmt);
        closeConn(conn);
    }

}
