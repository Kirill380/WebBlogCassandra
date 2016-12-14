<#import "/spring.ftl" as spring />
<#import "macros/post.ftl" as p/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Post</title>
    <link rel="stylesheet" href="/project/css/footer.css">
    <link rel="stylesheet" href="/project/css/posts.css">
    <link rel="stylesheet" href="/vendor/bootstrap-3.3.7/css/bootstrap.css">
    <link rel="stylesheet" href="/vendor/bootstrap-3.3.7/css/bootstrap-theme.css">
</head>
<body>
<#include "header.ftl"/>
<div class="container">
    <div class="controls">
        <div class="controls_create-post">
           <span class="create-post jsCreatePost">Create Post</span>
        </div>
    </div>
    <div id="container" class="post-container">
    <#list posts as post>
        <@p.post post/>
    </#list>
    </div>
    <div class="jsPopPost" style="display:none">
        <form action="/api/post/" method="post">
            <div class="form-group">
                <label for="title">Title: </label>
                <input type="text" class="form-control" name="title" id="title">
            </div>
            <div class="form-group">
                <label for="content">Content: </label>
                <textarea class="form-control" name="body" id="content"></textarea>
            </div>
            <div class="form-group">
                <label for="tags">tags: </label>
                <input type="text" class="form-control" name="tags" id="tags">
            </div>
            <input type="button" class="bClose jsPost btn btn-default" value="create">
        </form>
    </div>
</div>
<#include "footer.ftl"/>
<script src="/project/js/post.js"></script>
</body>
</html>