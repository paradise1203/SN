$(document).ready(function () {
    $(".changeInfo").click(function () {
        $.ajax({
            url: 'info/change',
            type: 'GET',
            success: function (response) {
                $("#content").html(response);
                $.getScript("/resources/myJs/change_info.js");
            }
        });
    });

    $(".sendPost").click(function () {
        var post = $("#post").val();
        $.ajax({
            url: 'posts/send',
            type: 'POST',
            data: {
                post: post
            },
            success: function (response) {
                $("#posts").prepend(response);
                $.getScript("/resources/myJs/post.js");
            }
        });
    });

    $(".deletePost").click(function () {
        var postId = $(this).siblings("input").val();
        $(this).closest("li").hide();
        $.ajax({
            url: 'posts/remove',
            type: 'POST',
            data: {
                postId: postId
            }
        });
    });

    $(".comment").click(function () {
        var block = $(this).closest('div');
        var id = block.find('form').find('input').first().val();
        var text = block.find('form').find('textarea').val();
        $.ajax({
            url: 'posts/comments/add',
            type: 'POST',
            data: {
                postId: id,
                text: text
            },
            success: function (response) {
                block.find('ul').prepend(response);
            }
        });
    });

    $(".like").click(function () {
        var but = $(this);
        var postId = but.siblings('input').val();
        $.ajax({
            url: 'posts/likes/add',
            type: 'POST',
            data: {
                postId: postId
            },
            success: function (count) {
                but.text('like' + count);
                if (but.hasClass('btn-default')) {
                    but.removeClass('btn-default');
                    but.addClass('btn-primary');
                } else {
                    but.removeClass('btn-primary');
                    but.addClass('btn-default');
                }
            }
        });
    });

});
