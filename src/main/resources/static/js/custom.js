$(function () {
    $('#newPost').submit(makePost);
    let res = window.location.pathname;
    if (res === "/timeline") {
        whoToFollow();
        timeline();
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
    $.ajax({
        url: '/timeline/data',
        method: 'GET',
        success: function (posts) {
            let timeline = "";
            $('.cm-timeline').remove();
            for (let i = 0; i < posts.length; i++) {
                timeline += '<div class="cm-timeline row"><span class="col-1 cmt-img">'
                    + '<img class="aAvatar" src="./images/parallel-avatar.jpg"/></span>'
                    + '<span class="col-11 cmt-text"><p class="cmtt-title"><b>John Doe</b> &nbsp; &nbsp;'
                    + '<span id="cmttt-handle">@username <i class="fa fa-circle small"></i> Dec 12</span></p>';
                if (posts[i].content) {
                    timeline += '<p>' + posts[i].content + '</p>';
                }
                if (posts[i].mediaItems && posts[i].mediaItems.length > 0) {
                    timeline += '<div class="cmtt-img"><img src="/uploads/pictures/' + posts[i].mediaItems[0].filePath + '" alt="Default Image"/></div>';
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
            $('.cm-timelines').append(timeline);
        },
        error:function (err) {
            console.log(err);
        }
    });
}
