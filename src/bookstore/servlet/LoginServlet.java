package bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.model.User;
import bookstore.action.UserAction;

public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//前台得到用户的输入
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserAction userAction = new UserAction();	
			
		if(userAction.userIsExist(username)){
			User user = userAction.login(username, password);
			request.getSession().setAttribute("user", user);
		//	request.getRequestDispatcher("information.jsp").forward(request, response);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else{
	//		request.setAttribute("info", "该用户不存在！");
			request.getRequestDispatcher("information.jsp").forward(request, response);
		}
	}


}
