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
                    <a class="navbar-brand active" href="#">SN</a>
                </div>
                <div>
                    <ul class="nav navbar-nav">
                        <li><a id="showU" href="#" onclick="doAjaxShowUserHomePage()">Home</a></li>
                        <li><a id="showF" href="#" onclick="doAjaxShowFriends()">Friends</a></li>
                        <li><a id="showOU" href="#" onclick="doAjaxShowOtherUsers()">Other users</a></li>
                        <li><a href="/logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div id="content" class="container"> </div>

        <script type="text/javascript" src="/resources/jquery-2.1.4.js"></script>
        <script type="text/javascript" src="/resources/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/myJs/main.js"></script>

    </body>

</html>