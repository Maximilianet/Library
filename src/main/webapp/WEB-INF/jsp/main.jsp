<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        .item p{
            font-size: 16px;
        }
        .row .item {
            min-height: 150px;
            text-align: center;
        }
        .item img {
            height: 120px;
        }
        .item .price b {
            font-size: 18px;
            color: red;
        }
        .left, .right {
            float: left;
            padding: 15px;
        }
        .left {
            max-width: 17%;
        }
        .col-md-2, .col-lg-3 {
            padding: 0px;
        }
        .search {
            padding: 10px 25px;
        }
        .row {
            padding: 0px 30px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
                <div class="row">
                    <form:form modelAttribute="findBook" action="/searchBook" method="post" class="search">
                        <div class="input-group">
                            <form:input path="name"  class="form-control" placeholder="Поиск"/>
                            <div class="input-group-btn">
                                <button class="btn btn-default" type="submit">Найти</button>
                            </div>
                        </div>
                    </form:form>
                    <div class="left">
                        <div class="form-group">
                            <label for="sel1">Выбор жанра:</label>
                            <select class="form-control" id="sel1">
                                <option>Роман</option>
                                <option>Реализм</option>
                                <option>Поэма</option>
                                <option>Повесть</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="sel1">Сортировка по рейтингу:</label>
                            <select class="form-control" id="sel1">
                                <option>По возрастанию</option>
                                <option>По убыванию</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="sel1">Количество выводимых книг на странице:</label>
                            <select class="form-control" id="sel1">
                                <option>10</option>
                                <option>20</option>
                                <option>50</option>
                            </select>
                        </div>
                    </div>
                    <div class="right">
            <c:forEach var="books" items="${booksList}" varStatus="i">
                <div class="col-sm-6 col-md-2 col-lg-3 item">
                    <a href="/book/${books.id}"><p>${books.name}</p>
                    <img src="https://ozon-st.cdn.ngenix.net/multimedia/1005610796.jpg" alt="книга"></a>
                    <p class="price"><b><b>${books.price}</b></b> руб.</p>
                    <a href="/authors/${books.authorId}"><p>${authorInfo.get(i.index).firstName} ${authorInfo.get(i.index).lastName}</p></a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>