<html>

    <head>
        <title> User </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/resources/bootstrap.min.css">
    </head>

    <body>
        <#macro info text>
            <div class="panel panel-default">
                <div class="panel-body">${text}</div>
            </div>
        </#macro>
        <#macro tHeads>
            <thead>
                <tr>
                    <th> Firstname </th>
                    <th> Lastname </th>
                    <th> sex </th>
                    <th> city </th>
                    <th> mobile </th>
                    <th>  </th>
                    <#nested>
                </tr>
            </thead>
        </#macro>

        <div class="container">
            <h3> Hello, ${user.lastName} ${user.firstName}! We have missed you :) </h3>

            <#if hasFriends>
                <@info text="Your friends:"/>
                <table class="table">
                    <@tHeads> <th> </th> </@tHeads>
                    <tbody>
                        <#list friends as f>
                            <tr>
                                <td> ${f.firstName} </td>
                                <td> ${f.lastName} </td>
                                <td> ${f.sex} </td>
                                <td> <#if f.city??>${f.city}</#if> </td>
                                <td> <#if f.mobilePhone??>${f.mobilePhone}</#if> </td>
                                <td>
                                    <form action="/dialog" method="get">
                                        <input name="sender" type="text" style="display: none" value=${user.id}>
                                        <input name="recipient" type="text" style="display: none" value=${f.id}>
                                        <input type="submit" class="btn bg-success" value="show dialog">
                                    </form>
                                </td>
                                <td>
                                    <form action="/removeFriends" method="post">
                                        <input name="sender" type="text" style="display: none" value=${user.id}>
                                        <input name="recipient" type="text" style="display: none" value=${f.id}>
                                        <input type="submit" class="btn bg-success" value="remove friend">
                                    </form>
                                </td>
                            </tr>
                        </#list>
                    </tbody>
                </table>
            <#else>
                <@info text="You don`t have friends yet! Hurry up to find some :)"/>
            </#if>

            <#if hasUsers>
                <@info text="Other users:"/>
                <table class="table">
                    <@tHeads/>
                    <tbody>
                        <#list users as u>
                            <tr>
                                <td> ${u.firstName} </td>
                                <td> ${u.lastName} </td>
                                <td> ${u.sex} </td>
                                <td> <#if u.city??>${u.city}</#if> </td>
                                <td> <#if u.mobilePhone??>${u.mobilePhone}</#if> </td>
                                <td>
                                    <form action="/makeFriends" method="post">
                                        <input name="sender" type="text" style="display: none" value=${user.id}>
                                        <input name="recipient" type="text" style="display: none" value=${u.id}>
                                        <input type="submit" class="btn bg-success" value="add to friends">
                                    </form>
                                </td>
                            </tr>
                        </#list>
                    </tbody>
                </table>
            <#else>
                <@info text="There is no other users yet :)"/>
            </#if>

        </div>

        <script type="text/javascript" src="/resources/jquery-2.1.4.js"></script>
        <script type="text/javascript" src="/resources/bootstrap.min.js"></script>
    </body>

</html>