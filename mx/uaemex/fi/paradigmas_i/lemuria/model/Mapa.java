package mx.uaemex.fi.paradigmas_i.lemuria.model;

import mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs.Sala;

public class Mapa {
	private int columnas;
	private int renglones;
	private Sala [][] cuadrantes;
	private Coordenadas posciocionActual;
	
	public Mapa(int columnas, int renglones) {
		super();
		this.columnas = columnas;
		this.renglones = renglones;
	}

	public Mapa(Sala[][] cuadrantes) {
		super();
		this.cuadrantes = cuadrantes;
	}

	public Sala[][] getSala() {
		return cuadrantes;
	}
	public void cambiarSala(int dir) {
		
	}

	public void setCuadrantes(Sala[][] cuadrantes, Coordenadas c) {
		this.cuadrantes = cuadrantes;
		this.posciocionActual = c;
	}
	
	
	
}
