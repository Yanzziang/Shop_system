package dao;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import vo.Drug;

import java.util.ArrayList;
import java.util.Vector;
import java.sql.ResultSet;
import db.Conn;
import db.DB;
import frame.*;

public class DrugDao {
    
	
	
	//增加
	public static void add(Drug drug) {
       Connection conn = null;
       Statement stmt = null;
       float i = 0;
       try {
           conn = Conn.getInstance();
           stmt = conn.createStatement();
           String sql = "insert into ruku(barcode,drugname,sprice,price,amount,type,spec,unit,intime,username,provider,expiredate) values('"
                        +drug.getBarcode()+"','"
                        +drug.getDrugname()+"',"+i+","
                        +drug.getPrice()+","
                        +drug.getAmount()+",'"
                        +drug.getType()+"','"
                        +drug.getSpec()+"','"
                        +drug.getUnit()+"','"
                        +drug.getIntime()+"','"
                        +drug.getUsername()+"','"
                        +drug.getProvider()+"',"
                        +drug.getExpiredate()+")";
           DB.executeUpdate(sql, conn, stmt);
           


       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           DB.close(null, stmt, conn);
       }
   }
	
	public static void delete1(String name) {
	       Connection conn = null;
	       Statement stmt = null;

	       try {
	           conn = db.Conn.getInstance();
	           stmt = conn.createStatement();
	           String sql = "delete from ruku where drugname='"+name+"'";
	           db.DB.executeUpdate(sql, conn, stmt);
	           /*String sql2 = "delete from yujing1 where barcode='"+barcode+"'";
	           db.DB.executeUpdate(sql2, conn, stmt);
	           String sql3 = "delete from ypbf where barcode='"+barcode+"'";
	           db.DB.executeUpdate(sql3, conn, stmt);*/

	       } catch (SQLException ex) {
	           ex.printStackTrace();
	       }}
//删除
   public static void delete(String barcode) {
       Connection conn = null;
       Statement stmt = null;

       try {
           conn = db.Conn.getInstance();
           stmt = conn.createStatement();
           String sql = "delete from ruku where barcode='"+barcode+"'";
           db.DB.executeUpdate(sql, conn, stmt);
           String sql2 = "delete from yujing1 where barcode='"+barcode+"'";
           db.DB.executeUpdate(sql2, conn, stmt);
           String sql3 = "delete from ypbf where barcode='"+barcode+"'";
           db.DB.executeUpdate(sql3, conn, stmt);

       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           DB.close(null, stmt, conn);
       }
   }

   public static ArrayList getbarinruku(){
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    
	    ArrayList g =new ArrayList();
	    try {
	        conn = db.Conn.getInstance();
	        stmt = conn.createStatement();
            int i = 0;
	        String sql = "select * from ruku";
	        rs = stmt.executeQuery(sql);
	        while(rs.next()){
	        	String b = rs.getString("barcode");
	            g.add(i++,b);}
	        
	        
	        }catch (SQLException ex) {
	            ex.printStackTrace();}
	    return g;
	}
   
   public static ArrayList getgoodinruku(){
		Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    ArrayList g =new ArrayList();
	    try {
	        conn = db.Conn.getInstance();
	        stmt = conn.createStatement();
	        
	        int i = 0;
	        String sql = "select * from ruku";
	        rs = stmt.executeQuery(sql);
	        while(rs.next()){
	        	String b = rs.getString("drugname");
	            	g.add(i++,b);}
	        
	        
	        }catch (SQLException ex) {
	            ex.printStackTrace();}
	    return g;
	}
   
