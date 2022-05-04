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
	List<Empleado> totalDeEmpleados = new ArrayList<Empleado>();
	List<Empleado> presentes = new ArrayList<Empleado>();
	 List<Empleado> ausentes = new ArrayList<Empleado>();


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
			if(persona instanceof Empleado) {
				((Empleado) persona).setPisoDondeEstaRealmente(pisos[0]);
				presentes.add((Empleado) persona);
			}
			if(persona instanceof Cliente)((Cliente) persona).ficharEntradaAlEdificio();
			return true;
		}return false;
	}

	public void retiroDePersona(Persona persona) {
		if(persona instanceof Cliente)((Cliente) persona).ficharSalidaDelEdificio();
		personas.remove(persona);
		cantidadDePersonasDentro--;
		persona.setIngresoAlEdificio(false);
	}

	public Empleado nuevoEmpleado(String nombre, Piso pisoAsignadoParaTrabajar) {
		Empleado nuevo = new Empleado(nombre, pisoAsignadoParaTrabajar);
		totalDeEmpleados.add(nuevo);
		return nuevo;
	}
	
	public List<Empleado> mostrarPresentes() {
		return presentes;
	}
	
	public void calcularEmpleadosAusentes() {
		for (Empleado empleado: totalDeEmpleados) {
			if(!presentes.contains(empleado)) {
				ausentes.add(empleado);
			}
		}
	}

	public List<Empleado> mostrarEmpleadosTotales() {
		return totalDeEmpleados;
	}

}
