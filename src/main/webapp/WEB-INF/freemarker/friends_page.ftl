<div class="container">
    <#if hasFriends>
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
                            <input type="text" style="display: none" value=${user.id}>
                            <input type="text" style="display: none" value=${f.id}>
                            <input type="button" class="btn btn-success dialog" value="show dialog">
                        </form>
                    </td>
                    <td>
                        <form role="form">
                            <input type="text" style="display: none" value=${user.id}>
                            <input type="text" style="display: none" value=${f.id}>
                            <input type="button" class="btn btn-success remFriend" value="remove friend">
                        </form>
                    </td>
                </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <div class="panel panel-default">
            <div class="panel-body">You don`t have friends yet, hurry up to find some :)</div>
        </div>
    </#if>
</div>
