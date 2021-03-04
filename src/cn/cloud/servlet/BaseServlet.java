package cn.cloud.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//设置编码集
		req.setCharacterEncoding("utf-8");
		//获取请求中携带的方法名
		String func = req.getParameter("func");
		//获取到继承BaseServlet类的字节码对象
		Class<? extends BaseServlet> clazz = this.getClass();
		//通过反射找到当前对象的方法
		try {
			Method method = clazz.getMethod(func, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
