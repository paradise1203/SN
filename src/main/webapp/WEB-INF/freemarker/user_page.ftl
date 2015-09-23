<html>

    <head>
        <title> User </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/resources/bootstrap.min.css">
    </head>

    <body>

        <#macro tHead>
            <thead>
                <tr>
                    <th> Firstname </th>
                    <th> Lastname </th>
                    <th> sex </th>
                    <th> city </th>
                    <th> mobile </th>
                    <th> </th>
                    <#nested>
                </tr>
            </thead>
        </#macro>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">SN</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a href="#">Home</a></li>
                        <li><a id="showF" href="#" onclick="doAjaxShowFriends()">friends</a></li>
                        <li><a id="showOU" href="#" onclick="doAjaxShowOtherUsers()">other users</a></li>
                        <li><a href="#">games</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container users" style="display: none">
            <table class="table">
                <@tHead/>
                <tbody class="users">

                </tbody>
            </table>
        </div>

        <form style="display: none">
            <input id="sender" type="text" value=${user.id}>
        </form>

        <script type="text/javascript" src="/resources/jquery-2.1.4.js"></script>
        <script type="text/javascript" src="/resources/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/myJs/user_page.js"></script>

    </body>

</html>