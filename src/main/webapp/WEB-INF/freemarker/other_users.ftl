<#import "patterns.ftl" as lib>

<div class="container">
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
                                <input type="button" class="btn btn-success addFriend" value="add to friends">
                            </form>
                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <@lib.info text="There are no other users except your friends yet :)"/>
    </#if>
</div>