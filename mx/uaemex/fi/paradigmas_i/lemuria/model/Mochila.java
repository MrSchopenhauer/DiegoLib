package mx.uaemex.fi.paradigmas_i.lemuria.model;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Item;

public class Mochila {
	private int capacidad;
	private int inventario;
	
	public Mochila(int capacidad) {
		super();
		this.capacidad = capacidad;
	}
	
	public Item sacar(Item i) {
		return i;
	}
	public Item guardar (Item i) {
		return i;
	}
}
