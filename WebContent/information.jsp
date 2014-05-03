<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bookstore.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LIWA Book Store--用户信息</title>
</head>
<body>
	<center>
		<jsp:include page="head.jsp"></jsp:include>
		<h3>用户信息</h3>
		<div class="div3">
			<%
				// 获取提示信息
				String info = (String) request.getAttribute("info");
				// 如果提示信息不为空，则输出提示信息
				if (info != null) {
					out.println(info);
					}
				// 获取登录的用户信息
				User user = (User) session.getAttribute("user");
				// 判断用户是否登录
				if (user != null) {
			%>
			<table align="center" width="350" border="1" height="200" bordercolor="#E8F4CC">
				<tr>
					<td align="center" colspan="2"><span
						style="font-weight: bold; font-size: 18px;"><%=user.getName()%></span>
						登录成功！</td>
				</tr>
			</table> 
			<%
				} else {
					out.println("<br>对不起，您还没有登录！");
				}
			%>
		</div>
	<br/><br/>
	<jsp:include page="foot.jsp"></jsp:include>
	</center>
</body>
</html>