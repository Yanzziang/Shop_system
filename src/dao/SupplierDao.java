package dao;

import vo.User;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import vo.Supplier;
import java.util.Vector;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * <p>Title:超市销售管理系统</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2010</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class SupplierDao {
    public static void add(Supplier supp) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "insert into supplier(name,person,phone,tel,telc,addr,remark) values('"
                         +supp.getName()+"','"
                         +supp.getPerson()+"','"
                         + supp.getPhone() + "','"
                         +supp.getTel()+"','"
                         +supp.getTelc()+"','"
                         +supp.getAddr()+"','"
                         +supp.getRemark()+"')";
            System.out.println(sql);
            db.DB.executeUpdate(sql, conn, stmt);

        } catch (SQLException ex) {
            //ex.printStackTrace();
            throw ex;
        } finally {
            db.DB.close(null, stmt, conn);
        }
    }

    public static void delete(String sid){
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "delete from supplier where sid=" + sid;
            System.out.println(sql);
            db.DB.executeUpdate(sql, conn, stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(null, stmt, conn);
        }
    }


    public static String[] getAllSupplierName() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String[] names = null;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select name from supplier";
            rs = db.DB.executeQuery(sql, conn, stmt);

            ArrayList<String> rows = new ArrayList<String>();

           while (rs.next()) {
               String name = rs.getString("name");
               rows.add(name);
           }
           names = new String[rows.size()];
           for(int i=0;i<rows.size();i++) {
               names[i] = rows.get(i);
           }
           return names;
       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           db.DB.close(rs, stmt, conn);
       }
        return null;
    }

    public static Vector<String> getSupplierName() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Vector a = new Vector();
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select name from supplier";
            rs = db.DB.executeQuery(sql, conn, stmt);

           while (rs.next()) {
               String name = rs.getString("name");
               a.add(name);
           }
           if (a.size()>0){
        	   return a;
           }
           
       } catch (SQLException ex) {
           ex.printStackTrace();
       } 
        return null;
    }

    public static void loadTable(javax.swing.table.DefaultTableModel dataTable){
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from supplier order by sid desc";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                int sid = rs.getInt("sid");
                String name = rs.getString("name");
                String person = rs.getString("person");
                String phone = rs.getString("phone");
                String tel = rs.getString("tel");
                String telc = rs.getString("telc");
                String addr = rs.getString("addr");
                String remark = rs.getString("remark");

                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(sid);
                row.add(name);
                row.add(person);
                row.add(phone);
                row.add(tel);
                row.add(telc);
                row.add(addr);
                row.add(remark);

                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(rs, stmt, conn);
        }
    }


}
