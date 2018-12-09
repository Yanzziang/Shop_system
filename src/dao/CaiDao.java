package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import db.Conn;
import db.DB;
import vo.Cai;
import vo.Drug;
import javax.swing.table.DefaultTableModel;

import java.util.Vector;
import java.sql.ResultSet;


public class CaiDao {

	public static void add(Cai cai) {
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conn.getInstance();
            stmt = conn.createStatement();
            //(user.isP1() == true ? 1 : 0)
            String sql = "insert into caigou(drugname,price,amount,type,spec,unit,caitime,username,provider,expiredate,isnot) values('" +
                         cai.getDrugname() + "','" +cai.getPrice()+ "','" +cai.getAmount()+
                         "','"+cai.getType()+"','"+cai.getSpec()+"','"+cai.getUnit()+"','"+cai.getCaitime()+"','"+cai.getUsername()+"','"+cai.getProvider()+
                         "',"+cai.getExpiredate()+"," + (cai.isnot() == true ? 1 : 0)+")";
            //System.out.println(sql);
            db.DB.executeUpdate(sql, conn, stmt);

	       } catch (SQLException ex) {
	           ex.printStackTrace();
	       } finally {
	           DB.close(null, stmt, conn);
	       }
	   }
	
	
	public static void delete(String cid) {
	       Connection conn = null;
	       Statement stmt = null;

	       try {
	           conn = db.Conn.getInstance();
	           stmt = conn.createStatement();
	           String sql = "delete from caigou where cid='"+cid+"'";
	           db.DB.executeUpdate(sql, conn, stmt);

	       } catch (SQLException ex) {
	           ex.printStackTrace();
	       } finally {
	           DB.close(null, stmt, conn);
	       }
	   }
	
	public static void update(Cai cai) {
	       Connection conn = null;
	       Statement stmt = null;

	       try {
	           conn = db.Conn.getInstance();
	           stmt = conn.createStatement();
	           String sql = "update caigou set isnot='"+cai.isnot()+
	                        "',price="+cai.getPrice()+
	                        ",amount="+cai.getAmount()+
	                        ",type='"+cai.getType()+
	                        "',spec='"+cai.getSpec()+
	                        "',unit='"+cai.getUnit()+	                        
	                        "',caitime='"+cai.getCaitime()+
	                        "',username='"+cai.getUsername()+
	                        "',provider='"+cai.getProvider()+
	                        "',expiredate="+cai.getExpiredate()+
	                        " where drugname='"+cai.getDrugname()+"'";
	           System.out.println(sql);
	           DB.executeUpdate(sql, conn, stmt);

	       } catch (SQLException ex) {
	           ex.printStackTrace();
	       } finally {
	           DB.close(null, stmt, conn);
	       }
	   }
	
	public static void update2(String cid,int amount){
		Connection conn = null;
	       Statement stmt = null;

	       try {
	           conn = db.Conn.getInstance();
	           stmt = conn.createStatement();
	           
	           String sql = "update caigou set amount = "+amount+"where cid = '"+cid+"' ";
	           System.out.println(sql);
	           DB.executeUpdate(sql, conn, stmt);

	       } catch (SQLException ex) {
	           ex.printStackTrace();
	       } finally {
	           DB.close(null, stmt, conn);
	       }
	   }
	
	
	public static void update(String drugname1 ) {
	       Connection conn = null;
	       Statement stmt = null;

	       try {
	           conn = db.Conn.getInstance();
	           stmt = conn.createStatement();
	           /*String sql = "update caigou set isnot='"+(i== true ? 1 : 0)+
	                        " where drugname='"+drugname1+"'";*/
	           String sql = "update caigou set isnot = "+1+"where drugname = '"+drugname1+"' ";
	           System.out.println(sql);
	           DB.executeUpdate(sql, conn, stmt);

	       } catch (SQLException ex) {
	           ex.printStackTrace();
	       } finally {
	           DB.close(null, stmt, conn);
	       }
	   }
	
	 public static void loadTable(DefaultTableModel dataTable){
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
	                String type = rs.getString("type");
	                String spec = rs.getString("spec");
	                String unit = rs.getString("unit");
	                //String producer = rs.getString("producer");
	                String caitime = rs.getString("caitime");
	                String username = rs.getString("username");
	                String provider = rs.getString("provider");
	                int expiredate = rs.getInt("expiredate");
	                boolean isnot = rs.getBoolean("isnot");

	                Vector row = new Vector();
	                //row.add(new Integer(++i));
	                row.add(new Integer(cid));
	                //row.add(barcode);
	                row.add(drugname);
	                row.add(price);
	                row.add(amount);
	                row.add(type);
	                row.add(spec);
	                row.add(unit);
	              
	                row.add(caitime);
	                row.add(username);
	                row.add(provider);
	                row.add(expiredate);
	                row.add(isnot);

	                dataTable.addRow(row);
	            }


	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            DB.close(rs, stmt, conn);
	        }
	    }
	   
	   public static void loadTable2(DefaultTableModel dataTable,String good){
	        dataTable.setRowCount(0);

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            String sql = "select * from caigou where drugname = '"+good+"'";
	            rs = db.DB.executeQuery(sql, conn, stmt);

	            int i = 0;
	            while (rs.next()) {
	                //int rkid = rs.getInt("rkid");
	                int cid = rs.getInt("cid");
	                String drugname = rs.getString("drugname");
	                float price = rs.getFloat("price");
	                int amount = rs.getInt("amount");
	                String type = rs.getString("type");
	                String spec = rs.getString("spec");
	                String unit = rs.getString("unit");
	                //String producer = rs.getString("producer");
	                String caitime = rs.getString("caitime");
	                String username = rs.getString("username");
	                String provider = rs.getString("provider");
	                int expiredate = rs.getInt("expiredate");
	                boolean isnot = rs.getBoolean("isnot");

	                Vector row = new Vector();
	                row.add(new Integer(++i));
	                row.add(new Integer(cid));
	                //row.add(barcode);
	                row.add(drugname);
	                row.add(price);
	                row.add(amount);
	                row.add(type);
	                row.add(spec);
	                row.add(unit);
	                //row.add(producer);
	                row.add(caitime);
	                row.add(username);
	                row.add(provider);
	                row.add(expiredate);
	                row.add(isnot);

	                dataTable.addRow(row);
	            }


	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            DB.close(rs, stmt, conn);
	        }
	    }
	   
	   public static void loadTable2(javax.swing.table.DefaultTableModel dataTable,int cid1){
	        dataTable.setRowCount(0);

	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            String sql = "select * from caigou where cid = "+cid1+"";
	            rs = db.DB.executeQuery(sql, conn, stmt);

	            int i = 0;
	            while (rs.next()) {
	                //int rkid = rs.getInt("rkid");
	                int cid = rs.getInt("cid");
	                String drugname = rs.getString("drugname");
	                float price = rs.getFloat("price");
	                int amount = rs.getInt("amount");
	                String type = rs.getString("type");
	                String spec = rs.getString("spec");
	                String unit = rs.getString("unit");
	                //String producer = rs.getString("producer");
	                String caitime = rs.getString("caitime");
	                String username = rs.getString("username");
	                String provider = rs.getString("provider");
	                int expiredate = rs.getInt("expiredate");
	                boolean isnot = rs.getBoolean("isnot");

	                Vector row = new Vector();
	                row.add(new Integer(++i));
	                row.add(new Integer(cid));
	                //row.add(barcode);
	                row.add(drugname);
	                row.add(price);
	                row.add(amount);
	                row.add(type);
	                row.add(spec);
	                row.add(unit);
	                //row.add(producer);
	                row.add(caitime);
	                row.add(username);
	                row.add(provider);
	                row.add(expiredate);
	                row.add(isnot);

	                dataTable.addRow(row);
	            }


	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            DB.close(rs, stmt, conn);
	        }
	    }
	   
	   public static void loadTable2(javax.swing.table.DefaultTableModel dataTable,String good,int cid1){
		    dataTable.setRowCount(0);

		    Connection conn = null;
		    Statement stmt = null;
		    ResultSet rs = null;

		    try {
		        conn = db.Conn.getInstance();
		        stmt = conn.createStatement();
		        String sql = "select * from caigou where cid ="+cid1+" and drugname ='"+good+"'";
		        rs = db.DB.executeQuery(sql, conn, stmt);

		        int i = 0;
		        while (rs.next()) {
		            //int rkid = rs.getInt("rkid");
		            int cid = rs.getInt("cid");
		            String drugname = rs.getString("drugname");
		            float price = rs.getFloat("price");
		            int amount = rs.getInt("amount");
		            String type = rs.getString("type");
		            String spec = rs.getString("spec");
		            String unit = rs.getString("unit");
		            //String producer = rs.getString("producer");
		            String caitime = rs.getString("caitime");
		            String username = rs.getString("username");
		            String provider = rs.getString("provider");
		            int expiredate = rs.getInt("expiredate");
		            boolean isnot = rs.getBoolean("isnot");
		           // boolean isnot = rs.getBoolean(1); ·µ»ØµÄÊÇtrue

		            Vector row = new Vector();
		            row.add(new Integer(++i));
		            row.add(new Integer(cid));
		            //row.add(barcode);
		            row.add(drugname);
		            row.add(price);
		            row.add(amount);
		            row.add(type);
		            row.add(spec);
		            row.add(unit);
		            //row.add(producer);
		            row.add(caitime);
		            row.add(username);
		            row.add(provider);
		            row.add(expiredate);
		            row.add(isnot);

		            dataTable.addRow(row);
		        }


		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    } finally {
		        DB.close(rs, stmt, conn);
		    }
		}

	   public static int getamount(String cid){
		   Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;
int i= 0;
	        
	        try {
	            conn = Conn.getInstance();
	            stmt = conn.createStatement();
	            
	            String sql = "select * from caigou where cid='" + cid + "'";
	            rs = DB.executeQuery(sql, conn, stmt);
	            if (rs.next()) {
	                
                     i = rs.getInt("amount");
                    }
	            }catch (SQLException ex) {
        	            ex.printStackTrace();}
	        return i;
	   }
	   
	   public static Cai getCaiBycode(String code) {
	        Connection conn = null;
	        Statement stmt = null;
	        ResultSet rs = null;

	        Cai vo = null;
	        try {
	            conn = Conn.getInstance();
	            stmt = conn.createStatement();
	            //rkid,barcode,drugname,price,amount,type,spec,unit,producer,intime,username,provider,expiredate
	            String sql = "select * from caigou where cid='" + code + "'";
	            rs = DB.executeQuery(sql, conn, stmt);

	            if (rs != null && rs.next()) {
	                vo = new Cai();
	                //vo.setRkid(rs.getInt("rkid"));
	                vo.setCid(rs.getInt("cid"));
	                vo.setDrugname(rs.getString("drugname"));
	                vo.setPrice(rs.getFloat("price"));
	                vo.setAmount(rs.getInt("amount"));
	                vo.setType(rs.getString("type"));
	                vo.setSpec(rs.getString("spec"));
	                vo.setUnit(rs.getString("unit"));
	               // vo.setProducer(rs.getString("producer"));
	                vo.setCaitime(rs.getString("Caitime"));
	                vo.setUsername(rs.getString("username"));
	                vo.setProvider(rs.getString("provider"));
	                vo.setExpiredate(rs.getInt("expiredate"));
	                vo.setisnot(rs.getBoolean("isnot"));
	            }

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            DB.close(rs, stmt, conn);
	        }
	        return vo;

	    }

public static void loadTable2(javax.swing.table.DefaultTableModel dataTable){
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
            String type = rs.getString("type");
            String spec = rs.getString("spec");
            String unit = rs.getString("unit");
            //String producer = rs.getString("producer");
            String caitime = rs.getString("caitime");
            String username = rs.getString("username");
            String provider = rs.getString("provider");
            int expiredate = rs.getInt("expiredate");
            boolean isnot = rs.getBoolean("isnot");

            Vector row = new Vector();
            row.add((++i));
            row.add((cid));
            //row.add(barcode);
            row.add(drugname);
            row.add(price);
            row.add(amount);
            row.add(type);
            row.add(spec);
            row.add(unit);
            //row.add(producer);
            row.add(caitime);
            row.add(username);
            row.add(provider);
            row.add(expiredate);
            row.add(isnot);

            dataTable.addRow(row);
        }


    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        DB.close(rs, stmt, conn);
    }
}
}
