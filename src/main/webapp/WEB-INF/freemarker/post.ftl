<li>
    You at ${post.date?string('HH:mm:ss')} : ${post.post}
    <form role="form">
        <input type="text" style="display: none" value=${post.id}>
        <input type="button" class="btn btn-success deletePost" value="Delete">
    </form>
</li>
