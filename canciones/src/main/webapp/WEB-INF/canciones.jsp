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
        <title>Lista de canciones</title>
    </head>
    <body>
        <h1>Lista de canciones</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Detalle</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="cancion" items="${listaCanciones}">
                    <tr>
                        <td>${cancion.titulo}</td>
                        <td>${cancion.artista.nombre} ${cancion.artista.apellido}</td>
                        <td>
                            <a href="/canciones/detalle/${cancion.id}">Detalle</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br>
        <a href="/canciones/formulario/agregar">
            <button type="button">Agregar nueva canción</button>
        </a>
        <br><br>
        <a href="/artistas">Ir a artistas</a>
    </body>
</html>