<%@ page pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
${sessionScope.user}
<c:choose>
    <c:when test="${sessionScope.user==null}">
        您还未登录
        <form action="login" method="post">
            用户名<input type="text" name="username">
            密码<input type="password" name="password">
            <input type="submit" value="登陆">
        </form>
        <input type="button" value="注册" onclick="window.location.href='register.jsp'">
    </c:when>
    <c:otherwise>
        欢迎${user.username}
    </c:otherwise>
</c:choose>

</body>
</html>
