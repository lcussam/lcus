<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>数据库连接</title>
</head>
<body>
<form id="form1" name="form1" method="post" action="checklogin.jsp">
  用户名:
  <input type="text" name="username" />
  <p>密码:
     <input type="text" name="password" />
  </p>
  <p>
    <input type="submit" name="Submit" value="提交" />
  </p>
  </form>  
</body>
</html>