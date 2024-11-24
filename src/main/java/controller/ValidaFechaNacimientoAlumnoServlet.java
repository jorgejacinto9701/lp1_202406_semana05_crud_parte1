package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/validaFechaNacimientoAlumnoServlet")
public class ValidaFechaNacimientoAlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fechaIngresada = req.getParameter("fechaNacimiento");
		System.out.println("Fecha de Nacimiento : " + fechaIngresada);
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			//Fecha Hoy disminuida en 18 años
			Date fechaHoy = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaHoy);
			int annoActual = cal.get(Calendar.YEAR);
			cal.set(Calendar.YEAR, annoActual-18);
			Date fechaMinima = cal.getTime();
			
			System.out.println("Fecha de Nacimiento : " + sdf.format(fechaMinima));
			
			//Fecha Ingresada es menor a la fecha Minima
			if (fechaIngresada != null) {
				Date dateFechaIngresada = sdf.parse(fechaIngresada);
				boolean esValida = dateFechaIngresada.before(fechaMinima);
				if (esValida) {
					resp.getWriter().print("{\"valid\":true}");
				} else {
					resp.getWriter().print("{\"valid\":false}");
				}
			}
			
				
		} catch (Exception e) {
			e.addSuppressed(e);
		}
		
		
	}
}