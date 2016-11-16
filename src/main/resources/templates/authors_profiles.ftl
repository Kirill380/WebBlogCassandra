<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Author Profiles</title>
</head>
<body>

<table>
<#list authors as author>
    <tr>
        <td>${author.email}</td>
        <td>${author.userName}</td>
    </tr>
</#list>
</table>

</body>
</html>