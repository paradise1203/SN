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
        <input type="button" class="btn btn-success sendMes" value="Send">
    </form>
</div>
