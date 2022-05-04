package ar.edu.unlam.pb2;

import java.time.LocalTime;

public class Empleado extends Persona{
	
	private String huellaDactilar;
	private Piso pisoAsignado;
	private Piso pisoDondeEstaRealmente;
	private Double tiempoFichado;
	private LocalTime horaEntrada, horaSalida;
	long horasTrabajadasEnElDia;

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
			horaEntrada = LocalTime.now();
			horaEntrada = LocalTime.parse("10:15:00");
			return true;
		}
		else return false;
	}

	public Boolean ficharSalidaAlPisoAsignadoParaTrabajo() {
		if(pisoAsignado.equals(pisoDondeEstaRealmente)) {
			horaSalida = LocalTime.now();
			horaSalida = LocalTime.parse("17:15:00");
			return true;
		}
		else return false;
	}
	
	public String getTotalDeTiempoFichadoEnEldia(){
		 Integer horas=horaSalida.getHour() - horaEntrada.getHour();
		 Integer minutos=horaSalida.getMinute() - horaEntrada.getMinute();
		 return "El empleado ha trabajado "+horas+" horas y "+minutos+" minutos.";
	}
	
}
