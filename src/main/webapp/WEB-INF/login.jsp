<%--
  Created by IntelliJ IDEA.
  User: WQ-Cxx
  Date: 2020/6/9
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
<form action="/account/login" method="post" id="from1">
    用户名:<input name="accountname" type="text" id="accountname"/><br>
    密码:<input name="passwd" type="password" id="passwd"> <br>
    <input type="submit" value="登录" id="login">
    <%--<input type="submit" value="注册" id="zc">--%>

</form>
<script>
    $(function(){
        $("#from1").on("click","#login",doLogin)
        .on("click","#zc",doZc());
    });
    function doZc() {
        location.hre="Zc";
    }
    function doLogin() {
        var params={
            accountname:$("#accountname").val(),
            passwd:$("#passwd").val()
        }
        var url="account/login";
        $.post(url,params,function (result) {
            if(result.code==200){
                //跳转到indexUI对应的页面
                location.href="getAccountByUname?t="+Math.random();
            }else{
                console.log(result.msg);
            }
            return false;
        })
    }
</script>



</body>
</html>
