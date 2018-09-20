package Test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.Request;

import entity.User;

import Service.UserDaoService;
import ServiceImpl.UserDaoServiceImpl;

public class UserAction extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=(String)request.getParameter("name");
		String pwd=(String)request.getParameter("pwd");
		UserDaoService uds=new UserDaoServiceImpl();
		User user=uds.login(name, pwd);
		if(user==null){
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "登录成功");
			response.sendRedirect("index.jsp");
		}
	}
}
