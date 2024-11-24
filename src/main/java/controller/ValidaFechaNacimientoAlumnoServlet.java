package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.FechaUtil;

@WebServlet("/validaFechaNacimientoAlumnoServlet")
public class ValidaFechaNacimientoAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fechaIngresada = req.getParameter("fechaNacimiento");
		System.out.println("Fecha de Nacimiento : " + fechaIngresada);

		// Fecha Ingresada es menor a la fecha Minima
		if (fechaIngresada != null) {
			boolean esValida = FechaUtil.esMayorEdad(fechaIngresada);
			if (esValida) {
				resp.getWriter().print("{\"valid\":true}");
			} else {
				resp.getWriter().print("{\"valid\":false}");
			}
		}

	}
}