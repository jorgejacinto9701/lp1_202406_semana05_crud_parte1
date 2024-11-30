package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Alumno;
import entity.Pais;
import util.FechaUtil;
import util.MySqlDBConexion;

public class AlumnoModel {

	public int insertaAlumno(Alumno obj) {
		int salida = -1;
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "INSERT INTO alumno (nombres, apellidos, telefono, dni, correo, "
					+ "fechaNacimiento, fechaRegistro, fechaActualizacion, estado, idPais)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());
			pstm.setString(2, obj.getApellidos());
			pstm.setString(3, obj.getTelefono());
			pstm.setString(4, obj.getDni());
			pstm.setString(5, obj.getCorreo());
			pstm.setDate(6, obj.getFechaNacimiento());
			pstm.setTimestamp(7, obj.getFechaRegistro());
			pstm.setTimestamp(8, obj.getFechaActualizacion());
			pstm.setInt(9, obj.getEstado());
			pstm.setInt(10, obj.getPais().getIdPais());
			salida = pstm.executeUpdate();

			System.out.println("SQL : " + pstm.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}

	public boolean existeDNI(String dni) {
		boolean existe = false;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select * from alumno where dni = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dni);
			rs = pstm.executeQuery();
			if (rs.next()) {
				existe = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return existe;
	}

	public boolean existeEmail(String email) {
		boolean existe = false;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select * from alumno where correo = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, email);
			rs = pstm.executeQuery();
			if (rs.next()) {
				existe = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return existe;

	}

	public boolean existeTelefono(String telefono) {
		boolean existe = false;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select * from alumno where telefono = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, telefono);
			rs = pstm.executeQuery();
			if (rs.next()) {
				existe = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return existe;
	}

	public List<Alumno> listaPorNombreLike(String filtro) {
		ArrayList<Alumno> data = new ArrayList<Alumno>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select a.*, p.nombre as pais from alumno "
					+ "a inner join pais p on a.idPais = p.idPais where a.nombres like ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, filtro + "%");
			rs = pstm.executeQuery();
			System.out.println("SQL : " + pstm.toString());
			while (rs.next()) {
				Alumno a = new Alumno();
				a.setIdAlumno(rs.getInt(1));
				a.setNombres(rs.getString(2));
				a.setApellidos(rs.getString(3));
				a.setTelefono(rs.getString(4));
				a.setDni(rs.getString(5));
				a.setCorreo(rs.getString(6));
				a.setFechaNacimiento(rs.getDate(7));
				a.setFechaNacimientoFormateada(FechaUtil.getFechaFormateadaYYYYMMdd(rs.getDate(7)));
				a.setFechaRegistro(rs.getTimestamp(8));
				a.setFechaActualizacion(rs.getTimestamp(9));
				a.setEstado(rs.getInt(10));
				
				Pais p = new Pais();
				p.setIdPais(rs.getInt(11));
				p.setNombre(rs.getString(12)); 
				
				a.setPais(p);
				data.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	
	public List<Alumno> listaAlumnoComplejo(String nombre, String telefono,String dni,Date fdesde,Date fhasta) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Alumno> lstSalida = new ArrayList<Alumno>();
		try {
			conn = MySqlDBConexion.getConexion();
			String sql = "select a.*, p.nombre from alumno a inner join pais p on a.idPais = p.idPais "
						+ "where (a.nombres like ? or a.apellidos like ? ) and "
						+ "( ? = '' or telefono = ?) and "
						+ "( ? = '' or dni = ?) and "
						+ "(fechaNacimiento >= ? and fechaNacimiento <= ?)";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre);
			pstm.setString(2, nombre);
			pstm.setString(3, telefono);
			pstm.setString(4, telefono);
			pstm.setString(5, dni);
			pstm.setString(6, dni);
			pstm.setDate(7, fdesde);
			pstm.setDate(8, fhasta);

			System.out.println("SQL => " + pstm);
			rs = pstm.executeQuery();
			Alumno objAlumno;
			Pais objPais;
			while(rs.next()) {
				objAlumno = new Alumno();
				objAlumno.setIdAlumno(rs.getInt(1));
				objAlumno.setNombres(rs.getString(2));
				objAlumno.setApellidos(rs.getString(3));
				objAlumno.setTelefono(rs.getString(4));
				objAlumno.setDni(rs.getString(5));
				objAlumno.setCorreo(rs.getString(6));
				objAlumno.setFechaNacimiento(rs.getDate(7));
				objAlumno.setFechaNacimientoFormateada(FechaUtil.getFechaFormateadaYYYYMMdd(rs.getDate(7)));
				objAlumno.setFechaRegistro(rs.getTimestamp(8));
				objAlumno.setFechaActualizacion(rs.getTimestamp(9));
				objAlumno.setEstado(rs.getInt(10));
				
				objPais = new Pais();
				objPais.setIdPais(rs.getInt(11));
				objPais.setNombre(rs.getString(12));
				objAlumno.setPais(objPais);
				lstSalida.add(objAlumno);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();

			} catch (Exception e2) {}
		}
		return lstSalida;
	}
}
