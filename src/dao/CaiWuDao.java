package dao;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.CaiDao;
import db.DB;
import vo.*;
import frame.*;

public class CaiWuDao {
	
	public static float[] getMoney1( String name, String provider1) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        float k = 0;
        float m = 0;
        float a[] = new float[2];
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from sale where drugname ='"+name+"' and provider = '"+provider1+"'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            
            while (rs.next()) {
                
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                float sprice = rs.getFloat("sprice");
                k = k + sprice * amount;
                m = m + (sprice - price) * amount;
            }
            
            a[0] = k;
            a[1] = m;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return a;
	}
	
	public static float[] getMoney1( String provider1) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float k = 0;
        float m = 0;
        float a[] = new float[2];
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from sale where provider ='"+provider1+"'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            
            while (rs.next()) {
                
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                float sprice = rs.getFloat("sprice");
                k = k + sprice * amount;
                m = m + (sprice - price) * amount;
            }
            
            a[0] = k;
            a[1] = m;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return a;
	}
	
	public static float[] getMoney( String name) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float k = 0;
        float m = 0;
        float a[] = new float[2];
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from sale where drugname ='"+name+"'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            
            while (rs.next()) {
                
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                float sprice = rs.getFloat("sprice");
                k = k + sprice * amount;
                m = m + (sprice - price) * amount;
            }
            
            a[0] = k;
            a[1] = m;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return a;
	}
	
	public static float[] getMoney( String date1, String date2) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float k = 0;
        float m = 0;
        float a[] = new float[2];
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from sale where datediff(day,saletime,cast('"+date1+"' as datetime)) <=0 and datediff(day,saletime,cast('"+date2+"' as datetime))>=0 order by sid desc";
            rs = db.DB.executeQuery(sql, conn, stmt);

            
            while (rs.next()) {
                
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                float sprice = rs.getFloat("sprice");
                k = k + sprice * amount;
                m = m + (sprice - price) * amount;
            }
            
            a[0] = k;
            a[1] = m;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return a;
	}
	
	
	
	public static float getmoney( String date1, String date2) throws SQLException {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float k = 0;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from caigou where datediff(day,caitime,cast('"+date1+"' as datetime)) <=0 and datediff(day,caitime,cast('"+date2+"' as datetime))>=0 order by cid desc";
            rs = db.DB.executeQuery(sql, conn, stmt);

            
            while (rs.next()) {
                
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                k = k + price * amount;}
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
        return k;
	}
	
	public static float getmoney( String name) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float k = 0;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from caigou where drugname ='"+name+"'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            
            while (rs.next()) {
                
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                k = k + price * amount;}
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return k;
	}
	
	public static float getmoney1( String name, String provider1) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float k = 0;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from caigou where drugname ='"+name+"' and provider = '"+provider1+"'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            
            while (rs.next()) {
                
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                k = k + price * amount;}
            
        }catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        return k;
	}
	
	public static float getmoney2( String provider1)  {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float k = 0;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from caigou where provider = '"+provider1+"'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            
            while (rs.next()) {
                
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                k = k + price * amount;}
            
        }catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        return k;
	}
	public static void loadTable4(javax.swing.table.DefaultTableModel dataTable,String name,String provider1){
		dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from caigou where drugname ='"+name+"' and provider = '"+provider1+"'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                int cid = rs.getInt("cid");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");

                String caitime = rs.getString("caitime");
                String provider = rs.getString("provider");
                String username = rs.getString("username");
                float allmoney = price * amount;
                
                Vector row = new Vector();
                //row.add(barcode);
                row.add(cid);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                
                row.add(allmoney);
                row.add(caitime);
                row.add(provider);
                row.add(username);



                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DB.close(rs, stmt, conn);
        }
    }
	
	public static void loadTable2(javax.swing.table.DefaultTableModel dataTable,String name){
		dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from caigou where drugname ='"+name+"'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                int cid = rs.getInt("cid");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");

                String caitime = rs.getString("caitime");
                String provider = rs.getString("provider");
                String username = rs.getString("username");
                float allmoney = price * amount;
                
                Vector row = new Vector();
                //row.add(barcode);
                row.add(cid);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                
                row.add(allmoney);
                row.add(caitime);
                row.add(provider);
                row.add(username);



                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DB.close(rs, stmt, conn);
        }
    }
	
	public static void loadTable3(javax.swing.table.DefaultTableModel dataTable,String provider1){
		dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from caigou where provider ='"+provider1+"'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                int cid = rs.getInt("cid");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");

                String caitime = rs.getString("caitime");
                String provider = rs.getString("provider");
                String username = rs.getString("username");
                float allmoney = price * amount;
                
                Vector row = new Vector();
                //row.add(barcode);
                row.add(cid);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                
                row.add(allmoney);
                row.add(caitime);
                row.add(provider);
                row.add(username);



                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DB.close(rs, stmt, conn);
        }
    }
	
	public static void loadTable(javax.swing.table.DefaultTableModel dataTable){
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from caigou ";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                int cid = rs.getInt("cid");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");

                String caitime = rs.getString("caitime");
                String provider = rs.getString("provider");
                String username = rs.getString("username");
                float allmoney = price * amount;
                
                Vector row = new Vector();
                //row.add(barcode);
                row.add(cid);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                
                row.add(allmoney);
                row.add(caitime);
                row.add(provider);
                row.add(username);



                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DB.close(rs, stmt, conn);
        }
    }
	
	public static void loadTable(javax.swing.table.DefaultTableModel dataTable, String day){
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from sale where DATEDIFF(day, saletime, getdate())=0";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                int cid = rs.getInt("cid");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");
 
                String caitime = rs.getString("caitime");
                String username = rs.getString("username");
                float allmoney = price * amount;
                
                Vector row = new Vector();
                //row.add(barcode);
                row.add(cid);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                
                row.add(allmoney);
                row.add(caitime);
                row.add(username);



                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DB.close(rs, stmt, conn);
        }
    }
	
	
	
	public static void loadTable(javax.swing.table.DefaultTableModel dataTable, String date1, String date2) throws SQLException{
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from caigou where datediff(day,caitime,cast('"+date1+"' as datetime)) <=0 and datediff(day,caitime,cast('"+date2+"' as datetime))>=0 order by cid desc";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                int cid = rs.getInt("cid");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");
                 String provider = rs.getString("provider");
                String caitime = rs.getString("caitime");
                String username = rs.getString("username");
                float allmoney = price * amount;
                
                Vector row = new Vector();
                //row.add(barcode);
                row.add(cid);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                
                row.add(allmoney);
                
                row.add(caitime);
                row.add(provider);
                row.add(username);



                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            DB.close(rs, stmt, conn);
        }
    }
	
	 public static void loadtable0(javax.swing.table.DefaultTableModel dataTable, String date1, String date2) throws SQLException{
	        dataTable.setRowCount(0);

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            
	            String sql = "select * from sale where datediff(day,saletime,cast('"+date1+"' as datetime)) <=0 and datediff(day,saletime,cast('"+date2+"' as datetime))>=0 order by sid desc";
	            System.out.println(sql);
	            rs = db.DB.executeQuery(sql, conn, stmt);

	            int i = 0;
	            while (rs.next()) {
	                String sid = rs.getString("sid");
	           
	                String drugname = rs.getString("drugname");
	                float sprice = rs.getFloat("sprice");
	                float price = rs.getFloat("price");
	                int amount = rs.getInt("amount");
	             

	                String provider = rs.getString("provider");
	                String saletime = rs.getString("saletime");
	                String username = rs.getString("username");
	                float winmoney = (sprice*amount) - (price*amount);
	                float allmoney = sprice*amount;

	                Vector row = new Vector();
	               // row.add(new Integer(++i));
	                //row.add(new Integer(id));
	                row.add(sid);

	                row.add(drugname);
	                row.add(price);
	                //row.add(sprice);
	                row.add(amount);
	                row.add(allmoney);
	                row.add(winmoney);

	                row.add(provider);
	                row.add(saletime);
	                row.add(username);

	                dataTable.addRow(row);
	            }


	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            throw ex;
	        } finally {
	            db.DB.close(rs, stmt, conn);
	        }
	    }
	 
	 public static void loadtable(javax.swing.table.DefaultTableModel dataTable){
	        dataTable.setRowCount(0);

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            
	            String sql = "select * from sale ";
	            System.out.println(sql);
	            rs = db.DB.executeQuery(sql, conn, stmt);

	            int i = 0;
	            while (rs.next()) {
	                String sid = rs.getString("sid");
	                //String barcode = rs.getString("barcode");
	                String drugname = rs.getString("drugname");
	                float sprice = rs.getFloat("sprice");
	                float price = rs.getFloat("price");
	                int amount = rs.getInt("amount");
	                //String allmoney = rs.getString("allmoney");

	                String provider = rs.getString("provider");
	                String saletime = rs.getString("saletime");
	                String username = rs.getString("username");
	                float winmoney = (sprice*amount) - (price*amount);
	                float allmoney = sprice*amount;

	                Vector row = new Vector();
	                //row.add(new Integer(++i));
	                //row.add(new Integer(id));
	                row.add(sid);

	                row.add(drugname);
	                row.add(price);
	                //row.add(sprice);
	                row.add(amount);
	                row.add(allmoney);
	                row.add(winmoney);

	                row.add(provider);
	                row.add(saletime);
	                row.add(username);

	                dataTable.addRow(row);
	            }


	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            
	        } finally {
	            db.DB.close(rs, stmt, conn);
	        }
	    }
	
	 
		public static void loadtable4(javax.swing.table.DefaultTableModel dataTable,String name,String provider1){
			dataTable.setRowCount(0);

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            String sql = "select * from sale where drugname ='"+name+"' and provider = '"+provider1+"'";
	            rs = db.DB.executeQuery(sql, conn, stmt);

	            int i = 0;
	            while (rs.next()) {
	                String sid = rs.getString("sid");
	                //String barcode = rs.getString("barcode");
	                String drugname = rs.getString("drugname");
	                float sprice = rs.getFloat("sprice");
	                float price = rs.getFloat("price");
	                int amount = rs.getInt("amount");
	                //String allmoney = rs.getString("allmoney");

	                String provider = rs.getString("provider");
	                String saletime = rs.getString("saletime");
	                String username = rs.getString("username");
	                float winmoney = (sprice*amount) - (price*amount);
	                float allmoney = sprice*amount;

	                Vector row = new Vector();
	                //row.add(new Integer(++i));
	                //row.add(new Integer(id));
	                row.add(sid);

	                row.add(drugname);
	                row.add(price);
	                //row.add(sprice);
	                row.add(amount);
	                row.add(allmoney);
	                row.add(winmoney);

	                row.add(provider);
	                row.add(saletime);
	                row.add(username);

	                dataTable.addRow(row);
	            }


	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            DB.close(rs, stmt, conn);
	        }
	    }
		
		public static void loadtable2(javax.swing.table.DefaultTableModel dataTable,String name){
			dataTable.setRowCount(0);

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            String sql = "select * from sale where drugname ='"+name+"'";
	            rs = db.DB.executeQuery(sql, conn, stmt);

	            int i = 0;
	            while (rs.next()) {
	                String sid = rs.getString("sid");
	                //String barcode = rs.getString("barcode");
	                String drugname = rs.getString("drugname");
	                float sprice = rs.getFloat("sprice");
	                float price = rs.getFloat("price");
	                int amount = rs.getInt("amount");
	                //String allmoney = rs.getString("allmoney");

	                String provider = rs.getString("provider");
	                String saletime = rs.getString("saletime");
	                String username = rs.getString("username");
	                float winmoney = (sprice*amount) - (price*amount);
	                float allmoney = sprice*amount;

	                Vector row = new Vector();
	                //row.add(new Integer(++i));
	                //row.add(new Integer(id));
	                row.add(sid);

	                row.add(drugname);
	                row.add(price);
	                //row.add(sprice);
	                row.add(amount);
	                row.add(allmoney);
	                row.add(winmoney);

	                row.add(provider);
	                row.add(saletime);
	                row.add(username);

	                dataTable.addRow(row);
	            }


	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            DB.close(rs, stmt, conn);
	        }
	    }
		
		public static void loadtable3(javax.swing.table.DefaultTableModel dataTable,String provider1){
			dataTable.setRowCount(0);

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            String sql = "select * from sale where provider ='"+provider1+"'";
	            rs = db.DB.executeQuery(sql, conn, stmt);

	            int i = 0;
	            while (rs.next()) {
	                String sid = rs.getString("sid");
	                //String barcode = rs.getString("barcode");
	                String drugname = rs.getString("drugname");
	                float sprice = rs.getFloat("sprice");
	                float price = rs.getFloat("price");
	                int amount = rs.getInt("amount");
	                //String allmoney = rs.getString("allmoney");

	                String provider = rs.getString("provider");
	                String saletime = rs.getString("saletime");
	                String username = rs.getString("username");
	                float winmoney = (sprice*amount) - (price*amount);
	                float allmoney = sprice*amount;

	                Vector row = new Vector();
	                //row.add(new Integer(++i));
	                //row.add(new Integer(id));
	                row.add(sid);

	                row.add(drugname);
	                row.add(price);
	                //row.add(sprice);
	                row.add(amount);
	                row.add(allmoney);
	                row.add(winmoney);

	                row.add(provider);
	                row.add(saletime);
	                row.add(username);

	                dataTable.addRow(row);
	            }

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            DB.close(rs, stmt, conn);
	        }
	    }
}
