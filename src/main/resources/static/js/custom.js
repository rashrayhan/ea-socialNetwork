$(function () {
    $('#newPost').submit(makePost);
    let res = window.location.pathname;
    if (res === "/timeline") {
        whoToFollow();
        let timelineHandler = timeline();
        timelineHandler.timelineHandler();
        $(window).scroll(function () {
           if($(window).height() + $(window).scrollTop() === $(document).height()) {
               if(timelineHandler.hasMore()) {
                   timelineHandler.timelineHandler();
               }
           }
        });
    }
    if (res === "/profile") {
        authenticatedUserInfo();
        let profileHandler = authenticatedUserProfile();
        profileHandler.userProfile();
        $(window).scroll(function () {
            if($(window).height() + $(window).scrollTop() === $(document).height()) {
                if(profileHandler.hasMore()) {
                    profileHandler.userProfile();
                }
            }
        });
    }
    if(res === "/follow") {
        authenticatedUserFollowInfo();
    }

    $(document).on('click', '.follow-btn', function (e) {
        e.preventDefault();
        let $this = $(this);
        let username = $this.data("username");
        $.ajax({
            url: '/follow/' + username,
            method: 'GET',
            success: function (res) {
                if (res) {
                    $this.text("Following");
                    $this.attr('disabled', true);
                    timeline();
                    setTimeout(whoToFollow, 5000);
                }
            },
            error: function (err) {
                console.log(err);
            }
        })
    });
});

const makePost = function (e) {
    e.preventDefault();
    let $form = $(this);
    let data = new FormData(this);
    let method = $form.attr("method");
    let url = $form.attr("action");
    let encType = $form.attr("enctype");
    $.ajax({
        url: url,
        method: method,
        data: data,
        contentType: false,
        processData: false,
        cache: false,
        enctype: encType,
        success: function (res) {
            $form[0].reset();
            $('#postSaved').text(res);
        },
        error: function (err) {
            console.log(err);
        }
    });
};

const whoToFollow = function () {
    $.ajax({
        url: '/who-to-follow',
        method: 'GET',
        success: function (users) {
            $('.cars-contact').remove();
            let suggestions = "";
            for (let i = 0; i < users.length; i++) {
                suggestions += '<div class="row cars-contact" >'
                    + '<span class="col-2 carsc-1">'
                    + '<img class="aAvatar" src="./images/parallel-avatar.jpg" alt="Profile"/></span>'
                    + '<a class="col-6 carsc-2 text-dark" href="user_profile"><b>' + users[i].surname
                    + ' ' + users[i].otherNames + '</b> <br/>' +
                    +'<span class="handle">@' + users[i].username + '</span></a><span class="col-4 carsc-3">'
                    + '<button class="btn btn-sm btn-outline-info follow-btn" data-username="' + users[i].username + '" type="submit">Follow</button></span></div>';
            }
            $('.car-suggest').append(suggestions);
        },
        error: function (err) {
            console.log(err);
        }
    });
};

const timeline = function () {
    let pageNumber = 0;
    let hasMore = true;

    let timelineHandler = function () {
        $.ajax({
            url: '/timeline/data/'+pageNumber,
            method: 'GET',
            success: function (posts) {
                if(posts.length < 10) {
                    hasMore = false;
                } else {
                    pageNumber++;
                }
                $('.cm-timelines').append(postsDesigner(posts));
                streamVideos();
            },
            error: function (err) {
                console.log(err);
            }
        });
    };

    return {
        timelineHandler:timelineHandler,
        hasMore:function () {
            return hasMore;
        }
    }
};

const authenticatedUserProfile = function () {
    let hasMore = true;
    let pageNumber = 0;
    let userProfile = function () {
        $.ajax({
            url: '/authenticated-user-profile-data/' + pageNumber,
            method: 'GET',
            success: function (posts) {
                if(posts.length < 10) {
                    hasMore = false;
                } else {
                    pageNumber++;
                }
                $('.profile-row').remove();
                $('.cm-timelines').append(postsDesigner(posts, 'profile-row'));
                streamVideos();
            },
            error: function (err) {
                console.log(err);
            }
        });
    };
    return {
        userProfile:userProfile,
        hasMore: function () {
            return hasMore;
        }
    }
};

const searchedUserProfile = function (username) {
    let pageNumber = 0;
    let hasMore = true;
    let userProfileHandler = function () {
        $.ajax({
            url: '/searched-user-profile-data/' + username + "/" + pageNumber,
            method: 'GET',
            success: function (posts) {
                if(posts.length < 10) {
                    hasMore = false;
                } else {
                    pageNumber++;
                }
                $('.cm-timeline').remove();
                $('.cm-timelines').append(postsDesigner(posts, ''));
            },
            error: function (err) {
                console.log(err);
            }
        });
    };

    return {
        userProfileHandler:userProfileHandler,
        hasMore:function () {
            return hasMore;
        }
    }
};

