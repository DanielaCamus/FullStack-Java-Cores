package com.clases;

public class ProductoElectrodomestico {
	// ATRIBUTOS
	private String nombre;
	private double precio;
	private int cantidadDisponible;
	
	// CONSTRUCTOR PRINCIPAL
	public ProductoElectrodomestico(String nombre, double precio, int cantidadDisponible) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = cantidadDisponible;
	}
	
	// SOBRECARGA DEL CONSTRUCTOR
	public ProductoElectrodomestico(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadDisponible = 0;
	}

	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}
	
	// MÉTODO DE COMPORTAMIENTO
	public void mostrarInformacion() {
			System.out.println("Nombre: " + nombre + ", Precio: $" + precio + ", Stock: " + cantidadDisponible);
	}
	
}
