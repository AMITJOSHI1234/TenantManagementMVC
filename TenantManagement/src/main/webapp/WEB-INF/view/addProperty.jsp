
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Property</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="resources/css/addProperty.css">
    <style>
        body {
            background-image: url('resources/image/home.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            margin: 0;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>
    <div class="container">
        <h2 class="text-center">Add Property</h2>
        <form:form action="addProperty" method="post" modelAttribute="propertyDto" enctype="multipart/form-data">
            <div class="form-group">
                <label for="address">Address:</label>
                <form:input path="address" type="text" class="form-control" id="address" placeholder="Enter address" />
                <form:errors path="address" cssClass="error" />
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <form:textarea path="description" class="form-control" id="description" placeholder="Enter description" />
                <form:errors path="description" cssClass="error" />
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <form:input path="price" type="number" class="form-control" id="price" placeholder="Enter price" />
                <form:errors path="price" cssClass="error" />
            </div>
            <div class="form-group">
                <label for="ownerName">Owner Name:</label>
                <form:input path="ownerName" type="text" class="form-control" id="ownerName" placeholder="Enter owner name" />
                <form:errors path="ownerName" cssClass="error" />
            </div>
            
            <div class="form-group">
               <input type="file" name="image"/>
            </div>
            
            <button type="submit" class="btn btn-primary">Add Property</button>
        </form:form>
    </div>
</body>
</html>