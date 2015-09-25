<div class="container">
    <#if hasUsers>
        <table class="table">
            <thead>
                <tr>
                    <th> Firstname </th>
                    <th> Lastname </th>
                    <th> sex </th>
                    <th> city </th>
                    <th> mobile </th>
                    <th> </th>
                </tr>
            </thead>
            <tbody>
                <#list users as u>
                    <tr>
                        <td> ${u.firstName} </td>
                        <td> ${u.lastName} </td>
                        <td> ${u.sex} </td>
                        <td> <#if u.city??>${u.city}</#if> </td>
                        <td> <#if u.mobilePhone??>${u.mobilePhone}</#if> </td>
                        <td>
                            <form role="form">
                                <input type="text" style="display: none" value=${user.id}>
                                <input type="text" style="display: none" value=${u.id}>
                                <input type="button" class="btn btn-success addFriend" value="add to friends">
                            </form>
                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <div class="panel panel-default">
            <div class="panel-body">There are no other users except your friends yet :)</div>
        </div>
    </#if>
</div>