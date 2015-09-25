$(document).ready(function () {
    $(".remFriend").click(function () {
        var ctx=$(this);
        ctx.closest("tr").hide();

        var sender = ctx.closest(".sender").val();
        var recipient = ctx.closest(".recipient").val();
        $.ajax({
            url: 'removeFriends',
            type: 'POST',
            data: {
                sender: sender,
                recipient: recipient
            }
        });
    });
});