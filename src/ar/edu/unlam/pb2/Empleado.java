package ar.edu.unlam.pb2;

public class Empleado extends Persona{
	
	private String huellaDactilar;

	public Empleado(String nombre) {
		super(nombre);
		huellaDactilar="";
	}

	@Override
	public void establecerIdentificacion(String huellaDactilar) {
		this.huellaDactilar=huellaDactilar;
	}
	
	@Override
	public String getIdentificacion() {
		return huellaDactilar;
	}

}
