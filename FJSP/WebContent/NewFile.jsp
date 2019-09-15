<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入界面</title>
</head>
<body>
<center>
<h2>用户登入</h2>
<form action="receive.jsp"method="post">
账号:<input type="text" name="Rdname"/>
<br/><br/>
密码:<input type="password" name=="Rdpasswd"/><br/><br/>
<input type="submit" value="确认"/>
<input type="reset" value="取消"/><br/><br/>
如果您还没有注册，请点击<a href="enroll.jsp">这里</a>注册!
</table>
</form>
</center>
</body>
</html>