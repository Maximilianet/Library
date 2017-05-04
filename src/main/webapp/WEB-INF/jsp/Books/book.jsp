<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        h2{
            font: 23px/27px Arial,Helvetica,sans-serif;
            color: #375f78;
            margin: 0 0 15px;
        }
    </style>
</head>
<body>
<h3>О книге</h3>
<div class="container">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Название</th>
            <th>Цена</th>
            <th>Отзыв</th>
            <th>Рейтинг</th>
            <th>Жанр</th>
        </tr>
        </thead>
            <tr>
                <td>${bookInfo.id}</td>
                <td>${bookInfo.name}</td>
                <td>${bookInfo.price} руб.</td>
                <td>${bookInfo.reviews}</td>
                <td>${bookInfo.rating}</td>
                <td>${bookInfo.genre}</td>
            </tr>
    </table>
    <button class="button" onclick="location.href='../main'">Возврат к Main</button>
</div>
</body>
