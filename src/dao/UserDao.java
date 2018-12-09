package dao;

import vo.User;
import java.sql.*;
import java.util.Vector;
import db.*;

public class UserDao {
	//登录
    public static User login(String username, String userpass) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        User user = null;
        try {
            conn = Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from yonghu where username='" + username +"' and userpass='" + userpass + "'";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                user = new User();
                //user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setUserpass(rs.getString("userpass"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setBirth(rs.getString("birth"));
                user.setIdcard(rs.getString("idcard"));
                user.setAddr(rs.getString("addr"));
                user.setPhone(rs.getString("phone"));
                user.setRemark(rs.getString("remark"));
                user.setP1(rs.getBoolean("p1"));
                user.setP2(rs.getBoolean("p2"));
                user.setP3(rs.getBoolean("p3"));
                user.setP4(rs.getBoolean("p4"));
                user.setP5(rs.getBoolean("p5"));
                //user.setP6(rs.getBoolean("p6"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } /*finally {
            db.DB.close(rs, stmt, conn);
        }*/
        return user;
    }
//添加用户
    public static void add(User user) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conn.getInstance();
            stmt = conn.createStatement();
            //(user.isP1() == true ? 1 : 0)
            String sql = "insert into yonghu(username,userpass,name,sex,birth,idcard,addr,phone,remark,p1,p2,p3,p4,p5) values('" +
                         user.getUsername() + "','" +user.getUserpass()+ "','" +user.getName()+
                         "','"+user.getSex()+"','"+user.getBirth()+"','"+user.getIdcard()+
                         "','"+user.getAddr()+"','"+user.getPhone()+"','"+user.getRemark()+
                         "',"+(user.isP1() == true ? 1 : 0)+"," + (user.isP2() == true ? 1 : 0)+","+(user.isP3() == true ? 1 : 0)+","+(user.isP4() == true ? 1 : 0)+","+(user.isP5() == true ? 1 : 0)+")";
            //System.out.println(sql);
            stmt.executeUpdate(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
            //System.out.println(e) 打印异常    
            //ex.printStackTrace();后者也是打印出异常，但是它还将显示出更深的调用信息
            throw ex;
        } /*finally {
            db.DB.close(rs, stmt, conn);
        }/*/
    }

    public static void delete(String username){
        Connection conn = null;
        Statement stmt = null;
       

        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
          String sql = "delete from yonghu where username='"+username+"'";
            db.DB.executeUpdate(sql, conn, stmt);

        } catch (SQLException ex) {
            ex.printStackTrace();
        } /*finally {
            db.DB.close(rs, stmt, conn);
        }*/
    }


    public static void modify(User user) throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "update yonghu set userpass='" +user.getUserpass()+
                         "',name='"+user.getName()+
                         "',sex='"+user.getSex()+
                         "',birth='"+user.getBirth()+
                         "',idcard='"+user.getIdcard()+
                         "',addr='"+user.getAddr()+
                         "',phone='"+user.getPhone()+
                         "',remark='"+user.getRemark()+
                         "',p1="+(user.isP1() == true ? 1 : 0)+
                         ",p2="+(user.isP2() == true ? 1 : 0)+
                         ",p3="+(user.isP3() == true ? 1 : 0)+
                         ",p4="+(user.isP4() == true ? 1 : 0)+
                         ",p5="+(user.isP5() == true ? 1 : 0)+
                         " where username='"+ user.getUsername()+"'";
            db.DB.executeUpdate(sql, conn, stmt);

        } catch (SQLException ex) {
            //ex.printStackTrace();
            throw ex;
        } finally {
            db.DB.close(null, stmt, conn);
        }
    }

    public static Vector<String> getUserNames() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Vector rows = new Vector();
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from yonghu";
            rs = db.DB.executeQuery(sql, conn, stmt);

            int i = 0;
            while (rs.next()) {
                String row = rs.getString("username");
                rows.add(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(rs, stmt, conn);
        }
        return rows;//返回一个动态数组
    }

    public static User getUserByName(String username) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        User user = new User();
        //User user = null;
        try {
            conn = db.Conn.getInstance();
            stmt = conn.createStatement();
            String sql = "select * from yonghu where username='" + username + "'";
            rs = db.DB.executeQuery(sql, conn, stmt);

            if (rs != null && rs.next()) {
               
                user.setUsername(rs.getString("username"));
                user.setUserpass(rs.getString("userpass"));
                user.setName(rs.getString("name"));
                user.setSex(rs.getString("sex"));
                user.setBirth(rs.getString("birth"));
                user.setIdcard(rs.getString("idcard"));
                user.setAddr(rs.getString("addr"));
                user.setPhone(rs.getString("phone"));
                user.setRemark(rs.getString("remark"));
                user.setP1(rs.getBoolean("p1"));
                user.setP2(rs.getBoolean("p2"));
                user.setP3(rs.getBoolean("p3"));
                user.setP4(rs.getBoolean("p4"));
                user.setP5(rs.getBoolean("p5"));
                //user.setP6(rs.getBoolean("p6"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            db.DB.close(rs, stmt, conn);
        }
        return user;

    }
    
   /* public String[] getallusertype(){
    	
    } */
    
}
