package ar.edu.unlam.transporte.dom;

import java.util.ArrayList;

public class Bicicleta {

	private double maxCapacidadDePeso;
	private double maxCapacidadDeVolumen;
	private Destino destino;
	private ArrayList<Paquete> paquetes;
	private final int maxCantidadDePaquetes = 2;
	private double capacidadDePesoActual = 0;
	private double capacidadDeVolumenActual = 0;
	
	public Bicicleta() {
		this.maxCapacidadDePeso = 15;
		this.maxCapacidadDeVolumen = 125000;
		this.paquetes = new ArrayList<Paquete>();
	}
	
	public Bicicleta(Destino destino) {
		this.maxCapacidadDePeso = 15;
		this.maxCapacidadDeVolumen = 125000;
		this.destino = destino;
		this.paquetes = new ArrayList<Paquete>();
	}

	public boolean agregarPaqueteABicicleta(Paquete paquete) {
		if(this.paquetes.size() < maxCantidadDePaquetes && this.destino == paquete.getDestino()
				&& maxCapacidadDePeso >= paquete.getPeso() && 
				maxCapacidadDeVolumen >= paquete.getVolumen()) {
			setCapacidadDePesoActual(this.capacidadDePesoActual + paquete.getPeso());
			setCapacidadDeVolumenActual(this.capacidadDeVolumenActual + paquete.getVolumen());
			
			return this.paquetes.add(paquete);
		}
		else if(this.destino != paquete.getDestino()) {
			return false;
			
		} else if(this.paquetes.size() == maxCantidadDePaquetes) {
			return false;
			
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

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}
	
}
