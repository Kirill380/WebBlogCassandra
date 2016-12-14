<#import "/spring.ftl" as spring />
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Author Profiles</title>
    <link rel="stylesheet" href="/project/css/footer.css">
    <link rel="stylesheet" href="/project/css/user-profile.css">
    <link rel="stylesheet" href="/vendor/bootstrap-3.3.7/css/bootstrap.css">
    <link rel="stylesheet" href="/vendor/bootstrap-3.3.7/css/bootstrap-theme.css">
</head>
<body>

<#include "header.ftl"/>

<div class="userProfile">
<div class="userProfile__field">
    <span>Email: </span>
    <span>${author.email}</span>
</div>
<div class="userProfile__field">
    <span>Full Name: </span>
    <span>${author.userName}</span>
</div>
</div>




<#include "footer.ftl"/>
</body>
</html>