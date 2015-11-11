$(document).ready(function () {
    var intF = setInterval(getMessage, 3000);

    $(".back").click(function () {
        $.ajax({
            url: 'friends',
            type: 'GET',
            dataType: 'html',
            success: function (response) {
                clearInterval(intF);
                $("title").text("friends");
                $("#content").html(response);
                $.getScript("/resources/myJs/friends.js");
            }
        });
    });

    $(".send").click(function () {
        var recipient = $("#recipient").val();
        var message = $("#message").val();

        $.ajax({
            url: 'friends/dialog/send',
            type: 'POST',
            data: {
                recipient: recipient,
                message: message
            },
            dataType: 'text',
            success: function (response) {
                $("#dialog").append(response);
            }
        });
    });
});

function getMessage() {
    var recipient = $("#recipient").val();

    $.ajax({
        url: 'friends/dialog/get',
        type: 'GET',
        data: {
            recipient: recipient
        },
        dataType: 'text',
        success: function (response) {
            $("#dialog").append(response);
        }
    });
}

