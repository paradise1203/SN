$(document).ready(function () {
    $(".changeInfo").click(function () {
        var fName = $("#fName").val();
        var lName = $("#lName").val();
        var sex = $("#sex").val();
        var city = $("#city").val();
        var mobile = $("#mobile").val();

        $.ajax({
            url: 'info/change',
            type: 'POST',
            data: {
                fName: fName,
                lName: lName,
                sex: sex,
                city: city,
                mobile: mobile
            },
            success: function () {
                $.ajax({
                    url: 'home',
                    type: 'GET',
                    success: function (response) {
                        $("#content").html(response);
                        $.getScript("/resources/myJs/home.js");
                    }
                });
            }
        });
    });
});
