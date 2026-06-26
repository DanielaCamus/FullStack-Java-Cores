package com.danielacamus.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.danielacamus.modelos.Cancion;
import com.danielacamus.servicios.ServicioCanciones;

@Controller
public class ControladorCanciones {
    
    @Autowired
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

}
