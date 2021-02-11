<%--
  Created by IntelliJ IDEA.
  User: Berikkali
  Date: 13.11.2020
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!--[if IE 9]> <html class="no-js ie9 fixed-layout" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js " lang="en"> <!--<![endif]-->
<head>

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Site Meta -->
    <title>Student Search Page</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="images/our-logo.png" type="image/x-icon" />
    <link rel="apple-touch-icon" href="images/our-logo.png">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,400i,500,700,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Droid+Serif:400,400i,700,700i" rel="stylesheet">

    <!-- Custom & Default Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/carousel.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/style.css">

    <!--[if lt IE 9]>
    <script src="js/vendor/html5shiv.min.js"></script>
    <script src="js/vendor/respond.min.js"></script>
    <![endif]-->

</head>
<body>

<!-- LOADER -->
<div id="preloader">
    <img class="preloader" src="images/loader.gif" alt="">
</div><!-- end loader -->
<!-- END LOADER -->

<div id="wrapper">
    <!-- BEGIN # MODAL LOGIN -->
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <!-- Begin # DIV Form -->
                <div id="div-forms">
                    <form id="login-form">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span class="flaticon-add" aria-hidden="true"></span>
                        </button>
                        <div class="modal-body">
                            <input class="form-control" type="text" placeholder="What you are looking for?" required>
                        </div>
                    </form><!-- End # Login Form -->
                </div><!-- End # DIV Form -->
            </div>
        </div>
    </div>
    <!-- END # MODAL LOGIN -->

    <%@include file="header.jsp"%>

    <section class="section db p120">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="tagline-message page-title text-center">
                        <h3>Search Student</h3>
                        <ul class="breadcrumb">
                            <li><a href="homePage.jsp">Judle</a></li>
                            <li class="active">Search Student</li>
                        </ul>
                    </div>
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section gb nopadtop">
        <div class="container">
            <div class="boxed boxedp4">

                <div class="row">
                    <div class="col-md-12 text-center">
                        <h2>Search Student</h2>
                        <form class="searchForm" method="post">
                            <h4>Student Email: <input type="text" class="userEmail" name="userEmail"></h4>
                            <select class="groupId" name="groupId">
                                <option value="0">Select group</option>
                                <c:forEach var="group" items="${requestScope.groupList}">
                                    <option value="${group.id}"><c:out value="${group.groupName}"/></option>
                                </c:forEach>
                            </select>
                            <select class="majorId" name="majorId">
                                <option value="0">Select major</option>
                                <c:forEach var="major" items="${requestScope.majorSet}">
                                    <option value="${major.id}"><c:out value="${major.majorName}"/></option>
                                </c:forEach>
                            </select>
                            <select class="graduateYear" name="graduateYear">
                                <option value="0">Select graduate year</option>
                                <c:forEach var="graduateYear" items="${requestScope.graduateYears}">
                                    <option value="${graduateYear}"><c:out value="${graduateYear}"/></option>
                                </c:forEach>
                            </select>
                            <br><br>
                            <input class="searchButton" name="searchButton" type="submit" value="Search">
                        </form>
                    </div>
                </div>

                <br><br><br><br>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Email</td>
                            <td>Role</td>
                            <td>Group ID</td>
                            <td>Major ID</td>
                            <td>Graduate Year</td>
                        </tr>
                    </thead>
                    <tbody id="searchResults">

                    </tbody>
                </table>

                <hr class="invis">
            </div><!-- end boxed -->
        </div><!-- end container -->
    </section>

    <!-- start footer -->
    <%@include file="footer.jsp"%>
    <!-- end footer -->

    <div class="copyrights">
        <div class="container">
            <div class="clearfix">
                <div class="pull-left">
                    <div class="cop-logo">
                        <a href="#"><img src="images/logo.png" alt=""></a>
                    </div>
                </div>

                <div class="pull-right">
                    <div class="footer-links">
                        <ul class="list-inline">
                            <li>Design : <a href="https://html.design">HTML.Design</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div><!-- end container -->
    </div><!-- end copy -->
</div><!-- end wrapper -->

<!-- jQuery Files -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/animate.js"></script>
<script src="js/custom.js"></script>

<script>
    $(document).ready(function() {
        $('.searchButton').click(function(event) {
            event.preventDefault();
            const formData = $('.searchForm').serialize();
            $.ajax({
                url: "api/user/search?" + formData,
                type: "GET",
                success: function(responseJSON, status, xhr) {
                    console.log(xhr.responseText)
                    // To clear the content inside <tbody>
                    $("#searchResults").empty();
                    $.each(responseJSON, function(index, item) {
                        $("#searchResults").append(
                            `<tr>
                                <td>`+ item.id +`</td>
                                <td>`+ item.userFirstName +`</td>
                                <td>`+ item.userLastName +`</td>
                                <td>`+ item.userEmail +`</td>
                                <td>`+ item.userRole +`</td>
                                <td>`+ item.groupId +`</td>
                                <td>`+ item.majorId +`</td>
                                <td>`+ item.graduateYear +`</td>
                            </tr>`
                        );
                    });
                }
            });
        });
    });
</script>

</body>
</html>
