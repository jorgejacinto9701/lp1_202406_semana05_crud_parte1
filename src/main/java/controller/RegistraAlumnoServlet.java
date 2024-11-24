package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

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

@WebServlet("/registraAlumno")
public class RegistraAlumnoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//recibir los datos del formulario
		String nombres = req.getParameter("nombres");
		String apellidos = req.getParameter("apellidos");
		String telefono = req.getParameter("telefono");
		String dni = req.getParameter("dni");
		String correo = req.getParameter("correo");
		String fechaNacimiento = req.getParameter("fechaNacimiento");
		String idPais = req.getParameter("pais");
		
		//instanciar el objeto Alumno
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
		
		//invocar al modelo
		AlumnoModel model = new AlumnoModel();
		int salida = model.insertaAlumno(objAlumno);
		
		Respuesta objRespuesta = new Respuesta();
		if (salida >0) {
			objRespuesta.setMensaje("Alumno registrado correctamente");
		} else {
			objRespuesta.setMensaje("Error al registrar alumno");
		}
		
		//convertir el objeto respuesta a JSON
		Gson gson = new Gson();
		String json = gson.toJson(objRespuesta);
		
		//respuesta al browser
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(json);
		
	}
	

}
