<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
</head>
<body>
<section>
    <div id="message">
    </div>
    <div class="jumbotron">
        <a href="<c:url value="/logout" />" class="btn btn-danger btn-mini pull-right">
            Wyloguj sie
        </a>
        <div class="container">
            <h1>Produkty</h1>
            <p>Dodaj produkty</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>Dodaj nowy produkt</legend>
            <div class="form-group">
            <label class="control-label col-lg-2 col-lg-2" for="productId">
                <spring:message code="addProduct.form.productId.label"/>
            </label>
            <div class="col-lg-10">
                <form:input id="productId" path="productId" type="text" class="form:input-large"/>
            </div>
        </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name">
                    <spring:message code="addProduct.form.name.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                    <spring:message code="addProduct.form.price.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice" type="text"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="description">
                    <spring:message code="addProduct.form.description.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="description" path="description" rows="2"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="manufacturer">
                    <spring:message code="addProduct.form.manufacturer.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="manufacturer" path="manufacturer" type="text"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="category">
                    <spring:message code="addProduct.form.category.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="category" path="category" type="text"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
                    <spring:message code="addProduct.form.unitsInStock.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock" type="number"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="condition">
                    <spring:message code="addProduct.form.condition.label"/>
                </label>
                <div class="col-lg-10">
                    <form:radiobutton path="condition" id="condition" value="New"/>
                    <spring:message code="addProduct.form.conditionNew.label"/>
                    <form:radiobutton path="condition" id="condition" value="Old"/>
                    <spring:message code="addProduct.form.conditionOld.label"/>
                    <form:radiobutton path="condition" id="condition" value="Refurbished"/>
                    <spring:message code="addProduct.form.conditionRefurbished.label"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProduct.form.productImage.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input path="productImage" id="productImage" type="file" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productFile">
                    <spring:message code="addProduct.form.productFile.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input path="productFile" id="productFile" type="file" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                  <input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>