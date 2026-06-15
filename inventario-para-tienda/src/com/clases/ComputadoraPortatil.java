package com.clases;

// DECLARACIÓN DE UNA SUBCLASE
public class ComputadoraPortatil extends ProductoElectrodomestico {
	// ATRIBUTOS
	private String marca;
	private int memoriaRAM;
	private String numeroSerie;
	
	// CONSTRUCTOR
	public ComputadoraPortatil(String nombre, double precio, int cantidadDisponible, String marca, int memoriaRAM,
			String numeroSerie) {
		// Ejecuta el constructor de la superclase para inicializar los atributos heredados.
		super(nombre, precio, cantidadDisponible);
		this.marca = marca;
		this.memoriaRAM = memoriaRAM;
		this.numeroSerie = numeroSerie;
	}
	
	// Sobreescritura del método
	@Override
	public void mostrarInformacion() {
		// Imprime el nombre, precio y stock de la superclase
		super.mostrarInformacion();
		// Atributos exclusivos de ComputadoraPortatil
		System.out.println("Marca: " + marca + ", RAM: " + memoriaRAM + "GB, Número de serie: " + numeroSerie);
	}
	
}
