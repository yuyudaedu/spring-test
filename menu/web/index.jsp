<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2018/10/28
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.post('show', function (data) {
                var html = '';
                $.each(data, function (index, val) {
                    html += "<dl>";
                    html += "<dt>"+ val['name'] +"</dt>";
                    $.each(val['children'], function (i, v) {
                        html += "<dd>"+ v['name'] +"</dd>";
                    });
                    html += "</dl>";
                });
                $('.menu').html(html);
            })
        });

        $(document).delegate('dt','click', function () {
            $(this).siblings().slideToggle(1000);
        })
    </script>
</head>
<body>
<div class="menu"></div>
<br><br>
<a href="/download?file=a.txt">下载</a><br><br>
<form action="upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"><br><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
