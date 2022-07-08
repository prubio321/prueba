<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>citaMedica</title>
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
    <%--@elvariable id="citaMedica" type="java"--%>
    <form:form action="/citaMedica/registro/${citaMedica.id}" method="post" modelAttribute="citaMedica">
        <form:label path="paciente.id" class="form-label" >Paciente:</form:label>
        <form:input path="paciente.id" class="form-control" />
        <br>
        <form:label path="hora" class="form-label" >Hora:</form:label>
        <form:input path="hora" class="form-control" />
        <br>
        <form:label path="areaMedica" class="form-label">Area Medica:</form:label>
        <form:input path="areaMedica" class="form-control"/>
        <br>
    


        <button type="submit" class="btn btn-outline-primary">Guardar Cita Medica</button>
    </form:form>
</div>
</body>
</html>