package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;

import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistance.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserControllerServlet extends HttpServlet {

	private static final long serialVersionUID = -4331680861219300600L;
	private UserDAO uDAO;

	public UserControllerServlet() {
		uDAO = new UserDAO();
	}

	// --READ--//
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		for (UserDTO u : uDAO.getUsers()) {
			out.write(u.toString());
		}
		out.close();
	}

	// --CREATE--//
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean status = uDAO.validate(new UserDTO(username, password));
		PrintWriter out = resp.getWriter();
		if (status) {
			RequestDispatcher rd = req.getRequestDispatcher("login_success.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("login_error.jsp");
			rd.forward(req, resp);
		}
		out.close();
	}

	// --UPDATE--//
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int index = Integer.parseInt(req.getParameter("index"));
		
		PrintWriter out = resp.getWriter();
		int status = uDAO.update(index, new UserDTO(username, password));
		//1 = No existe 
		//0 = Correcto
		if(status == 0) {
			out.write("Actualizado Correctamente");
		}else {
			out.write("La posicion no existe");
		}
		out.close();
	}

	// --DELETE--//
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doHead(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doHead(arg0, arg1);
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(req, resp);
	}

	@Override
	protected void doTrace(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doTrace(arg0, arg1);
	}

}
