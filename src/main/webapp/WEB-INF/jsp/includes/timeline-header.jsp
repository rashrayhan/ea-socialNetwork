<jsp:include page="/WEB-INF/jsp/includes/index-header.jsp"></jsp:include>
<body>

<div class="container">
    <div class="row" >
        <div class="col-2 c-aside-left">
            <a class="waves-effect">
                <img src="./images/logo.PNG" class="img-fluid" alt="">
            </a>

            <div class="list-group list-group-flush mt-5">
                <a href="timeline" class="list-group-item waves-effect">
                    <i class="fas fa-home mr-3"></i>Home
                </a>
                <a href="follow" class="list-group-item list-group-item-action waves-effect">
                    <i class="fas fa-reply mr-3"></i>Followers</a>
                <a href="follow" class="list-group-item list-group-item-action waves-effect">
                    <i class="fas fa-share mr-3"></i>Following</a>
                <a href="persona_profile" class="list-group-item list-group-item-action waves-effect">
                    <i class="fas fa-user mr-3"></i>Profile</a>
                <a href="index" class="list-group-item list-group-item-action waves-effect">
                    <i class="fas fa-sign-out-alt mr-3"></i>Logout</a>
            </div>
            <br/>
            <%--            <button class="btn btn-lg btn-block btnSign" mat-raised-button (click)="openDialog()">peep</button>--%>

        </div>
    </div>
</div>
</body>
