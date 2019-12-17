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
                        <form  style="width: 100%;" method="post" action="/updateProfilePicture" enctype="multipart/form-data">
                        <div class="cmp-profile">
                            <img class="aAvatar" src="./uploads/profilepictures/${user.profilePhoto}" width="218" height="231"/>
                            <br/>
                            <label class=""> <i class="fa fa-edit text-info ml-5"></i><input type="file" class="uploadFile" name="file" >
                            </label>
                            <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
                            <button type="submit" >Change PP</button>
                        </div>
                        </form>
                        <div class="cmp-btn">
                            <button class="btn btn-sm blue-gradient btn-rounded float-right" type="submit" data-toggle="modal" data-target="#editModal">Edit profile</button>
                        </div>
                    </div>


                    <div class="cm-details mt-1">
                        <p class="cmd-handle"><b><span class="profileNames"></span></b> <br/><span class="profileUsername"></span></p>
                        <p class="cmd-bio">Living mutual has always been at the core of human existence, and it's guided us since our founding in 1851. </p>
                        <p class="cmd-follow"><span class="profileFollowing"></span><span> Following</span> &nbsp; &nbsp; &nbsp; <span class="profileFollowers"></span><span> Followers</span></p>

                    </div>

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
                <form method="post" action="/updateprofile">
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-12">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="name"  name="username" value="${user.username}">
                                <label for="name">Username</label>
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->
                    <input type="hidden"  name="id" value="${user.id}">
                    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="yob"  name="dateOfBirth" value="${user.dateOfBirth}">
                                <label for="yob">Year of Birth</label>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="md-form mb-0">
                                <input type="email" class="form-control" id="email"  name="email" value="${user.email}">
                                <label for="email">Email</label>
                            </div>
                        </div>
                    </div>
                    <!--Grid row-->

                    <!--Grid row-->
                    <div class="row">
                        <div class="col-md-3">
                            <div class="md-form mb-0">

                                <input type="hidden"  name="address.id" value="${user.address.id}">
                                <input type="text" class="form-control" id="country"  name="address.country" value="${user.address.country}">

                                <label for="country">Country</label>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="state"  name="address.state" value="${user.address.state}">
                                <label for="state">State</label>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="city"  name="address.city" value="${user.address.city}">
                                <label for="city">City</label>
                            </div>
                        </div>

                        <div class="col-md-3">
                            <div class="md-form mb-0">
                                <input type="text" class="form-control" id="zip"  name="address.zipCode" value="${user.address.zipCode}">
                                <label for="zip">Zip</label>
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

                                <textarea class="form-control md-textarea" id="bio" name="biography" rows="3">${user.biography}</textarea>
                            </div>

                        </div>
                    </div>
                    <!--Grid row-->


            <div class="modal-footer">
                <button type="button" class="btn btn-outline-warning" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-outline-primary">save</button>
            </div>
                </form>
            </div>

        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"></jsp:include>
