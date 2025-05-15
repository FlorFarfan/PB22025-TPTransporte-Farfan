package ar.edu.unlam.transporte.dom;

import java.util.HashSet;
import java.util.Set;

public abstract class Vehiculo {

	protected int codigo;
	protected double maxCapacidadDeVolumen;
	protected double maxCapacidadDePeso;
	protected int maxCantidadDeDestinos;
	protected Set<Destino> destinos;
	protected Set<Paquete> paquetes;
	protected double capacidadDePesoActual;
	protected double capacidadDeVolumenActual;
	
	public Vehiculo(int codigo) {
		this.codigo = codigo;
		this.destinos = new HashSet<Destino>();
		this.paquetes = new HashSet<Paquete>();
		this.capacidadDePesoActual = 0;
		this.capacidadDeVolumenActual = 0;
	}

	public boolean agregarDestinoAVehiculo(Destino destino) {
		if(this.destinos.size() < maxCantidadDeDestinos) {
			return this.destinos.add(destino);
		}
		return false;
	}
	
	public boolean agregarPaqueteAVehiculo(Paquete paquete) {
		if(sePuedeAgregarPaqueteAVehiculo(paquete)) {
			setCapacidadDePesoActual(this.capacidadDePesoActual + paquete.getPeso());
			setCapacidadDeVolumenActual(this.capacidadDeVolumenActual + paquete.getVolumen());
			
			return this.paquetes.add(paquete);
		}
		return false;
	}
	
	public boolean sePuedeAgregarPaqueteAVehiculo(Paquete paquete) {
		if(this.destinos.contains(paquete.getDestino()) && 
				maxCapacidadDePeso >= (paquete.getPeso() + capacidadDePesoActual) &&
				maxCapacidadDeVolumen >= (paquete.getVolumen() + capacidadDeVolumenActual)) {
			return true;
		}
		return false;
	}
	
	public double getMaxCapacidadDeVolumen() {
		return maxCapacidadDeVolumen;
	}

	public void setMaxCapacidadDeVolumen(double maxCapacidadDeVolumen) {
		this.maxCapacidadDeVolumen = maxCapacidadDeVolumen;
	}

	public double getMaxCapacidadDePeso() {
		return maxCapacidadDePeso;
	}

	public void setMaxCapacidadDePeso(double maxCapacidadDePeso) {
		this.maxCapacidadDePeso = maxCapacidadDePeso;
	}

	public int getMaxCantidadDeDestinos() {
		return maxCantidadDeDestinos;
	}

	public void setMaxCantidadDeDestinos(int cantCiudadesQueRecorre) {
		this.maxCantidadDeDestinos = cantCiudadesQueRecorre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Set<Destino> getDestinos() {
		return destinos;
	}

	public void setDestinos(Set<Destino> destinos) {
		this.destinos = destinos;
	}

	public Set<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPaquetes(Set<Paquete> paquetes) {
		this.paquetes = paquetes;
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
	
}
