/**
 * 
 */
package ar.edu.unlam.pb2;

/**
 * @author German
 *
 */
public class EdificioInteligente {
	
	private String direccion;
	private Piso pisos[];
	private Integer cantidadDePisos, cantidadDeAscensores;

	public EdificioInteligente(String direccion, Integer cantidadDePisos) {
		this.direccion=direccion;
		this.cantidadDePisos=cantidadDePisos;
		cantidadDeAscensores=0;
		pisos = new Piso[cantidadDePisos];
		crearPisos();
	}
	
	private void crearPisos(){
		for(int i=0; i<pisos.length;i++) {
			if(pisos[i] == null) {
				pisos[i] = new Piso();
				if( i==0 || i%2 == 0 ) pisos[i].setPar(true);
			}
		}
	}
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public Piso getPiso(Integer numeroDePiso) {
		return pisos[numeroDePiso];
	}

	public Integer getCantidadDePisos() {
		return cantidadDePisos;
	}
	
	public Integer getCantidadDeAscensores() {
		return cantidadDeAscensores;
	}
	
	public Boolean saberSiElPisoEsAreaDeServicio(Integer numeroDePiso) {
		return pisos[numeroDePiso].saberSiEsAreaDeServicio();
	}
	
	public void configurarPisosParaAreasDeServicios(Integer numeroDePiso, Boolean esONoAreaDeServicio) {
		pisos[numeroDePiso].setAreaDeServicio(esONoAreaDeServicio);
	}

	public Ascensor crearAscensor() {
		Ascensor nuevoAscensor = new Ascensor();
		cantidadDeAscensores++;
		return nuevoAscensor;
	}
	public Ascensor crearMontacarga() {
		Ascensor nuevoMontacarga = new Montacarga();
		cantidadDeAscensores++;
		return nuevoMontacarga;

	}

}
