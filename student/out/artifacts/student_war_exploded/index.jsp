<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/10/25
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <title>Student练习</title>
      <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
      <script type="text/javascript">
          $(function () {
              var pageSize = ${pageinfo.pageSize};
              var page = ${pageinfo.page};
              var sname = "${pageinfo.sname}";
              var tname = "${pageinfo.tname}";
              var total = ${pageinfo.total};
              $.each($(":radio"), function (i, n) {
                  if ($(n).val() == pageSize) {
                      $(n).attr("checked", true);
                  }
              });
              $(":text[name='sname']").val(sname);
              $(":text[name='tname']").val(tname);

              $("button").on("click", function (e) {
                  location.href = "show?pageSize=" + pageSize + "&page=" + page + "&sname=" +  $(":text[name='sname']").val() + "&tname=" +  $(":text[name='tname']").val();
              });

              $(":radio").on("click", function (e) {
                  pageSize = $(this).val();
                  location.href = "show?pageSize=" + pageSize + "&page=" + page + "&sname=" +  $(":text[name='sname']").val() + "&tname=" +  $(":text[name='tname']").val();
              });

              $(".page").eq(0).on('click', function (e) {
                  page = parseInt(page) - 1;
                  if (page >= 1)
                     location.href = "show?pageSize=" + pageSize + "&page=" + page + "&sname=" +  $(":text[name='sname']").val() + "&tname=" +  $(":text[name='tname']").val();
                  else
                     page = 1;

                  return false;
              });

              $(".page").eq(1).on('click', function (e) {
                  page = parseInt(page) + 1;
                  if (page <= total)
                      location.href = "show?pageSize=" + pageSize + "&page=" + page + "&sname=" +  $(":text[name='sname']").val() + "&tname=" +  $(":text[name='tname']").val();
                  else
                      page = total;
                  return false;
              });
          });
      </script>
  </head>
  <body>
  <input type="radio" name="pageSize" value="2">2
  <input type="radio" name="pageSize" value="3">3
  <input type="radio" name="pageSize" value="4">4<br/>
  学生：<input type="text" name="sname"> 老师：<input type="text" name="tname"> <button>查询</button><br/>
  <table border="1">
      <tr>
          <th>学生编号</th>
          <th>学生姓名</th>
          <th>学生年龄</th>
          <th>任课老师</th>
      </tr>
      <c:forEach items="${pageinfo.list}" var="stu">
          <tr>
              <td>${stu.id}</td>
              <td>${stu.name}</td>
              <td>${stu.age}</td>
              <td>${stu.teacher.name}</td>
          </tr>
      </c:forEach>
  </table>
  <a href="" class="page">上一页</a> <a href="" class="page">下一页</a>
  </body>
</html>
