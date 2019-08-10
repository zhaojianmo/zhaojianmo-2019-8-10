<%--
  Created by IntelliJ IDEA.
  User: 赵毛毛
  Date: 2019/7/16
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="filename" multiple/>
    <input type="submit"/>
  </form>


<%--  <img src="/test702/"/>--%>

  <img src="http://localhost:8080/test702/download1?path=upload/日式寿司.jpg"/>tu
  <a href="http://localhost:8080/test702/download1?path=upload/日式寿司.jpg">下载</a>
</body>
</html>
