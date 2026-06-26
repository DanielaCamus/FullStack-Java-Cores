package com.danielacamus.modelos;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Anotación que marca una clase como una entidad JPA, lo que significa que se puede mapear a una tabla en la base de datos.
@Entity
// Anotación que permite especificar detalles sobre la tabla en la que se debe mapear la entidad, como el nombre de la tabla y el esquema.
@Table(name = "canciones")
public class Cancion {
    // Cada atributo va a representar una columna de la tabla.

    // Anotación para indicar que el atributo va a ser la columna de la llave primaria de la tabla/entidad.
    @Id
    // Anotación para indicar que la llave primaria es autoincremental.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String artista;
    private String album;
    private String genero;
    private String idioma;

    // Anotación para indicar que la fecha de creación de la canción es la fecha actual.
    @CreationTimestamp
    // name indca el nombre de la columna. updatable=false indica que no se puede actualizar la fecha de creación de la canción.
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    // Anotación para indicar que la fecha de actualización de la canción es la fecha actual.
    @UpdateTimestamp
    // name indica el nombre de la columna en la base de datos.
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    // Constructor vacío (necesario para JPA)
    public Cancion() {
	
	}

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

}
