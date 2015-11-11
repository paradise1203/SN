$(document).ready(function () {
    $(".deletePost").click(function () {
        var postId = $(this).closest("form").find("input").first().val();
        $(this).closest("li").hide();
        $.ajax({
            url: 'posts/remove',
            type: 'POST',
            data: {
                postId: postId
            }
        });
    });
});
