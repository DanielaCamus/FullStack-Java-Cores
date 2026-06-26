package com.danielacamus.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielacamus.modelos.Cancion;
import com.danielacamus.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {

    @Autowired
    private RepositorioCanciones repositorio;

    // Devuelve una lista de objetos Cancion de la tabla canciones de nuestra base de datos.
    public List<Cancion> obtenerTodasLasCanciones() {
        return this.repositorio.findAll();
    }

    // Devuelve un solo objeto de tipo Cacion dado el id enviado como parámetro. Si la Cancion no existe devuelve null.
    public Cancion obtenerCancionPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }
}
