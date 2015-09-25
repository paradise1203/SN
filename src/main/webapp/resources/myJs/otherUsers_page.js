$(document).ready(function () {
    $(".addFriend").click(function () {
        var ctx=$(this);
        ctx.closest("tr").hide();

        var sender=ctx.closest(".sender").val();
        var recipient=ctx.closest(".recipient").val();
        $.ajax({
            url: 'makeFriends',
            type: 'POST',
            data: {
                sender: sender,
                recipient: recipient
            }
        });
    });
});
