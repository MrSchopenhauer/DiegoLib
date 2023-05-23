package mx.uaemex.fi.paradigmas_i.lemuria.model;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Arma;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Guerrero;
import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Pocion;

public class Personaje extends Guerrero{
	private Mochila mochila;
	private Arma mano;
	private int maxAtaque;
	private int masDefensa;
	private int maxVida;
	
	public Personaje(int maxAtaque, int masDefensa, int maxVida) {
		super();
		this.maxAtaque = maxAtaque;
		this.masDefensa = masDefensa;
		this.maxVida = maxVida;
	}
	
	public void usarPcion(Pocion p) {
		
	}

	public Mochila getMochila() {
		return mochila;
	}

	public void setMochila(Mochila mochila) {
		this.mochila = mochila;
	}

	public Arma getMano() {
		return mano;
	}

	public void setMano(Arma mano) {
		this.mano = mano;
	}
	
	
	
}
