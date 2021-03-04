package cn.cloud.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.cloud.entity.User;
import cn.cloud.service.UserService;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	//校验用户名唯一的方法
	public void checkUserName(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String username = req.getParameter("username");
		boolean isRegist = userService.checkUserName(username);
		res.getWriter().print(isRegist);
	}
	//校验邮箱唯一的方法
	public void checkEmail(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String email = req.getParameter("email");
		boolean isRegist = userService.checkEmail(email);
		res.getWriter().print(isRegist);
	}
	//注册用户的方法
	public void registUser(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String uname = req.getParameter("uname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		User user = new User(uname, username, password, email, new Date());
		boolean isSuccess = userService.registUser(user);
		if(isSuccess) {
			res.sendRedirect("login.jsp");
		}
	}
}
