<?xml version="1.0" encoding="utf-8" ?>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>LIWA Book Store--用户注册</title>
<script type="text/javascript">
	    	function reg(form){
	        	if(form.username.value == ""){
	        		alert("用户不能为空！");
	        		return false;
	        	}
	        	if(form.password.value == ""){
	        		alert("密码不能为空！");
	        		return false;
	        	}
	        	if(form.repassword.value == ""){
	        		alert("确认密码不能为空！");
	        		return false;
	        	}
	        	if(form.password.value != form.repassword.value){
	        		alert("两次密码输入不一致！");
	        		return false;
	        	}
	        	if(form.email.value == ""){
	        		alert("电子邮箱不能为空！");
	        		return false;
	        	}
	    	}
	    </script>
</head>
<body>
	<center>
		<jsp:include page="head.jsp"></jsp:include>
		<h3>用户注册</h3>
		<form action="RegServlet" method="post" onsubmit="return reg(this);">
			<table align="center" width="450" border="0">
				<tr>
					<td align="right">用户名：</td>
					<td><input type="text" name="username"/></td>
				</tr>
				<tr>
					<td align="right">密 码：</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td align="right">确认密码：</td>
					<td><input type="password" name="repassword"/></td>
				</tr>
				<tr>
					<td align="right">电子邮箱：</td>
					<td><input type="text" name="email"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="注 册"/> 
					<input type="reset" value="重 置"/></td>
				</tr>
			</table>
		</form>
		<jsp:include page="foot.jsp"></jsp:include>
	</center>
</body>
</html>