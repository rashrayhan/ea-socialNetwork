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
                <form:label class="btn aqua-gradient btn-sm" path="video"> <i class="fa fa-video"></i>
                    <form:input type="file" class="uploadFile" path="video" accept="video/*"/>
                </form:label>

                <form:checkbox css="form-check-input ml-2 mt-3" path="notifyFollowers"/>
                <form:label class="form-check-label btn-sm ml-3"
                            path="notifyFollowers">Notify users</form:label>
                <button class="btn btn-sm blue-gradient btn-rounded float-right" type="submit">Post</button>
            </form:form>

            <div class="cm-timelines">

            </div>
        </div>
        <%--        right side externlized--%>
        <jsp:include page="/WEB-INF/jsp/includes/whotofollow.jsp"/>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"/>
