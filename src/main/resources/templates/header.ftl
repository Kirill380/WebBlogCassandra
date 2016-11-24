<meta name="_csrf" content="${_csrf.token}"/>
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}"/>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home">Home</a></li>
                <li><a href="/profile">Profile</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a class="jsLogout" href="/">Sign Out</a></li>
            </ul>
        </div>
    </div>
</nav>
<script src="<@spring.url '/vendor/jquery-3.1.1.min.js'/>"></script>
<script src="/project/js/header.js"></script>