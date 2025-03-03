<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top">
    <a class="navbar-brand" href="index.jsp">Tenant Management</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <% if (session.getAttribute("roleId") != null) { %>
                <% if ((Long)session.getAttribute("roleId")==1L) { %>
                    <li class="nav-item">
                        <a class="nav-link" href="propertyList">Property List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="user_list?page=0&size=5&sort=username">Users List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="addProperty">Add Property</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="updateUser?userId=<%=session.getAttribute("userId") %>">Admin Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                <% } else { %>
                    <li class="nav-item">
                        <a class="nav-link" href="propertyList">Property List</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="updateUser?userId=<%=session.getAttribute("userId") %>">User Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                <% } %>
                <li class="nav-item">
                    <span class="nav-link text-success">Welcome, <%= session.getAttribute("name") %></span>
                </li>
            <% } else { %>
                <li class="nav-item">
                    <a class="nav-link" href="login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register">Register</a>
                </li>
            <% } %>
        </ul>
    </div>
</nav>