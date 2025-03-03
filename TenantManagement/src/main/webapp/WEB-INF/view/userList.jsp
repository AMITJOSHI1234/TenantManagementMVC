<%@page import="com.yash.tenantmanagement.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users List</title>
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
        
        .table {
            margin-bottom: 20px;
        }
        
        .table th, .table td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        
        .table th {
            background-color: #f0f0f0;
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
        
        .form-group {
            margin-bottom: 20px;
        }
        
        .form-control {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        
        .error {
            color: #dc3545;
            font-size: 12px;
            margin-top: 5px;
        }
        
        .search-field {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        
        .search-field input {
            width: 70%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        
        .search-field button {
            width: 20%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@ include file="navbar.jsp" %>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2 class="text-center" style="color: green">Users List</h2>
            </div>
            <div class="card-body">
            <form action="searchUser" method="post">
                <div class="search-field">
                     
                    <input type="text" class="form-control" id="username" name="username" placeholder="Enter username">
                    <input type="text" class="form-control" id="address" name="address" placeholder="Enter address">
                    <button type="submit" class="btn btn-primary">Search</button>
                    
                </div>
                </form>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Address</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            List<UserDto> users = (List<UserDto>) request.getAttribute("userDtos");
                            for (UserDto user : users) {
                        %>
                        <%if(!user.getUsername().equalsIgnoreCase("amit")){ %>
                        <tr>     
                           
                            <td><%= user.getUsername() %></td>
                           
                            <td><%= user.getEmail() %></td>
                            <td><%= user.getPhone() %></td>
                            <td><%= user.getAddress() %></td>
                            <td>
                            <!-- 
                                <button type="button" class="btn btn-primary" onclick="location.href='updateUser/<%= user.getUserId() %>'">Update</button> -->
                                <button type="button" class="btn btn-danger" onclick="location.href='userDelete/<%= user.getUserId() %>'">Delete</button>
                            </td>
                        </tr>
                         <%} %>
                        <% } %>
                    </tbody>
                </table>
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <% 
                            int currentPage = (Integer) request.getAttribute("currentPage");
                            int pageSize = (Integer) request.getAttribute("pageSize");
                            int totalUsers = (Integer) request.getAttribute("totalUsers");
                            int totalPages = (int) Math.ceil((double) totalUsers / pageSize);
                        %>
                        <li class="page-item <%= currentPage == 0 ? "disabled" : "" %>">
                            <a class="page-link" href="user_list?page=<%= currentPage - 1 %>&size=<%= pageSize %>&sort=<%= (String)request.getAttribute("sort") %>">Previous</a>
                        </li>
                        <li class="page-item <%= currentPage == totalPages  ? "disabled" : "" %>">
                            <a class="page-link" href="user_list?page=<%= currentPage + 1 %>&size=<%= pageSize %>&sort=<%= (String)request.getAttribute("sort") %>">Next</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>