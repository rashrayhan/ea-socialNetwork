
$(function(){
    $('#newPost').submit(makePost);
});

const makePost = function (e) {
    e.preventDefault();
    let $form = $(this);
    let data = new FormData(this);
    let method = $form.attr("method");
    let url = $form.attr("action");
    let encType = $form.attr("enctype");
    $.ajax({
       url:url,
        method:method,
        data:data,
        contentType:false,
        processData:false,
        cache:false,
        enctype:encType,
        success:function(res) {
           $form[0].reset();
           $('#postSaved').text(res);
        },
        error:function(err) {
           console.log(err);
        }
    });
};
