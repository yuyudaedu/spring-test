<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/10/24
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>page分布练习</title>
  </head>
  <body>
  <table border="1">
    <tr>
      <th>编号</th>
      <th>姓名</th>
      <th>年龄</th>
    </tr>
    <c:forEach items="${pageInfo.list}" var="pi">
      <tr>
        <td>${pi.id}</td>
        <td>${pi.name}</td>
        <td>${pi.age}</td>
      </tr>
    </c:forEach>
  </table>
  <a href="page?page=${pageInfo.page - 1}&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.page <= 1}"> onclick="javascript:return false;" </c:if>>上一页</a>
  <a href="page?page=${pageInfo.page + 1}&pageSize=${pageInfo.pageSize}" <c:if test="${pageInfo.page >= pageInfo.total}"> onclick="javascript:return false;" </c:if>>下一页</a>
  </body>
</html>
