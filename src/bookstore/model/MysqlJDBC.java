package bookstore.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class MysqlJDBC {
	
	public static void main(){
		getConnection();
	}
	
	public static Connection getConnection(){
		
		Connection connect = null;
		
	    try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
///		     System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
//		      System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/BookStore","root","12345678");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

//		      System.out.println("Success connect Mysql server!");
//		      Statement stmt = (Statement) connect.createStatement();
//		      ResultSet rs = stmt.executeQuery("select * from user");
//		                                                              //user 为你表的名称
//		while (rs.next()) {
//		        System.out.println(rs.getString("username"));
//		      }
		    }
		    catch (Exception e) {
//		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
		    
		    return connect;
	}

	public static void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
