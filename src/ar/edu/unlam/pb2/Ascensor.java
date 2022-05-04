package ar.edu.unlam.pb2;

public class Ascensor {
	
	protected Double capacidadDeCargaPorPeso, pesoAcumulado;
	protected Integer capacidadDeCargaPorPersonas, cantidadDePersonasIngresadas;
	protected String pisosAParar;
	protected Persona personasDentro[];
	
	public Ascensor() {
		capacidadDeCargaPorPeso=500.0;
		capacidadDeCargaPorPersonas=4;
		pisosAParar="todos";
		cantidadDePersonasIngresadas=0;
		personasDentro= new Persona[capacidadDeCargaPorPersonas];
		pesoAcumulado=0.0;
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
	
	public Boolean ingresarPersonaAlAscensor(Persona persona) {
		if(persona.getIngresoAlEdificio() &&  cantidadDePersonasIngresadas < capacidadDeCargaPorPersonas && (pesoAcumulado + persona.getPeso()) <= capacidadDeCargaPorPeso) {
			for (int i = 0; i < personasDentro.length; i++) {
				if(personasDentro[i]==null) {
					personasDentro[i]=persona;
					cantidadDePersonasIngresadas++;
					pesoAcumulado+=persona.getPeso();
					return true;
				}
			}
			return true;
		}
		return false;
	}
	
	public Boolean sacarPersonaDelAscensor(Persona persona) {
		for (int i = 0; i < personasDentro.length; i++) {
			if(personasDentro[i].equals(persona)) {
				personasDentro[i]=null;
				cantidadDePersonasIngresadas--;
				pesoAcumulado-=persona.getPeso();
				return true;
			}
		}return false;
	}
}
