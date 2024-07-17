package crm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static crm.common.Constant.*;
import crm.service.RoleService;

@WebServlet(name = "roleServlet", urlPatterns = { ROLE, ROLE_ADD })
public class RoleServlet extends HttpServlet {

	private RoleService roleService = new RoleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		switch (path) {
		case ROLE:
			getRoles(req, resp);
			break;
		case ROLE_ADD:
			addRole(req, resp);
			break;
		default:
			break;
		}
	}

	private void getRoles(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("roles", roleService.getAll());
		try {
			req.getRequestDispatcher("/roles.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addRole(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/role_add.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
