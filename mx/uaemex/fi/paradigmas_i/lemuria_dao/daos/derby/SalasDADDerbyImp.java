package mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.derby;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.AbstractDAO;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.SalaDAO;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.error.PersistenciaException;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Pocion;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Sala;

public class SalasDADDerbyImp extends AbstractDAO implements SalaDAO {
	
	public Sala byNombre (String nombre) {
		Sala sala;
		Statement stmt;
		ResultSet rs;
		int id;
		
		String nom, sql, imagen;
		try {
			stmt = this.conexion.createStatement();
			sql = "Select * from salas ";

			sql += "where nombre = '" + nombre + "'";

			rs = stmt.executeQuery(sql);
			sala = null;

			while (rs.next()) {
				sala = new Sala();
				sala.setId(id = rs.getInt("id"));
				sala.setNombre(nom = rs.getString("nombre"));
				sala.setImagen(imagen = rs.getString("imagen"));
				return sala;
			}

			if (sala == null) {
				throw new PersistenciaException("Objeto no encontrado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return sala;
	}
	
	@Override
	public void create(Sala s) {
		Statement stmt;

		try {
			stmt = this.conexion.createStatement();

			String sql = "Insert into salas values ";
			sql += "(" + s.getId() + ", ' " + s.getNombre() + "'";
			sql += ",'" + s.getImagen() + "'";

			stmt.executeUpdate(sql);
			System.out.println("creado");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}

	}

	@Override
	public Sala read(Sala s) {
		Sala sala;
		Statement stmt;
		ResultSet rs;

		int id;
		String nombre, imagen, sql;

		boolean withId = false;

		nombre = s.getNombre();
		id = s.getId();
		try {
			stmt = this.conexion.createStatement();
			sql = "Select * from salas ";

			if (id > 0) {
				sql += "where id = " + id;
				withId = true;
			}
			if (nombre != null) {
				if (withId) {
					sql += "and nombre = '" + nombre + "'";
				} else {
					sql += "where nombre = '" + nombre + "'";
				}
			}

			rs = stmt.executeQuery(sql);
			sala = null;

			while (rs.next()) {
				sala = new Sala();
				sala.setId(id = rs.getInt("id"));
				sala.setNombre(nombre = rs.getString("nombre"));
				sala.setImagen(imagen = rs.getString("imagen"));
				return sala;
			}

			if (sala == null) {
				throw new PersistenciaException("Objeto no encontrado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return sala;
	}

	@Override
	public List<Sala> read() {
		List<Sala> resultado;
		Statement stmt;
		ResultSet rs;
		Sala sala;
		int id;
		String nombre, imagen;

		resultado = new ArrayList<Sala>();

		try {
			stmt = this.conexion.createStatement();
			rs = stmt.executeQuery("select * from salas");
			while (rs.next()) {
				sala = new Sala();
				id = rs.getInt("id");
				sala.setId(id);
				nombre = rs.getString("nombre");
				sala.setNombre(nombre);
				imagen = rs.getString("imagen");
				sala.setImagen(imagen);
				resultado.add(sala);

			}
		} catch (SQLException e) {
			throw new PersistenciaException(e);
		}
		return resultado;
	}

	@Override
	public void upadate(Sala s) {
		Statement stmt;

		try {
			stmt = this.conexion.createStatement();
			String sql = "update salas set ";
			sql += "imagen = '" + s.getImagen() + "' ";
			sql += "where id = " + s.getId();
			stmt.executeUpdate(sql);
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new PersistenciaException();
		}

	}

	@Override
	public void delete(Sala s) {
		Statement stmt;

		try {
			stmt = this.conexion.createStatement();
			String sql = "Delete from salas ";
			sql += "where id = " + s.getId();
			stmt.executeUpdate(sql);
			System.out.println("sala eliminada");
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new PersistenciaException();
		}

	}

}
