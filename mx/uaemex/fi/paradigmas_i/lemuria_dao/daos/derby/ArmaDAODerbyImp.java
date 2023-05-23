package mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.derby;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.AbstractDAO;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.ArmaDAO;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.error.ConfiguracionException;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.error.PersistenciaException;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Arma;

public class ArmaDAODerbyImp extends AbstractDAO implements ArmaDAO {

	@Override
	public void create(Arma a) {
		Statement stmt;
		
		try {
			stmt = this.conexion.createStatement();		
			String arma = "insert into armas values("
					+a.getId()+",'"+ a.getNombre()+"',"
					+a.getNivel()+",'"+a.getImagen()+"')";
			stmt.executeUpdate(arma);
			System.out.println("registro creado");
		} catch (SQLException e) {
			throw new PersistenciaException(e);
		}
		

	}

	@Override
	public Arma read(Arma a) {
		Arma arma;
		Statement stmt;
		ResultSet rs;
		int id, poder;
		String nombre, img, sql;
		boolean withId = false;
		
		
		//Averiguar paramatros de busqueda
		nombre = a.getNombre();
		id = a.getId();
		
		try {
			stmt = this.conexion.createStatement();
			sql = "select * from armas ";
			if(id>0) {
				sql+=" where id="+id;
				withId = true;
			}
			
			if(nombre != null) {
				if(withId) {
					sql += "and nombre='"+nombre+"'";
				} else {
					sql += "where nombre='"+nombre+"'";
				}
			}
			rs = stmt.executeQuery(sql);
			arma = null;
			while(rs.next()) {
				arma = new Arma();
				id = rs.getInt("id");
				arma.setId(id);
				nombre= rs.getString("nombre");
				arma.setNombre(nombre);
				poder = rs.getInt("poder");
				arma.setNivel(poder);
				img = rs.getString("imagen");
				arma.setImagen(img);
				return arma;
			}
			if(arma==null) {
				throw new PersistenciaException("Objeto no encontrado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}
		return arma;
	}

	@Override
	public List<Arma> read() {
		List<Arma> resultado;
		Statement stmt;
		ResultSet rs;
		Arma arma;
		int id;
		String nombre;
		int poder;
		String img;
		
		resultado = new ArrayList<Arma>();
		

		try {
			//Paso uno: crear el statement
			stmt = this.conexion.createStatement();
			rs = stmt.executeQuery("select * from armas");
			while (rs.next()) {
				arma = new Arma();
				id = rs.getInt("id");
				arma.setId(id);
				nombre = rs.getString("nombre");
				arma.setNombre(nombre);
				poder = rs.getInt("poder");
				arma.setNivel(poder);
				img = rs.getString("imagen");
				arma.setImagen(img);
				resultado.add(arma);
			}
		} catch (SQLException e) {
			throw new PersistenciaException(e);
		}
		return resultado;
	}

	@Override
	public void upadate(Arma a) {
		Arma arma;
		Statement stmt;
		int id,poder;
		String nombre,img;
		try {
			stmt = this.conexion.createStatement();
			String update ="update armas set poder = " + a.getNivel() + ", imagen = '"+ a.getImagen() +"' where id = "+ a.getId();
			stmt.executeUpdate(update);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}

	}

	@Override
	public void delete(Arma a) {
		Statement stmt;
		
		try {
			stmt = this.conexion.createStatement();
			String delete = "delete from armas where nombre = '" + a.getNombre()+"'";
			stmt.executeUpdate(delete);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistenciaException();
		}

	}

}
