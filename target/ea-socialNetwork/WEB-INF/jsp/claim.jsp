<jsp:include page="/WEB-INF/jsp/includes/timeline-header.jsp"></jsp:include>

        <div class="col-md-6 col-sm-10 c-main">
            <h5 class="cm-title">Account Locked</h5>

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

                        </div>
                        <div class="cmp-btn">
                            <button class="btn btn-sm blue-gradient btn-rounded float-right" type="submit" data-toggle="modal" data-target="#claimModal">Claim Account</button>
                        </div>
                    </div>


                    <div class="cm-details mt-1">
                        <p class="cmd-handle"><b>RJ Barnesdel</b> <br/><span class="">@azarq_m</span></p>
                        <p class="cmd-bio">Living mutual has always been at the core of human existence, and it's guided us since our founding in 1851. </p>
                        <p class="cmd-follow">127 <span class="">Following</span> &nbsp; &nbsp; &nbsp; 300 <span class="">Follow</span></p>

                    </div>



                </div>


            </div>
        </div>

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

                        <!--Grid column-->
                        <div class="col-md-12">

                            <div class="md-form">
                                <label for="reason">Reason</label>
                                <textarea class="form-control md-textarea" id="reason" name="reason" rows="5"></textarea>
                            </div>

                        </div>
                    </div>
                    <!--Grid row-->
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-warning" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-outline-primary">Send claim</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"></jsp:include>