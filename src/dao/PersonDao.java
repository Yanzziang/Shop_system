package dao;

import vo.Person;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import vo.Drug;
import java.util.Vector;
import java.sql.ResultSet;
import db.Conn;
import db.DB;
import javax.swing.table.DefaultTableModel;

public class PersonDao {

	public static void add(Person person) throws SQLException{
		
		 Connection conn = null;
	        Statement stmt = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            String sql = "insert into person(pname,age,sex,dept) values('"
	                         +person.getPname()+"','"
	                         +person.getAge()+"','"
	                         + person.getSex() + "','"
	                         +person.getDept()+"')";
	            System.out.println(sql);
	            db.DB.executeUpdate(sql, conn, stmt);
	        } catch (SQLException ex) {
	            //ex.printStackTrace();
	            throw ex;
	        } finally {
	            db.DB.close(null, stmt, conn);
	        }
	}	
	 public static void delete(String pname){
	        Connection conn = null;
	        Statement stmt = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            String sql = "delete from person where pname='" + pname+"'";
	            System.out.println(sql);
	            db.DB.executeUpdate(sql, conn, stmt);
	            

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } 
	    }
	
	public static void loadTable(DefaultTableModel table){
		
		table.setRowCount(0);
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try{
			conn = Conn.getInstance();
			stm = conn.createStatement();
			String sql = "select * from person order by pid desc";
			rs = DB.executeQuery(sql, conn, stm);
			//int ii = 0;
			while(rs.next()){
				int pid = rs.getInt(1);
				String pname = rs.getString(2);
				String age = rs.getString(3);
				String sex = rs.getString(4);
				String dept = rs.getString(5);
				
				Vector row = new Vector();
				//row.add(new Integer(++ii));
				//row.add(pid);
				row.add(pname);
				row.add(age);
				row.add(sex);
				row.add(dept);
				
				table.addRow(row);
			}		
					
		}catch (SQLException ex) {
            ex.printStackTrace();}
	}


public static void loadTable(DefaultTableModel table,String pname){
	
	table.setRowCount(0);
	
	Connection conn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	try{
		conn = Conn.getInstance();
		stm = conn.createStatement();
		String sql = "select * from person where pname = '"+pname+"' order by pid desc";
		rs = DB.executeQuery(sql, conn, stm);
		//int ii = 0;
		while(rs.next()){
			int pid = rs.getInt(1);
			String pname1 = rs.getString(2);
			String age = rs.getString(3);
			String sex = rs.getString(4);
			String dept = rs.getString(5);
			
			Vector row = new Vector();
			//row.add(new Integer(++ii));
			//row.add(pid);
			row.add(pname1);
			row.add(age);
			row.add(sex);
			row.add(dept);
			
			table.addRow(row);
		}		
				
	}catch (SQLException ex) {
        ex.printStackTrace();}
}


public static void loadTable2(DefaultTableModel table,String dept1){
	
	table.setRowCount(0);
	
	Connection conn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	try{
		conn = Conn.getInstance();
		stm = conn.createStatement();
		String sql = "select * from person where dept = '"+dept1+"' order by pid desc";
		rs = DB.executeQuery(sql, conn, stm);
		//int ii = 0;
		while(rs.next()){
			int pid = rs.getInt(1);
			String pname = rs.getString(2);
			String age = rs.getString(3);
			String sex = rs.getString(4);
			String dept = rs.getString(5);
			
			Vector row = new Vector();
			//row.add(new Integer(++ii));
			//row.add(pid);
			row.add(pname);
			row.add(age);
			row.add(sex);
			row.add(dept);
			
			table.addRow(row);
		}		
				
	}catch (SQLException ex) {
        ex.printStackTrace();}
}

public static void loadTable2(DefaultTableModel table,String dept1,String pname1){
	
	table.setRowCount(0);
	
	Connection conn = null;
	Statement stm = null;
	ResultSet rs = null;
	
	try{
		conn = Conn.getInstance();
		stm = conn.createStatement();
		String sql = "select * from person where dept = '"+dept1+"' and pname = '"+pname1+"' order by pid desc";
		rs = DB.executeQuery(sql, conn, stm);
		//int ii = 0;
		while(rs.next()){
			int pid = rs.getInt(1);
			String pname = rs.getString(2);
			String age = rs.getString(3);
			String sex = rs.getString(4);
			String dept = rs.getString(5);
			
			Vector row = new Vector();
			//row.add(new Integer(++ii));
			//row.add(pid);
			row.add(pname);
			row.add(age);
			row.add(sex);
			row.add(dept);
			
			table.addRow(row);
		}		
				
	}catch (SQLException ex) {
        ex.printStackTrace();}
}
}
