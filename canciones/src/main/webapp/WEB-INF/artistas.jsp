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
        <title>Lista de artistas</title>
    </head>
    <body>
        <h1>Lista de artistas</h1>

        <ul>
            <c:forEach items="${artistas}" var="artista">
                <li>
                    <a href="/artistas/detalle/${artista.id}">
                        ${artista.nombre} ${artista.apellido}
                    </a>
                </li>
            </c:forEach>
        </ul>

        <br>
        <a href="/artistas/formulario/agregar">
            <button type="button">Agregar nuevo artista</button>
        </a>
        <br><br>
        <a href="/canciones">Ir a canciones</a>
    </body>
</html>