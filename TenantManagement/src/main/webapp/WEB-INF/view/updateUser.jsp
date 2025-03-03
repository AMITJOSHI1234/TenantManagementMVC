<%@page import="com.yash.tenantmanagement.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
        body {
            background-image: url('resources/image/index1.jpg');
            background-size: cover;
            background-position: center;
            height: 100vh;
            margin: 0;
        }
        
        .card {
            margin-top: 50px;
            margin-bottom: 50px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        
        .card-header {
            color: #fff;
            padding: 10px;
            border-bottom: 1px solid #ccc;
        }
        
        .card-body {
            padding: 20px;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        .form-control {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        
        .btn-primary {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        
        .btn-danger {
            background-color: #dc3545;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        
        .error {
            color: #dc3545;
            font-size: 12px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>
    <div class="container">
    <%UserDto dto = (UserDto)request.getAttribute("userDto"); %>
        <div class="card">
            <div class="card-header">
                <h2 class="text-center" style="color: green">Update User</h2>
            </div>
            <div class="card-body">
                <form:form action="updateUser" method="post" modelAttribute="userDto">
                <input type="hidden" name="userId" value="<%= dto.getUserId() %>" />
                    <div class="form-group">
                        <label for="username">Username:</label>
                        <form:input path="username" type="text" class="form-control" id="username" />
                        <div class="error"><form:errors path="username" /></div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <form:input path="password" type="password" class="form-control" id="password" />
                        <div class="error"><form:errors path="password" /></div>
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <form:input path="email" type="email" class="form-control" id="email" />
                        <div class="error"><form:errors path="email" /></div>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone:</label>
                        <form:input path="phone" type="text" class="form-control" id="phone" />
                        <div class="error"><form:errors path="phone" /></div>
                    </div>
                    <div class="form-group">
                        <label for="address">Address:</label>
                        <form:input path="address" type="text" class="form-control" id="address" />
                        <div class="error"><form:errors path="address" /></div>
                    </div>
                    <button type="submit" class="btn btn-primary">Update</button>
                    <button type="button" class="btn btn-danger" onclick="location.href='user_list'">Cancel</button>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>