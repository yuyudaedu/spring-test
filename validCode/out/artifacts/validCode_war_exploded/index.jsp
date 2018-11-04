<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/10/26
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $("a").on("click", function () {
            $("img").attr("src", "validcode?random=" + Math.random());
            return false;
        });
    </script>
</head>
<body>
<form action="login" method="post">
    用户名：<input type="text" name="name"><br><br>
    密　码：<input type="password" name="password"><br><br>
    验证码：<input type="text" name="code" size="3">　<img src="validcode" width="60" height="30"> <a href="">看不清</a><br><br>
    　　　　<input type="submit" value="登录">　　<input type="reset" value="重置">
</form>
</body>
</html>
