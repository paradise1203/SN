<#import "/spring.ftl" as spring>

<html>

<head>
    <title> Registration </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/bootstrap.min.css">
</head>

<body>
<div class="container">
    <h3> Welcome to registration page! </h3>

    <form role="form" method="post" action="/registration">
        <div class="form-group">
            <label for="fName"> First name: </label>
            <input id="fName" name="fName" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="lName"> Last name: </label>
            <input id="lName" name="lName" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="sex"> Sex: </label>
            <select id="sex" name="sex">
                <option value=0> Male </option>
                <option value=1> Female </option>
            </select>
        </div>
        <div class="form-group">
            <label for="city"> City: </label>
            <input id="city" name="city" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="mobile"> Mobile: </label>
            <input id="mobile" name="mobile" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="login"> Login: </label>
            <input id="login" name="login" class="form-control" type="text" required>
        </div>
        <div class="form-group">
            <label for="password"> Password: </label>
            <input id="password" name="password" class="form-control" type="password" required>
        </div>
        <input type="submit" class="btn btn-primary" value="Register">
    </form>
</div>
<script type="text/javascript" src="/resources/jquery-2.1.4.js"></script>
<script type="text/javascript" src="/resources/bootstrap.min.js"></script>
</body>

</html>