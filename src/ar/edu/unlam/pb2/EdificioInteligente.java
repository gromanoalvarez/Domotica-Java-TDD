/**
 * 
 */
package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author German
 *
 */
public class EdificioInteligente {
	
	private String direccion;
	private Piso pisos[];
	private Integer cantidadDePisos, cantidadDeAscensores, cantidadDePersonasDentro;
	
	List<Persona> personas = new ArrayList<Persona>();

	public EdificioInteligente(String direccion, Integer cantidadDePisos) {
		this.direccion=direccion;
		this.cantidadDePisos=cantidadDePisos;
		cantidadDeAscensores=0;
		pisos = new Piso[cantidadDePisos];
		crearPisos();
		cantidadDePersonasDentro=0;
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
	
	public Integer getcantidadDePersonasDentro() {
		return cantidadDePersonasDentro;
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
	
	public Boolean ingresarPersonas(Persona persona) {
		if(persona.getIdentificacion() != "") {
			personas.add(persona);
			cantidadDePersonasDentro++;
			persona.setIngresoAlEdificio(true);
			//debo guardar la hora de entrada del cliente
			return true;
		}return false;
	}

	public void retiroDePersona(Persona persona) {
		personas.remove(persona);
		cantidadDePersonasDentro--;
		persona.setIngresoAlEdificio(false);
		//debo guardar la hora de salida del cliente
	}
	
	public void tomarElAscensor(Persona persona, Ascensor ascensor, Piso pisoDeseado) {
		//restringir que la cantidad de personas o de peso no exceda el limite del ascensor
		//debo setear el pisoDeseado que se guarde en el pisoRealOcupado
	}
	
	public void fichajeDelEmpleado(Persona empleado, Piso pisoAsignado) {
		//para que el empleado fiche entrada y salida 
		//pisoRealOcupado  == pisoAsignado
	}
	
	//crear lista de todos los empleados
	//crear metodo que permita saber los ausentes en el dia
}
