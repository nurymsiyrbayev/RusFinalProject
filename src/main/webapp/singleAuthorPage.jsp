<%--
  Created by IntelliJ IDEA.
  User: nurym
  Date: 11/11/20
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!--[if IE 9]> <html class="no-js ie9 fixed-layout" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js " lang="en"> <!--<![endif]-->
<html lang="ru">
<head>

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Site Meta -->
    <title>Single Author Page</title>
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
    <link rel="stylesheet" href="css/prettyPhoto.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/style.css">

    <!--[if lt IE 9]>
    <script src="js/vendor/html5shiv.min.js"></script>
    <script src="js/vendor/respond.min.js"></script>
    <![endif]-->

</head>
<body style="font-family: Tahoma, Arial, Helvetica, sans-serif">

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

    <section class="section cb">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="tagline-message page-title">
                        <h3>Автор</h3>
                    </div>
                </div><!-- end col -->
                <div class="col-md-6 text-right">
                    <ul class="breadcrumb">
                        <li><a href="homePage.jsp">Judle</a></li>
                        <li class="active">Автор</li>
                    </ul>
                </div>
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section">
        <div class="container">
            <div class=" ">
                <div class="row">
                    <div class="col-md-6 shop-media">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="image-wrap entry">
                                    <img src="<c:out value="${requestScope.author.authorImgUrl}"/>" alt="" class="img-responsive authorImg">
                                </div><!-- end image-wrap -->
                            </div>
                        </div><!-- end row -->

                        <hr class="invis">

                    </div><!-- end col -->

                    <div class="col-md-6">
                        <div class="shop-desc">
                            <h3 class="authorName"><c:out value="${requestScope.author.authorName}"/></h3>
                            <small>Author</small>
                            <br>
                            <div>
<%--                                <form method="post">--%>
<%--                                    <input type="hidden" class="authorId" name="authorId" value="${requestScope.auhtor.id}">--%>
<%--                                    <input type="hidden" class="userId"  value="${sessionScope.signedUser.id}">--%>
<%--                                    <input class="joinBtn" type="submit" value="Join">--%>
<%--                                </form>--%>
                                <br><br>
                                <ul class="list-inline">
                                    <li> Astana IT University</li>
                                    <form method="get" action="author">
                                        <input type="hidden" name="action" value="getAll">
                                        <%--                                                    <input type="hidden" class="authorId" name="authorId" value="${author.id}">--%>
                                        <input type="hidden" class="authorId" name="authorId" value="${author.authorId}">
                                        <%--                                                    <a class="nav-link" href="#" onclick="this.parentNode.submit()"><c:out value="${author.authorName}"/></a>--%>
                                        <li>Categories: <a class="nav-link" href="#" onclick="this.parentNode.submit()">Автор</a>
                                    </form>

                                </ul>
                            </div>
                            <!-- end shop meta -->
                        </div><!-- end desc -->
                    </div><!-- end col -->
                </div><!-- end row -->

                <hr class="invis">

                <div class="row">
                    <div class="col-md-12">
                        <div class="shop-extra">
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#description">Биография</a></li>
                                <li><a data-toggle="tab" href="#menu2">Отзыв</a></li>
