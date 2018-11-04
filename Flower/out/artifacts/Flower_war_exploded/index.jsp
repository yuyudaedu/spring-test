<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/10/23
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>My first web</title>
  </head>
  <body>
    <table border="1">
        <tr>
            <th>花卉编号</th>
            <th>花卉名称</th>
            <th>价格（元）</th>
            <th>原产地</th>
        </tr>
        <c:forEach items="${list}" var="flower">
            <tr>
                <td>${flower.id}</td>
                <td>${flower.name}</td>
                <td>${flower.price}</td>
                <td>${flower.production}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="add.jsp">添加花卉</a>
  </body>
</html>
