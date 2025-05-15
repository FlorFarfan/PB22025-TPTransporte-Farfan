package ar.edu.unlam.transporte.dom;

public class Bicicleta extends Vehiculo{

	private final int maxCantidadDePaquetes = 2;
	
	public Bicicleta(int codigo) {
		super(codigo);
		this.maxCapacidadDePeso = 15;
	    this.maxCapacidadDeVolumen = 125000;
	    this.maxCantidadDeDestinos = 1;
	}
	
	public void noTieneDestinoAsignado(Paquete paquete) {
		if(this.destinos == null) {
			destinos.add(paquete.getDestino());
		}
	}
	
	@Override
	public boolean sePuedeAgregarPaqueteAVehiculo(Paquete paquete) {
		noTieneDestinoAsignado(paquete);
		if(this.destinos.contains(paquete.getDestino()) && 
				this.paquetes.size() < maxCantidadDePaquetes &&
				maxCapacidadDePeso >= (paquete.getPeso() + capacidadDePesoActual) &&
				maxCapacidadDeVolumen >= (paquete.getVolumen() + capacidadDeVolumenActual)) {
			return true;
		}
		return false;
	}
	
}
