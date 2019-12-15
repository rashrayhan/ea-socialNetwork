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
                            <img src="./images/HIyWCaRh.jpg"/>
                        </div>
                        <div class="cmp-profile">
                            <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                            <br/>
                            <label class=""> <i class="fa fa-edit text-info ml-5"></i><input type="file" class="uploadFile" name="picture[]" multiple accept="image/*">
                            </label>
                        </div>
                        <div class="cmp-btn">
                            <button class="btn btn-sm blue-gradient btn-rounded float-right" type="submit" data-toggle="modal" data-target="#editModal">Edit profile</button>
                        </div>
                    </div>


                    <div class="cm-details mt-1">
                        <p class="cmd-handle"><b>RJ Barnesdel</b> <br/><span class="">@azarq_m</span></p>
                        <p class="cmd-bio">Living mutual has always been at the core of human existence, and it's guided us since our founding in 1851. </p>
                        <p class="cmd-follow">127 <span class="">Following</span> &nbsp; &nbsp; &nbsp; 300 <span class="">Follow</span></p>

                    </div>



                </div>


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

<!-- Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="addModal" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Edit Profile</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="post" action="">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="name"  name="name">
                                <label for="name">Name</label>
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->

                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="yob"  name="yob">
                                <label for="yob">Year of Birth</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="md-form mb-0">
                                <input type="email" class="form-control" id="email"  name="email">
                                <label for="email">Email</label>
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->

                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-3">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="country"  name="country">
                                <label for="country">Country</label>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="state"  name="state">
                                <label for="state">State</label>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="city"  name="city">
                                <label for="city">City</label>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="zip"  name="zip">
                                <label for="zip">Zip</label>
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->


                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="md-form mb-0">
                                <input type="password" class="form-control" id="oldpass"  name="oldpass">
                                <label for="oldpass">Old password</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="md-form mb-0">
                                <input type="password" class="form-control" id="newpass"  name="newpass">
                                <label for="newpass">New password</label>
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->


                    <!--Grid row-->
                    <div class="row">

                        <!--Grid column-->
                        <div class="col-md-12">

                            <div class="md-form">
                                <label for="bio">Bio</label>
                                <textarea class="form-control md-textarea" id="bio" name="bio" rows="3"></textarea>
                            </div>

                        </div>
                    </div>
                    <!--Grid row-->
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-warning" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-outline-primary">save</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"></jsp:include>