package dao;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import db.Conn;
import db.DB;
import vo.Cai;
import vo.Drug;

import java.util.*;
import java.sql.ResultSet;
import vo.*;
import javax.swing.table.DefaultTableModel;
public class YuDao {

	public static void add(Yu yu){
		Connection conn = null;
		Statement stmt = null;
		//ResultSet rs = null;
		try{
			conn = Conn.getInstance();
            stmt = conn.createStatement();
            
            String sql = "insert into yujing1(barcode,drugname,amount,samount,username,provider) values('" +
                         yu.getBarcode()+"','"+yu.getDrugname()+"',"+yu.getAmount()+","+yu.getSamount()+",'"+yu.getUsername()
                         +"','" +yu.getProvider()+"')";
            db.DB.executeUpdate(sql, conn, stmt);
            
		}catch (SQLException ex) {
	           ex.printStackTrace();
	       }
	}
	public static void update(int amount,String barcode,Yu yu){
		   Connection conn = null;
	       Statement stmt = null;
	       
	       try {
	           conn = db.Conn.getInstance();
	           stmt = conn.createStatement();
	           String sql = "update yujing1 set amount = "+amount+" where barcode='"+barcode+"'";
	           System.out.println(sql);
	           DB.executeUpdate(sql, conn, stmt);
	       }catch (SQLException ex) {
	           ex.printStackTrace();}
	   }
	
	public static void getupdate(String barcode , int amount,Yu yu){
		   Connection conn = null;
	       Statement stmt = null;
	       ResultSet rs = null;
	       
	      
	       try {
	           conn = Conn.getInstance();
	           stmt = conn.createStatement();
	           
	           String sql = "select * from yujing1 where barcode='" +barcode+ "'";
	           rs = DB.executeQuery(sql, conn, stmt);
	           
	           if(rs.next()){
	        	   dao.YuDao.update(amount, barcode,yu);
	           }
	           else{
	        	   dao.YuDao.add(yu);
	           }
	           }catch (SQLException ex) {
	               ex.printStackTrace();}
	           
	   }
	
public static ArrayList getBar(){
	Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    ArrayList e = new ArrayList();
    int i = 0;
    int j =0;
    try {
        conn = db.Conn.getInstance();
        stmt = conn.createStatement();
        String sql = "select * from yujing1";
        rs = stmt.executeQuery(sql);
       while(rs.next()){
        	e.add(rs.getString("barcode"));
        	}
        
        }catch (SQLException ex) {
            ex.printStackTrace();}
    return e;
        
}

public static ArrayList getamountinruku(ArrayList e){
	Connection conn = null;
    Statement stmt = null;
    
    ArrayList g =new ArrayList();
    try {
        conn = db.Conn.getInstance();
        stmt = conn.createStatement();
        int i = 0;
        //Object k = e.get(i);
        
        for(i=0;i<e.size();i++){
        	ResultSet rs = null;
        	String sql = "select amount from ruku where barcode='" +e.get(i).toString()+ "'";
        	rs = stmt.executeQuery(sql);
        	if(rs.next()){
            	g.add(i,rs.getInt("amount"));}
        }
        
        }catch (SQLException ex) {
            ex.printStackTrace();}
    return g;
}

public static void update(ArrayList e1,ArrayList e2){
	Connection conn = null;
    Statement stmt = null;
    try {
        conn = db.Conn.getInstance();
        stmt = conn.createStatement();
        int i = 0;
        
        //for(i=0;i<e2.size();i++)
        while(i<e2.size())
        {
        	String sql = "update yujing1 set samount ="+e1.get(i)+"where barcode ='"+e2.get(i).toString()+"'";
        	i++;
        	System.out.println(sql);
	           stmt.executeUpdate(sql);
        	}
        }catch (SQLException ex) {
	           ex.printStackTrace();}
}
	
	
	public static void loadTable(DefaultTableModel table){
		
		table.setRowCount(0);

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from yujing1 order by amount";
            rs = db.DB.executeQuery(sql, conn, stmt);
            int i = 0;
           
            while (rs.next()) {
            	String bar = rs.getString("barcode");
            	
            	
            	/*String sql2 = "select amount from ruku where barcode ='"+bar+"'";
            	rs2 = db.DB.executeQuery(sql, conn, stmt);
            	
            	smount = rs2.getInt("amount");*/
            	/*String sql2 = "select amount from ruku where barcode='" + bar + "'";
                rs2 = DB.executeQuery(sql, conn, stmt);
               
                if (rs2 != null && rs2.next()) {
                    
                    //vo.setRkid(rs.getInt("rkid"));
                   int smount = rs2.getInt("amount");
 
                }*/
                
                
            	int smount = rs.getInt("samount");
            	String name = rs.getString("drugname");
            	int mount = rs.getInt("amount");
            	String userid = rs.getString("username");
            	String pro = rs.getString("provider");
            	
            	if(smount <= mount){
            	Vector row = new Vector();
            	row.add(++i);
            	row.add(bar);
            	row.add(name);
            	row.add(mount);
            	row.add(smount);
            	row.add(userid);
            	row.add(pro);
            	
            	table.addRow(row);}
            	
            }
            
            }catch (SQLException ex) {
	               ex.printStackTrace();}
		
	}
}
