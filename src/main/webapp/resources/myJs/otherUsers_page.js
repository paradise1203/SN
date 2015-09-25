$(document).ready(function () {
    $(".addFriend").click(function () {
        $(this).closest("tr").hide();
        var sAdr = $(this).closest("form").find("input").first();
        var sender = sAdr.val();
        var recipient = sAdr.next().val();
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
