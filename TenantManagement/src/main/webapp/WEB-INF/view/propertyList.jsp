<%@page import="com.yash.tenantmanagement.domain.Property"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.Base64"%>
<%@page import="com.yash.tenantmanagement.dto.PropertyDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Property List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="resources/css/propertyList.css">
    <style>
        body {
            background-image: url('resources/image/propertyList.jpg');
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
        <h2 class="text-center mb-4">Property List</h2>
        <form:form action="searchProperty" method="post" modelAttribute="propertyDto" class="form-inline mb-4">
            <div class="form-group mr-2">
                <label for="address" class="mr-2">Address:</label>
                <form:input path="address" type="text" class="form-control" id="address" placeholder="Enter address" />
            </div>
            <div class="form-group mr-2">
                <label for="description" class="mr-2">Description:</label>
                <form:input path="description" type="text" class="form-control" id="description" placeholder="Enter description" />
            </div>
            <div class="form-group mr-2">
                <label for="price" class="mr-2">Price:</label>
                <form:input path="price" type="number" class="form-control" id="price" placeholder="Enter price" />
            </div>
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form:form>
        <div class="row">
            <% 
                List<PropertyDto> properties = (List<PropertyDto>) request.getAttribute("properties");
                for(PropertyDto property : properties) {
            %>
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"><%= property.getAddress() %></h5>
                            <p class="card-text"><%= property.getDescription() %></p>
                            <p class="card-text">Price: <%= property.getPrice() %></p>
                            <p class="card-text">Owner Name: <%= property.getOwnerName() %></p>
                            
                            <% if((Long)session.getAttribute("roleId")==2L) { %>
                                <a href="userDetails?id=<%=session.getAttribute("userId") %>" class="btn btn-primary">Contact Admin</a>
                                <a href="getImage?propId=<%=property.getPropertyId() %>" class="btn btn-primary">Image</a>
                            <% } %>
                            <% if((Long)session.getAttribute("roleId")==1L) { %>
                                <a href="<%= property.getPropertyId() %>" class="btn btn-primary">Update</a>
                                <a href="delete/<%= property.getPropertyId() %>" class="btn btn-danger">Delete</a>
                            <% } %>
                        </div>
                    </div>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>