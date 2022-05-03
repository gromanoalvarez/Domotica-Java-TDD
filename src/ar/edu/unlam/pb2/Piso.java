package ar.edu.unlam.pb2;

public class Piso {
	
	private Boolean esAreaDeServicio;
	private Boolean esPar;
	
	public Piso() {
		esAreaDeServicio=false;
		esPar=false;
	}
	
	public void setAreaDeServicio(Boolean queSeaONoAreaDeServicio) {
		esAreaDeServicio=queSeaONoAreaDeServicio;
	}
	
	public Boolean saberSiEsAreaDeServicio(){
		return esAreaDeServicio;
	}

	public void setPar(Boolean b) {
		esPar=true;
	}
	
	public Boolean getPar() {
		return esPar;
	}

}
