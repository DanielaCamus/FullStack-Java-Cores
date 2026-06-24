package com.danielacamus.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorLibros {
    
    private static HashMap<String, String> listaLibros = new HashMap<String, String>();

    public ControladorLibros() {
        listaLibros.put("Odisea", "Homero");	
        listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
        listaLibros.put("El Código Da Vinci", "Dan Brown");		
        listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
        listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
        listaLibros.put("El alquimista", "Paulo Coelho");	
    }

    // Método que responde a la ruta /libros y retorna un JSP llamado libros.jsp para cargar todos los libros dentro de la lista.
    @GetMapping("/libros")
    public String obtenerTodosLosLibros(Model modelo) {
        modelo.addAttribute("libros", listaLibros.keySet());
        return "libros.jsp";
    }

    // Método que responde a la ruta /libros/{nombre} y retorna la información de un libro en específico, devuelve el nombre del libro y su autor al JSP llamado detalleLibro.jsp. En caso de que el libro no exista en la lista devolver un mensaje como el siguiente: «El libro no se encuentra en nuestra lista.»
    @GetMapping("/libros/{nombre}")
    public String obtenerInformacionDeLibro(@PathVariable("nombre") String nombre, Model modelo) {
        if (listaLibros.containsKey(nombre)) {
            modelo.addAttribute("libro", nombre);
            modelo.addAttribute("autor", listaLibros.get(nombre));
            return "detalleLibro.jsp";
        } else {
            modelo.addAttribute("mensajeError", "El libro no se encuentra en nuestra lista.");
            return "detalleLibro.jsp";
        }
    }

    // formularioLibro(): Método que responde a la ruta /libros/formulario y retorna un JSP llamado formularioLibros.jsp para cargar un formulario para poder dar de alta un nuevo libro y su respectivo autor.
    @GetMapping("/libros/formulario")
    public String formularioLibro() {
        return "formularioLibros.jsp";
    }

    // Método que responde a la ruta /procesa/libro y se encarga de recibir los parámetros del formulario para agregarlos a la lista de libros. Recibe únicamente dos parámetros: nombreLibro y nombreAutor. Tras agregar el libro con su autor a la lista se redirecciona a la ruta de /libros.
    @PostMapping("/procesa/libro")
    public String procesaLibro(@RequestParam("nombreLibro") String nombreLibro, @RequestParam("nombreAutor") String nombreAutor) {
        listaLibros.put(nombreLibro, nombreAutor);
        return "redirect:/libros";
    }

}
