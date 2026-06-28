<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Actualizar canción</title>
    </head>
    <body>
        
        <h1>Actualizar información de la canción</h1>

        <form:form action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">
            <input type="hidden" name="_method" value="PUT" />

            <input type="hidden" name="id" value="${cancion.id}" />
            <input type="hidden" name="fechaCreacion" value="${cancion.fechaCreacion}" />

            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo" />
            <form:errors path="titulo" />
            <br><br>
            <form:label path="artista">Artista:</form:label>
            <form:input path="artista" />
            <form:errors path="artista" />
            <br><br>
            <form:label path="album">Álbum:</form:label>
            <form:input path="album" />
            <form:errors path="album" />
            <br><br>
            <form:label path="genero">Género:</form:label>
            <form:input path="genero" />
            <form:errors path="genero" />
            <br><br>
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma" />
            <form:errors path="idioma" />
            <br><br>
            <button type="submit">Actualizar canción</button>
        </form:form>
    <br><br>
    <a href="/canciones">Volver a lista de canciones</a>

    </body>
</html>