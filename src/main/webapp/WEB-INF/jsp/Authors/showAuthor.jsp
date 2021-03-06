<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        h3{
            font: bold 16px/20px Arial,Helvetica,sans-serif;
            color: #595959;
            margin: 0 0 10px;
        }
    </style>
</head>

<body>

<div class="container">

    <h3>${authorInfo.firstName} ${authorInfo.lastName}</h3>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Имя</th>
            <th>Цена</th>
            <th>Отзывы</th>
            <th>Рейтинг</th>
            <th>Жанр</th>
        </tr>
        </thead>

            <tr>
                <td>${authorBooks.id}</td>
               <td>${authorBooks.name}</td>
               <td>${authorBooks.price}</td>
                <td>${authorBooks.reviews}</td>
               <td>${authorBooks.rating}</td>
               <td>${authorBooks.genre}</td>
            </tr>

    </table>
    <button class="button" onclick="location.href='../main'">Возврат к Main</button>

</div>


</body>
