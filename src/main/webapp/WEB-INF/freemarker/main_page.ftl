<html>

    <head>
        <title> SN </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/resources/bootstrap.min.css">
    </head>

    <body>

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">SN</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a id="showU" href="#">Home</a></li>
                        <li><a id="showF" href="#" onclick="doAjaxShowFriends()">friends</a></li>
                        <li><a id="showOU" href="#" onclick="doAjaxShowOtherUsers()">other users</a></li>
                        <li><a href="#">games</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="content" class="container"> </div>

        <form style="display: none">
            <input id="sender" type="text" value=${user.id}>
        </form>

        <script type="text/javascript" src="/resources/jquery-2.1.4.js"></script>
        <script type="text/javascript" src="/resources/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/myJs/main_page.js"></script>

    </body>

</html>