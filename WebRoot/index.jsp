<%@page import="entity.Category"%>
<%@page import="ServiceImpl.CateServiceImpl"%>
<%@page import="Service.CateService"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
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
   <table border="1">
     	<tr>
     	<td>编号</td>
     	<td>类型</td>
     	<td>时间</td>
     	</tr>
     	
    <%
    	CateService cs=new CateServiceImpl();
    	int size=2;
    	int kaiShi=1;
    	int count=cs.findAll(size);
    	 String s_pageNo=request.getParameter("pageNo");
    	if(s_pageNo!=null){
    		kaiShi=Integer.parseInt(s_pageNo);
    	}
    	if(kaiShi<1){
    		kaiShi=1;
    	}
    	if(kaiShi>count){
    		kaiShi=count;
    	}
    	List<Category> li=cs.findAllType(kaiShi, size);
    	for(Category c:li){
     %>
     	<tr>
     	<td><%=c.getId() %></td>
     	<td><%=c.getName() %></td>
     	<td><%=c.getCreateDate() %></td>
     	</tr>
    <%} %>
     </table>
     <a href="index.jsp?pageNo=1">首页</a>
      <%
     	if(kaiShi<count){
     	
      %>
     <a href="index.jsp?pageNo=<%=kaiShi+1%>">下一页</a>
     <%} %>
     共<%=kaiShi %>/<%=count %>页
     <%
     	if(kaiShi>1){
     	
      %>
     <a href="index.jsp?pageNo=<%=kaiShi-1%>">上一页</a>
     <%} %>
     <a href="index.jsp?pageNo=<%=count%>">尾页</a>
     <form action="index.jsp">
     	<input type="text" name="pageNo" size=2 value="<%=kaiShi%>"/>&nbsp;<input type="submit"  value="跳转"/>
     </form>
     <p><a href="doUp.jsp">上传图片</a></p>
  </body>
</html>
