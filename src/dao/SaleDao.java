package dao;
import java.util.*;
import vo.*;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import vo.User;
import java.sql.ResultSet;
import java.util.Vector;

public class SaleDao {
    public static void add(String barcode,String drugname,String price,String sprice,String mount,String allmoney,String type,String spec,String unit,String provider,String username) {
       Connection conn = null;
       Statement stmt = null;
       

       try {
           conn = db.Conn.getInstance();
           stmt = conn.createStatement();
           /*String sql = "insert into sale(barcode,drugname,saletype,price,amount,allmoney,type,spec,unit,provider,saletime,username) values('"
                        +barcode+"','"+drugname+"','0',"+price+","+mount+","+allmoney+",'"+type+"','"+spec+"','"+unit+"','"+provider+"',getdate(),'"+username+"')";*/
           String sql = "insert into sale(barcode,drugname,saletype,price,sprice,amount,allmoney,type,spec,unit,provider,saletime,username) values('"
                   +barcode+"','"+drugname+"','0',"+price+","+sprice+","+mount+","+allmoney+",'"+type+"','"+spec+"','"+unit+"','"+provider+"',getdate(),'"+username+"')";
           
           //System.out.println(sql);
           //insert into sale(barcode,drugname,saletype,price,amount,allmoney,type,spec,unit,provider,saletime,username)
           //values('11','≤Ë“∂','0',22.0,1,22.0,'22','22','2','∞Ÿ∂»',now(),'admin')
           db.DB.executeUpdate(sql, conn, stmt);
           String sql2 = "update ruku set amount=amount-"+mount+" where barcode='"+barcode+"'";
           db.DB.executeUpdate(sql2, conn, stmt);
       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           db.DB.close(null, stmt, conn);
       }
    }
    
    
    public static void de_lete(String sid,String barcode){
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "delete from sale where sid=" + sid;
            System.out.println(sql);
            db.DB.executeUpdate(sql, conn, stmt);
            String sql1 = "update ruku set amount=amount+1 where barcode='"+barcode+"'";
            db.DB.executeUpdate(sql1, conn, stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }
    
    public static String getname(String barcode){
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String a = null;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select drugname from ruku where barcode='"+barcode+"'";
            
            rs = db.DB.executeQuery(sql, conn, stmt);
            if(rs.next())
            {
            	a = rs.getString("drugname");
            	
            }
            }catch (SQLException ex) {
                ex.printStackTrace();
            } 
        
            return a;
    }

    public static float getsprice(String barcode){
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float a = 0;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select sprice from ruku where barcode='"+barcode+"'";
            
            rs = db.DB.executeQuery(sql, conn, stmt);
            if(rs.next())
            {
            	a = rs.getFloat("sprice");
            	//System.out.print(a);
            }
            }catch (SQLException ex) {
                ex.printStackTrace();
            } 
        
