$(document).ready(function () {
    $(".sendMes").click(function () {
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
    });
});

