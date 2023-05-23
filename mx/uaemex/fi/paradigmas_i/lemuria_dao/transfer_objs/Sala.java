package mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs;

public class Sala extends ElementoConNombre {
	private Enemigo masSiOsare;
	private Item coso;
	
	public Sala() {
		super();
	}
	
	public Sala(String n) {
		super();
		this.nombre = n;
	}

	public Sala(String n, Enemigo masSiOsare, Item coso) {
		super();
		this.nombre = n;
		this.masSiOsare = masSiOsare;
		this.coso = coso;
	}

	public Enemigo getMasSiOsare() {
		return masSiOsare;
	}

	public void setMasSiOsare(Enemigo masSiOsare) {
		this.masSiOsare = masSiOsare;
	}

	public Item getCoso() {
		return coso;
	}

	public void setCoso(Item coso) {
		this.coso = coso;
	}
	//nombre 
	@Override
	public String toString() {
		if (this.masSiOsare == null && this.coso==null) {
			return "[Nombre de la Sala = "+super.toString() +"]";
		}
		if (this.coso == null) {
			return "[Nombre de la Sala = "+super.toString() +"] [Nombre del enemigo =" + this.masSiOsare.toString() + "]";
		}
		return "[Nombre de la Sala = "+super.toString() +"] [Nombre del enemigo =" + this.masSiOsare.toString() + "] [Item =" + this.coso.toString() + "]";
	}
	
	
}
