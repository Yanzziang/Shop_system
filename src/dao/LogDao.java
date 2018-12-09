package dao;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import vo.Log;
import vo.User;
import java.util.Vector;

public class LogDao {
    public static void add(User user, String type) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "insert into inout(username,opertype,opertime) values('"+
                         user.getUsername()+"','" + type  + "',getdate())";
            db.DB.executeUpdate(sql, conn, stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(null, stmt, conn);
        }
    }

    public static void deleteAll() {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "delete from inout";
            db.DB.executeUpdate(sql, conn, stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(null, stmt, conn);
        }
    }


    public static void loadTable(javax.swing.table.DefaultTableModel dataTable){
        dataTable.setRowCount(0);//设置行数为0

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from inout order by id desc";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;//编号
            while (rs.next()) {
                int id = rs.getInt("id");
                //String userid = rs.getString("userid");
                String username = rs.getString("username");
                String opertype = rs.getString("opertype");
                String opertime = rs.getString("opertime");

                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                //row.add(userid);
                row.add(username);
                row.add(opertype);
                row.add(opertime);

                dataTable.addRow(row);//表模型进行一行一行的添加，一行又有四个元素
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(rs, stmt, conn);
        }
    }

}
