package com.danielacamus.repositorios;

import java.util.List;

// permite manipular MySQL sin tener que escribir sentencias SQL.
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.danielacamus.modelos.Cancion;

// etiqueta el archivo como un componente de acceso a la base de datos.
@Repository
// Crea un contrato pque hereda más de 12 métodos transaccionales de CrudRepository para el acceso a la base de datos.
// Se le asigna el modelo de dominio al que va a estar enlazado y el tipo de dato que trae la llave primaria.
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
    // Este método no es necesario. Es para entender mejor como se comunica con las tablas de la base de datos.
    // SELECT * FROM canciones, empaquete el 100% de las filas devueltas por MySQL dentro de una sola lista estática instanciada.
    List<Cancion> findAll();

    //Si se quiere hacer un query que involucre una clausula WHERE, SÍ se necesita crear el método correspondiente ej.:
    // List<Cancion> findByGenero(String genero);
}