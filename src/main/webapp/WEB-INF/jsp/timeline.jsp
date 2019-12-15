<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/includes/timeline-header.jsp"/>
<div class="col-md-6 col-sm-10 c-main">
    <h5 class="cm-title">Home</h5>
    <div class="row cm-peep">
                <span class="col-1 cmp-img">
                    <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                </span>
        <div class="col-11 cmp-form">
            <h6 style="color: green;" id="postSaved"></h6>
            <form:form action="/post" method="post" modelAttribute="newPost" enctype="multipart/form-data">
                <form:textarea path="content" placeholder="What's happening?" formControlName="peep"
                               resize="false"/>

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
                               <form style="width: 100%;" method="post" action="#">
                                <input type="text" class="col-8" placeholder="enter comment" name="comment">
                                   <button type="submit" class="btn btn-primary btn-sm" style="">send</button>
                               </form>

                            </div>
                            <div class="row cmttc-otherComments">
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
        <jsp:include page="/WEB-INF/jsp/includes/whotofollow.jsp"/>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"/>