<%--                                <li><a data-toggle="tab" href="#requestToJoin">Request(s)</a></li>--%>
                            </ul>

                            <div class="tab-content">
                                <div id="description" class="tab-pane fade in active">
                                    <c:if test="${sessionScope.signedUser.id == 2}">
                                        <form method="post">
                                            <input type="hidden" class="authorId" name="authorId" value="${requestScope.author.id}">
                                            <input type="hidden" class="ownerId" value="${requestScope.author.authorId}">
                                            Полгон имя ФИО:
                                            <br>
                                            <input type="text" class="updateName" name="authorName" value="<c:out value="${requestScope.author.authorName}"/>">
                                            <br>
                                            Img Url:
                                            <br>
                                            <textarea class="updateImgUrl" name="updateImgUrl" cols="20" rows="5"><c:out value="${requestScope.author.authorImgUrl}"/></textarea>
                                            <br>
                                            Биография:
                                            <br>
                                            <textarea class="updateBiography" name="authorBiography" id="" cols="60" rows="10"><c:out value="${requestScope.author.authorBiography}"/></textarea>
                                            <br>
                                            <input class="authorUpdate" type="submit" value="Обнавить">
                                        </form>
                                    </c:if>
                                    <c:if test="${sessionScope.signedUser.id != 2}">
                                        <p><c:out value="${requestScope.author.authorBiography}"/></p>
                                    </c:if>
                                </div>
                                <div id="menu2" class="tab-pane fade">
                                    <h3>Отзыв</h3>

                                    <p>Ваша электронная почта не будет разглашена. Обязательные поля помечены *</p>

                                    <div class="rating">
                                        <p>Ваша оценка</p>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>

                                    <hr class="invis">

                                    <form class="big-contact-form row" role="search">
                                        <div class="col-md-12">
                                            <textarea class="form-control" placeholder="Ваш отзыв .."></textarea>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" placeholder="Введите ваше имя..">
                                        </div>
                                        <div class="col-md-6">
                                            <input type="email" class="form-control" placeholder="Введите адрес электронной почты..">
                                        </div>
                                        <div class="col-md-12">
                                            <button type="submit" class="btn btn-primary" value="Отправить">Отправить</button>
                                        </div>
                                    </form>
                                </div>
<%--                                <c:if test="${sessionScope.signedUser.id == 2}">--%>
<%--                                    <div id="requestToJoin" class="tab-pane fade">--%>
<%--                                        <h3>Request(s)</h3>--%>
<%--                                        <table class="table">--%>
<%--                                            <thead>--%>
<%--                                            <tr>--%>
<%--                                                <td><strong>First Name</strong></td>--%>
<%--                                                <td><strong>Last Name</strong></td>--%>
<%--                                                <td>Email</td>--%>
<%--                                                <td>Graduate Year</td>--%>
<%--                                                <td>———</td>--%>
<%--                                                <td>———</td>--%>
<%--                                            </tr>--%>
<%--                                            </thead>--%>
<%--                                            <tbody class="requestsTable">--%>
<%--                                            <c:forEach var="item" items="${requestScope.userJoinRequests}">--%>
<%--                                                <c:if test="${item.id != requestScope.owner.id}">--%>
<%--                                                    <form method="post">--%>
<%--                                                        <tr class="requestsTr">--%>
<%--                                                            <input type="hidden" class="authorId" name="authorId" value="${requestScope.author.id}">--%>
<%--                                                            <input type="hidden" class="userId" name="userId" value="${item.id}">--%>
<%--                                                            <td><strong><c:out value="${item.userFirstName}"/></strong></td>--%>
<%--                                                            <td><strong><c:out value="${item.userLastName}"/></strong></td>--%>
<%--                                                            <td><c:out value="${item.userLastName}"/></td>--%>
<%--                                                            <td><c:out value="${item.graduateYear}"/></td>--%>
<%--                                                            <td><input type='submit' class="addUser" name="addSubmitBtn"  value="Add"></td>--%>
<%--                                                            <td><input type='submit' class="removeUser" name="removeSubmitBtn" value="Remove"></td>--%>
<%--                                                        </tr>--%>
<%--                                                    </form>--%>
<%--                                                </c:if>--%>
<%--                                            </c:forEach>--%>
<%--                                            </tbody>--%>
<%--                                        </table>--%>
<%--                                    </div>--%>
<%--                                </c:if>--%>
                            </div>
                        </div><!-- end shop-extra -->
                        <c:if test="${sessionScope.signedUser.id == 2}">
                            <div class="deleteAuthor">
                                <form method="post">
                                    <input type="hidden" class="authorId" name="authorId" value="${requestScope.author.id}">
                                    <input type="submit" class="authorDelete" value="Удалить Автора">
                                </form>
                            </div>
                        </c:if>
                    </div><!-- end col -->
                </div><!-- end row -->

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
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/custom.js"></script>

