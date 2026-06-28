package com.danielacamus.servicios;

import java.time.LocalDateTime;
import java.util.List;

// le dice al servidor que conecte variables por detrás usando el motor de reflexión, para evitar usar la palabra new.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// vincula el objeto Cancion a este archivo, permitiendo que el Servicio pueda recibir, procesar y transportar instancias de la clase.
import com.danielacamus.modelos.Cancion;
// contrato del operario de base de datos, dándole al Servicio el derecho de comunicarse con MySQL por delegación.
import com.danielacamus.repositorios.RepositorioCanciones;

@Service
// declara la estructura ejecutable del Servicio, contiene los métodos que orquestarán el movimiento de información
public class ServicioCanciones {

    // cableado automático
    @Autowired
    // Inyección por Atributo
    private RepositorioCanciones repositorio;

    // Devuelve una lista de objetos Cancion de la tabla canciones de nuestra base de datos.
    public List<Cancion> obtenerTodasLasCanciones() {
        // ejecuta el trabajo real: toma el puntero del repositorio, gatilla el comando de búsqueda masiva sobre la base de datos y toma el paquete de resultados de vuelta arrojándolo inmediatamente por el conducto de retorno hacia arriba.
        return this.repositorio.findAll();
    }

    // Devuelve un solo objeto de tipo Cacion dado el id enviado como parámetro
    public Cancion obtenerCancionPorId(Long id) {
        // va a MySQL a buscar el objeto unitario con el ID capturado de la URL, lo retorna si existe y null si no
        return repositorio.findById(id).orElse(null);
    }

    // Agrega la canción a la base de datos dado el Objeto Cancion enviado como parámetro. Devuelve un objeto Cancion con la canción creada.
    public Cancion agregarCancion(Cancion cancion) {
        return repositorio.save(cancion);
    }

    // Actualiza la canción de la base de datos dado el Objeto Cancion enviado como parámetro. Devuelve un objeto Cancion con la canción actualizada.
    public Cancion actualizaCancion(Cancion cancion) {
        // marca la hora y fecha en la que el usuario actualizó
		cancion.setFechaActualizacion(LocalDateTime.now());
        // Envía la entidad final a la base de datos para sobreescribir el registro anterior y retorna el resultado de esa operación al controlador.
		return repositorio.save(cancion);
	}
}
