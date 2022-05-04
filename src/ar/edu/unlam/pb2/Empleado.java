package ar.edu.unlam.pb2;

public class Empleado extends Persona{
	
	private String huellaDactilar;
	private Piso pisoAsignado;
	private Piso pisoDondeEstaRealmente;
	private Double tiempoFichado;

	public Empleado(String nombre,Piso pisoAsignado) {
		super(nombre);
		huellaDactilar="";
		this.pisoAsignado=pisoAsignado;
		pisoDondeEstaRealmente=null;
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
	
	public void setPisoDondeEstaRealmente(Piso pisoDondeEstaRealmente) {
		this.pisoDondeEstaRealmente = pisoDondeEstaRealmente;
	}

	public Piso getPisoDondeEstaRealmente() {
		return pisoDondeEstaRealmente;
	}

	public Boolean ficharEntradaAlPisoAsignadoParaTrabajo() {
		if(pisoAsignado.equals(pisoDondeEstaRealmente)) {
			return true;
		}
		else return false;
	}

	public Boolean ficharSalidaAlPisoAsignadoParaTrabajo() {
		if(pisoAsignado.equals(pisoDondeEstaRealmente)) return true;
		else return false;
	}
}
