<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/10/26
  Time: 1:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>airplane项目练习</title>
</head>
<body>
<form action="/showtake" method="post">
    起飞机场：
    <select name="takeid">
        <option value="">请选择</option>
        <c:forEach items="${takeport}" var="take">
            <option value="${take.id}">${take.portname}</option>
        </c:forEach>
    </select>
    降落机场：
    <select name="landid">
        <option value="">请选择</option>
        <c:forEach items="${landport}" var="land">
            <option value="${land.id}">${land.portname}</option>
        </c:forEach>
    </select>
    <input type="submit" value="查询">
</form>
<table border="1">
    <tr>
        <th>飞机编号</th>
        <th>起飞机场</th>
        <th>起飞城市</th>
        <th>降落机场</th>
        <th>降落城市</th>
        <th>航行时间</th>
        <th>价格(元)</th>
    </tr>
    <c:forEach items="${list}" var="vo">
        <tr>
            <td>${vo.airNo}</td>
            <td>${vo.takePort.portname}</td>
            <td>${vo.takePort.cityname}</td>
            <td>${vo.landPort.portname}</td>
            <td>${vo.landPort.cityname}</td>
            <td>${vo.time}</td>
            <td>${vo.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
