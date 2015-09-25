$(document).ready(function () {
    $(".remFriend").click(function () {
        $(this).closest("tr").hide();
        var sAdr = $(this).closest("form").find("input").first();
        var sender = sAdr.val();
        var recipient = sAdr.next().val();
        $.ajax({
            url: 'removeFriends',
            type: 'POST',
            data: {
                sender: sender,
                recipient: recipient
            }
        });
    });

    $(".dialog").click(function () {
        var sAdr = $(this).closest("form").find("input").first();
        var sender = sAdr.val();
        var recipient = sAdr.next().val();
        $.ajax({
            url: 'dialog',
            type: 'GET',
            data: {
                sender: sender,
                recipient: recipient
            },
            dataType: 'html',
            success: function (response) {
                $("#content").html(response);
                $("title").text("dialog");
                $.getScript("/resources/myJs/dialog_page.js");
            }
        });
    });
});