package ar.edu.unlam.transporte.dom;

public class Vehiculo {

	private double maxCapacidad;
	private double maxPeso;
	private int cantCiudadesQueRecorre;
	
	public Vehiculo(double maxCapacidad, double maxPeso, int cantCiudadesQueRecorre) {
		this.maxCapacidad = maxCapacidad;
		this.maxPeso = maxPeso;
		this.cantCiudadesQueRecorre = cantCiudadesQueRecorre;
	}

	public double getMaxCapacidad() {
		return maxCapacidad;
	}

	public void setMaxCapacidad(double maxCapacidad) {
		this.maxCapacidad = maxCapacidad;
	}

	public double getMaxPeso() {
		return maxPeso;
	}

	public void setMaxPeso(double maxPeso) {
		this.maxPeso = maxPeso;
	}

	public int getCantCiudadesQueRecorre() {
		return cantCiudadesQueRecorre;
	}

	public void setCantCiudadesQueRecorre(int cantCiudadesQueRecorre) {
		this.cantCiudadesQueRecorre = cantCiudadesQueRecorre;
	}
	
}
