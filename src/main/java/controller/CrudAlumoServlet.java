package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.google.gson.Gson;

import entity.Alumno;
import entity.Pais;
import entity.Respuesta;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AlumnoModel;

@WebServlet("/crudAlumno")
public class CrudAlumoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String metodo = req.getParameter("metodo");
		switch (metodo) {
		case "paramLista":
			lista(req, resp);
			break;
		case "paramInserta":
			inserta(req, resp);
			break;
		case "paramActualiza":
			actualiza(req, resp);
			break;
		case "paramLogico":
			eliminacionLogica(req, resp);
			break;
		case "paramFisico":
			eliminacionFisica(req, resp);
			break;
		}
	}

	protected void lista(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>> CrudController >>> lista >>> [ini]");
		String filtro = req.getParameter("filtro");
		AlumnoModel model = new AlumnoModel();
		List<Alumno> lista = model.listaPorNombreLike(filtro);

		Gson gson = new Gson();
		String json = gson.toJson(lista);

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
	}

	protected void inserta(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(">>> CrudController >>> inserta >>> [ini]");

		// recibir los datos del formulario
		String nombres = req.getParameter("nombres");
		String apellidos = req.getParameter("apellidos");
		String telefono = req.getParameter("telefono");
		String dni = req.getParameter("dni");
		String correo = req.getParameter("correo");
		String fechaNacimiento = req.getParameter("fechaNacimiento");
		String idPais = req.getParameter("pais");

		// instanciar el objeto Alumno
		Pais objPais = new Pais();
		objPais.setIdPais(Integer.parseInt(idPais));

		Alumno objAlumno = new Alumno();
		objAlumno.setNombres(nombres);
		objAlumno.setApellidos(apellidos);
		objAlumno.setTelefono(telefono);
		objAlumno.setDni(dni);
		objAlumno.setCorreo(correo);
		objAlumno.setFechaNacimiento(Date.valueOf(fechaNacimiento));
		objAlumno.setEstado(1);
		objAlumno.setFechaRegistro(new Timestamp(System.currentTimeMillis()));
		objAlumno.setFechaActualizacion(new Timestamp(System.currentTimeMillis()));
		objAlumno.setPais(objPais);

		// invocar al modelo
		AlumnoModel model = new AlumnoModel();
		int salida = model.insertaAlumno(objAlumno);
		List<Alumno> lstTodos = model.listaPorNombreLike("%");
					
		Respuesta objRespuesta = new Respuesta();
		if (salida > 0) {
			objRespuesta.setMensaje("Alumno registrado correctamente");
			objRespuesta.setDatos(lstTodos);
		} else {
			objRespuesta.setMensaje("Error al registrar alumno");
		}

		// convertir el objeto respuesta a JSON
		Gson gson = new Gson();
		String json = gson.toJson(objRespuesta);

		// respuesta al browser
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);

		System.out.println(">>> CrudController >>> inserta >>> [fin]");
	}

	protected void actualiza(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	protected void eliminacionLogica(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(">>> CrudController >>> eliminacionLogica >>> [ini]");

		String id = req.getParameter("id");
		String estado = req.getParameter("estado");
		int intId = Integer.parseInt(id);
		int intEstado = Integer.parseInt(estado);
		int intNewEstado = intEstado == 0 ? 1 : 0;

		AlumnoModel model = new AlumnoModel();
		int salida = model.eliminarLogicoAlumno(intId, intNewEstado);

		Respuesta objRespuesta = new Respuesta();
		if (salida > 0) {
			List<Alumno> lista = model.listaPorNombreLike("");
			objRespuesta.setMensaje("Actualización existosa");
			objRespuesta.setDatos(lista);
		}

		// convertir el objeto respuesta a JSON
		Gson gson = new Gson();
		String json = gson.toJson(objRespuesta);

		// respuesta al browser
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
		System.out.println(">>> CrudController >>> eliminacionLogica >>> [fin]");
	}

	protected void eliminacionFisica(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println(">>> CrudController >>> eliminacionFisica >>> [ini]");

		String id = req.getParameter("id");
		int intId = Integer.parseInt(id);

		AlumnoModel model = new AlumnoModel();
		int salida = model.eliminarFisicoAlumno(intId);

		Respuesta objRespuesta = new Respuesta();
		if (salida > 0) {
			List<Alumno> lista = model.listaPorNombreLike("");
			objRespuesta.setMensaje("Eliminación existosa");
			objRespuesta.setDatos(lista);
		}

		// convertir el objeto respuesta a JSON
		Gson gson = new Gson();
		String json = gson.toJson(objRespuesta);

		// respuesta al browser
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write(json);
		System.out.println(">>> CrudController >>> eliminacionFisica >>> [fin]");
	}

}
