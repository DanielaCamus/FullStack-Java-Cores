package com;
import com.clases.Televisor;
import com.clases.ComputadoraPortatil;
import com.clases.TiendaElectronica;

public class Aplicacion {
    
    public static void main(String[] args) {
        
        // Instancia de la tienda
        TiendaElectronica tienda = new TiendaElectronica();
        
        // Instancia objetos de diferentes tipos de productos electrónicos
        Televisor tv1 = new Televisor("Sony Bravia XR", 1250000, 8, 65, "8K HDR");
        Televisor tv2 = new Televisor("Samsung The Frame", 780000, 6, 50, "4K QLED");
        ComputadoraPortatil portatil1 = new ComputadoraPortatil("MacBook Pro M3 Max", 2800000, 3, "Apple", 36, "APP-990011");
        ComputadoraPortatil portatil2 = new ComputadoraPortatil("Asus ROG Zephyrus", 1850000, 0, "Asus", 32, "ROG-554433");
        
        // Los agrega al inventario de la tienda.
        System.out.println("\n--------- REGISTRO DE PRODUCTOS ---------");
        tienda.agregarProducto(tv1);
        tienda.agregarProducto(tv2);
        tienda.agregarProducto(portatil1);
        tienda.agregarProducto(portatil2);

        // Muestra todos los productos disponibles en el inventario para verificar que se agregaron correctamente
        tienda.mostrarTodosLosProductos();

        // Busca un producto por nombre, realiza la venta y actualiza el stock
        System.out.println("\n--------- REGISTRO DE VENTAS ---------");
        tienda.realizarVenta("Sony Bravia XR");
        tienda.realizarVenta("Samsung The Frame");
        tienda.realizarVenta("MacBook Pro M3 Max");
        tienda.realizarVenta("Asus ROG Zephyrus"); 
        tienda.realizarVenta("Lenovo Legion Slim"); 

        // Muestra todos los productos disponibles en el inventario con stock actualizado después de las ventas
        tienda.mostrarTodosLosProductos();
    }
}