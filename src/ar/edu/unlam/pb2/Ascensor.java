package ar.edu.unlam.pb2;

public class Ascensor {
	
	protected Double capacidadDeCargaPorPeso;
	protected Integer capacidadDeCargaPorPersonas;
	protected String pisosAParar;
	
	public Ascensor() {
		capacidadDeCargaPorPeso=1000.0;
		capacidadDeCargaPorPersonas=10;
		pisosAParar="todos";
	}

	public Double getcapacidadDeCargaPorPeso() {
		return capacidadDeCargaPorPeso;
	}

	public void setcapacidadDeCargaPorPeso(Double capacidadDeCargaPorPeso) {
		this.capacidadDeCargaPorPeso = capacidadDeCargaPorPeso;
	}
	
	public Integer getcapacidadDeCargaPorPersonas() {
		return capacidadDeCargaPorPersonas;
	}

	public void setcapacidadDeCargaPorPersonas(Integer capacidadDeCargaPorPersonas) {
		this.capacidadDeCargaPorPersonas = capacidadDeCargaPorPersonas;
	}
	
	public void establecerParadas(String pisosAParar) {
		this.pisosAParar=pisosAParar;
	}
	
	public Boolean saberSiElAscensorPuedePararEnElPisoIndicado(Piso pisoDeseado) {
		if(this instanceof Montacarga) {
			if(pisoDeseado.saberSiEsAreaDeServicio()) return true;
		}else {
			if(pisosAParar.equals("todos")) return true;
			if(pisosAParar.equals("par") && pisoDeseado.getPar().equals(true)) return true;
			if(pisosAParar.equals("impar") && pisoDeseado.getPar().equals(false)) return true;	
		}
		return false;
	}
}
