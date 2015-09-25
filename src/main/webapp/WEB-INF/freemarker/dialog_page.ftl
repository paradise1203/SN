<html>

    <head>
        <title> Dialog </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/resources/bootstrap.min.css">
    </head>

    <body>
        <div class="container">
            <ul id="dialog">
                <#if hasMessages>
                    <#list messages as message>
                        <#if message.senderId==sender.id>
                            <li> You at ${message.date} : ${message.message} </li>
                        <#elseif message.senderId==recipient.id>
                            <li> ${recipient.firstName} at ${message.date} : ${message.message} </li>
                        </#if>
                    </#list>
                </#if>
            </ul>
            <form role="form">
                <input id="sender" type="text" style="display: none" value=${sender.id}>
                <input id="recipient" type="text" style="display: none" value=${recipient.id}>
                <div class="form-group">
                    <label for="message">Write message:</label>
                    <textarea id="message" class="form-control" rows="5"></textarea>
                </div>
                <input type="button" class="btn btn-success" value="Send" onclick="doAjaxSendMessage()">
            </form>
        </div>
        <script type="text/javascript" src="/resources/jquery-2.1.4.js"></script>
        <script type="text/javascript" src="/resources/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/myJs/dialog_page.js"></script>
    </body>

</html>