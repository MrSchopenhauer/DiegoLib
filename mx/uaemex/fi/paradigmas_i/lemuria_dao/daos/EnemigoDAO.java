package mx.uaemex.fi.paradigmas_i.lemuria_dao.daos;

import java.util.List;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Enemigo;

public interface EnemigoDAO {
	public void create (Enemigo e);
	public Enemigo read (Enemigo e);
	public List<Enemigo> read ();
	public void upadate (Enemigo e);
	public void delete (Enemigo e);
}
