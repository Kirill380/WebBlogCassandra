<#macro post post>
<div id="${post.id}" class="post">
    <div class="post_title">${post.title}</div>
    <div class="post_content">
        <div class="content">
            <div class="content_votes">
                <div class="votes">
                    <div class="votes_up jsUp"></div>
                    <div class="votes_count">${post.getVoteScore()}</div>
                    <div class="votes_down jsDown"></div>
                </div>
            </div>
            <div class="content_body">${post.body}</div>
        </div>
    </div>
    <div class="post_tags">
        <div class="tags">
            <#list post.tags as tag>
                <div class="tags_item">${tag}</div>
            </#list>
        </div>
    </div>
    <div class="post_author">
        <div class="author">
            <div class="author_name">${post.author}</div>
            <div class="author_publish-date">${post.publishDate?datetime}</div>
        </div>
    </div>
    <div class="comment_section">
        <div class="comment_list">
            <div id="list" class="list">
                <#list post.comments as comment>
                    <div class="list_item">
                        <div class="item">
                            <div class="item_body">
                                ${comment.commentBody} – <span class="item_author-email">${comment.email}</span> <span class="item_date">${comment.publishDate?datetime}</span>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
        <div class="comment_add jsAddComment">add a comment</div>
        <div class="jsPopUpComment" data-id="${post.id}" style="display: none">
            <form  action="/api/post/$$$/comment" method="post">
                <label for="com">Comment:</label>
                <textarea class="form-control" name="commentBody" id="com" rows="5"></textarea>
                <input type="button" class="bClose jsComment btn btn-default" value="create">
            </form>
        </div>
    </div>
</div>

</#macro>