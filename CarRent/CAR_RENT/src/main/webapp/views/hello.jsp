<%--
  Created by IntelliJ IDEA.
  User: Buarzej
  Date: 2020-05-27
  Time: 01:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <title>Carousel Template for Bootstrap</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="<c:url value="/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"/>"></script>
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/carousel.css" />" rel="stylesheet">
</head>
<body>
<%--<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="#">Carousel</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="appUsers.html">App Users</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="admin.html">Admin</a>
                </li>
            </ul>
            <form class="form-inline mt-2 mt-md-0">
                <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</header>--%>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="carousel-item active">
            <img class="first-slide"
                 src="../resources/images/products/camaro_1.jpg"
                 alt="First slide">
            <div class="container">
                <div class="carousel-caption d-none d-md-block text-left">
                    <h1>Alquilar un coche</h1>
                    <p>Disfruta tu viaje en auto</p>
                    <%--<p class="bg-warning text-white">Tekst 1</p>--%>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <img class="second-slide"
                 src="../resources/images/products/mini1959_1.jpg"
                 alt="Second slide">
            <div class="container">
                <div class="carousel-caption d-none d-md-block">
                    <h1>Rent cars ! Message</h1>
                    <p>Enjoy driving very good cars :)</p>
                    <%--<p>Tekst 2</p>--%>
                </div>
            </div>
        </div>
        <div class="carousel-item">
            <img class="third-slide"
                 src="../resources/images/products/impala_1.jpg"
                 alt="Third slide">
            <div class="container">
                <div class="carousel-caption d-none d-md-block text-right">
                    <h1>Wypożyczaj samochody</h1>
                    <p class="text-danger" Ciesz sie najlepszymi samochodami w polsce i na świecie.</p>
                </div>
            </div>
        </div>
    </div>


    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
        integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>

</body>
</html>
