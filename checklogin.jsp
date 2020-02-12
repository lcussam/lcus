<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数据库连接</title>
</head>
<body>
<%
   String username=new String(request.getParameter("username").getBytes("ISO8859_1"),"GBK");
   String password=new String(request.getParameter("password").getBytes("ISO8859_1"),"GBK");
   try
   {
	   Class.forName("com.mysql.jdbc.Driver");
	   String url="jdbc:mysql://localhost:3306/db_01?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowPublicKeyRetrieval=true";

	   String usename="root";
	   String psw="liaoyuxuan";
	   Connection conn=DriverManager.getConnection(url,usename,psw);
	   System.out.print(conn);
	   if(conn!=null)
	   {
		   String sql="select * from tb_user where UName='"+username+"'and Pwd='"+password+"'";
		   Statement stmt=conn.createStatement();
		   ResultSet rs=stmt.executeQuery(sql);
		   if(rs.next())
		   {
			   
			   response.sendRedirect("home.jsp");
			  
		   }
		   else
		   {
			   out.print("用户名或密码错误，清重新输入!");
			   %>
			  <a href="javascript:history.back()">返回</a>
			   <%
		   }
		   out.print("数据库连接成功!");
		   conn.close();
	   }
	   else
	   {
		   out.println("数据库连接失败!");
	   }
   }
   catch (ClassNotFoundException e)
   {
	   e.printStackTrace();
   }
   catch (SQLException e)
   {
	   e.printStackTrace();
   }
   %>
</body>
</html>