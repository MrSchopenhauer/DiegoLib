package mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.derby;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.AbstractDAO;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.PocionDAO;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.error.PersistenciaException;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Enemigo;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Pocion;

public class PocionDAODerbyImp extends AbstractDAO implements PocionDAO {

	@Override
	public void create(Pocion p) {
		Statement stmt;

		try {
			stmt = this.conexion.createStatement();

			String sql = "Insert into pociones values ";
			sql += "(" + p.getId() + ", ' " + p.getNombre() + "'";
			sql += "," + p.getNivel() + ",'" + p.getImagen() + "'" + ", '" + p.getTipo() + "')";

			stmt.executeUpdate(sql);
			System.out.println("creado");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}

	}

	@Override
	public Pocion read(Pocion p) {
		Pocion pocion;
		Statement stmt;
		ResultSet rs;

		int id, nivel;
		String nombre, imagen, sql;

		boolean withId = false;

		nombre = p.getNombre();
		id = p.getId();

		try {
			stmt = this.conexion.createStatement();
			sql = "Select * from pociones ";

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
			pocion = null;

			while (rs.next()) {
				pocion = new Pocion(3);
				pocion.setId(id = rs.getInt("id"));
				pocion.setNombre(nombre = rs.getString("nombre"));
				pocion.setNivel(nivel = rs.getInt("nivel"));
				pocion.setImagen(imagen = rs.getString("imagen"));
				return pocion;
			}

			if (pocion == null) {
				throw new PersistenciaException("Objeto no encontrado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException(e);
		}
		return pocion;
	}

	@Override
	public List<Pocion> read() {
		List<Pocion> resultado;
		Statement stmt;
		ResultSet rs;
		Pocion pocion;
		int id, nivel, tipo;
		String nombre, img;

		resultado = new ArrayList<Pocion>();

		try {
			// Paso uno: crear el statement
			stmt = this.conexion.createStatement();
			rs = stmt.executeQuery("select * from pociones");
			while (rs.next()) {
				pocion = new Pocion(1);
				id = rs.getInt("id");
				pocion.setId(id);
				nombre = rs.getString("nombre");
				pocion.setNombre(nombre);
				nivel = rs.getInt("nivel");
				pocion.setNivel(nivel);
				img = rs.getString("imagen");
				pocion.setImagen(img);
				resultado.add(pocion);
			}
		} catch (SQLException e) {
			throw new PersistenciaException(e);
		}
		return resultado;
	}

	@Override
	public void upadate(Pocion p) {
		Statement stmt;

		try {
			stmt = this.conexion.createStatement();
			String sql = "update pociones set ";
			sql += "nivel = " + p.getNivel() + ", imagen = '" + p.getImagen() + "'";
			sql += "where id = " + p.getId();
			stmt.executeUpdate(sql);
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new PersistenciaException();
		}

	}

	@Override
	public void delete(Pocion p) {
		Statement stmt;

		try {
			stmt = this.conexion.createStatement();
			String sql = "Delete from pociones ";
			sql += "where id = " + p.getId();
			stmt.executeUpdate(sql);
			System.out.println("pocion eliminada");
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new PersistenciaException();
		}

	}

}
