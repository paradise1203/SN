<#macro table_heads>
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

<#macro info text>
    <div class="panel panel-default">
        <div class="panel-body">${text}</div>
    </div>
</#macro>