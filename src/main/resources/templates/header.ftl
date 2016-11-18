<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home">Home</a></li>
                <li><a href="/profile">Profile</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form action="/logout" method="post">
                        <input type="submit" value="Sign Out"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>