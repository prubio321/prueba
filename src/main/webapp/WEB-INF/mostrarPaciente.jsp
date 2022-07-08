<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>pacientes</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>
<body>
<div class="container">
    <!-- formulario de busqueda-->
   <!-- <form action="/paciente/buscar" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre">

        <input type="submit" class="btn btn-primary">
    </form>-->
    <a href="/paciente" class="btn btn-primary">Nuevo Paciente</a>
    <br>
    <!-- Tabla -->
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Nombre</th>
            <th scope="col">Apellido</th>
            <th scope="col">Edad</th>
            <th scope="col">Email</th>
            <th scope="col">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="paciente" items="${pacientesCapturados}" >
            <tr>
                <th>id</th>
                <th scope="row">${paciente.id}</th>
                <th>${paciente.nombre}</th>
                <td>${paciente.apellido}</td>
                <td>${paciente.edad}</td>
                <td>${paciente.email}</td>
                <td><a class="btn btn-warning" href="/paciente/editar/${paciente.id}" role="button">Editar</a></td>
                <td><a class="btn btn-danger" href="eliminar/${paciente.id}" role="button">Eliminar</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${msgPaciente != null}">
        <c:out value="${msgPaciente}"></c:out>
    </c:if>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
></script>
</body>
</html>