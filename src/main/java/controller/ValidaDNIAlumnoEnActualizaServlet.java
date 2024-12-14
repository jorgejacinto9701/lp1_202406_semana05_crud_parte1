package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AlumnoModel;

@WebServlet("/validaDNIAlumnoEnActualizaServlet")
public class ValidaDNIAlumnoEnActualizaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dni = req.getParameter("dni");
		String id = req.getParameter("id");
		System.out.println("DNI : " + dni);
		System.out.println("id : " + id);
		
		AlumnoModel model = new AlumnoModel();
		boolean existe = model.existeDNIEnActualiza(dni, Integer.parseInt(id));
		if (existe) {
            resp.getWriter().print("{\"valid\":false}");
        } else {
            resp.getWriter().print("{\"valid\":true}");
	    }
	}
}