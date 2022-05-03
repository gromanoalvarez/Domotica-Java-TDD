package ar.edu.unlam.pb2;

public class Cliente extends Persona{
	
	private String tarjetaDeInvitado;

	public Cliente(String nombre) {
		super(nombre);
		tarjetaDeInvitado="";
	}

	@Override
	public void establecerIdentificacion(String tarjetaDeInvitado) {
		this.tarjetaDeInvitado=tarjetaDeInvitado;		
	}

	@Override
	public String getIdentificacion() {
		return tarjetaDeInvitado;
	}

}