            return a;
    }
    
    public static void update(String barcode,float sprice){
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "update ruku set sprice = "+sprice+" where barcode='"+barcode+"'";
            System.out.println(sql);
            db.DB.executeUpdate(sql, conn, stmt);
           
        } catch (SQLException ex) {
            ex.printStackTrace();
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
            String sql = "select * from sale order by sid desc";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                String sid = rs.getString("sid");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                String sprice = rs.getString("sprice");
                String price = rs.getString("price");
                String amount = rs.getString("amount");
                String allmoney = rs.getString("allmoney");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
                String provider = rs.getString("provider");
                String saletime = rs.getString("saletime");
                String username = rs.getString("username");


                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(sid);
                row.add(barcode);
                row.add(drugname);
                row.add(price);
                row.add(sprice);
                row.add(amount);
                row.add(allmoney);
                row.add(type);
                row.add(spec);
                row.add(unit);
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

    public static ArrayList getallsale(){
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList a = new ArrayList();
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from sale where DATEDIFF(day, saletime, getdate())=0";
            //System.out.println(sql);
            rs = db.DB.executeQuery(sql, conn, stmt);
            while (rs.next()) {
            	String barcode = rs.getString("barcode");
            	a.add(barcode);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        /*for(int c = 0;c<a.size();c++){
    		System.out.println(a.get(c));
    	}*/
        return a;
    }
    
    public static float getallprice(){
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float i = 0;
        
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select price from sale where DATEDIFF(day, saletime, getdate())=0";
            //System.out.println(sql);
            rs = db.DB.executeQuery(sql, conn, stmt);
            while (rs.next()) {
            	i = i + rs.getFloat("price");
            	
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        /*for(int c = 0;c<a.size();c++){
    		System.out.println(a.get(c));
    	}*/
        return i;
    }
    public static float getallsprice(){
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        float i = 0;
        
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select sprice from sale where DATEDIFF(day, saletime, getdate())=0";
            //System.out.println(sql);
            rs = db.DB.executeQuery(sql, conn, stmt);
            while (rs.next()) {
            	i = i + rs.getFloat("sprice");
            	
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        /*for(int c = 0;c<a.size();c++){
    		System.out.println(a.get(c));
    	}*/
        return i;
    }
    
    public static ArrayList xiaoqu(ArrayList a){
    	
    	
    	/*for(int i = a.size()-1;i>0;i--){
    		if(a.get(i).equals(a.get(i-1))){
    			a.remove(i);
    			
    		}
    	}*/
    	
    	int g = a.size();
    	int i = g - 1;
        int j = g - 2;
    	while(i>=0){
    		while(j>=0){
    			if(a.get(i).equals(a.get(j))){
    				a.remove(j);
    				i--;
    				
    			}
    			j--;
    		}
    		i--;
    	}
    	
    	/*for(int c = 0;c<a.size();c++){
    		System.out.println(a.get(c));
    	}*/
    	return a;
    	
    }
    
    public static ArrayList amount(ArrayList a){
    	Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList l = new ArrayList();
        
        int j =0;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            for(j = 0;j<a.size();j++){
             int i =0;
                String sql = "select amount from sale where barcode='"+a.get(j)+"'";
                rs = stmt.executeQuery(sql);
                 while(rs.next()){
            	 i = i + rs.getInt("amount");
                 }
                 l.add(j, i);
            }
           
            
            /*for(int c = 0;c<l.size();c++){
        		System.out.println(l.get(c));
        	}*/
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
            return l;
    }
    
    public static Best best(ArrayList a,ArrayList l){
    	int max = 0;
    	for(int i=0;i<l.size();i++){
    		if(Integer.parseInt(String.valueOf(l.get(max)))<=Integer.parseInt(String.valueOf(l.get(i)))){
    			max = i;
    			
    		}
    		
    	}
    	Best best = new Best();
    	best.setAmount(Integer.parseInt(String.valueOf(l.get(max))));
    	best.setBarcode(String.valueOf(a.get(max)));
    	return best;
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
            System.out.println(sql);
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                String sid = rs.getString("sid");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                String sprice = rs.getString("sprice");
                String price = rs.getString("price");
                String amount = rs.getString("amount");
                String allmoney = rs.getString("allmoney");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
                String provider = rs.getString("provider");
                String saletime = rs.getString("saletime");
                String username = rs.getString("username");


                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(sid);
                row.add(barcode);
                row.add(drugname);
                row.add(price);
                row.add(sprice);
                row.add(amount);
                row.add(allmoney);
                row.add(type);
                row.add(spec);
                row.add(unit);
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



    public static void loadTable(javax.swing.table.DefaultTableModel dataTable, String date1, String date2) throws SQLException{
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            //String sql = "select * from sale where DATEDIFF('d',"+date1+", saletime)>=0 and DATEDIFF('d',saletime, "+date2+")>0 order by sid desc";
            //String sql = "select * from sale where saletime>=#"+date1+"# and saletime<=#"+date2+"# order by sid desc";
            //where datediff(day,intime,cast('"+date1+"' as datetime)) <=0 and datediff(day,intime,cast('"+date2+"' as datetime))>=0
            String sql = "select * from sale where datediff(day,saletime,cast('"+date1+"' as datetime)) <=0 and datediff(day,saletime,cast('"+date2+"' as datetime))>=0 order by sid desc";
            System.out.println(sql);
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                String sid = rs.getString("sid");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                String sprice = rs.getString("sprice");
                String price = rs.getString("price");
                String amount = rs.getString("amount");
                String allmoney = rs.getString("allmoney");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
                String provider = rs.getString("provider");
                String saletime = rs.getString("saletime");
                String username = rs.getString("username");


                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(sid);
                row.add(barcode);
                row.add(drugname);
                row.add(price);
                row.add(sprice);
                row.add(amount);
                row.add(allmoney);
                row.add(type);
                row.add(spec);
                row.add(unit);
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

    public static void loadTableByBarName(javax.swing.table.DefaultTableModel dataTable, String barname){
        dataTable.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from sale where barcode like '%"+barname+"%' or drugname like '%"+barname+"%'";
            System.out.println(sql);
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                String sid = rs.getString("sid");
                String barcode = rs.getString("barcode");
                String drugname = rs.getString("drugname");
                String sprice = rs.getString("sprice");
                String price = rs.getString("price");
                String amount = rs.getString("amount");
                String allmoney = rs.getString("allmoney");
                String type = rs.getString("type");
                String spec = rs.getString("spec");
                String unit = rs.getString("unit");
                String provider = rs.getString("provider");
                String saletime = rs.getString("saletime");
                String username = rs.getString("username");


                Vector row = new Vector();
                row.add(new Integer(++i));
                //row.add(new Integer(id));
                row.add(sid);
                row.add(barcode);
                row.add(drugname);
                row.add(price);
                row.add(sprice);
                row.add(amount);
                row.add(allmoney);
                row.add(type);
                row.add(spec);
                row.add(unit);
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



}
