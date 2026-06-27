<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Agregar canción</title>
</head>
<body>
        <h1>Agregar nueva canción</h1>

        <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
            
            <form:label path="titulo">Título:</form:label>
            <form:input path="titulo" type="text" />
            <form:errors path="titulo" />
            <br><br>
            <form:label path="artista">Artista:</form:label>
            <form:input path="artista" type="text" />
            <form:errors path="artista" />
            <br><br>
            <form:label path="album">Álbum:</form:label>
            <form:input path="album" type="text" />
            <form:errors path="album" />
            <br><br>
            <form:label path="genero">Género:</form:label>
            <form:input path="genero" type="text" />
            <form:errors path="genero" />
            <br><br>
            <form:label path="idioma">Idioma:</form:label>
            <form:input path="idioma" type="text" />
            <form:errors path="idioma" />
            <br><br>
            <button type="submit">Guardar canción</button>

        </form:form>

        <br>
        <a href="/canciones">Volver a lista de canciones</a>

    </body>
</html>