<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Property Image</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f5f5f5;
        }
        .container {
            margin-top: 50px;
        }
        .image-container {
            margin-top: 20px;
        }
        .image-container img {
            width: 100%;
            height: 500px;
            object-fit: cover;
            border-radius: 10px;
        }
        .message {
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1 class="text-center">Property Image</h1>
            </div>
        </div>
        <div class="row image-container">
            <div class="col-md-12">
                <img src="data:image/jpeg;base64,<%=session.getAttribute("image")%>">
            </div>
        </div>
        <div class="row message">
            <div class="col-md-12">
                <h2 class="text-center">Welcome, Tenant!</h2>
                <p class="text-center">We're glad you're interested in this property. Our goal is to provide you with a comfortable and safe living space. If you have any questions or concerns, please don't hesitate to reach out to us.</p>
            </div>
        </div>
    </div>
</body>
</html>