package ar.edu.unlam.transporte.dom;

import java.util.ArrayList;
import java.util.List;

public class GestionDeTransporte {

	private List<Camion> camiones;
	private List<Automovil> automoviles;
	private List<Bicicleta> bicletas;
	
	public GestionDeTransporte() {
		this.camiones = new ArrayList<Camion>();
		this.automoviles = new ArrayList<Automovil>();
		this.bicletas = new ArrayList<Bicicleta>();
	}

	public boolean agregarCamion(Camion camion) {
		return this.camiones.add(camion);
	}
	
	public boolean agregarAutomovil(Automovil auto) {
		return this.automoviles.add(auto);
	}
	
	public boolean agregarBicicleta(Bicicleta bicicleta) {
		return this.bicletas.add(bicicleta);
	}
	
	
}
