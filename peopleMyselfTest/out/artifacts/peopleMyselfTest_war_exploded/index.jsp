<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/10/24
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>复习mybatis people例子</title>
  </head>
  <body>
    <table align="center" border="1">
      <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
      </tr>
      <c:forEach items="${list}" var="peo">
        <tr>
          <td>${peo.id}</td>
          <td>${peo.name}</td>
          <td>${peo.age}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
