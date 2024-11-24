package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AlumnoModel;

@WebServlet("/validaTelefonolAlumnoServlet")
public class ValidaTelefonolAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String telefono = req.getParameter("telefono");
		System.out.println("Telefono : " + telefono);

		AlumnoModel model = new AlumnoModel();
		boolean existe = model.existeTelefono(telefono);
		if (existe) {
			resp.getWriter().print("{\"valid\":false}");
		} else {
			resp.getWriter().print("{\"valid\":true}");
		}
	}
}