package ar.edu.unlam.pb2;

public abstract class Persona {
	
	private String nombre;
	private Boolean ingresoAlEdificio;
	private Double peso;
	
	public Persona(String nombre) {
		this.nombre=nombre;	
		ingresoAlEdificio=false;
		peso=100.0;
	}
	
	public abstract void establecerIdentificacion(String tipoDeIdentificacion);
	public abstract String getIdentificacion();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getIngresoAlEdificio() {
		return ingresoAlEdificio;
	}

	public void setIngresoAlEdificio(Boolean ingresoAlEdificio) {
		this.ingresoAlEdificio = ingresoAlEdificio;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	

}
