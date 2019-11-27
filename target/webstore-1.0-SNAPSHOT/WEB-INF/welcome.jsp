<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Witaj</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1> ${greeting}</h1>
            <p> ${tagline}</p>
        </div>
    </div>
    <a href=" <spring:url value="/products"/>
                            " class="btn btn-primary">
        <span class="glyphicon-info-sign glyphicon"/></span> Lista produktow
    </a>
</section>
</body>
</html>