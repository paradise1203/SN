<#import "patterns.ftl" as lib>

<div class="container">
    <#if hasFriends>
        <table class="table">
            <@lib.table_heads><th></th><th></th></@lib.table_heads>
            <tbody>
                <#list friends as f>
                <tr>
                    <td> ${f.friend.firstName} </td>
                    <td> ${f.friend.lastName} </td>
                    <td> ${f.friend.sex} </td>
                    <td> ${f.friend.city} </td>
                    <td> ${f.friend.mobilePhone} </td>
                    <td>
                        <form role="form">
                            <input type="text" style="display: none" value=${f.friend.id}>
                            <input type="button" class="btn btn-success dialog" value="show dialog">
                        </form>
                    </td>
                    <td>
                        <#if f.message??>
                        ${f.message.user1.firstName} at ${f.message.date} : ${f.message.text}
                        </#if>
                    </td>
                    <td>
                        <form role="form">
                            <input type="text" style="display: none" value=${f.friend.id}>
                            <input type="button" class="btn btn-success remFriend" value="remove friend">
                        </form>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <@lib.info text="You don`t have friends yet, hurry up to find some :)"/>
    </#if>
    <#if hasUsers>
        <table class="table">
            <@lib.table_heads/>
            <tbody>
                <#list users as u>
                <tr>
                    <td> ${u.firstName} </td>
                    <td> ${u.lastName} </td>
                    <td> ${u.sex} </td>
                    <td> ${u.city} </td>
                    <td> ${u.mobilePhone} </td>
                    <td>
                        <form role="form">
                            <input type="text" style="display: none" value=${u.id}>
                            <input type="button" class="btn btn-success approve" value="approve friend">
                        </form>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    </#if>
</div>
