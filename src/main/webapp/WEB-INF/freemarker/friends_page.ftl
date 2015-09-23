<link rel="stylesheet" href="/bootstrap.min.css">

<#macro info text>
    <div class="panel panel-default">
        <div class="panel-body">${text}</div>
    </div>
</#macro>

<div class="container">
    <#if hasFriends>
        <@info text="Your friends:"/>
        <table class="table">
            <thead>
                <tr>
                    <th> Firstname </th>
                    <th> Lastname </th>
                    <th> sex </th>
                    <th> city </th>
                    <th> mobile </th>
                    <th> </th>
                    <th> </th>
                </tr>
            </thead>
            <tbody>
                <#list friends as f>
                <tr>
                    <td> ${f.firstName} </td>
                    <td> ${f.lastName} </td>
                    <td> ${f.sex} </td>
                    <td> <#if f.city??>${f.city}</#if> </td>
                    <td> <#if f.mobilePhone??>${f.mobilePhone}</#if> </td>
                    <td>
                        <form role="form">
                            <input id="sender" type="text" style="display: none" value=${user.id}>
                            <input id="recipient" type="text" style="display: none" value=${f.id}>
                            <input type="button" class="btn btn-success" value="show dialog" onclick="doAjaxShowDialog()">
                        </form>
                    </td>
                    <td>
                        <form role="form">
                            <input id="sender" type="text" style="display: none" value=${user.id}>
                            <input id="recipient" type="text" style="display: none" value=${f.id}>
                            <input type="button" class="btn btn-success remFriend" value="remove friend" onclick="doAjaxRemoveFriend()">
                        </form>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <@info text="You don`t have friends yet! Hurry up to find some :)"/>
    </#if>
</div>

<script type="text/javascript">

    $(document).ready(function () {
        $(".remFriend").click(function () {
            $(this).closest("tr").hide();
        });
    });

    function doAjaxShowDialog() {
        var sender = $("#sender").val();
        var recipient = $("#recipient").val();

        $.ajax({
            url: 'makeFriends',
            type: 'POST',
            data: {
                sender: sender,
                recipient: recipient
            },
            dataType: 'html',
            success: function (response) {
                $("#content").html(response);
            }
        });
    }

    function doAjaxRemoveFriend() {
        var sender = $("#sender").val();
        var recipient = $("#recipient").val();

        $.ajax({
            url: 'removeFriends',
            type: 'POST',
            data: {
                sender: sender,
                recipient: recipient
            }
            success: function() {

            }
        });
    }
</script>

<script type="text/javascript" src="/jquery-2.1.4.js"></script>
<script type="text/javascript" src="/bootstrap.min.js"></script>
