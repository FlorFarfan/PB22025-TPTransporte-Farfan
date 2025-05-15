package ar.edu.unlam.transporte.dom;

public class Camion extends Vehiculo{

	public Camion(int codigo) {
		super(codigo);
		this.maxCapacidadDePeso = 16000;
	    this.maxCapacidadDeVolumen = 2e+7;
	    this.maxCantidadDeDestinos = 50;
	}

}
