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
        type: 'POST',
        data: {
            sender: id
        },
        dataType: 'html',
        success: function (response) {
            $("#friends").append(response);
        }
    });
}

function doAjaxShowOtherUsers() {
    var id = $("#sender").val();

    $.ajax({
        url: 'ou',
        type: 'POST',
        data: {
            sender: id
        },
        dataType: 'html',
        success: function (response) {
            $("tbody.users").append(response);
            $("div.users").css("display", "block");
        }
    });
}

