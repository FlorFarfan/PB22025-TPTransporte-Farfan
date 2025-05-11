package ar.edu.unlam.transporte.dom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GestionDeTransporteTest {

	@Test
	public void agregarVehiculoExitoso() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Bicicleta bici = new Bicicleta();
		
		assertTrue(gestion.agregarBicicleta(bici));
	}
	
	@Test
	public void agregarPaqueteExitosoABicicleta() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Bicicleta bici = new Bicicleta();
		gestion.agregarBicicleta(bici);
		Destino destino1 = new Destino("Madero");
		Paquete paquete = new Paquete(7, 5, 6, 6, destino1);
		bici.setDestino(paquete.getDestino());
		
		assertTrue(bici.agregarPaqueteABicicleta(paquete));
	}
	
	@Test
	public void agregarPaqueteExitosoAAutomovil() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Automovil auto = new Automovil();
		gestion.agregarAutomovil(auto);
		
		Destino destino1 = new Destino("Madero");
		Destino destino2 = new Destino("Capital");
		Destino destino3 = new Destino("San Justo");
		
		auto.agregarDestinoAAutomovil(destino1);
		auto.agregarDestinoAAutomovil(destino2);
		auto.agregarDestinoAAutomovil(destino3);
		
		Paquete paquete = new Paquete(7, 5, 6, 6, destino1);
		
		assertEquals(3, auto.getDestinos().size());
		assertTrue(auto.agregarPaqueteAAutomovil(paquete));
	}
	
	@Test
	public void agregarPaqueteExitosoACamion() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Camion camion = new Camion();
		gestion.agregarCamion(camion);
		
		Destino destino1 = new Destino("Madero");
		Destino destino2 = new Destino("Capital");
		Destino destino3 = new Destino("San Justo");
		
		camion.agregarDestinoACamion(destino1);
		camion.agregarDestinoACamion(destino2);
		camion.agregarDestinoACamion(destino3);
		
		Paquete paquete = new Paquete(7, 5, 6, 1000, destino1);
		Paquete paquete2 = new Paquete(7, 5, 6, 15000, destino1);
		
		assertTrue(camion.agregarPaqueteACamion(paquete));
		assertTrue(camion.agregarPaqueteACamion(paquete2));
	}
	
	@Test
	public void queUnaBicicletaSoloPuedaHacerEntregasEnSuCiudadAsignada() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		
		Destino destino1 = new Destino("Madero");
		Destino destino2 = new Destino("Capital");
		Bicicleta bici = new Bicicleta(destino1);
		
		gestion.agregarBicicleta(bici);
		
		Paquete paquete = new Paquete(7, 5, 6, 6, destino2);
		
		assertFalse(bici.agregarPaqueteABicicleta(paquete));
	}
	
	@Test
	public void queNoSePuedanAñadirDestinosRepetidosEnAutomovil() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Automovil auto = new Automovil();
		gestion.agregarAutomovil(auto);
		
		Destino destino1 = new Destino("Madero");
		Destino destino2 = new Destino("Capital");
		Destino destino3 = new Destino("San Justo");
		
		auto.agregarDestinoAAutomovil(destino1);
		auto.agregarDestinoAAutomovil(destino2);
		auto.agregarDestinoAAutomovil(destino2);
		auto.agregarDestinoAAutomovil(destino3);
		
		
		assertEquals(3, auto.getDestinos().size());
	}
	
	@Test
	public void agregarDosPaquetesAUnCamionQueNoExcedanLaCapacidadDePesoMaximo() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Camion camion = new Camion();
		gestion.agregarCamion(camion);
		
		Destino destino1 = new Destino("Madero");
		Destino destino2 = new Destino("Capital");
		Destino destino3 = new Destino("San Justo");
		
		camion.agregarDestinoACamion(destino1);
		camion.agregarDestinoACamion(destino2);
		camion.agregarDestinoACamion(destino3);
		
		Paquete paquete = new Paquete(7, 5, 6, 1000, destino1);
		Paquete paquete2 = new Paquete(7, 5, 6, 14000, destino1);
		
		assertTrue(camion.agregarPaqueteACamion(paquete));
		assertTrue(camion.agregarPaqueteACamion(paquete2));
		
		double capacidadDePesoActualDelCamion = camion.getCapacidadDePesoActual();
		
		assertEquals(15000d, capacidadDePesoActualDelCamion, 0.1);
	}
}
