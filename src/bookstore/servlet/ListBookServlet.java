package bookstore.servlet;

import java.io.IOException; 
import java.sql.ResultSet;
import java.util.List;   
import javax.servlet.ServletException; 
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bookstore.model.Book;
import bookstore.model.MysqlJDBC;
import bookstore.model.User;
import bookstore.action.*;

public class ListBookServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			request.setAttribute("booklist", books);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
