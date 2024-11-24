package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entity.Alumno;
import util.MySqlDBConexion;

public class AlumnoModel {

	public int insertaAlumno(Alumno obj ) {
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
			
		}catch(Exception e) {
            e.printStackTrace();
		}finally {
			try {
				if (pstm != null) pstm.close();
				if (con != null) con.close();
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
		
	
}












