package crm.api;

import static crm.common.Constant.ROLE_API_ADD;
import static crm.common.Constant.ROLE_API_DELETE;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm.payload.ResponseData;
import crm.service.RoleService;

@WebServlet(name = "roleApi", urlPatterns = {ROLE_API_DELETE, ROLE_API_ADD})
public class RoleApi extends HttpServlet{
	
	private RoleService roleService = new RoleService();
	private Gson gson = new Gson();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		switch (path) {
		case ROLE_API_DELETE:
			delete(req, resp);
			break;
		case ROLE_API_ADD:
			add(req, resp);
			break;
		default:
			break;
		}
	}
	
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		
		boolean isSuccess = roleService.addRole(name, desc);
		ResponseData responseData = new ResponseData();
		responseData.setSuccess(isSuccess);
		responseData.setData("");
		responseData.setDescription("");
		
		String json = gson.toJson(responseData);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		try {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write(json);
			printWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		
		boolean isSuccess = roleService.deleteRoleById(id);
		ResponseData responseData = new ResponseData();
		responseData.setSuccess(isSuccess);
		responseData.setData("");
		responseData.setDescription("");
		
		String json = gson.toJson(responseData);
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		try {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write(json);
			printWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
