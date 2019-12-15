<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" type="text/css" href="../css/timelinestyle.css">
</head>

<body>
<a href="timeline" class="list-group-item list-group-item-action waves-effect">
    <i class="fas fa-money-bill-alt mr-3"></i>timeline</a>

<div class="container">
    <div class="row">
        <div class="col-2 c-aside-left">
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
                <a href="/timeline" class="list-group-item list-group-item-action waves-effect">
                    <i class="fas fa-money-bill-alt mr-3"></i>timeline</a>
            </div>
            <br/>
            <%--            <button class="btn btn-lg btn-block btnSign" mat-raised-button (click)="openDialog()">peep</button>--%>

        </div>

        <jsp:include page="/WEB-INF/jsp/includes/timeline-header.jsp"></jsp:include>
        <div class="col-md-6 col-sm-10 c-main">
            <h5 class="cm-title">Home</h5>
            <div class="row cm-peep">
                <span class="col-1 cmp-img">
                    <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                </span>
                <span class="col-11 cmp-form">
                    <h6 style="color: green;" id="postSaved"></h6>
                     <form:form action="/post" method="post" modelAttribute="newPost" enctype="multipart/form-data">
                         <form:textarea path="content" placeholder="What's happening?" formControlName="peep" resize="false"/>

                         <form:label class="btn purple-gradient btn-sm" path="picture"> <i class="fa fa-image"></i>
                             <form:input type="file" class="uploadFile" path="picture" accept="image/*"/>
                         </form:label>
                         <form:label class="btn aqua-gradient btn-sm" path="picture"> <i class="fa fa-video"></i>
                             <form:input type="file" class="uploadFile" path="video" accept="video/*"/>
                         </form:label>

                         <form:checkbox css="form-check-input ml-2 mt-3" path="notifyFollowers"/>
                         <form:label class="form-check-label btn-sm ml-3"
                                     path="notifyFollowers">Notify users</form:label>
                         <button class="btn btn-sm blue-gradient btn-rounded float-right" type="submit">Post</button>
                     </form:form>

                    <div class="cm-timelines">

                <!-- timeline -->
                <div class="cm-timeline row">
                      <span class="col-1 cmt-img">
                          <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                      </span>

                      <span class="col-11 cmt-text">
                        <p class="cmtt-title"><b>John Doe</b> &nbsp; &nbsp;
                          <span id="cmttt-handle">@username <i class="fa fa-circle small"></i> Dec 12</span>
                        </p>
                        <p>Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups,  ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual </p>
                        <div class="cmtt-img">
                          <img src="./images/HIyWCaRh.jpg"/>
                        </div>
                        <div class="row cmtt-action">
                          <span class="ca-action"><i class="fa fa-heart"></i></span>
                          <span class="col-3 ca-count">82.5K</span>

                          <span class="ca-action commentToggle"><i class="fa fa-comment"></i></span>
                          <span class="col-3 ca-count">7.2k</span>
                        </div>

                          <div class="container cmtt-comments">
                            <div class="md-form mb-0">
                               <form  style="width: 100%;" method="post" action="#">
                                <input type="text" class="col-8" placeholder="enter comment" name="comment">
                                   <button type="submit" class="btn btn-primary btn-sm" style="">send</button>
                               </form>

                            </div>
                            <div class="row cmttc-otherComments" >
                              <div class="col-1 cmttco-user">
                                  <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                                  <p class="small">@user</p>
                              </div>
                              <div class="col-9 cmttco-cmt">
                                  <p>This is a comment from me</p>
                              </div>
                            </div>
                        </div>
                      </span>
                </div>


            </div>
        </div>
<%--        right side externlized--%>
<jsp:include page="/WEB-INF/jsp/includes/whotofollow.jsp"></jsp:include>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"></jsp:include>
