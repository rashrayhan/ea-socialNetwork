<jsp:include page="/WEB-INF/jsp/includes/timeline-header.jsp"></jsp:include>

        <div class="col-md-6 col-sm-10 c-main">
            <h5 class="cm-title">Home</h5>
            <div class="row cm-peep">
                <span class="col-1 cmp-img">
                    <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                </span>

                <span class="col-11 cmp-form">
                    <form class="" >

                      <textarea matInput placeholder="What's happening?" formControlName="peep" resize="false"></textarea>
                      <div class="row">

<%--                          <button routerLink="" class="col btn btnSign">post</button>--%>
                      </div>
                    </form>
                </span>
            </div>
            <!-- timelines -->
            <div class="cm-timelines">

                <!-- timeline -->
                <div class="cm-timeline row">
          <span class="col-1 cmt-img">
              <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
          </span>

                    <span class="col-11 cmt-text">
            <p class="cmtt-title"><b>John Doe</b> &nbsp; &nbsp;
              <span id="cmttt-handle">@handle • 13h</span>
            </p>
            <p>Lorem ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual mockups,  ipsum is placeholder text commonly used in the graphic, print, and publishing industries for previewing layouts and visual </p>
            <div class="cmtt-img">
              <img src="assets/XNBgQIbg.jpg"/>
            </div>
            <div class="row cmtt-action">

              <span class="ca-action"><mat-icon> favorite_border </mat-icon></span>
              <span class="col-3 ca-count">82.5K</span>

              <span class="ca-action"><mat-icon> comment </mat-icon></span>
              <span class="col-3 ca-count">7.2k</span>

              <span class="ca-action"><mat-icon> bookmark_border </mat-icon></span>
            </div>



          </span>
                </div>


            </div>
        </div>

        <div class="col-3 c-aside-right">
            <div class="car-search">
                <mat-form-field appearance="outline" class="mat-form-group">
                    <mat-label>Search Users</mat-label>
                    <input type="email" matInput placeholder="search">

                </mat-form-field>
            </div>
            <div class="car-suggest">
                <h6>Who to follow</h6>
                <!-- contact row -->
                <div class="row cars-contact" >
                <span class="col-2 carsc-1">
                    <img class="aAvatar" src="./images/parallel-avatar.jpg"/>
                </span>
                    <span class="col-6 carsc-2" routerLink="/user"><b>MilanMiranda.</b> <br/><span class="handle">@azarq_m</span></span>
                    <span class="col-4 carsc-3">
<%--                    <button routerLink="/" class="col btn btn-lg btn-block btnFollow">Follow</button>--%>
                </span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
