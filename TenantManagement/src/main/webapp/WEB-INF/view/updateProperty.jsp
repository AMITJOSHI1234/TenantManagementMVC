<%@page import="com.yash.tenantmanagement.dto.PropertyDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale= 1.0">
    <title>Update Property</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
    <div class="container">
    <%PropertyDto dto = (PropertyDto)request.getAttribute("propertyDto"); %>
        <h2 class="text-center">Update Property</h2>
        <form:form action="update" method="post" modelAttribute="propertyDto">
            <input type="hidden" name="propertyId" value="<%= dto.getPropertyId() %>" />
            <div class="form-group">
                <label for="address">Address:</label>
                <form:input path="address" type="text" class="form-control" id="address" placeholder="Enter address" />
                <% if(request.getAttribute("addressError") != null) { %>
                    <div class="error"><%= request.getAttribute("addressError") %></div>
                <% } %>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <form:textarea path="description" class="form-control" id="description" placeholder="Enter description" />
                <% if(request.getAttribute("descriptionError") != null) { %>
                    <div class="error"><%= request.getAttribute("descriptionError") %></div>
                <% } %>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <form:input path="price" type="number" class="form-control" id="price" placeholder="Enter price" />
                <% if(request.getAttribute("priceError") != null) { %>
                    <div class="error"><%= request.getAttribute("priceError") %></div>
                <% } %>
            </div>
            <div class="form-group">
                <label for="ownerName">Owner Name:</label>
                <form:input path="ownerName" type="text" class="form-control" id="ownerName" placeholder="Enter owner name" />
                <% if(request.getAttribute("ownerNameError") != null) { %>
                    <div class="error"><%= request.getAttribute("ownerNameError") %></div>
                <% } %>
            </div>
            
            <button type="submit" class="btn btn-primary">Update Property</button>
        </form:form>
    </div>
</body>
</html>