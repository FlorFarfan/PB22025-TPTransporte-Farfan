package ar.edu.unlam.transporte.dom;

public class Automovil extends Vehiculo{
	
	public Automovil(int codigo) {
		super(codigo);
		this.maxCapacidadDePeso = 500;
	    this.maxCapacidadDeVolumen = 2e+6;
	    this.maxCantidadDeDestinos = 3;
	}
}
