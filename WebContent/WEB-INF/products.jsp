<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <a href="<c:url value="/logout" />" class="btn btn-danger btn-mini pull-right">
                Wyloguj sie
            </a>
            <div class="container">
                <h1>Produkty</h1>
                <p>Wszystkie produkty dostepne w sklepie</p>
            </div>
        </div>
    </section>
<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <c:if test="${product.productImage} != null">
                        <img src="<c:url value="/images/${product.productId}.jpg"></c:url>"
                             alt="image" style="width: 100%"/>
                    </c:if>
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>${product.unitPrice}</p>
                        <p>Liczba sztuk w magazynie: ${product.unitsInStock}</p>
                        <p>
                            <a href=" <spring:url value="/products/product?id=${product.productId}"/>
                            " class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> Szczegoly
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <a href=" <spring:url value="/products/add"/>
                            " class="btn btn-primary">
        <span class="glyphicon-info-sign glyphicon"/></span> Dodaj produkt
    </a>
</section>
</body>
</html>
