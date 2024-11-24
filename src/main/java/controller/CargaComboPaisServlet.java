package controller;

import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;

import entity.Pais;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PaisModel;

@WebServlet("/cargaComboPais")
public class CargaComboPaisServlet extends HttpServlet {

	public static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// Invocar al modelo
		PaisModel model = new PaisModel();
		List<Pais> lista = model.listaPais();
		
		//Convertir la lista a JSON
		Gson gson = new Gson();
		String json = gson.toJson(lista);
		
		//Respuesta al browser(Chrome, Firefox, Edge, etc)
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(json);
	}
	
}



