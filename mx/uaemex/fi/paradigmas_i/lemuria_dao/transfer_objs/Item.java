package mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs;

import java.util.Objects;

public class Item extends ElementoConNombre{
	protected int nivel;
	protected String descripcion;
	
	public Item() {
		super();
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public boolean equals(Object obj) {
		Item i;
		try {
			i = (Item)obj;
			return i.getNombre().compareTo(this.getNombre())==0;
		}catch(ClassCastException e) {
			return false;
		}
	}
	
	
}
