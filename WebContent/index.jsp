
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>
<%@ page import="bookstore.model.*"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=uft-8">
<title>LIWA Book Store</title>
</head>
<body>
	<center>
		<jsp:include page="head.jsp"></jsp:include>
		
		<%
		List<Book> list = (List<Book>) request.getAttribute("booklist");
		%>

<!-- 		<table border="1" width="60%">
			<tr>
				<td>书名</td>
				<td>ISBN</td>
				<td>价格</td>
				<td></td>
			</tr> -->

			<%
				if(list.isEmpty())
				{
					out.println("对不起！目前还没有任何图书！");
				}
				else{
					Book b = new Book(); 
					for(int i = 0;i < list.size(); i++)
					{
						b = list.get(i);
			%>
				<tr>
					<td><%=b.getTitle() %></td>
				</tr>
			<%
					}
				}
			%>

		<%-- 	<c:forEach var="book" items="${books}">
				<tr>
					<td>${book.title}</td>
					<td>${book.ISBN}</td>
					<td>${book.price}</td>
					<td><a href="#">加入购物车</a></td>
				</tr>
			</c:forEach>
 --%>		
<!--  </table> -->


		<%-- 	<%
	Connection conn = MysqlJDBC.getConnection();
	String sql = "select * from book";
	
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			out.println("<p>"+rs.getString("title")+"</p>");
		}
		
		ps.close();
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		MysqlJDBC.closeConnection(conn);
	}
	%>
 --%>
 

		<jsp:include page="foot.jsp"></jsp:include>
	</center>
</body>
</html>