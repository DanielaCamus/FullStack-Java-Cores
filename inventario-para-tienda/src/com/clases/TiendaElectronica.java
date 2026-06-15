package com.clases;

import java.util.ArrayList;

public class TiendaElectronica {
	// ATRIBUTO
    // Declara un array dinámico que solo acepta objetos del tipo ProductoElectrodomestico o sus subclases.
	private ArrayList<ProductoElectrodomestico> listaDeProductos;

    // CONSTRUCTOR (permite crear distintas tiendas con inventarios separados)
    public TiendaElectronica() {
        // Crea el objeto para que empiece a recibir datos.
        this.listaDeProductos = new ArrayList<>();
    }
	
    // Método que recibe un objeto producto para ingresarlo al sistema.
	public void agregarProducto(ProductoElectrodomestico producto) {
        // Agrega el nuevo producto al final de la lista.
        listaDeProductos.add(producto);
        // confirmación
        System.out.println(producto.getNombre() + " se ha agregado al inventario.");
    }
	
	// Método que muestra todos los productos disponibles
	public void mostrarTodosLosProductos() {
        System.out.println("\n========= INVENTARIO =========");
        // Bucle para recorrer la lista
        for (ProductoElectrodomestico producto : listaDeProductos) {
            // Muestra la información de cada producto
            producto.mostrarInformacion();
            System.out.println("----------------------------------------------------");
        }
    }

    // Método que recibe el nombre de un producto, lo busca en la lista y entrega el objeto. Si no lo encuentra, entrega null
    public ProductoElectrodomestico buscarProductoPorNombre(String nombre) {
        // Bucle para recorrer la lista
        for (ProductoElectrodomestico producto : listaDeProductos) {
            // Compara el nombre del producto actual con el nombre buscado
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                // Si se encuentra el producto, se entrega. Frena el bucle y el método
                return producto;
            }
        }
        // Si termina el bucle, entrega null
        return null;
    }

    // Método que 
    public void realizarVenta(String nombre) {
        // Busca el producto usando el método creado anteriormente
        ProductoElectrodomestico productoEncontrado = buscarProductoPorNombre(nombre);
        // Si el producto existe
        if (productoEncontrado != null) {
            // Comprueba el stock
            if (productoEncontrado.getCantidadDisponible() > 0) {
                // Resta 1 al stock
                productoEncontrado.setCantidadDisponible(productoEncontrado.getCantidadDisponible() - 1);
                // Confirma la venta y muestra el stock restante
                System.out.println("Venta exitosa de: " + productoEncontrado.getNombre() + ". Stock restante: " + productoEncontrado.getCantidadDisponible());
            // Si el stock es 0
            } else {
                System.out.println("El producto " + productoEncontrado.getNombre() + " se encuentra agotado.");
            }        
        } else {
            // Si es nulo, muestra un error
            System.out.println("Error: El producto '" + nombre + "' no existe.");
        }
    }
}