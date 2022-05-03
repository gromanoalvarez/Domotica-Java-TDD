package ar.edu.unlam.pb2;

public class Empleado extends Persona{
	
	private String huellaDactilar;
	private Piso pisoAsignado;

	public Empleado(String nombre,Piso pisoAsignado) {
		super(nombre);
		huellaDactilar="";
		this.pisoAsignado=pisoAsignado;
	}

	@Override
	public void establecerIdentificacion(String huellaDactilar) {
		this.huellaDactilar=huellaDactilar;
	}
	
	@Override
	public String getIdentificacion() {
		return huellaDactilar;
	}

	public Piso getPisoAsignado() {
		return pisoAsignado;
	}

	public void setPisoAsignado(Piso pisoAsignado) {
		this.pisoAsignado = pisoAsignado;
	}
	
	

}
