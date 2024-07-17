package crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm.service.LoginService;

@WebServlet(name = "loginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		boolean isExists = loginService.checkLogin(username, password);
		if(isExists) {
			resp.sendRedirect(req.getContextPath() + "/hello.jsp");
		}else {
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
