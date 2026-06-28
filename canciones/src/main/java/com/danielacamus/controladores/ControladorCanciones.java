package com.danielacamus.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.danielacamus.modelos.Cancion;
import com.danielacamus.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
    
    @Autowired
    // le permite al Controlador encargar peticiones de datos procesados por el Servicio
    private ServicioCanciones servicio;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        // EXTRACCIÓN: se piden los datos al Servicio y se retienen en la memoria RAM
        List<Cancion> canciones = servicio.obtenerTodasLasCanciones();
        // CARGA: se agrega la variable en Model bajo la etiqueta vinculante
        modelo.addAttribute("listaCanciones", canciones);
        // DESPACHO: se retorna la vista
        return "canciones.jsp";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model modelo) {
        // EXTRACCIÓN: se pide al Servicio el objeto unitario que coincide con el ID capturado de la URL
        Cancion cancionEncontrada = servicio.obtenerCancionPorId(idCancion);
        // CARGA: se agrega el objeto en el Model bajo la etiqueta "cancion"
        modelo.addAttribute("cancion", cancionEncontrada);
        // DESPACHO
        return "detalleCancion.jsp";
    }
    
    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model modelo) {
        modelo.addAttribute("cancion", new Cancion());
        return "agregarCancion.jsp";
    }

    // Agrega la canción a la base de datos. Redirige a la ruta de “/canciones”. En caso de que el formulario no pase alguna validación hay que cargar el mismo formulario agregarCancion.jsp para mostrar los errores.
    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult validaciones) {
        if (validaciones.hasErrors()) {
            return "agregarCancion.jsp";
        }
        servicio.agregarCancion(cancion);
        return "redirect:/canciones";
    }

    // Ruta a utilizar “/canciones/formulario/editar/{idCancion}”. Devuelve un objeto Cancion dado el idCancion para ser enviado a la vista JSP editarCancion.jsp. Este formulario cuenta con todos los campos/atributos de una canción y deben de estar precargados con la información de la canción actual.
    @GetMapping("/canciones/formulario/editar/{idCancion}")
	public String formularioEditarCancion(@PathVariable Long idCancion, Model modelo) {
		Cancion cancion = servicio.obtenerCancionPorId(idCancion);
		modelo.addAttribute("cancion", cancion);
		return "editarCancion.jsp";
	}

    // Ruta a utilizar “/canciones/procesa/editar/{idCancion}”. Edita la canción dado el id recibido como parámetro. Redirige a la ruta de “/canciones”. En caso de que el formulario no pase alguna validación hay que redirigir al mismo formulario editarCancion.jsp para mostrar los errores.
	@PutMapping("/canciones/procesa/editar/{idCancion}")
	public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
		BindingResult resultadoValidacion, @PathVariable Long idCancion) {
		if (resultadoValidacion.hasErrors()) {
			return "editarCancion.jsp";
		}
		cancion.setId(idCancion);
		servicio.actualizaCancion(cancion);
		return "redirect:/canciones";
	}

}