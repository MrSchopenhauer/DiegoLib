package mx.uaemex.fi.paradigmas_i.lemuria_dao.principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.derby.ArmaDAODerbyImp;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.derby.EnemigoDAODerbyImp;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.derby.PocionDAODerbyImp;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.daos.derby.SalasDADDerbyImp;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Arma;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Enemigo;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Pocion;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Sala;

public class Principal {

	public static void main(String[] args) {
		/*ArmaDAODerbyImp amrasDao;
		Arma arma;
		List<Arma> misArmas;
		
		EnemigoDAODerbyImp enemigoDao;
		List<Enemigo> miEnemigo;
		
		PocionDAODerbyImp pocionDao;
		List<Pocion> miPocion;
		
		SalasDADDerbyImp salaDao;
		List<Sala> miSala;*/
		PocionDAODerbyImp pocionDao;
		Pocion pocion;
		EnemigoDAODerbyImp enemigoDao;
		Enemigo enemy;
		SalasDADDerbyImp salaDao;
		Sala sala;
		Connection con;
		String url;
		
		url = "jdbc:derby://localhost:1527/juego";
		try {
			con = DriverManager.getConnection(url);
			
			pocionDao = new  PocionDAODerbyImp();
			pocionDao.setConexion(con);
			pocion = new Pocion(3);
			
			salaDao = new SalasDADDerbyImp();
			salaDao.setConexion(con);
			sala = new Sala();
			String nombre = "Encrucijada";
			sala = salaDao.byNombre(nombre);
			System.out.println(sala);
			
			//pocion.setNombre(" aguiita");
			//pocion = pocionDao.read(pocion);
			//pocionDao.delete(pocion);
			/*amrasDao = new ArmaDAODerbyImp();
			amrasDao.setConexion(con);
			misArmas = amrasDao.read();
			
			for (Arma a : misArmas) {
				System.out.println(a);
			}
			
			enemigoDao = new EnemigoDAODerbyImp();
			enemigoDao.setConexion(con);
			miEnemigo = enemigoDao.read();
			
			for (Enemigo e : miEnemigo) {
				System.out.println(e);
			}
			pocionDao = new PocionDAODerbyImp();
			pocionDao.setConexion(con);
			miPocion = pocionDao.read();
			for (Pocion p : miPocion) {
				System.out.println(p);
			}
			salaDao = new SalasDADDerbyImp();
			salaDao.setConexion(con);
			miSala = salaDao.read();
			
			for(Sala s : miSala) {
				System.out.println(s);
			}
			amrasDao = new ArmaDAODerbyImp();
			amrasDao.setConexion(con);
			arma = new Arma();
			arma.setNombre("null");
			arma = amrasDao.read(arma);			
			amrasDao.delete(arma);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