   /*public static boolean isbar(String a,ArrayList e){
	   boolean b = false;
	   for(int i =0;i<e.size();i++){
		   String k = e.get(i).toString().trim();
		   if(a.equals(k)){
			   return true;
		   }
		   else{
			   b = false;
		   }
	   }
	   return b;
   }
   
   public static boolean isgood(String a,ArrayList e){
	   boolean b = false;
	   for(int i =0;i<e.size();i++){
		   if(a.equals(e.get(i))){
			   return true;
			   //break;
		   }
		   else{
			   b = false;
		   }
	   }
	   return b;
   }*/
   
   
   
//更新
   public static void update(Drug drug) {
       Connection conn = null;
       Statement stmt = null;

       try {
           conn = db.Conn.getInstance();
           stmt = conn.createStatement();
           String sql = "update ruku set drugname='"+drug.getDrugname()+
                        "',price="+drug.getPrice()+
                        ",amount="+drug.getAmount()+
                        ",type='"+drug.getType()+
                        "',spec='"+drug.getSpec()+
                        "',unit='"+drug.getUnit()+
                        "',intime='"+drug.getIntime()+
                        "',username='"+drug.getUsername()+
                        "',provider='"+drug.getProvider()+
                        "',expiredate="+drug.getExpiredate()+
                        " where barcode='"+drug.getBarcode()+"'";
           System.out.println(sql);
           DB.executeUpdate(sql, conn, stmt);

       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           DB.close(null, stmt, conn);
       }
   }
   
   
   public static void update(String bar,String good,int amount) {
       Connection conn = null;
       Statement stmt = null;

       try {
           conn = db.Conn.getInstance();
           stmt = conn.createStatement();
           String sql = "update ruku set amount = amount + "+amount+" where drugname ='"+good+"'and barcode ='"+bar+"'";
           System.out.println(sql);
           DB.executeUpdate(sql, conn, stmt);

       } catch (SQLException ex) {
           ex.printStackTrace();
       } 
   }
   //---------
   public static int getamount(String barcode){
	   Connection conn = null;
       Statement stmt = null;
       ResultSet rs = null;
       int i = 0;
       try {
           conn = Conn.getInstance();
           stmt = conn.createStatement();
           
           String sql = "select amount from ruku where barcode='" +barcode+ "'";
           rs = DB.executeQuery(sql, conn, stmt);
           
           if(rs.next()){
        	
        	    i = rs.getInt("amount");
        	    
           }
           else{i=0;}
           
           
           
           }catch (SQLException ex) {
               ex.printStackTrace();}
       return i;
   }
   
