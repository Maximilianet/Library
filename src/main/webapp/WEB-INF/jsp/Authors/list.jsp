<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>

</head>

<body>

<div class="container">

    <table class="table table-striped">
    <thead>
        <tr>
            <th>#ID</th>
            <th>Имя</th>
            <th>Фамилия</th>
        </tr>
    </thead>

    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td>
            </td>
        </tr>
    </c:forEach>
    </table>
    <button class="button" onclick="location.href='../main'">Возврат к Main</button>

</div>
</body>