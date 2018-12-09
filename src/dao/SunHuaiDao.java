package dao;

import vo.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Vector;
import java.sql.ResultSet;


public class SunHuaiDao {
    public static void add(Drug drug, String shtype) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "insert into ypbf(barcode,drugname,amount,type,spec,unit,username,stype,retime) values('"
                         + drug.getBarcode() + "','"
                         + drug.getDrugname() + "',"
                         + drug.getAmount() + ",'"
                         + drug.getType() + "','"
                         + drug.getSpec() + "','"
                         + drug.getUnit() + "','"
                         + drug.getUsername() + "','"
                         +shtype + "',getdate())";
            db.DB.executeUpdate(sql, conn, stmt);
            String sql1 = "update ruku set amount=amount-1 where barcode='"+drug.getBarcode()+"'";
            db.DB.executeUpdate(sql1, conn, stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(null, stmt, conn);
        }
    }
    
    public static void delete(String id,String barcode,int amount){
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "delete from ypbf where id=" + id;
            System.out.println(sql);
            db.DB.executeUpdate(sql, conn, stmt);
            String sql1 = "update ruku set amount=amount+"+amount+" where barcode='"+barcode+"'";
            db.DB.executeUpdate(sql1, conn, stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static void update(int amount,String stype,String barcode,int id){
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            
            String sql1 = "update ypbf set amount = "+amount+",stype = '"+stype+"' where id="+id+"";
            db.DB.executeUpdate(sql1, conn, stmt);
            String sql2 = "update ruku set amount = amount+1-"+amount+" where barcode='"+barcode+"'";
            db.DB.executeUpdate(sql2, conn, stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static SunHuai getall(int id){
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
       SunHuai s = new SunHuai();
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from ypbf where id="+id+"";
            
            rs = db.DB.executeQuery(sql, conn, stmt);
            while(rs.next())
            {
            	s.setAmount(rs.getInt("amount"));
            	s.setBarcode(rs.getString("barcode"));
            	s.setDrugname(rs.getString("drugname"));
            	s.setId(rs.getInt("id"));
            	s.setRetime(rs.getString("retime"));
            	s.setSpec(rs.getString("spec"));
            	s.setStype(rs.getString("stype"));
            	s.setType(rs.getString("type"));
            	s.setUnit(rs.getString("unit"));
            	s.setUsername(rs.getString("username"));
            	
            }
            }catch (SQLException ex) {
                ex.printStackTrace();
            } 
        
            return s;
    }

    
    public static void loadTable(javax.swing.table.DefaultTableModel dataTable){
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from ypbf order by id desc";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                String amount = rs.getString("amount");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
               // String producer = rs.getString("producer");
                String username = rs.getString("username");
                String stype = rs.getString("stype");
                String retime = rs.getString("retime");

                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(id);
                row.add(barcode);
                row.add(drugname);
                row.add(amount);
                row.add(type);
                row.add(spec);
                row.add(unit);
                //row.add(producer);
                row.add(username);
                row.add(stype);
                row.add(retime);


                dataTable.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(rs, stmt, conn);
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
            String sql = "select * from ypbf where DATEDIFF(day, retime, getdate())=0";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                String amount = rs.getString("amount");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
                //String producer = rs.getString("producer");
                String username = rs.getString("username");
                String stype = rs.getString("stype");
                String retime = rs.getString("retime");

                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(id);
                row.add(barcode);
                row.add(drugname);

                row.add(amount);
                row.add(type);
                row.add(spec);
                row.add(unit);
                //row.add(producer);
                row.add(username);
                row.add(stype);
                row.add(retime);

                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(rs, stmt, conn);
        }
    }

    public static void loadTableBySearch(javax.swing.table.DefaultTableModel dataTable, String search){
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from ypbf where barcode like '%"+search+"%' or drugname like '%"+search+"%' or stype like '%"+search+"%'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                String amount = rs.getString("amount");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
                //String producer = rs.getString("producer");
                String username = rs.getString("username");
                String stype = rs.getString("stype");
                String retime = rs.getString("retime");

                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(id);
                row.add(barcode);
                row.add(drugname);
                row.add(amount);
                row.add(type);
                row.add(spec);
                row.add(unit);
                //row.add(producer);
                row.add(username);
                row.add(stype);
                row.add(retime);

                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(rs, stmt, conn);
        }
    }


    public static void loadTable(javax.swing.table.DefaultTableModel dataTable, String date1, String date2, String typec) throws SQLException{
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            //String sql = "select * from sale where DATEDIFF('d',"+date1+", saletime)>=0 and DATEDIFF('d',saletime, "+date2+")>0 order by sid desc";
            //String sql = "select * from ypbf where retime>=#"+date1+"# and retime<=#"+date2+"# and stype='"+typec+"' order by id desc";
            //System.out.println(sql);
            //where datediff(day,intime,cast('"+date1+"' as datetime)) <=0 and datediff(day,intime,cast('"+date2+"' as datetime))>=0
            String sql = "select * from ypbf where datediff(day,retime,cast('"+date1+"' as datetime)) <=0 and datediff(day,retime,cast('"+date2+"' as datetime))>=0 order by id desc";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                String amount = rs.getString("amount");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
               // String producer = rs.getString("producer");
                String username = rs.getString("username");
                String stype = rs.getString("stype");
                String retime = rs.getString("retime");

                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(id);
                row.add(barcode);
                row.add(drugname);
                row.add(amount);
                row.add(type);
                row.add(spec);
                row.add(unit);
                //row.add(producer);
                row.add(username);
                row.add(stype);
                row.add(retime);

                dataTable.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.DB.close(rs, stmt, conn);
        }
    }


}
