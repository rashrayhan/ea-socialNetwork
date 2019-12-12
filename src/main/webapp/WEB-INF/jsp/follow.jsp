<jsp:include page="/WEB-INF/jsp/includes/timeline-header.jsp"></jsp:include>

        <div class="col-md-6 col-sm-10 c-main">
            <h5 class="cm-title">Following/Followers</h5>
            <div class="row cm-peep">
                <span class="col-1 cmp-img">
                    <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                </span>

                <span class="col-11 cmp-form">
                    <form class="" method="post" action="" enctype="multipart/form-data" >

                            <textarea matInput placeholder="What's happening?" name="peep" rows="3" resize="false"></textarea>
                            <label class="btn purple-gradient btn-sm"> <i class="fa fa-image"></i><input type="file" class="uploadFile" name="picture[]" multiple accept="image/*">
                            </label>

                            <label class="btn aqua-gradient btn-sm"> <i class="fa fa-video"></i><input type="file" class="uploadFile" name="video[]" multiple accept="video/*">
                            </label>

                            <input type="checkbox" class="form-check-input ml-2 mt-3" id="notify">
                            <label class="form-check-label btn-sm ml-3" for="notify" name="notify">Notify users</label>

                            <button class="btn btn-sm blue-gradient btn-rounded float-right" type="submit">Post</button>

                    </form>
                </span>
            </div>
            <!-- timelines -->
            <div class="cm-timelines">

                <!-- timeline -->
                <div class="cm-timeline row">
                    <ul class="nav nav-tabs fill" id="list" role="tablist">
                        <li class="nav-item text-center">
                            <a class="nav-link active" data-toggle="tab" href="#panel4" role="tab">Following</a>
                        </li>
                        <li class="nav-item text-center">
                            <a class="nav-link" data-toggle="tab" href="#panel5" role="tab">Follower</a>
                        </li>
                    </ul>
                    <!-- Tab panels -->

                    <div class="tab-content card col-12">
                       <div class="tab-pane fade in show active p-4 " id="panel4" role="tabpane4">
                           <div class="row cars-contact">
                              <span class="col-1 carsc-1">
                                    <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                              </span>
                               <span class="col-8 carsc-2">
                                   <b>MilanMiranda</b> <span class="muted small">@azarq_m</span><br/>
                                    <span class="bio small">The Ideological Warfare Center is a good one</span>
                               </span>
                                <span class="col-2 carsc-3">
                                     <button class="btn btn-sm btn-outline-danger" type="submit">Unfollow</button>
                              </span>
                           </div>

                         </div>


                        <div class="tab-pane fade in show p-4 " id="panel5" role="tabpane5">
                            <div class="row cars-contact">
                              <span class="col-1 carsc-1">
                                    <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                              </span>
                                <span class="col-8 carsc-2">
                                   <b>MilanMiranda</b> <span class="muted small">@azarq_m</span><br/>
                                    <span class="bio small">The Ideological Warfare Center is a good one</span>
                               </span>
                                <span class="col-2 carsc-3">
                                     <button class="btn btn-sm btn-outline-info" type="submit">follow</button>
                              </span>
                            </div>

                        </div>
                    </div>
                </div>


            </div>
        </div>
<%--        right side externlized--%>
        <jsp:include page="/WEB-INF/jsp/includes/whotofollow.jsp"></jsp:include>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"></jsp:include>