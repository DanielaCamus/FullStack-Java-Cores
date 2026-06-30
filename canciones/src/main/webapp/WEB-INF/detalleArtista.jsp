<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Detalle del artista</title>
    </head>
    <body>
        <h1>Información del artista</h1>
        <ul>
            <li><strong>ID:</strong> ${artista.id}</li>
            <li><strong>Nombre:</strong> ${artista.nombre}</li>
            <li><strong>Apellido:</strong> ${artista.apellido}</li>
            <li><strong>Biografía:</strong> ${artista.biografia}</li>
            <li><strong>Fecha de creación:</strong> ${artista.fechaCreacion}</li>
            <li><strong>Última actualización:</strong> ${artista.fechaActualizacion}</li>
        </ul>
        <h2>Lista de canciones:</h2>
        <ul>
            <c:choose>
                <c:when test="${empty artista.canciones}">
                    <span>Este artista no tiene canciones registradas.</span>
                </c:when>
                <c:otherwise>
                    <c:forEach items="${artista.canciones}" var="cancion">
                        <li>${cancion.titulo}</li>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </ul>
        <br><br>
        <a href="/artistas">Volver a lista de artistas</a>
    </body>
</html>