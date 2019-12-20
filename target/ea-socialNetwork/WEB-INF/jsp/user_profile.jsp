<jsp:include page="/WEB-INF/jsp/includes/timeline-header.jsp"></jsp:include>

        <div class="col-md-6 col-sm-10 c-main">
            <h5 class="cm-title">Personal Profile</h5>
<%--            <div class="row cm-peep">--%>
<%--                <span class="col-1 cmp-img">--%>
<%--                    <img class="aAvatar" src="./images/parallel-avatar.jpg"/>--%>
<%--                </span>--%>

<%--                <span class="col-11 cmp-form">--%>
<%--                    <form class="" method="post" action="" enctype="multipart/form-data" >--%>

<%--                            <textarea matInput placeholder="What's happening?" name="peep" rows="3" resize="false"></textarea>--%>
<%--                            <label class="btn purple-gradient btn-sm"> <i class="fa fa-image"></i><input type="file" class="uploadFile" name="picture[]" multiple accept="image/*">--%>
<%--                            </label>--%>

<%--                            <label class="btn aqua-gradient btn-sm"> <i class="fa fa-video"></i><input type="file" class="uploadFile" name="video[]" multiple accept="video/*">--%>
<%--                            </label>--%>

<%--                            <input type="checkbox" class="form-check-input ml-2 mt-3" id="notify">--%>
<%--                            <label class="form-check-label btn-sm ml-3" for="notify" name="notify">Notify users</label>--%>

<%--                            <button class="btn btn-sm blue-gradient btn-rounded float-right" type="submit">Post</button>--%>

<%--                    </form>--%>
<%--                </span>--%>
<%--            </div>--%>
            <!-- timelines -->
            <div class="cm-timelines">

                <!-- timeline -->
                <div class="cm-timeline row">

                    <div class="row cm-peep cm-peep-up">
                        <div class="cmp-cover">
                            <img src="../../../resources/static/images/HIyWCaRh.jpg"/>
                        </div>
                        <div class="cmp-profile">
                            <img class="aAvatar" src="../../../resources/static/images/parallel-avatar.jpg"/>

                        </div>
                        <div class="cmp-btn">
                            <button class="btn btn-sm btn-outline-info btn-rounded float-right" type="submit">Follow</button>
                        </div>
                    </div>


                    <div class="cm-details">
                        <p class="cmd-handle"><b>RJ Barnesdel</b> <br/><span class="">@azarq_m</span></p>
                        <p class="cmd-bio">Living mutual has always been at the core of human existence, and it's guided us since our founding in 1851. </p>
                        <p class="cmd-follow">127 <span class="">Following</span> &nbsp; &nbsp; &nbsp; 300 <span class="">Follow</span></p>

                    </div>



                </div>


                <div class="cm-timeline row">
                      <span class="col-1 cmt-img">
                          <img class="aAvatar" src="../../../resources/static/images/parallel-avatar.jpg"/>
                      </span>

                    <span class="col-11 cmt-text">
                        <p class="cmtt-title"><b>John Doe</b> &nbsp; &nbsp;
                          <span id="cmttt-handle">@username <i class="fa fa-circle small"></i> Dec 12</span>
                        </p>
                        <p>Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups,  ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual </p>
                        <div class="cmtt-img">
                          <img src="../../../resources/static/images/HIyWCaRh.jpg"/>
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
                                  <img class="aAvatar" src="../../../resources/static/images/parallel-avatar.jpg"/>
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