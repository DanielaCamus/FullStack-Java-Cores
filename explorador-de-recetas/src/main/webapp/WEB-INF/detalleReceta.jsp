<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle de la Receta</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="contenedor">
        
        <c:choose>

            <c:when test="${not empty mensajeError}">
                <div class="error">
                    <h2>${mensajeError}</h2>
                </div>
            </c:when>

            <c:otherwise>
                <h1>Receta: ${nombre}</h1>
                <h3>Ingredientes:</h3>
                <ul>
                    <c:forEach var="ingrediente" items="${ingredientes}">
                        <li>${ingrediente}</li>
                    </c:forEach>
                </ul>
            </c:otherwise>

        </c:choose>

        <footer class="pie">
            <a href="/recetas" class="btn">Volver a la lista</a>
        </footer>

    </div>
</body>
</html>