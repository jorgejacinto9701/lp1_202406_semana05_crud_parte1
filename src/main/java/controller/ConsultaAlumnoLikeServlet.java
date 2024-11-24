package controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import entity.Alumno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AlumnoModel;

@WebServlet("/consultaAlumnoLike")
public class ConsultaAlumnoLikeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1 Recibir el filtro
		String filtro = req.getParameter("filtro");
		System.out.println("Filtro: " + filtro);
		
		//2 Invocar al modelo
		AlumnoModel model = new AlumnoModel();
		List<Alumno> lista = model.listaPorNombreLike(filtro);
		
		//3 Enviar la lista a la vista
		Gson  gson = new Gson();
		String json = gson.toJson(lista);
		
		//4 Respuesta al browser
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
		
	}
	
	
}
