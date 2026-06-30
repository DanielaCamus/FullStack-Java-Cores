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
        <title>Agregar artista</title>
    </head>
    <body>
        <h1>Agregar artista</h1>
        <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">
            <form:label path="nombre">Nombre:</form:label>
            <form:input path="nombre" type="text" />
            <form:errors path="nombre" />
            <br><br>
            <form:label path="apellido">Apellido:</form:label>
            <form:input path="apellido" type="text" />
            <form:errors path="apellido" />
            <br><br>
            <form:label path="biografia">Biografía:</form:label>
            <form:textarea path="biografia" />
            <form:errors path="biografia" />
            <br><br>
            <button type="submit">Guardar artista</button>
        </form:form>
        <br><br>
        <a href="/artistas">Volver a lista de artistas</a>
    </body>
</html>