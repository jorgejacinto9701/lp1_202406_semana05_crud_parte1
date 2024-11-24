package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Pais;
import util.MySqlDBConexion;

public class PaisModel {

	public List<Pais> listaPais(){
		List<Pais> lista = new ArrayList<Pais>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
            con = MySqlDBConexion.getConexion();
            pstm = con.prepareStatement("select * from pais order by nombre asc");
            rs = pstm.executeQuery();
            while(rs.next()){
                Pais pais = new Pais();
                pais.setIdPais(rs.getInt(1));
                pais.setIso(rs.getString(2));
                pais.setNombre(rs.getString(3));
                lista.add(pais);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null) rs.close();
                if(pstm != null) pstm.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
		return lista;
	}
}
