package mx.uaemex.fi.paradigmas_i.lemuria_dao.daos;

import java.util.List;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Pocion;

public interface PocionDAO {
	public void create (Pocion p);
	public Pocion read (Pocion p);
	public List<Pocion> read();
	public void upadate(Pocion p);
	public void delete (Pocion p);
}
