package com.danielacamus.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ControladorRecetas {

    private static String [] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
    private static HashMap<String, String []> recetasConIngredientes = new HashMap<String, String[]>();

    public ControladorRecetas() {
	String [] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
	recetasConIngredientes.put("Pizza", pizza);
	String [] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
	recetasConIngredientes.put("Espagueti", espagueti);
	String [] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
	recetasConIngredientes.put("Lasaña", lasaña);
    }

    // Método que responde a la ruta /recetas. Toma la lista de recetas y la agrega como atributo “listaRecetas” a un objeto Modelo para enviar hacia el JSP llamado recetas.jsp.
    @GetMapping("/recetas")
    public String obtenerTodasLasRecetas(Model modelo) {
        modelo.addAttribute("listaRecetas", listaRecetas);
        return "recetas.jsp";
    }

    // Método que responde a la ruta /recetas/{nombre}. Busca el nombre de la receta y agrega su nombre y sus ingredientes en dos atributos respectivamente a un objeto Modelo para enviar hacía el JSP llamado detalleReceta.jsp En caso de que la receta no exista en la lista devolver un mensaje como el siguiente: «La receta no se encuentra en nuestra lista.»
    @GetMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable("nombre") String nombre, Model modelo) {
        if (recetasConIngredientes.containsKey(nombre)) {
            modelo.addAttribute("nombre", nombre);
            modelo.addAttribute("ingredientes", recetasConIngredientes.get(nombre));
        } else {
            modelo.addAttribute("mensajeError", "La receta no se encuentra en nuestra lista.");
        }
        return "detalleReceta.jsp";
    }
}