   /*public static void update(int amount,String barcode,Drug drug){
	   Connection conn = null;
       Statement stmt = null;
       int amount1 = amount+getamount(barcode);
       try {
           conn = db.Conn.getInstance();
           stmt = conn.createStatement();
           String sql = "update ruku set amount = "+amount1+" where barcode='"+barcode+"'";
           System.out.println(sql);
           DB.executeUpdate(sql, conn, stmt);
       }catch (SQLException ex) {
           ex.printStackTrace();}
   }*/

   
   /*public static void getupdate(String barcode , int amount,Drug drug){
	   Connection conn = null;
       Statement stmt = null;
       ResultSet rs = null;
       
      
       try {
           conn = Conn.getInstance();
           stmt = conn.createStatement();
           
           String sql = "select * from ruku where barcode='" +barcode+ "'";
           rs = DB.executeQuery(sql, conn, stmt);
           
           if(rs.next()){
        	   dao.DrugDao.update(amount, barcode,drug);
           }
           else{
        	   dao.DrugDao.add(drug);
           }
           }catch (SQLException ex) {
               ex.printStackTrace();}
           
   }*/
   

//获得条形码
   public static Drug getDrugByBarcode(String barcode) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Drug vo = null;
        try {
            conn = Conn.getInstance();
            stmt = conn.createStatement();
            //rkid,barcode,drugname,price,amount,type,spec,unit,producer,intime,username,provider,expiredate
            String sql = "select * from ruku where barcode='" + barcode + "'";
            rs = DB.executeQuery(sql, conn, stmt);

            if (rs != null && rs.next()) {
                vo = new Drug();
                //vo.setRkid(rs.getInt("rkid"));
                vo.setBarcode(rs.getString("barcode"));
                vo.setDrugname(rs.getString("drugname"));
                vo.setPrice(rs.getFloat("price"));
                vo.setAmount(rs.getInt("amount"));
                vo.setType(rs.getString("type"));
                vo.setSpec(rs.getString("spec"));
                vo.setUnit(rs.getString("unit"));
               // vo.setProducer(rs.getString("producer"));
                vo.setIntime(rs.getString("intime"));
                vo.setUsername(rs.getString("username"));
                vo.setProvider(rs.getString("provider"));
                vo.setExpiredate(rs.getInt("expiredate"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DB.close(rs, stmt, conn);
        }
        return vo;

    }
   
  

   public static void loadTable(javax.swing.table.DefaultTableModel dataTable){
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from ruku order by amount";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
                //String producer = rs.getString("producer");
                String intime = rs.getString("intime");
                String username = rs.getString("username");
                String provider = rs.getString("provider");
                int expiredate = rs.getInt("expiredate");

                Vector row = new Vector();
                //row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(barcode);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                row.add(type);
                row.add(spec);
                row.add(unit);
               // row.add(producer);
                row.add(intime);
                row.add(username);
                row.add(provider);
                row.add(expiredate);

                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DB.close(rs, stmt, conn);
        }
    }

    public static void loadTable(javax.swing.table.DefaultTableModel dataTable, String search){
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from ruku where barcode like '%"+search+"%' or drugname like '%"+search+"%'";
            rs = DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
                //String producer = rs.getString("producer");
                String intime = rs.getString("intime");
                String username = rs.getString("username");
                String provider = rs.getString("provider");
                int expiredate = rs.getInt("expiredate");

                Vector row = new Vector();
                //row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(barcode);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                row.add(type);
                row.add(spec);
                row.add(unit);
               // row.add(producer);
                row.add(intime);
                row.add(username);
                row.add(provider);
                row.add(expiredate);

                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DB.close(rs, stmt, conn);
        }
    }

    public static void loadTable(javax.swing.table.DefaultTableModel dataTable, String date1, String date2) throws
            SQLException {
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "";
            if(date2 == null) {
                sql = "select * from ruku where DATEDIFF(day, intime, getdate())=0";
            } else {
                //sql = "select * from ruku where intime>=#"+date1+"# and intime<=#"+date2+"# order by rkid desc";
                //datediff(day,intime,cast('2010-01-01' as datetime))
                sql = "select * from ruku where datediff(day,intime,cast('"+date1+"' as datetime)) <=0 and datediff(day,intime,cast('"+date2+"' as datetime))>=0 order by rkid desc";
            }

            System.out.println(sql);
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
               // String producer = rs.getString("producer");
                String intime = rs.getString("intime");
                String username = rs.getString("username");
                String provider = rs.getString("provider");
                int expiredate = rs.getInt("expiredate");

                Vector row = new Vector();
                //row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(barcode);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                row.add(type);
                row.add(spec);
                row.add(unit);
              //  row.add(producer);
                row.add(intime);
                row.add(username);
                row.add(provider);
                row.add(expiredate);

                dataTable.addRow(row);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            db.DB.close(rs, stmt, conn);
        }
    }

    public static void loadTable(javax.swing.table.DefaultTableModel dataTable, int f1, int f2) throws
            SQLException {
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from ruku where amount>="+f1+" and amount<="+f2+" order by rkid desc";

            System.out.println(sql);
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                //int rkid = rs.getInt("rkid");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                float price = rs.getFloat("price");
                int amount = rs.getInt("amount");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
               // String producer = rs.getString("producer");
                String intime = rs.getString("intime");
                String username = rs.getString("username");
                String provider = rs.getString("provider");
                int expiredate = rs.getInt("expiredate");

                Vector row = new Vector();
                //row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(barcode);
                row.add(drugname);
                row.add(price);
                row.add(amount);
                row.add(type);
                row.add(spec);
                row.add(unit);
               // row.add(producer);
                row.add(intime);
                row.add(username);
                row.add(provider);
                row.add(expiredate);

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
