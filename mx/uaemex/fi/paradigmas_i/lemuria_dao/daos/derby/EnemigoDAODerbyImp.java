package mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.derby;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.AbstractDAO;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.EnemigoDAO;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.error.PersistenciaException;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Enemigo;

public class EnemigoDAODerbyImp extends AbstractDAO implements EnemigoDAO {

	@Override
	public void create(Enemigo e) {
		Statement stmt;

		try {
			stmt = this.conexion.createStatement();
			
			String sql = "Insert into enemigos values ";
			sql += "(" + e.getId() +", ' " + e.getNombre() + "'";
			sql += "," + e.getVida() + ", "+ e.getDefensa()+ ", "+ e.getAtaque()+",'"+ e.getImagen() + "')";
			
			stmt.executeUpdate(sql);
		} catch (SQLException s) {
			s.printStackTrace();
			throw new PersistenciaException(s);
		}

	}

	@Override
	public Enemigo read(Enemigo e) {
		Enemigo enemy;
		Statement stmt;
		ResultSet rs;
		int id,vida,defensa,ataque;
		String nombre, imagen, sql;
		
		boolean withId = false;
		
		nombre = e.getNombre();
		id = e.getId();
		
		try {
			stmt = this.conexion.createStatement();
			sql = "select * from enemigos ";
			
			if (id > 0) {
				sql += "where id = " + id;
				withId = true;
			}
			
			if (nombre != null) {
				if (withId) {
					sql += "and nombre = '"+ nombre + "'";
				}else {
					sql+= "where nombre = '" + nombre + "'";
				}
			}
			
			rs= stmt.executeQuery(sql);
			enemy = null;
			while(rs.next()) {
				enemy = new Enemigo();
				enemy.setId(id = rs.getInt("id"));
				enemy.setNombre(nombre = rs.getString("nombre"));
				enemy.setVida(vida = rs.getInt("vida"));
				enemy.setDefensa(defensa = rs.getInt("defensa"));
				enemy.setAtaque(ataque = rs.getInt("ataque"));
				enemy.setImagen(imagen = rs.getString("imagen"));
				return enemy;
			}
			if(enemy == null) {
				throw new PersistenciaException("Objetno no enocntyrado");
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new PersistenciaException(e2);
		}
		return enemy;
	}

	@Override
	public List<Enemigo> read() {
		List<Enemigo> resultado;
		Statement stmt;
		ResultSet rs;
		Enemigo enemigo;
		int id;
		String nombre;
		int vida;
		int defensa;
		int ataque;
		String img;

		resultado = new ArrayList<Enemigo>();

		try {
			// Paso uno: crear el statement
			stmt = this.conexion.createStatement();
			rs = stmt.executeQuery("select * from enemigos");
			while (rs.next()) {
				enemigo = new Enemigo();
				id = rs.getInt("id");
				enemigo.setId(id);
				nombre = rs.getString("nombre");
				enemigo.setNombre(nombre);
				vida = rs.getInt("vida");
				enemigo.setVida(vida);
				defensa = rs.getInt("defensa");
				enemigo.setDefensa(defensa);
				ataque = rs.getInt("ataque");
				enemigo.setAtaque(ataque);
				img = rs.getString("imagen");
				enemigo.setImagen(img);
				resultado.add(enemigo);
			}
		} catch (SQLException e) {
			throw new PersistenciaException(e);
		}
		return resultado;
	}

	@Override
	public void upadate(Enemigo e) {
		Statement stmt;
		
		try {
			stmt = this.conexion.createStatement();
			String sql = "update enemigos set ";
				   sql += "vida = " + e.getVida() + ", defensa = " + e.getDefensa();
				   sql += ", ataque = " + e.getAtaque() + ", imagen = '" + e.getImagen() + "'";
				   sql += "where id = " + e.getId();
			stmt.executeUpdate(sql);
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new PersistenciaException();
		}

	}

	@Override
	public void delete(Enemigo e) {
		Statement stmt;
		
		try {
			stmt = this.conexion.createStatement();
			String sql = "Delete from enemigos ";
				   sql += "where id = " + e.getId();
			stmt.executeUpdate(sql);
			System.out.println("enemigo eliminado");
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new PersistenciaException();
		}
	}

}
