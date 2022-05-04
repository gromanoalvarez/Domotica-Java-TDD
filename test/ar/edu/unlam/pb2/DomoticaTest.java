/**
 * 
 */
package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Test;

/**
 * @author German Romano Alvarez
 *
 */
public class DomoticaTest {
	
	@Test
	public void queSePuedaCrearUnEdificioInteligente() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 12);
		
		assertNotNull(edificioInteligente);
	}
	
	@Test
	public void queDesdeElEdificioSePuedaSaberSiUnPisoEsAreaDeServicio() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 12);
		//por defecto no lo es
		assertFalse(edificioInteligente.saberSiElPisoEsAreaDeServicio(2));
		
		//al modificarlo lo reconoce
		edificioInteligente.configurarPisosParaAreasDeServicios(2, true);
		assertTrue(edificioInteligente.saberSiElPisoEsAreaDeServicio(2));
	}
	
	@Test
	public void queDesdeElEdificioSePuedaSaberSiUnPisoEspar() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 12);

		assertTrue(edificioInteligente.getPiso(0).getPar());
		assertFalse(edificioInteligente.getPiso(1).getPar());		
	}
	
	@Test
	public void queDesdeElEdificioPuedaContenerAscensoresYMontacargas() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 12);
		final Integer CANTIDAD_ESPERADA=5;
		
		edificioInteligente.crearAscensor();
		edificioInteligente.crearAscensor();
		edificioInteligente.crearAscensor();
		edificioInteligente.crearAscensor();
		edificioInteligente.crearMontacarga();

		assertEquals(CANTIDAD_ESPERADA, edificioInteligente.getCantidadDeAscensores());		
	}
	
	@Test
	public void queMontacargaSoloPareEnAreasDeServicio() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		 Ascensor nuevoAscensor= edificioInteligente.crearMontacarga();
		 edificioInteligente.configurarPisosParaAreasDeServicios(3, true);
		 
		assertFalse(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(0)));
		assertFalse(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(1)));
		assertFalse(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(2)));
		assertTrue(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(3)));
		assertFalse(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(4)));
	}
	
	@Test
	public void queAscensorConfiguradoEnPisosParRespeteSusParadas() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		 Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		 nuevoAscensor.establecerParadas("par");
	
		 	assertTrue(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(0)));
			assertFalse(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(1)));
			assertTrue(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(2)));
			assertFalse(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(3)));
			assertTrue(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(4)));
	}
	
	@Test
	public void queAscensorConfiguradoEnPisosImparRespeteSusParadas() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		 Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		 nuevoAscensor.establecerParadas("impar");

			assertFalse(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(0)));
			assertTrue(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(1)));
			assertFalse(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(2)));
			assertTrue(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(3)));
			assertFalse(nuevoAscensor.saberSiElAscensorPuedePararEnElPisoIndicado(edificioInteligente.getPiso(4)));
	}
	
	@Test
	public void queSePuedanCrearEmpleadosYClientes() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Persona uno =new Empleado("javier", edificioInteligente.getPiso(2));
		Persona dos =new Cliente("micaela");
		
		assertNotNull(uno);
		assertNotNull(dos);
	}
	
	@Test
	public void queAlEdificioPuedanIngresarPersonasConIdentificacionEstablecida() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Persona uno =new Empleado("javier",edificioInteligente.getPiso(2));
		Persona dos =new Cliente("micaela");
		Persona tres =new Cliente("coral");
		final Integer CANTIDAD_PERSONAS_ESPERADAS=2;
		
		uno.establecerIdentificacion("token 1234");
		edificioInteligente.ingresarPersonas(uno);
		dos.establecerIdentificacion("token 000");
		edificioInteligente.ingresarPersonas(dos);
		//El siguiente sin identificacion no ingresa
		edificioInteligente.ingresarPersonas(tres);

		assertEquals(CANTIDAD_PERSONAS_ESPERADAS, (Integer)edificioInteligente.personas.size());
		assertEquals(CANTIDAD_PERSONAS_ESPERADAS, edificioInteligente.getcantidadDePersonasDentro());
	}
	
	@Test
	public void queDelEdificioPuedanSalirLasPersonas() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Persona uno =new Empleado("javier",edificioInteligente.getPiso(2));
		Persona dos =new Cliente("micaela");
		Persona tres =new Cliente("coral");
		final Integer CANTIDAD_PERSONAS_ESPERADAS=1;
		
		uno.establecerIdentificacion("token 1234");
		edificioInteligente.ingresarPersonas(uno);
		dos.establecerIdentificacion("token 000");
		edificioInteligente.ingresarPersonas(dos);
		tres.establecerIdentificacion("cori");
		edificioInteligente.ingresarPersonas(tres);
		
		edificioInteligente.retiroDePersona(uno);
		edificioInteligente.retiroDePersona(dos);

		assertEquals(CANTIDAD_PERSONAS_ESPERADAS, (Integer)edificioInteligente.personas.size());
		assertEquals(CANTIDAD_PERSONAS_ESPERADAS, edificioInteligente.getcantidadDePersonasDentro());
	}
	
	@Test
	public void queUnaPersonaQueIngresoAlEdificioPuedaTomarUnAscensor() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		Persona tres =new Cliente("coral");
		
		//para que la persona tome el ascensor primero debe estar dentro del edificio
		tres.establecerIdentificacion("vengo a hacer reclamo");
		edificioInteligente.ingresarPersonas(tres);

		assertTrue(nuevoAscensor.ingresarPersonaAlAscensor(tres));
	}
	
	@Test
	public void queUnaPersonaQueIngresoAlEdificioPuedaTomarUnAscensorSinPasarLasCapacidadesDelMismo() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		Persona tres =new Cliente("coral");
		
		//para que la persona tome el ascensor primero debe estar dentro del edificio
		tres.establecerIdentificacion("vengo a hacer reclamo");
		edificioInteligente.ingresarPersonas(tres);
		
		//que respete capacidad de personas=4
		assertTrue(nuevoAscensor.ingresarPersonaAlAscensor(tres));
		assertTrue(nuevoAscensor.ingresarPersonaAlAscensor(tres));
		assertTrue(nuevoAscensor.ingresarPersonaAlAscensor(tres));
		assertTrue(nuevoAscensor.ingresarPersonaAlAscensor(tres));
		assertFalse(nuevoAscensor.ingresarPersonaAlAscensor(tres));

		Ascensor nuevoAscensor2= edificioInteligente.crearAscensor();

		tres.setPeso(150.0);
		//que respete pesoMaximo=500.0kg
		assertTrue(nuevoAscensor2.ingresarPersonaAlAscensor(tres));
		assertTrue(nuevoAscensor2.ingresarPersonaAlAscensor(tres));
		assertTrue(nuevoAscensor2.ingresarPersonaAlAscensor(tres));
		assertFalse(nuevoAscensor2.ingresarPersonaAlAscensor(tres));		
	}
	
	@Test
	public void queLaPersonaAlBajarDelAscensorSeActualicenLasCapacidadesDelMismo() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		Persona tres =new Cliente("coral");
		Persona dos =new Cliente("micaela");
		final Integer PERSONAS_ESPERADAS_DENTRO=1;
		final Double PESO_ESPERADO_DENTRO=100.0;
	
		//para que la persona tome el ascensor primero debe estar dentro del edificio
		tres.establecerIdentificacion("vengo a hacer reclamo");
		edificioInteligente.ingresarPersonas(tres);
		dos.establecerIdentificacion("vengo a hacer reclamo");
		edificioInteligente.ingresarPersonas(dos);
		
		assertTrue(nuevoAscensor.ingresarPersonaAlAscensor(tres));
		assertTrue(nuevoAscensor.ingresarPersonaAlAscensor(dos));
		assertTrue(nuevoAscensor.sacarPersonaDelAscensor(dos));		
		//Que  baje la cantidad de personas
		assertEquals(PERSONAS_ESPERADAS_DENTRO, nuevoAscensor.cantidadDePersonasIngresadas);
		//Que baje el peso acumulado
		assertEquals(PESO_ESPERADO_DENTRO, nuevoAscensor.pesoAcumulado);
	}
	
	@Test
	public void queElEmpleadoFicheCuandoIngresaASuPisoCorrespondiente() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		nuevoAscensor.establecerParadas("impar");
		Piso pisoAsignadoAMartina = edificioInteligente.getPiso(3);
		Empleado martina =new Empleado("martina", pisoAsignadoAMartina);
		martina.establecerIdentificacion("atencion al cliente");
		assertTrue(edificioInteligente.ingresarPersonas(martina));
		assertTrue(nuevoAscensor.viajarPorAscensor(martina, pisoAsignadoAMartina));
		assertTrue(martina.ficharEntradaAlPisoAsignadoParaTrabajo());
		
		//que si esta en otro piso fuera de su sector asignado no pueda fichar
		Piso otroPisoImpar = edificioInteligente.getPiso(1);
		assertTrue(nuevoAscensor.viajarPorAscensor(martina, otroPisoImpar));
		assertFalse(martina.ficharEntradaAlPisoAsignadoParaTrabajo());
	}
	
	@Test
	public void queElEmpleadoFicheSalidaEnSuPisoCorrespondiente() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		nuevoAscensor.establecerParadas("impar");
		Piso pisoAsignadoAMartina = edificioInteligente.getPiso(3);
		Empleado martina =new Empleado("martina", pisoAsignadoAMartina);
		martina.establecerIdentificacion("atencion al cliente");
		assertTrue(edificioInteligente.ingresarPersonas(martina));
		assertTrue(nuevoAscensor.viajarPorAscensor(martina, pisoAsignadoAMartina));
		assertTrue(martina.ficharEntradaAlPisoAsignadoParaTrabajo());
		assertTrue(martina.ficharSalidaAlPisoAsignadoParaTrabajo());
		
		//que si esta en otro piso fuera de su sector asignado no pueda fichar
		Piso otroPisoImpar = edificioInteligente.getPiso(1);
		assertTrue(nuevoAscensor.viajarPorAscensor(martina, otroPisoImpar));
		assertFalse(martina.ficharSalidaAlPisoAsignadoParaTrabajo());
	}
	
	@Test // CONSIGNA A)
	public void queSePuedaConocerElTiempoTrabajadoAlDiaDeUnEmpleado() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		nuevoAscensor.establecerParadas("impar");
		Piso pisoAsignadoAMartina = edificioInteligente.getPiso(3);
		Empleado martina =new Empleado("martina", pisoAsignadoAMartina);
		martina.establecerIdentificacion("atencion al cliente");
		final String TIEMPO_ESPERADO= "El empleado ha trabajado 7 horas y 0 minutos.";
		
		assertTrue(edificioInteligente.ingresarPersonas(martina));
		assertTrue(nuevoAscensor.viajarPorAscensor(martina, pisoAsignadoAMartina));
		assertTrue(martina.ficharEntradaAlPisoAsignadoParaTrabajo());
		assertTrue(martina.ficharSalidaAlPisoAsignadoParaTrabajo());
		assertEquals(TIEMPO_ESPERADO, martina.getTotalDeTiempoFichadoEnEldia());		
	}
	
	@Test // CONSIGNA B)
	public void queSePuedaConocerTasaDeEsperaDeAtencionDelClienteEnElEdificio() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		Piso pisoDeGarantias = edificioInteligente.getPiso(2);
		nuevoAscensor.establecerParadas("par");
		Cliente cesar =new Cliente("cesar");
		cesar.establecerIdentificacion("reclamo de garantia");
		final String TASA_DE_ESPERA= "El Cliente ha tenido una tasa de espera de 1 horas y 15 minutos.";
		
		assertTrue(edificioInteligente.ingresarPersonas(cesar));
		assertTrue(nuevoAscensor.viajarPorAscensor(cesar,pisoDeGarantias));
		edificioInteligente.retiroDePersona(cesar);
		assertEquals(TASA_DE_ESPERA, cesar.promedioQueUnClienteSeEncuentraEnElEdificio());
	}
	
	@Test
	public void queElEdificioPuedaAgregarUnNuevoEmpleadoASuLista() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Piso pisoDeGarantias = edificioInteligente.getPiso(2);
		Piso pisoDeAsesoramiento = edificioInteligente.getPiso(1);
		Piso pisoDeJefes = edificioInteligente.getPiso(3);

		edificioInteligente.nuevoEmpleado("daniel", pisoDeGarantias);
		edificioInteligente.nuevoEmpleado("ludmila", pisoDeGarantias);
		edificioInteligente.nuevoEmpleado("viviana", pisoDeAsesoramiento);
		edificioInteligente.nuevoEmpleado("martha", pisoDeJefes);
		edificioInteligente.nuevoEmpleado("alexis", pisoDeAsesoramiento);
		edificioInteligente.nuevoEmpleado("pedro", pisoDeJefes);
		
		final Integer TOTAL_EMPLEADOS = 6;
		assertEquals(TOTAL_EMPLEADOS, (Integer)edificioInteligente.totalDeEmpleados.size());
	}

	@Test
	public void listadoDePresentes() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Piso pisoDeGarantias = edificioInteligente.getPiso(2);
		Piso pisoDeAsesoramiento = edificioInteligente.getPiso(1);
		Piso pisoDeJefes = edificioInteligente.getPiso(3);
		Ascensor nuevoAscensor= edificioInteligente.crearAscensor();


		Empleado daniel = edificioInteligente.nuevoEmpleado("daniel", pisoDeGarantias);
		Empleado martha =edificioInteligente.nuevoEmpleado("martha", pisoDeJefes);
		
		//Hacer que solamente uno vaya al edificio a fichar el presente:
		final Integer TOTAL_EMPLEADOS_PRESENTES = 1; 
		martha.establecerIdentificacion("jefa");
		edificioInteligente.ingresarPersonas(martha);
		
		assertEquals(TOTAL_EMPLEADOS_PRESENTES, (Integer)edificioInteligente.presentes.size());
	}
	
	@Test
	public void listadoDeAusentes() {
		EdificioInteligente edificioInteligente = new EdificioInteligente("Bouchard 459", 5);
		Piso pisoDeGarantias = edificioInteligente.getPiso(2);
		Piso pisoDeAsesoramiento = edificioInteligente.getPiso(1);
		Piso pisoDeJefes = edificioInteligente.getPiso(3);
		Ascensor nuevoAscensor= edificioInteligente.crearAscensor();
		final Integer TOTAL_EMPLEADOS = 3;
		final Integer TOTAL_EMPLEADOS_PRESENTES = 1; 
		final Integer TOTAL_EMPLEADOS_AUSENTES = 2; 

		Empleado daniel = edificioInteligente.nuevoEmpleado("daniel", pisoDeGarantias);
		Empleado martha = edificioInteligente.nuevoEmpleado("martha", pisoDeJefes);
		Empleado viviana =edificioInteligente.nuevoEmpleado("viviana", pisoDeAsesoramiento);

		
		//Hacer que solamente uno vaya al edificio a fichar el presente:
		martha.establecerIdentificacion("jefa");
		edificioInteligente.ingresarPersonas(martha);
		edificioInteligente.calcularEmpleadosAusentes();
		
		assertEquals(TOTAL_EMPLEADOS, (Integer)edificioInteligente.totalDeEmpleados.size());
		assertEquals(TOTAL_EMPLEADOS_PRESENTES, (Integer)edificioInteligente.presentes.size());
		assertEquals(TOTAL_EMPLEADOS_AUSENTES, (Integer)edificioInteligente.ausentes.size());		
	}

}
