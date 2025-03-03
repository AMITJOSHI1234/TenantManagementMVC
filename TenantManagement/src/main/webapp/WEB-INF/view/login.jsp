<!DOCTYPE html>
<html>
<head>
    <title>Login User</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    <link rel="stylesheet" href="resources/css/login.css">
</head>
<body>
    <%@ include file="navbar.jsp" %>
    <section class="vh-100">
        <div class="container py-5 h-100">
            <div class="row d-flex align-items-center justify-content-center h-100">
                <div class="col-md-8 col-lg-7 col-xl-6">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw1.webp"
                        class="img-fluid" alt="Login image">
                </div>
                <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
             
                    <h2 class="login-heading">Login to your account</h2>
                    <% if (request.getAttribute("error") != null) { %>
                        <div class="alert alert-danger animate__animated animate__shakeX" role="alert">
                            <%= request.getAttribute("error") %>
                        </div>
                    <% } %>
                    <form action="login" method="post">
                        <div data-mdb-input-init class="form-outline mb-4">
                            <input type="email" id="form1Example13" name="email" class="form-control form-control-lg" />
                            <label class="form-label" for="form1Example13">Email address</label>
                            <% if (request.getAttribute("emailError") != null) { %>
                                <div class="error animate__animated animate__shakeX"><%= request.getAttribute("emailError") %></div>
                            <% } %>
                        </div>

                        <div data-mdb-input-init class="form-outline mb-4">
                            <input type="password" id="form1Example23" name="password" class="form-control form-control-lg" />
                            <label class="form-label" for="form1Example23">Password</label>
                            <% if (request.getAttribute("passwordError") != null) { %>
                                <div class="error animate__animated animate__shakeX"><%= request.getAttribute("passwordError") %></div>
                            <% } %>
                        </div>

                        <!-- Submit button -->
                        <button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-lg btn-block">Login</button>

                    </form>
                </div>
            </div>
        </div>
        <!--  <div class="d-flex flex-column flex-md-row text-center text-md-start justify-content-between py-4 px-4 px-xl-5 bg-primary">
            <div class="text-white mb-3 mb-md-0">&copy; 2025 Tenant Management.</div>
        </div>-->
    </section>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>