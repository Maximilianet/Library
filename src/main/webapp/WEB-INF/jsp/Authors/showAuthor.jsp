<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">


<body>

<div class="container">

    <h1>All Authors</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>name</th>
            <th>price</th>
            <th>reviews</th>
            <th>rating</th>
            <th>genre</th>
        </tr>
        </thead>

            <tr>
                <td>${myAuthor.id}</td>
               <td>${myAuthor.name}</td>
               <td>${myAuthor.price}</td>
               <td>${myAuthor.reviews}</td>
               <td>${myAuthor.rating}</td>
               <td>${myAuthor.genre}</td>
            </tr>

    </table>

</div>


</body>
