<!-- index.jsp -->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tenant Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
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
    <%@ include file="WEB-INF/view/navbar.jsp" %>
    <div class="header animate__animated animate__fadeInDown">
        <h1>Tenant Management</h1>
    </div>
    <div class="container mt-5 animate__animated animate__fadeInUp" style="background-color: beige">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h2 class="text-center animate__animated animate__fadeInLeft">Welcome to Tenant Management System</h2>
                <p class="animate__animated animate__fadeInRight">Tenant Management is a comprehensive system designed to simplify the process of managing tenants and properties. With our system, you can easily track rent payments, manage lease agreements, and communicate with your tenants. Our system is user-friendly, secure, and scalable, making it the perfect solution for property managers and landlords.</p>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>