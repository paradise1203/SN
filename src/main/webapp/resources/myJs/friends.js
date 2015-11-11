$(document).ready(function () {
    $(".remFriend").click(function () {
        $(this).closest("tr").hide();
        var recipient = $(this).closest("form").find("input").first().val();
        $.ajax({
            url: 'friends/remove',
            type: 'POST',
            data: {
                recipient: recipient
            }
        });
    });

    $(".approve").click(function () {
        $(this).closest("tr").hide();
        var recipient = $(this).closest("form").find("input").first().val();
        $.ajax({
            url: 'friends/approve',
            type: 'POST',
            data: {
                recipient: recipient
            }
        });
    });

    $(".dialog").click(function () {
        var recipient = $(this).closest("form").find("input").first().val();
        $.ajax({
            url: 'friends/dialog',
            type: 'GET',
            data: {
                recipient: recipient
            },
            dataType: 'html',
            success: function (response) {
                $("title").text("dialog");
                $("#content").html(response);
                $.getScript("/resources/myJs/dialog.js");
            }
        });
    });
});