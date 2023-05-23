package mx.uaemex.fi.paradigmas_i.lemuria_dao.transfer_objs;

public class ElementoConNombre {
	protected String nombre;
	protected String imagen;
	protected int id;
	
	
	public ElementoConNombre() {
		super();
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	//nombre
	@Override
	public String toString() {
		return this.id+" [Nombre = " + this.nombre + "]";
	}
	
	
}
