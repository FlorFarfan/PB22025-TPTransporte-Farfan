package ar.edu.unlam.transporte.dom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Automovil {

	private double maxCapacidadDePeso;
	private double maxCapacidadDeVolumen;
	private Set<Destino> destinos;
	private List<Paquete> paquetes;
	private final int maxCantidadDeDestinos = 3;
	private double capacidadDePesoActual = 0;
	private double capacidadDeVolumenActual = 0;
	
	public Automovil() {
		this.maxCapacidadDePeso = 500;
		this.maxCapacidadDeVolumen = 2e+6;
		this.paquetes = new ArrayList<Paquete>();
		this.destinos = new HashSet<Destino>();
	}

	public boolean agregarDestinoAAutomovil(Destino destino) {
		if(this.destinos.size() < maxCantidadDeDestinos) {
			return this.destinos.add(destino);
		}
		return false;
	}
	
	public boolean agregarPaqueteAAutomovil(Paquete paquete) {
		if(this.destinos.contains(paquete.getDestino()) && maxCapacidadDePeso >= paquete.getPeso() && 
				maxCapacidadDeVolumen >= paquete.getVolumen()) {
			setCapacidadDePesoActual(this.capacidadDePesoActual + paquete.getPeso());
			setCapacidadDeVolumenActual(this.capacidadDeVolumenActual + paquete.getVolumen());
			return this.paquetes.add(paquete);
			
		}
		return false;
	}
	
	public double getCapacidadDePesoActual() {
		return capacidadDePesoActual;
	}

	public void setCapacidadDePesoActual(double capacidadDePesoActual) {
		this.capacidadDePesoActual = capacidadDePesoActual;
	}

	public double getCapacidadDeVolumenActual() {
		return capacidadDeVolumenActual;
	}

	public void setCapacidadDeVolumenActual(double capacidadDeVolumenActual) {
		this.capacidadDeVolumenActual = capacidadDeVolumenActual;
	}

	public double getMaxCapacidadDePeso() {
		return maxCapacidadDePeso;
	}

	public void setMaxCapacidadDePeso(double maxCapacidadDePeso) {
		this.maxCapacidadDePeso = maxCapacidadDePeso;
	}

	public double getMaxCapacidadDeVolumen() {
		return maxCapacidadDeVolumen;
	}

	public void setMaxCapacidadDeVolumen(double maxCapacidadDeVolumen) {
		this.maxCapacidadDeVolumen = maxCapacidadDeVolumen;
	}

	public Set<Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(Set<Destino> destinos) {
		this.destinos = destinos;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	public int getMaxCantidadDeDestinos() {
		return maxCantidadDeDestinos;
	}
	
}
