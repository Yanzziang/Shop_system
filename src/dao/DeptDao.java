package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import db.Conn;
import db.DB;
import vo.Dept;

public class DeptDao {

	public static void add(Dept dept) throws SQLException{
		
		 Connection conn = null;
	        Statement stmt = null;

	        try {
	            conn = db.Conn.getInstance();
	            stmt = conn.createStatement();
	            String sql = "insert into dept(dept,manage) values('"
	                         +dept.getDept()+"','"+dept.getManage()+"')";
	            System.out.println(sql);
	            db.DB.executeUpdate(sql, conn, stmt);
	        } catch (SQLException ex) {
	            //ex.printStackTrace();
	            throw ex;
	        } 
	}
	
	public static String[] getAllDeptName() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String[] deptnames = null;
        try {
            conn = Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select dept from dept";
            rs = DB.executeQuery(sql, conn, stmt);

            ArrayList<String> rows = new ArrayList<String>();

           while (rs.next()) {
               String name = rs.getString("dept");
               rows.add(name);
           }
           deptnames = new String[rows.size()];
           for(int i=0;i<rows.size();i++) {
               deptnames[i] = rows.get(i);
           }
           return deptnames;
       } catch (SQLException ex) {
           ex.printStackTrace();
       } finally {
           db.DB.close(rs, stmt, conn);
       }
        return null;
    }
	
public static void loadTable(DefaultTableModel table){
		
		table.setRowCount(0);
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try{
			conn = Conn.getInstance();
			stm = conn.createStatement();
			String sql = "select * from dept order by did desc";
			rs = DB.executeQuery(sql, conn, stm);
			//int ii = 0;
			while(rs.next()){
				int did = rs.getInt(1);
				String dept = rs.getString(2);
				String manage = rs.getString(3);
			
				
				Vector row = new Vector();
				//row.add(new Integer(++ii));
				//row.add(pid);
				
				row.add(dept);
				row.add(manage);
				
				table.addRow(row);
			}		
					
		}catch (SQLException ex) {
            ex.printStackTrace();}
	}
}
