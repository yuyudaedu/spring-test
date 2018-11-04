<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/10/26
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<c:forEach items="${list}" var="vo">
    ${vo.id} ${vo.portname} ${vo.cityname} <br>
</c:forEach>
</body>
</html>
