<#import "/spring.ftl" as spring />
<#import "macros/post.ftl" as p/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Post</title>
    <link rel="stylesheet" href="<@spring.url '/project/css/footer.css'/>">
    <link rel="stylesheet" href="<@spring.url '/project/css/posts.css'/>">
    <link rel="stylesheet" href="<@spring.url '/vendor/bootstrap-3.3.7/css/bootstrap.css'/>">
    <link rel="stylesheet" href="<@spring.url '/vendor/bootstrap-3.3.7/css/bootstrap-theme.css'/>">
</head>
<body>
<#include "header.ftl"/>
<div class="container">

    <div class="post-container">
    <#list posts as post>
        <@p.post post/>
    </#list>
    </div>

</div>
<#include "footer.ftl"/>
</body>
</html>