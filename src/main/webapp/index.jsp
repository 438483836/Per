<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/person/saveByPerson" method="post">
    id: <input type="text" name="id" value=""/>
    <br>
    用户名: <input type="text" name="username" value=""/>
    <br>
    密码: <input type="text" name="password" value="">
    <br>
    <input type="submit" value="Submit"/>
</form>


<br><br>
<a href="/test/testFunction">Test Function</a>

</body>
</html>
