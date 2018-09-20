<%@page import="ServiceImpl.CateServiceImpl"%>
<%@page import="Service.CateService"%>
<%@page import="entity.Category"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="java.io.File"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'doAddName.jsp' starting page</title>
    
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
    <%
    	String path=request.getRealPath("/pics");
    	File file=new File(path);
    	List<String> picType=Arrays.asList("jpg","jpeg","gif","png");
    	
    	if(!file.exists()){
    		file.mkdir();
    	}
    	
    	String name="";
    	String createDate="";
    	FileItemFactory factory=new DiskFileItemFactory();
    	ServletFileUpload upload=new ServletFileUpload(factory);
    	List<FileItem> list=upload.parseRequest(request);
    	for(FileItem item:list){
    		if(item.isFormField()){
    			if(item.getFieldName().equals("name")){
    				name=item.getString("utf-8");
    			}else if(item.getFieldName().equals("createDate")){
    				createDate=item.getString();
    			}
    		}else{ //上传
    		//1.获取文件名
    			String fileName=item.getName();
    			if(fileName!=null&&!fileName.equals("")){//用户没有上传文件
    			//2.解决兼容问题
    			fileName=new File(fileName).getName();
    			String type=fileName.substring(fileName.lastIndexOf(".")+1);
    			if(picType.contains(type)){
    			upload.setFileSizeMax(1024);
    			fileName=UUID.randomUUID().toString().replace("-", "")+"."+type;
    			//3.获取上传路径
    			String uploadFile=path+"/"+fileName;
    			//4.上传
    			item.write(new File(uploadFile));
    			Category c=new Category();
    			CateService cs=new CateServiceImpl();
    			c.setName(name);
    			c.setCreateDate(new Timestamp(System.currentTimeMillis()));
    			c.setPic(path+fileName);
    			cs.AddFindById(c);
    			%>
    			<h2>上传成功<%=name %><%=c.getCreateDate() %><%=path+fileName %></h2>
    		<% }else{
    			out.print("上传错误");
    		}
    		}
    		}
    	}
    	%>
     
  </body>
  
</html>
