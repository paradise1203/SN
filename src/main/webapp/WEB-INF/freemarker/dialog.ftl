<div class="container">
    <ul id="dialog">
        <#if hasMessages>
            <#list messages as message>
                <#if message.user1==recipient>
                    <li> ${recipient.firstName} at ${message.date} : ${message.text} </li>
                <#else>
                    <li> You at ${message.date} : ${message.text} </li>
                </#if>
            </#list>
        </#if>
    </ul>
    <form role="form">
        <input id="recipient" type="text" style="display: none" value=${recipient.id}>
        <div class="form-group">
            <label for="message">Write your message:</label>
            <textarea id="message" class="form-control" rows="5"></textarea>
        </div>
        <input type="button" class="btn btn-success back" value="back to friends">
        <input type="button" class="btn btn-success send" value="send">
    </form>
</div>

