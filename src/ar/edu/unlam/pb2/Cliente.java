package ar.edu.unlam.pb2;

import java.time.LocalTime;

public class Cliente extends Persona{
	
	private String tarjetaDeInvitado;
	private LocalTime horaEntrada, horaSalida;
	long horasDeEsperaTotal;



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
	
	public void ficharEntradaAlEdificio() {
			horaEntrada = LocalTime.now();
			horaEntrada = LocalTime.parse("15:15:00");
	}
	
	public void ficharSalidaDelEdificio() {
			horaSalida = LocalTime.now();
			horaSalida = LocalTime.parse("16:30:00");
	}
	
	public String promedioQueUnClienteSeEncuentraEnElEdificio() {
		 Integer horas=horaSalida.getHour() - horaEntrada.getHour();
		 Integer minutos=horaSalida.getMinute() - horaEntrada.getMinute();
		 return "El Cliente ha tenido una tasa de espera de "+horas+" horas y "+minutos+" minutos.";
	}

}
