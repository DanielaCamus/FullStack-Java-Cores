package com.danielacamus.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielacamus.modelos.Artista;
import com.danielacamus.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repositorioArtistas;

    // Devuelve una lista de objetos Artista de la tabla artistas de nuestra base de datos.
    public List<Artista> obtenerTodosLosArtistas() {
        return repositorioArtistas.findAll();
    }

    // Devuelve un solo objeto de tipo Artista dado el id enviado como parámetro. Si el Artista no existe devuelve null.
    public Artista obtenerArtistaPorId(Long id) {
        return repositorioArtistas.findById(id).orElse(null);
    }

    // Agrega el artista a la base de datos dado el Objeto Artista enviado como parámetro. Devuelve un objeto Artista con el artista creado.
    public Artista agregarArtista(Artista artista) {
        return repositorioArtistas.save(artista);
    }
}