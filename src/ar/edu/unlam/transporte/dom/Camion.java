package ar.edu.unlam.transporte.dom;

import java.util.ArrayList;
import java.util.List;

public class Camion {

	private double maxCapacidadDePeso;
	private double maxCapacidadDeVolumen;
	private List<Destino> destinos;
	private List<Paquete> paquetes;
	private double capacidadDePesoActual = 0;
	private double capacidadDeVolumenActual = 0;
	
	public Camion() {
		this.maxCapacidadDePeso = 16000;
		this.maxCapacidadDeVolumen = 2e+7;
		this.paquetes = new ArrayList<Paquete>();
		this.destinos = new ArrayList<Destino>();
	}

	public boolean agregarDestinoACamion(Destino destino) {
		return this.destinos.add(destino);
	}
	
	public boolean agregarPaqueteACamion(Paquete paquete) {
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

	public List<Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	public List<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(List<Paquete> paquetes) {
		this.paquetes = paquetes;
	}
	
}
