<link rel="stylesheet" href="/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<#list users as u>
    <tr>
        <td> ${u.firstName} </td>
        <td> ${u.lastName} </td>
        <td> ${u.sex} </td>
        <td> <#if u.city??>${u.city}</#if> </td>
        <td> <#if u.mobilePhone??>${u.mobilePhone}</#if> </td>
        <td>
            <form role="form">
                <input class="sender" type="text" style="display: none" value=${user.id}>
                <input class="recipient" type="text" style="display: none" value=${u.id}>
                <input type="button" class="btn btn-success addFriend" value="add to friends">
            </form>
        </td>
    </tr>
</#list>

<script type="text/javascript" src="/resources/jquery-2.1.4.js"></script>
<script type="text/javascript" src="/resources/bootstrap.min.js"></script>
<script type="text/javascript" src="/resources/myJs/otherUsers_page.js"></script>