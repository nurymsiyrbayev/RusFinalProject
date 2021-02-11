<%--
  Created by IntelliJ IDEA.
  User: nurym
  Date: 11/11/20
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${empty sessionScope.signedUser}">
    <c:redirect url="loginPage.jsp"/>
</c:if>

<header class="header header-normal">
    <div class="topbar clearfix">
        <div class="container">
            <div class="row-fluid">
                <div class="col-md-6 col-sm-6 text-left">
                    <p>
                        <strong><i class="fa fa-phone"></i></strong> +90 543 123 45 67 &nbsp;&nbsp;
                        <strong><i class="fa fa-envelope"></i></strong> <a href="mailto:#">info@yoursite.com</a>
                    </p>
                </div><!-- end left -->
                <div class="col-md-6 col-sm-6 text-right">
                    <%--  Login and Logout is here   --%>
                    <div class="social-links">
                        <c:if test="${sessionScope.signedUser == null}">
                            <a href="loginPage.jsp">Login</a>
                        </c:if>
                        <c:if test="${sessionScope.signedUser != null}">
                            <form action="user" method="POST">
                                <input type="hidden" name="action" value="logout">
                                <a href="#" onclick="this.parentNode.submit()">Log out</a>
                            </form>
                        </c:if>
                    </div>
                        <%--  Login and Logout is end   --%><!-- end left -->
                </div>
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end topbar -->

    <div class="container">
        <nav class="navbar navbar-default yamm">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <div class="logo-normal">
                    <a class="navbar-brand" href="#"><img src="images/our-logo.png" alt=""></a>
                </div>
            </div>

            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="homePage.jsp">Главная страница</a></li>
                    <li><a href="event"></a></li>
                    <li><a href="club?action=getAll">Личности</a></li>
                    <li><a href="news">Новости</a></li>
                    <li class="iconitem"><a href="user">Search <i class="fa fa-search"></i></a></li>
                </ul>
            </div>
        </nav><!-- end navbar -->
    </div><!-- end container -->
</header>
