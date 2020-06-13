<%--
  Created by IntelliJ IDEA.
  User: WQ-Cxx
  Date: 2020/6/3
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/account/addAccount" method="post">
    用户名:<input name="accountname" type="text" id="accountname"/><br>
    密码:<input name="passwd" type="password" id="passwd"> <br>
    type:<input name="type" type="text" id="type"> <br>
    <input type="submit" value="注册" id="zc">
</form>

</body>
</html>
