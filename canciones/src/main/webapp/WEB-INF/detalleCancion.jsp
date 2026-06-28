<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Detalle de la canción: ${cancion.titulo}</title>
    </head>
    <body>

        <c:choose>
            <c:when test="${cancion != null}">
                <h1>Detalle de la canción</h1>
                <ul>
                    <li><strong>ID:</strong> ${cancion.id}</li>
                    <li><strong>Título:</strong> ${cancion.titulo}</li>
                    <li><strong>Artista:</strong> ${cancion.artista}</li>
                    <li><strong>Álbum:</strong> ${cancion.album}</li>
                    <li><strong>Género:</strong> ${cancion.genero}</li>
                    <li><strong>Idioma:</strong> ${cancion.idioma}</li>
                    <li><strong>Fecha de registro:</strong> ${cancion.fechaCreacion}</li>
                    <li><strong>Última actualización:</strong> ${cancion.fechaActualizacion}</li>
                </ul>
                <a href="/canciones/formulario/editar/${cancion.id}">Actualizar canción</a>
            </c:when>
            
            <c:otherwise>
                <p>Error: La canción no existe en la base de datos.</p>
            </c:otherwise>
        </c:choose>

        <br><br><br>
        <a href="/canciones">Volver a lista de canciones</a>
    </body>
</html>