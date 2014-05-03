package bookstore.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.model.User;
import bookstore.action.UserAction;

public class RegServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		UserAction userAction = new UserAction();
		
		if(username != null && !username.isEmpty()){
			if(!userAction.userIsExist(username)){
				User user = new User();		
				user.setName(username);	
				user.setPassword(password);
				user.setEmail(email);
				userAction.saveUser(user);	
				request.setAttribute("info", "恭喜，注册成功！<br>");
			}else{
				request.setAttribute("info", "错误：该用户已存在！");
			}
		}
		request.getRequestDispatcher("information.jsp").forward(request, response);
	}


}
