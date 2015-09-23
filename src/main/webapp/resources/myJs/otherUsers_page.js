$(document).ready(function () {
    $(".addFriend").click(function () {
        $(this).closest("tr").hide();
        var sender=$(this).closest(".sender").val();
        var recipient=$(this).closest(".recipient").val();
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
