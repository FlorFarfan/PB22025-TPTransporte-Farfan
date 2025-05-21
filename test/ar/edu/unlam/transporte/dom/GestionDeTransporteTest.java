package ar.edu.unlam.transporte.dom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GestionDeTransporteTest {

	@Test
	public void sePuedeAgregarUnVehiculo() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Vehiculo bici = new Bicicleta(1);
		
		assertTrue(gestion.agregarVehiculo(bici));
	}
	
	@Test
	public void sePuedeAgregarUnPaqueteABicicleta() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Vehiculo bici = new Bicicleta(1);
		gestion.agregarVehiculo(bici);
		
		Destino destino1 = new Destino("La Matanza");
		gestion.agregarDestino(destino1);
		Paquete paquete = new Paquete(1, 7, 5, 6, 6, destino1);
		gestion.agregarPaquete(paquete);
		
		bici.agregarDestinoAVehiculo(destino1);
		
		assertTrue(bici.agregarPaqueteAVehiculo(paquete));
	}
	
	@Test
	public void sePuedeAgregarUnPaqueteAAutomovil() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Vehiculo auto = new Automovil(1);
		gestion.agregarVehiculo(auto);
		
		Destino destino1 = new Destino("La Matanza");
		Destino destino2 = new Destino("Ezeiza");
		Destino destino3 = new Destino("Tigre");
		gestion.agregarDestino(destino1);
		gestion.agregarDestino(destino2);
		gestion.agregarDestino(destino3);
		
		auto.agregarDestinoAVehiculo(destino1);
		auto.agregarDestinoAVehiculo(destino2);
		auto.agregarDestinoAVehiculo(destino3);
		
		Paquete paquete = new Paquete(1, 7, 5, 6, 6, destino1);
		gestion.agregarPaquete(paquete);
		
		assertEquals(3, auto.getDestinos().size());
		assertTrue(auto.agregarPaqueteAVehiculo(paquete));
	}
	
	@Test
	public void sePuedeAgregarUnPaqueteACamion() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Vehiculo camion = new Camion(1);
		gestion.agregarVehiculo(camion);
		
		Destino destino1 = new Destino("La Matanza");
		Destino destino2 = new Destino("Ezeiza");
		Destino destino3 = new Destino("Tigre");
		gestion.agregarDestino(destino1);
		gestion.agregarDestino(destino2);
		gestion.agregarDestino(destino3);
		
		camion.agregarDestinoAVehiculo(destino1);
		camion.agregarDestinoAVehiculo(destino2);
		camion.agregarDestinoAVehiculo(destino3);
		
		Paquete paquete = new Paquete(1, 7, 5, 6, 1000, destino1);
		Paquete paquete2 = new Paquete(2, 7, 5, 6, 15000, destino1);
		gestion.agregarPaquete(paquete);
		gestion.agregarPaquete(paquete2);
		
		assertTrue(camion.agregarPaqueteAVehiculo(paquete));
		assertTrue(camion.agregarPaqueteAVehiculo(paquete2));
	}
	
	@Test
	public void queUnaBicicletaSoloPuedaHacerEntregasEnSuCiudadAsignada() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		
		Destino destino1 = new Destino("La Matanza");
		Destino destino2 = new Destino("Ezeiza");
		gestion.agregarDestino(destino1);
		gestion.agregarDestino(destino2);
		
		Vehiculo bici = new Bicicleta(1);
		gestion.agregarVehiculo(bici);
		bici.agregarDestinoAVehiculo(destino1);
		
		Paquete paquete = new Paquete(1, 7, 5, 6, 6, destino2);
		gestion.agregarPaquete(paquete);
		
		assertFalse(bici.agregarPaqueteAVehiculo(paquete));
	}
	
	@Test
	public void queUnaBicicletaSoloPuedaHacerEntregaDeDosPaquetesEnSuCiudadAsignada() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		
		Destino destino1 = new Destino("La Matanza");
		gestion.agregarDestino(destino1);
		
		Vehiculo bici = new Bicicleta(1);
		gestion.agregarVehiculo(bici);
		bici.agregarDestinoAVehiculo(destino1);
		
		Paquete paquete = new Paquete(1, 7, 5, 6, 6, destino1);
		gestion.agregarPaquete(paquete);
		Paquete paquete2 = new Paquete(2, 7, 5, 6, 6, destino1);
		gestion.agregarPaquete(paquete2);
		Paquete paquete3 = new Paquete(3, 7, 5, 6, 6, destino1);
		gestion.agregarPaquete(paquete3);
		
		bici.agregarPaqueteAVehiculo(paquete);
		bici.agregarPaqueteAVehiculo(paquete2);
		bici.agregarPaqueteAVehiculo(paquete3);
		
		assertEquals(2, bici.paquetes.size());
	}
	
	@Test
	public void queNoSePuedanAñadirDestinosRepetidosEnAutomovil() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Vehiculo auto = new Automovil(1);
		gestion.agregarVehiculo(auto);
		
		Destino destino1 = new Destino("La Matanza");
		Destino destino2 = new Destino("Ezeiza");
		Destino destino3 = new Destino("Tigre");
		gestion.agregarDestino(destino1);
		gestion.agregarDestino(destino2);
		gestion.agregarDestino(destino3);
		
		auto.agregarDestinoAVehiculo(destino1);
		auto.agregarDestinoAVehiculo(destino2);
		auto.agregarDestinoAVehiculo(destino2);
		auto.agregarDestinoAVehiculo(destino3);
		
		assertEquals(3, auto.getDestinos().size());
	}
	
	@Test
	public void queLosPaquetesDeUnCamionNoExcedanLaCapacidadDePesoMaximo() {
		GestionDeTransporte gestion = new GestionDeTransporte();
		Vehiculo camion = new Camion(1);
		gestion.agregarVehiculo(camion);
		
		Destino destino1 = new Destino("La Matanza");
		Destino destino2 = new Destino("Ezeiza");
		gestion.agregarDestino(destino1);
		gestion.agregarDestino(destino2);
		
		camion.agregarDestinoAVehiculo(destino1);
		camion.agregarDestinoAVehiculo(destino2);
		
		Paquete paquete = new Paquete(1, 7, 5, 6, 10000, destino1);
		Paquete paquete2 = new Paquete(2, 7, 5, 6, 10000, destino2);
		gestion.agregarPaquete(paquete);
		gestion.agregarPaquete(paquete2);
		
		assertTrue(camion.agregarPaqueteAVehiculo(paquete));
		assertFalse(camion.agregarPaqueteAVehiculo(paquete2));
	}
}