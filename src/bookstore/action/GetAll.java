package bookstore.action;

import java.sql.ResultSet;
import java.util.List; 

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bookstore.model.*;

public class GetAll {
	
	public List<Book> getAllBook()
	{
		List<Book> books = null;
		Connection conn = (Connection) MysqlJDBC.getConnection();
		String sql = "select * from book";
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Book book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setISBN(rs.getString("ISBN"));
				book.setPrice(rs.getFloat("price"));
				System.out.print(rs.getString("title"));
				books.add(book);
			}
			
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MysqlJDBC.closeConnection(conn);
		}
		
		return books;
	}

}
