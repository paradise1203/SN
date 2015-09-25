//listeners:
/*
$(document).ready(function() {
    $("#showF").click(function () {
        var id = $("#sender").val();
        $.ajax({
            url: 'f',
            type: 'POST',
            data: {
                sender: id
            },
            dataType: 'html',
            success: function (response) {
                $("#content").html(response);
            }
        });
    });
    $("#showOU").click(function () {
        var id = $("#sender").val();
        $.ajax({
            url: 'ou',
            type: 'POST',
            data: {
                sender: id
            },
            dataType: 'html',
            success: function (response) {
                $("#content").html(response);
            }
        });
    })
});
*/

//functions:
function doAjaxShowFriends() {
    var id = $("#sender").val();

    $.ajax({
        url: 'f',
        type: 'GET',
        data: {
            sender: id
        },
        dataType: 'html',
        success: function (response) {
            $("#content").html(response);
            $("title").text("friends");
            $.getScript("/resources/myJs/friends_page.js");
        }
    });
}

function doAjaxShowOtherUsers() {
    var id = $("#sender").val();

    $.ajax({
        url: 'ou',
        type: 'GET',
        data: {
            sender: id
        },
        dataType: 'html',
        success: function (response) {
            $("#content").html(response);
            $("title").text("users");
            $.getScript("/resources/myJs/otherUsers_page.js");
        }
    });
}

