<jsp:include page="/WEB-INF/jsp/includes/index-header.jsp"></jsp:include>
<body class="grey lighten-3">

<header>

    <!-- Navbar -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
        <div class="container-fluid">

            <!-- Brand -->
            <a class="navbar-brand waves-effect" href="">
                <strong class="blue-text">MUM-Social Admin</strong>
            </a>

            <!-- Collapse -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Right -->
            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item">
                    <form action="/logout" method="post">
                        <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
                        <button type="submit" href="index" class="nav-link border border-light rounded waves-effect">
                            <i class="fas fa-sign-out-alt mr-2 blue-text"></i>Logout
                        </button>
                    </form>
                </li>
            </ul>
        </div>
    </nav>
    <!-- Navbar -->

    <!-- Sidebar -->
    <div id="navbarSupportedContent" class="sidebar-fixed position-fixed">

        <a class="waves-effect">
            <img src="./images/logo.PNG" class="img-fluid" alt="">
        </a>

        <div class="list-group list-group-flush mt-5">
            <a href="dashboard" class="list-group-item waves-effect">
                <i class="fas fa-bullhorn mr-3 blue-grey-text"></i>Dashboard
            </a>
            <a href="filthy" class="list-group-item list-group-item-action waves-effect">
                <i class="fas fa-ban mr-3 blue-grey-text"></i>Filthy posts</a>
            <a href="filthy_words" class="list-group-item list-group-item-action waves-effect">
                <i class="fas fa-file-word mr-3 blue-grey-text"></i>Filthy words</a>
            <a href="users_all" class="list-group-item list-group-item-action waves-effect">
                <i class="fas fa-users mr-3 blue-grey-text"></i>System users</a>
            <a href="user_claims" class="list-group-item list-group-item-action waves-effect">
                <i class="fas fa-id-card mr-3 blue-grey-text"></i>User Claims</a>
            <a href="timeline" class="list-group-item list-group-item-action waves-effect">
                <i class="fas fa-stream mr-3 blue-grey-text"></i>System timeline</a>
        </div>

    </div>
    <!-- Sidebar -->

</header>
