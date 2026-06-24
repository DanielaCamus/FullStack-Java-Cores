<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${libro}</title>
</head>
<body>
    <c:choose>
        <c:when test="${not empty mensajeError}">
            <h3>${mensajeError}</h3>
        </c:when>
        
        <c:otherwise>
            <h1>Información del libro</h1>
            <p><strong>Nombre del libro:</strong> ${libro}</p>
            <p><strong>Autor:</strong> ${autor}</p>
        </c:otherwise>
    </c:choose>

    <br>
    <a href="/libros"><button>Regresar a la lista de libros</button></a>
</body>
</html>