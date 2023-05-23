package mx.uaemex.fi.paradigmas_i.lemuria_dao.daos;

import java.sql.Connection;

public class AbstractDAO {
	protected Connection conexion;
	
	public AbstractDAO() {
		this.conexion = null;
	}
	public AbstractDAO (Connection c ) {
		this.conexion = c;
	}
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
}
