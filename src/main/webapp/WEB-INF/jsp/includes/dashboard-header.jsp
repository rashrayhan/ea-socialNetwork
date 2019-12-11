<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>MUM-Social</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/mdb.min.css">
    <link  rel="stylesheet" type="text/css" href="../css/style.css">
    <link  rel="stylesheet" type="text/css" href="./css/style.min.css">
    <link  rel="stylesheet" type="text/css" href="./css/mediaUploadStyle.css">

</head>
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
                <i class="fas fa-users mr-3"></i>Dashboard
            </a>
            <a href="#" class="list-group-item list-group-item-action waves-effect">
                <i class="fas fa-user mr-3"></i>Link 1</a>
            <a href="#" class="list-group-item list-group-item-action waves-effect">
                <i class="fas fa-table mr-3"></i>Link 2</a>
            <a href="#" class="list-group-item list-group-item-action waves-effect">
                <i class="fas fa-map mr-3"></i>Link 3</a>
            <a href="timeline" class="list-group-item list-group-item-action waves-effect">
                <i class="fas fa-money-bill-alt mr-3"></i>timeline</a>
        </div>

    </div>
    <!-- Sidebar -->

</header>
