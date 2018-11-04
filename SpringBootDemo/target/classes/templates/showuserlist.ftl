<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemarker</title>
</head>
<body>
<table border="1" align="center" width="50%">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>密码</th>
    </tr>
    <#list list as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.password}</td>
        </tr>
    </#list>
</table>
</body>
</html>