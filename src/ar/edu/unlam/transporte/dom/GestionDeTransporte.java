package ar.edu.unlam.transporte.dom;

import java.util.HashSet;
import java.util.Set;

public class GestionDeTransporte {

	private Set<Vehiculo> vehiculos;
	private Set<Destino> destinos;
	private Set<Paquete> paquetes;
	
	public GestionDeTransporte() {
		this.vehiculos = new HashSet<Vehiculo>();
		this.destinos = new HashSet<Destino>();
		this.paquetes = new HashSet<Paquete>();
	}

	public boolean agregarVehiculo(Vehiculo vehiculo) {
		return this.vehiculos.add(vehiculo);
	}
	
	public boolean agregarDestino(Destino destino) {
		return this.destinos.add(destino);
	}
	
	public boolean agregarPaquete(Paquete paquete) {
		return this.paquetes.add(paquete);
	}
}
