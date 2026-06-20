package com.danielacamus.controladores;

import java.text.Normalizer;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/peliculas")
public class ControladorPeliculas {
    // Declaración, instanciación y asignación de un atributo estático de la clase. Crea un diccionario en memoria, listo para guardar pares de textos.
    private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

    // Constructor
    public ControladorPeliculas() {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");	
        listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
        listaPeliculas.put("Tarzán", "Kevin Lima");		
        listaPeliculas.put("Mulán", "Barry Cook");
        listaPeliculas.put("Oliver", "Kevin Lima");	
        listaPeliculas.put("Big Hero 6", "Don Hall");
    }

    // Método auxiliar (helper) para normalizar con RegEx (Expresiones Regulares)
	private String normalizarRegEx(String texto) {
        // Toma el texto original y lo descompone, luego lo guarda en la variable "normalizado" (Ej. "á" se descompone en "a" y "´").
		String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        // Busca todos los acentos aislados, los borra, convierte todo el texto resultante a minúsculas, y devuelve ese texto limpio.
		return normalizado.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase();
	}

    // 1. Método que responde a la ruta /peliculas y retorna un string con la lista de todas las películas disponibles.
    @GetMapping("")
    public String obtenerTodasLasPeliculas() {
        // Declaración de una variable local vacía (acumulador).
        String peliculas = "";
        // Bucle que extrae todas las KEYS del mapa y las procesa una por una.
        for(String pelicula : listaPeliculas.keySet()) {
            if(peliculas.isEmpty()) {
                    peliculas += "Nuestra lista de películas es la siguiente: <br>";
                }
                peliculas += pelicula + "<br>";
        }
        return peliculas;
    }

    // 2. Método que responde a la ruta /peliculas/{nombre} y retorna la información de una película específica, devuelve el nombre de la película y su director. En caso de que la película no exista en la lista devolver un mensaje como el siguiente:  «La película no se encuentra en nuestra lista.»
	@GetMapping("/{nombre}")
	public String obtenerPeliculaPorNombre(@PathVariable String nombre) {
        // Normaliza el texto que ingresó el usuario y lo guarda en la variable "nombreBuscado".
		String nombreBuscado = normalizarRegEx(nombre);
		for(String pelicula : listaPeliculas.keySet()) {
            // Toma la KEY original del mapa, la limpia, y luego verifica si esa versión limpia es exactamente igual a la versión limpia de lo que ingresó el usuario.
			if(normalizarRegEx(pelicula).equals(nombreBuscado)) {
				return "Película: " + pelicula + ", dirigida por: " + listaPeliculas.get(pelicula);
			}
		}
		return "La película no se encuentra en la lista.";
	}

    // 3. Método que responde a la ruta /peliculas/director/{nombre} y retorna un string con la lista de todas las películas que tienen ese director asignado. En caso de que el director no exista en la lista devolver un mensaje como el siguiente: «No contamos con películas con ese director en nuestra lista.»
    @GetMapping("/director/{nombre}")
	public String obtenerPeliculasPorDirector(@PathVariable String nombre) {
		String resultado = "";
		
		for(String pelicula : listaPeliculas.keySet()) {
			String director = listaPeliculas.get(pelicula);
			if(director.equalsIgnoreCase(nombre)) {
				if(resultado.isEmpty()) {
                    resultado += "Películas dirigidas por " + director + ":<br>";
                }
                resultado += pelicula + ".<br>";
			}
		}
		return resultado.isEmpty() ? "No contamos con películas con ese director en nuestra lista." : resultado;
	}
}