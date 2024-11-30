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

@WebServlet("/consultaAlumnoLikeServlet")
public class ConsultaAlumnoLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			// Recibiendo el parametro
		    String filtro = req.getParameter("filtro");
		    
		    // Imprimiendo el parametro
		    System.out.println("Filtro : " + filtro);
		    
			// Invocando al modelo
		    AlumnoModel model = new AlumnoModel();
		    List<Alumno> lista = model.listaPorNombreLike(filtro);
		    
		    // emviando json
			Gson gson = new Gson();
			String json = gson.toJson(lista);
			
			//respuesta al browser
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(json);
		    

		
	}

}