</body>
</html>
<script>
    //Script to delete news
    $(document).on('click', '.authorDelete', function(event) {
        event.preventDefault();
        let button = $(this);
        let authorId;
        $(this).siblings().each(function(){
            if($(this).hasClass("authorId")){
                authorId = $(this).val();
            }
        });
        $.ajax({
            url: "api/author/remove/" + authorId,
            type: "POST",
            success: function(message) {
                alert(message);
                window.location.href = "author?action=getAll";
            }
        });
    });
    //Script to delete news

    //Script to update author
    $(document).on('click', '.authorUpdate', function(event) {
        event.preventDefault();
        let button = $(this);
        let card = button.closest('.tab-pane');
        let authorId;
        let authorName = card.find('.updateName').val();
        let authorImgUrl = card.find('.updateImgUrl').val();
        let authorBiography = card.find('.updateBiography').val();
        $(this).siblings().each(function() {
            if ($(this).hasClass("authorId")) {
                authorId = $(this).val();
            }
        });
        let toSend = {
            id: authorId,
            authorName: authorName,
            authorBiography: authorBiography,
            authorImgUrl: authorImgUrl,
        }
        let jsonData = JSON.stringify(toSend);
        $.ajax({
            url: "api/author/update",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: jsonData,
            success: function(message) {
                alert(message);
                if (message === "Author was updated successfully!") {
                    $('.authorName').text(authorName);
                    $('.authorImg').attr('src', authorImgUrl);
                    card.find('.updateName').val(authorName);
                    card.find('.updateImgUrl').val(authorImgUrl);
                    card.find('.updateBiography').val(authorBiography);
                }
            }
        })
    });
    //Script to update author

    //Script to update author owner
    $(document).on('click', '.updateOwner', function(event) {
        event.preventDefault();
        let button = $(this);
        let card = button.closest('.shop-meta');
        let authorId;
        let authorOwnerEmail = card.find('.updateOwnerEmail').val();
        $(this).siblings().each(function() {
            if ($(this).hasClass("authorId")) {
                authorId = $(this).val();
            }
        });
        $.ajax({
            url: "api/author/update/owner/"+authorId+"/"+authorOwnerEmail,
            type: "POST",
            success: function(message) {
                alert(message);
                window.location.href = "author?action=getAuthor&authorId="+authorId;
            }
        });
    });
    //Script to update author

    //Script to join to Author
    $(document).on('click', '.joinBtn', function (event){
        event.preventDefault();
        let button = $(this);
        let authorId;
        let userId;
        $(this).siblings().each(function(){
            if($(this).hasClass("authorId")){
                authorId = $(this).val();
            }
            if($(this).hasClass("userId")){
                userId = $(this).val();
            }
        });
        $.ajax({
            url: "api/author/join/" + userId + "/" + authorId,
            type: "POST",
            success: function (message) {
                alert(message);
            }
        })
    });
    //Script to join to Author
    $(document).on('click', '.addUser', function (event){
        event.preventDefault();
        let button = $(this);
        let row = button.closest(".requestsTr");
        let authorId = row.find(".authorId").val();
        let userId = row.find(".userId").val();
        $.ajax({
            url: "api/author/member/add/"+authorId+"/"+userId,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            success: function(message) {
                alert(message);
                window.location.href = "author?action=getAuthor&authorId="+authorId;

            }
        })
    });

    $(document).on('click', '.removeUser', function (event){
        event.preventDefault();
        let button = $(this);
        let row = button.closest(".requestsTr");
        let authorId = row.find(".authorId").val();
        let userId = row.find(".userId").val();
        $.ajax({
            url: "api/author/joinRequest/remove/"+authorId+"/"+userId,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            success: function(message) {
                alert(message);
                window.location.href = "author?action=getAuthor&authorId="+authorId;
            }
        })
    });

    $(document).on('click', '.removeMember', function (event){
        event.preventDefault();
        let button = $(this);
        let row = button.closest(".memberRow");
        let authorId = row.find(".authorId").val();
        let memberId = row.find(".memberId").val();
        $.ajax({
            url: "api/author/member/remove/"+authorId+"/"+memberId,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            success: function(message) {
                alert(message);
                window.location.href = "author?action=getAuthor&authorId="+authorId;
            }
        })
    });
</script>

