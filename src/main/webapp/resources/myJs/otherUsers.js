$(document).ready(function () {
    $(".addFriend").click(function () {
        var record = $(this).closest("tr");
        var recipient = record.find("form").find("input").val();
        record.hide();
        $.ajax({
            url: 'friends/add',
            type: 'POST',
            data: {
                recipient: recipient
            }
        });
    });
});
