<html>

<head>
    <title> Login </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/bootstrap.min.css">
</head>

<body>
<div class="container">
    <h3> Welcome to login page! </h3>

    <form role="form" method="post" action="/login">
        <div class="form-group">
            <label for="login">Login: </label>
            <input id="login" name="login" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="password">Password: </label>
            <input id="password" name="password" class="form-control" type="password" required>
            <#if error??> ${error} </#if>
        </div>
        <div class="form-group">
            <label for="remMe">Remember me </label>
            <input id="remMe" name="remMe" class="form-control" type="checkbox">
        </div>
        <input type="submit" class="btn btn-primary" value="Login">
    </form>
</div>
<script type="text/javascript" src="/resources/jquery-2.1.4.js"></script>
<script type="text/javascript" src="/resources/bootstrap.min.js"></script>
</body>

</html>