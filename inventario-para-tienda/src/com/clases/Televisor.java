package com.clases;

// Declaración de una subclase
public class Televisor extends ProductoElectrodomestico {
	// ATRIBUTOS
	private double tamanoPantalla;
	private String resolucion;
	
	
	// CONSTRUCTOR
	public Televisor(String nombre, double precio, int cantidadDisponible, double tamañoPantalla, String resolucion) {
		// Ejecuta el constructor de la superclase para inicializar los atributos heredados.
		super(nombre, precio, cantidadDisponible);
		this.tamanoPantalla = tamañoPantalla;
		this.resolucion = resolucion;
	}

	// Sobreescritura del método
	@Override
	// Método que está aplicando polimorfismo
	public void mostrarInformacion() {
		// Imprime Nombre, Precio y Stock de la superclase
		super.mostrarInformacion();
		// Atributos exclusivos de Televisor
		System.out.println("Tamaño de pantalla: " + tamanoPantalla + " pulgadas, Resolución: " + resolucion);
	}

}