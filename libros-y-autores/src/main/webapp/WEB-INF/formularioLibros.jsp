<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulario de libros</title>
</head>
<body>
    <h1>Agrega un nuevo libro</h1>

    <form action="/procesa/libro" method="POST">
        <div>
            <label for="nombreLibro">Nombre del libro:</label>
            <input type="text" id="nombreLibro" name="nombreLibro" required>
        </div>
        <br>
        <div>
            <label for="nombreAutor">Nombre del autor:</label>
            <input type="text" id="nombreAutor" name="nombreAutor" required>
        </div>
        <br>
        <button type="submit">Guardar libro</button>
    </form>

    <br><br>
    <a href="/libros"><button>Regresar a la lista de libros</button></a>
</body>
</html>