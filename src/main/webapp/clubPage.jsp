<%--
  Created by IntelliJ IDEA.
  User: nurym
  Date: 11/11/20
  Time: 21:17
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
    <title>Club Page</title>
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
    <link rel="stylesheet" href="css/bootstrap-select.min.css">
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

    <section class="section lb p120">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="tagline-message page-title text-center">
                        <h3>Авторы</h3>
                        <ul class="breadcrumb">
                            <li><a href="javascript:void(0)">Judle</a></li>
                            <li class="active">Club</li>
                        </ul>
                    </div>
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section gb nopadtop">
        <div class="container">
            <div class="boxed boxedp4">
                <c:if test="${sessionScope.signedUser.userRole == 2}">
                    <div class="mx-auto">
                        <h2>Add New Club (Related to some Club)</h2>
                        <form method="post" class="clubInsert">
                            <input type="hidden" name="action" value="addNewClub">
                            Club Owner Email <input class="newOwnerEmail" name="clubOwnerEmail" type="text">
                            <br>
                            Club Name <input class="newName" name="clubName" type="text">
                                <br>
                            Club Description<br>
                                <label>
                                    <textarea class="newDescription" name="clubDescription" cols="45" rows="5"></textarea>
                                </label>
                            <br>
                            Club Image URL <input class="newUrl" name="clubImageURL" type="text">
                                <br>
                            <input class="addClub" type="submit" value="Add">
                        </form>
                    </div>
                </c:if>

                <br><br><br><br>

                <div class="row blog-grid shop-grid">
<%--        Clubs loop here         --%>
                    <c:forEach var="club" items="${requestScope.clubs}">
                        <div class="col-md-3">
                            <div class="course-box shop-wrapper">
                                <div class="image-wrap entry">
<%--                                    <img src="${club.clubImgUrl}" alt="" class="img-responsive" width="200px" height="200px">--%>
                                    <img src="" alt="" class="img-responsive" width="200px" height="200px">
                                </div>
                                <!-- end image-wrap -->
                                    <div class="course-details shop-box text-center">
                                            <h4>
                                                <form method="get" action="club">
                                                    <input type="hidden" name="action" value="getClub">
<%--                                                    <input type="hidden" class="clubId" name="clubId" value="${club.id}">--%>
                                                    <input type="hidden" class="clubId" name="clubId" value="Автор">
<%--                                                    <a class="nav-link" href="#" onclick="this.parentNode.submit()"><c:out value="${club.clubName}"/></a>--%>
                                                    <a class="nav-link" href="#" onclick="this.parentNode.submit()"><c:out value="Автор"/></a>
                                                </form>
                                                <small>Автор</small>
                                            </h4>
                                    </div>
                                <!-- end details -->
                                <div class="course-footer clearfix">
                                    <div class="pull-left">
                                        <ul class="list-inline">
                                            <form method="post">
                                                <input type="hidden" class="clubId"  value="${club.id}">
                                                <input type="hidden" class="userId"  value="${sessionScope.signedUser.id}">
                                                <input class="joinBtn" type="submit" value="JOIN">
                                            </form>
                                        </ul>
                                    </div><!-- end left -->
                                </div><!-- end footer -->
                            </div><!-- end box -->
                        </div><!-- end col -->
                    </c:forEach>
<%--                    Blogs loop here         --%>

                </div><!-- end row -->
            </div>
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
<script src="js/bootstrap-select.min.js"></script>
<script src="js/custom.js"></script>

</body>
</html>

<script>
    $(document).ready(function() {
        //Script to add new news
        $('.addClub').click(function(event) {
            event.preventDefault();
            let button = $(this);
            let form = button.closest('.clubInsert');
            let clubOwnerEmail = form.find('.newOwnerEmail').val();
            let clubName = form.find('.newName').val();
            let clubDescription = form.find('.newDescription').val();
            let clubUrl = form.find('.newUrl').val();
            let toSend = {
                clubName: clubName,
                clubDescription: clubDescription,
                clubImgUrl: clubUrl,
            };
            let sendJson = JSON.stringify(toSend);
            $.ajax({
                url: "api/club/insert/"+clubOwnerEmail,
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: sendJson,
                success: function(message) {
                    alert(message);
                    if(message === "Club was inserted successfully!") {
                        $.ajax({
                            url: "api/club/all",
                            type: "GET",
                            success: function (responseJson) {
                                let lastClub = responseJson[responseJson.length - 1];
                                $('.blog-grid').append(
                                    `<div class="col-md-3">
                                        <div class="course-box shop-wrapper">
                                            <div class="image-wrap entry">
                                                <img src="` + clubUrl + `" alt="" class="img-responsive" width="200px" height="200px">
                                            </div>
                                                <div class="course-details shop-box text-center">
                                                        <h4>
                                                            <form method="get" action="club">
                                                                <input type="hidden" name="action" value="getClub">
                                                                <input type="hidden" class="clubId" name="clubId" value="` + lastClub.id + `">
                                                                <a class="nav-link" href="#" onclick="this.parentNode.submit()">` + clubName + `</a>
                                                            </form>
                                                            <small>club</small>
                                                        </h4>
                                                </div>
                                            <div class="course-footer clearfix">
                                                <div class="pull-left">
                                                    <ul class="list-inline">
                                                        <form method="post">
                                                            <input type="hidden" class="clubId" name="clubId" value="` + lastClub.id + `">
                                                            <input type="hidden" class="userId"  value="${sessionScope.signedUser.id}">
                                                            <input class="joinBtn" type="submit" value="JOIN">
                                                        </form>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>`
                                );
                            }
                        });
                    }
                }
            })
        });
        //Script to add new news

        //Script to join to Club
        $(document).on('click', '.joinBtn', function (event){
            event.preventDefault();
            let button = $(this);
            let clubId;
            let userId;
            $(this).siblings().each(function(){
                if($(this).hasClass("clubId")){
                    clubId = $(this).val();
                }
                if($(this).hasClass("userId")){
                    userId = $(this).val();
                }
            });
            $.ajax({
                url: "api/club/join/" + userId + "/" + clubId,
                type: "POST",
                success: function (message) {
                    alert(message);
                }
            })
        });
        //Script to join to Club
    });
</script>
