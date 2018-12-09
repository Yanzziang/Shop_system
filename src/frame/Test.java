package frame;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * <p>Title: 医药销售管理系统</p>
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
public class Test {
    public Test() {
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        conn = db.Conn.getInstance();
        stmt = conn.createStatement();
        String sql = "select DATEDIFF('d', saletime, Now()) as t1,saletime from sale where DATEDIFF('d', '2001-1-1', Now())>0 order by sid desc";
        rs = db.DB.executeQuery(sql, conn, stmt);
        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
        db.DB.close(rs, stmt, conn);
    }
}
