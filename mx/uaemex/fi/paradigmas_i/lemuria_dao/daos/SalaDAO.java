package mx.uaemex.fi.paradigmas_i.lemuria_dao.daos;

import java.util.List;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Sala;


public interface SalaDAO {
	public void create (Sala s);
	public Sala read (Sala s);
	public List<Sala> read();
	public void upadate(Sala s);
	public void delete (Sala s);
}
