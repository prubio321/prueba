<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>citaMedicas</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet">
</head>
<body>
<div class="container">
    <!-- formulario de busqueda-->
   <!-- <form action="/citaMedica/buscar" method="post">
        <label for="hora">Hora:</label>
        <input type="text" id="hora" name="hora">

        <input type="submit" class="btn btn-primary">
    </form>-->
    <a href="/citaMedica" class="btn btn-primary">Nuevo CitaMedica</a>
    <br>
    <!-- Tabla -->
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">ID</th>
            <th scope="col">Paciente</th>
            <th scope="col">Hora</th>
            <th scope="col">AreaMedica</th>
            <th scope="col">Chasis</th>
            <th scope="col">Modelo</th>
            <th scope="col">Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="citaMedica" items="${citaMedicasCapturados}" >
            <tr>
                <th>id</th>
                <th scope="row">${citaMedica.id}</th>
                <th>${citaMedica.paciente.nombre}</th>
                <th>${citaMedica.hora}</th>
                <td>${citaMedica.areaMedica}</td>
               
                <td><a class="btn btn-warning" href="/citaMedica/editar/${citaMedica.id}" role="button">Editar</a></td>
                <td><a class="btn btn-danger" href="eliminar/${citaMedica.id}" role="button">Eliminar</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <c:if test="${msgCitaMedica != null}">
        <c:out value="${msgCitaMedica}"></c:out>
    </c:if>
</div>
<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
></script>
</body>
</html>