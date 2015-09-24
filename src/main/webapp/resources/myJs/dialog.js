
$(document).ready(function () {
    var interval=setInterval(function () {
        var sender = $("#sender").val();
        var recipient = $("#recipient").val();
        $.ajax({
            url: 'getMessage',
            type: 'GET',
            data: {
                sender: sender,
                recipient: recipient
            },
            dataType: 'text',
            success: function (response) {
                $("#dialog").append(response);
            }
        });
    }, 3000);
});


function doAjaxSendMessage() {
    var sender = $("#sender").val();
    var recipient = $("#recipient").val();
    var message = $("#message").val();

    $.ajax({
        url: 'sendMessage',
        type: 'POST',
        data: {
            sender: sender,
            recipient: recipient,
            message: message
        },
        dataType: 'text',
        success: function (response) {
            $("#dialog").append(response);
        }
    });
}
