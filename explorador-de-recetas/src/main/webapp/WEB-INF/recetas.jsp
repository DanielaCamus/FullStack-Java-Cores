<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Explorador de recetas</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <div class="contenedor">
        <h1>Lista de recetas</h1>
        <ul>
            <c:forEach var="receta" items="${listaRecetas}">
                <li>
                    <a href="/recetas/${receta}">${receta}</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>