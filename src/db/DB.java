package db;

import java.sql.*;

public class DB {
    public DB() {
    }

    //查询数据库的并返回一个ResultSet
    //假如未有问题，将会返回一个ResultSet = null;
    public static ResultSet executeQuery(String sql, Connection conn , Statement stmt)throws SQLException {
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();//连接
            rs = stmt.executeQuery(sql);//语句查询结果返回结果集
        }catch(SQLException e) {
            rs = null;
            e.printStackTrace();
            throw e;
        }
        return rs;
    }

    //更新数据数据库中的记录
    //如果没有更新失几，将会返回 -1
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
