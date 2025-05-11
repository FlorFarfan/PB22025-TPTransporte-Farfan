package ar.edu.unlam.transporte.dom;

public class Paquete {

	private double largo;
	private double ancho;
	private double profundidad;
	private double volumen;
	private double peso;
	private Destino destino;
	
	public Paquete(double largo, double ancho, double profundidad, double peso, Destino destino) {
		this.largo = largo;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.peso = peso;
		this.destino = destino;
		this.volumen = calcularVolumenDelPaquete();
	}

	public double calcularVolumenDelPaquete() {
		double volumen = largo * ancho * profundidad;
		return volumen;
	}
	
	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(double profundidad) {
		this.profundidad = profundidad;
	}

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}
