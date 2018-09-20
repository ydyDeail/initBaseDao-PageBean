<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'doUp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="doAddName.jsp" method="post" enctype="multipart/form-data">
    	<p>新闻类型:<input type="text" name="name" /></p>
    	<p>时间:<input type="text" name="time" /></p>
    	<p>新闻图片:<input type="file" name="pic" /></p>
    	<p><input type="submit" value="添加" /></p>
    </form>
  </body>
</html>
