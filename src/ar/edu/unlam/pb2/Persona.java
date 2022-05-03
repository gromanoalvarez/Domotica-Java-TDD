package ar.edu.unlam.pb2;

public abstract class Persona {
	
	private String nombre;
	
	public Persona(String nombre) {
		this.nombre=nombre;	
	}
	
	public abstract void establecerIdentificacion(String tipoDeIdentificacion);
	public abstract String getIdentificacion();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
