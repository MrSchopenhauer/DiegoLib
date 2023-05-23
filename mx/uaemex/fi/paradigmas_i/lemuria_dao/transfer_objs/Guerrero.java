
package mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs;

public class Guerrero extends ElementoConNombre {
	private int vida;
	private int defensa;
	private  int ataque;
	
	public Guerrero() {
		super();
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	
	
}
