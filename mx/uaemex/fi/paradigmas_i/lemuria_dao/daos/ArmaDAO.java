package mx.uaemex.fi.paradigmas_i.lemuria_dao.daos;

import java.util.List;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Arma;

public interface ArmaDAO {
	public void create (Arma a);
	public Arma read (Arma a);
	public List<Arma> read ();
	public void upadate(Arma a);
	public void delete (Arma a);
	
}
