<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<form action="login" method="post">
    用户名<input type="text" name="username">
    密码<input type="password" name="password">
    <input type="submit" value="登陆">
</form>

<input type="button" value="注册" onclick="window.location.href='register.jsp'">
</body>
</html>
