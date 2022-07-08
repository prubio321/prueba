<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>paciente</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
            crossorigin="anonymous">
</head>
<body>
<div class="container">
    <c:if test="${msgError!= null}">
        <c:out value="${msgError}"></c:out>
    </c:if>
    <%--@elvariable id="paciente" type="java"--%>
    <form:form action="/paciente/actualizar/${paciente.id}" method="post" modelAttribute="paciente">
        <form:label path="nombre" class="form-label" >Nombre:</form:label>
        <form:input path="nombre" class="form-control" />
        <br>
        <form:label path="apellido" class="form-label">Apellido:</form:label>
        <form:input path="apellido" class="form-control"/>
        <br>
        <form:label path="edad" class="form-label">edad:</form:label>
        <form:input type="number" path="edad" class="form-control"/>
        <br>
        <form:label path="email" class="form-label">email:</form:label>
        <form:input type="text" path="email" class="form-control"/>
        <br>


        <button type="submit" class="btn btn-outline-warning">Editar paciente</button>
    </form:form>
</div>
</body>
</html>