const postsDesigner = function (posts, rowClass) {
    let timeline = "";
    for (let i = 0; i < posts.length; i++) {
        timeline += '<div class="' + rowClass + ' row cm-timeline"><span class="col-1 cmt-img">'
            + '<img class="aAvatar" src="./images/parallel-avatar.jpg"/></span>'
            + '<span class="col-11 cmt-text"><p class="cmtt-title"><b>' + posts[i].user.otherNames + ' ' +
            posts[i].user.surname + '</b> &nbsp; &nbsp;'
            + '<span id="cmttt-handle">@' + posts[i].user.username + '<i class="fa fa-circle small"></i>' + posts[i].activityTime + '</span></p>';
        if (posts[i].content) {
            timeline += '<p>' + posts[i].content + '</p>';
        }
        if (posts[i].mediaItems && posts[i].mediaItems.length > 0) {
            if(posts[i].mediaItems[0].mediaType === 'Image') {
                timeline += '<div class="cmtt-img"><img src="/uploads/pictures/' + posts[i].mediaItems[0].filePath + '" alt="Default Image"/></div>';
            } else {
                timeline += '<div class="cmtt-img"><video src="/uploads/videos/' + posts[i].mediaItems[0].filePath + '"' +
                    ' autoplay class="video"/></div>';
            }
        }
        timeline += '<div class="row cmtt-action"><span class="ca-action"><i class="fa fa-heart"></i></span>'
            + '<span class="col-3 ca-count">82.5K</span><span class="ca-action commentToggle">'
            + '<i class="fa fa-comment"></i></span><span class="col-3 ca-count">7.2k</span></div>'
            + '<div class="container cmtt-comments"><div class="md-form mb-0">'
            + '<form style="width: 100%;" method="post" action="#">'
            + '<input type="text" class="col-8" placeholder="enter comment" name="comment">'
            + '<button type="submit" class="btn btn-primary btn-sm" style="">send</button>'
            + '</form></div><div class="row cmttc-otherComments"><div class="col-1 cmttco-user">'
            + '<img class="aAvatar" src="./images/parallel-avatar.jpg"/><p class="small">@user</p>'
            + '</div><div class="col-9 cmttco-cmt"><p>This is a comment from me</p>'
            + '</div></div></div></span></div>';
    }
    return timeline;
};

const authenticatedUserInfo = function () {
    $.ajax({
        url: '/authenticated-user-info',
        method: 'GET',
        success: function (info) {
            $('.profileNames').text(info.user.otherNames + " " + info.user.surname);
            $('.profileUsername').text("@" + info.user.username);
            $('.profileFollowing').text(info.followings);
            $('.profileFollowers').text(info.followers);

        },
        error: function (err) {
            console.log(err);
        }
    });
};

const authenticatedUserFollowInfo = function () {
    $.ajax({
        url: '/authenticated-user-follow-info',
        method: 'GET',
        success: function (info) {
            let followings = info.followings;
            let followers = info.followers;
            if (followings) {
                let data = "";
                $('.followings .cars-contact').remove();
                for (let i = 0; i < followings.length; i++) {
                    data += '<div class="row cars-contact"><span class="col-1 carsc-1">'
                        + '<img class="aAvatar" src="./images/parallel-avatar.jpg" alt="User Photo"/>'
                        + '</span><span class="col-8 carsc-2"><b class="f-names">' + followings[i].otherNames + ' '
                        + followings[i].surname + '</b><span class="muted small f-username">' +
                        '@'+followings[i].username+'</span><br/>';
                        if(followings[i].bio) {
                            data += '<span class="bio small">'+followings[i].biography+'</span>';
                        }
                        data += '</span><span class="col-2 carsc-3">'
                        + '<button class="btn btn-sm btn-outline-danger" type="submit">Unfollow</button>'
                        + '</span></div>';
                }
                $('.followings').append(data);
            }
            if(followers) {
                let data = "";
                $('.followers .cars-contact').remove();
                for (let i = 0; i < followers.length; i++) {
                    data += '<div class="row cars-contact"><span class="col-1 carsc-1">'
                        + '<img class="aAvatar" src="./images/parallel-avatar.jpg" alt="User Photo"/>'
                        + '</span><span class="col-8 carsc-2"><b class="f-names">' + followers[i].otherNames + ' '
                        + followers[i].surname + '</b><span class="muted small f-username">' +
                        '@'+followers[i].username+'</span><br/>';
                    if(followers[i].bio) {
                        data += '<span class="bio small">'+followers[i].biography+'</span>';
                    }
                    data += '</span><span class="col-2 carsc-3">'
                        + '<button class="btn btn-sm btn-outline-info" type="submit">Follow</button>'
                        + '</span></div>';
                }
                $('.followers').append(data);
            }
        },
        error: function (err) {
            console.log(err);
        }
    });
};

const streamVideos = function () {
    $('.video').each(function(){
        const myMediaSource = new MediaSource();
        const url = URL.createObjectURL(myMediaSource);
        let vidSrc = this.src;
        this.src = url;

        const videoSourceBuffer = myMediaSource
            .addSourceBuffer('video/webm; codecs="avc1.64001e"');

        fetch(window.location.host + vidSrc).then(function(response) {
            return response.arrayBuffer();
        }).then(function(videoData) {
            videoSourceBuffer.appendBuffer(videoData);
        });
    });
};
