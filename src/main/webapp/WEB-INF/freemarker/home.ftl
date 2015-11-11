<#import "patterns.ftl" as lib>

<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">Your information:</div>
        <div class="panel-body">
            <ul>
                <li> First name: ${user.firstName} </li>
                <li> Last name: ${user.lastName} </li>
                <li> Sex: ${user.sex} </li>
                <li> City: ${user.city} </li>
                <li> Mobile: ${user.mobilePhone} </li>
            </ul>
            <form role="form">
                <div class="form-group">
                    <input class="btn btn-success changeInfo" type="button" value="edit">
                </div>
            </form>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">Your board:</div>
        <div class="panel-body">
            <form role="form">
                <div class="form-group">
                    <label for="post">Write your post:</label>
                    <textarea id="post" class="form-control" rows="5"></textarea>
                </div>
                <input type="button" class="btn btn-success sendPost" value="send">
            </form>

            <ul id="posts">
                <#list posts as post>
                    <li>
                        <button class="like btn btn-default"> like ${post.rating} </button>
                        <input type="text" style="display: none" value=${post.id}>
                        <#if post.user==user>
                            You at ${post.date?string('dd.MM.yyyy HH:mm:ss')} : ${post.post}
                            <button class="btn btn-success deletePost"> Delete </button>
                        <#else>
                             ${post.user.firstName} at ${post.date?string('dd.MM.yyyy HH:mm:ss')} : ${post.post}
                        </#if>
                    </li>
                    Comments:
                    <div>
                    <form role="form">
                        <input type="text" style="display: none" value=${post.id}>
                        <div class="form-group">
                            Write your comment: <textarea class="form-control" rows="5"></textarea>
                        </div>
                        <input type="button" class="btn btn-success comment" value="send">
                    </form>
                    <ul>
                    <#list post.comments as comment>
                        <li> ${comment.user.firstName} at ${comment.date} : ${comment.text} </li>
                    </#list>
                    </ul>
                    </div>
                </#list>
            </ul>
        </div>
    </div>

</div>