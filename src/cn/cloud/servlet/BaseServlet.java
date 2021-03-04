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
		//���ñ��뼯
		req.setCharacterEncoding("utf-8");
		//��ȡ������Я���ķ�����
		String func = req.getParameter("func");
		//��ȡ���̳�BaseServlet����ֽ������
		Class<? extends BaseServlet> clazz = this.getClass();
		//ͨ�������ҵ���ǰ����ķ���
		try {
			Method method = clazz.getMethod(func, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, req, res);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
