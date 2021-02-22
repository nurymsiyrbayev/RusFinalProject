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
<head>

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Site Meta -->
    <title>Single Club Page</title>
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

    <section class="section cb">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="tagline-message page-title">
                        <h3>Single Club</h3>
                    </div>
                </div><!-- end col -->
                <div class="col-md-6 text-right">
                    <ul class="breadcrumb">
                        <li><a href="homePage.jsp">Judle</a></li>
                        <li class="active">Single Club</li>
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
                                    <img src="<c:out value="${requestScope.club.clubImgUrl}"/>" alt="" class="img-responsive clubImg">
                                </div><!-- end image-wrap -->
                            </div>
                        </div><!-- end row -->

                        <hr class="invis">

                    </div><!-- end col -->

                    <div class="col-md-6">
                        <div class="shop-desc">
                            <h3 class="clubName"><c:out value="${requestScope.club.clubName}"/></h3>
                            <small>Club</small>
                            <br>
                            <div>
                                <form method="post">
                                    <input type="hidden" class="clubId" name="clubId" value="${requestScope.club.id}">
                                    <input type="hidden" class="userId"  value="${sessionScope.signedUser.id}">
                                    <input class="joinBtn" type="submit" value="Join">
                                </form>
                                <br><br>
                                <ul class="list-inline">
                                    <li> Astana IT University</li>
                                    <li>Categories: <a href="#">Club</a>
                                </ul>
                            </div>
                            <c:if test="${sessionScope.signedUser.id == requestScope.owner.id}">
                                <div class="shop-meta">
                                    <form method="post">
                                        <input type="hidden" class="clubId" name="clubId" value="${requestScope.club.id}">
                                        <h1>Give owner status</h1>
                                        <input type="text" class="updateOwnerEmail" name="clubOwner" placeholder="Enter email">
                                        <br> <br>
                                        <input class="updateOwner" name="updateOwner" type="submit" value="Give">
                                        <br> <br>
                                    </form>
                                </div>
                            </c:if>
                            <!-- end shop meta -->
                        </div><!-- end desc -->
                    </div><!-- end col -->
                </div><!-- end row -->

                <hr class="invis">

                <div class="row">
                    <div class="col-md-12">
                        <div class="shop-extra">
                            <ul class="nav nav-tabs">
                                <li class="active"><a data-toggle="tab" href="#description">Description</a></li>
                                <li><a data-toggle="tab" href="#members">Member(s)</a></li>
                                <li><a data-toggle="tab" href="#menu2">Reviews</a></li>
                                <c:if test="${sessionScope.signedUser.id == requestScope.owner.id}">
                                    <li><a data-toggle="tab" href="#requestToJoin">Request(s)</a></li>
                                </c:if>
                            </ul>

                            <div class="tab-content">
                                <div id="description" class="tab-pane fade in active">
                                    <c:if test="${sessionScope.signedUser.id == requestScope.owner.id}">
                                        <form method="post">
                                            <input type="hidden" class="clubId" name="clubId" value="${requestScope.club.id}">
                                            <input type="hidden" class="ownerId" value="${requestScope.club.clubOwnerId}">
                                            Name:
                                            <br>
                                            <input type="text" class="updateName" name="clubName" value="<c:out value="${requestScope.club.clubName}"/>">
                                            <br>
                                            Img Url:
                                            <br>
                                            <textarea class="updateImgUrl" name="updateImgUrl" cols="20" rows="5"><c:out value="${requestScope.club.clubImgUrl}"/></textarea>
                                            <br>
                                            Description:
                                            <br>
                                            <textarea class="updateDescription" name="clubDescription" id="" cols="60" rows="10"><c:out value="${requestScope.club.clubDescription}"/></textarea>
                                            <br>
                                            <input class="clubUpdate" type="submit" value="Update">
                                        </form>
                                    </c:if>
                                    <c:if test="${sessionScope.signedUser.id != requestScope.owner.id}">
                                        <p><c:out value="${requestScope.club.clubDescription}"/></p>
                                    </c:if>
                                </div>
                                <div id="members" class="tab-pane fade">
                                    <h3>Member(s) information</h3>
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <td><strong>First Name</strong></td>
                                            <td><strong>Last Name</strong></td>
                                            <td>Email</td>
                                            <td>Graduate Year</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td><strong><c:out value="${requestScope.owner.userFirstName}"/> </strong></td>
                                            <td><strong><c:out value="${requestScope.owner.userLastName}"/></strong></td>
                                            <td><c:out value="${requestScope.owner.userEmail}"/></td>
                                            <td><c:out value="${requestScope.owner.graduateYear}"/></td>
                                            <td>owner of this club</td>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="member" items="${requestScope.members}">
                                            <c:if test="${member.id != requestScope.owner.id}">
                                                <form method="post">
                                                    <tr class="memberRow">
                                                        <input type="hidden" class="memberId" name="userId" value="${member.id}">
                                                        <input type="hidden" class="clubId" name="clubId" value="${requestScope.club.id}">
                                                        <td><strong><c:out value="${member.userFirstName}"/></strong></td>
                                                        <td><strong><c:out value="${member.userLastName}"/></strong></td>
                                                        <td><c:out value="${member.userLastName}"/></td>
                                                        <td><c:out value="${member.graduateYear}"/></td>
                                                        <c:if test="${sessionScope.signedUser.id == requestScope.owner.id}">
                                                            <td><input type="submit" class="removeMember" value="Remove"></td>
                                                        </c:if>
                                                    </tr>
                                                </form>
                                            </c:if>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div id="menu2" class="tab-pane fade">
                                    <h3>Reviews</h3>

                                    <p>Your email address will not be published. Required fields are marked *</p>

                                    <div class="rating">
                                        <p>Your Rating</p>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                        <i class="fa fa-star"></i>
                                    </div>

                                    <hr class="invis">

                                    <form class="big-contact-form row" role="search">
                                        <div class="col-md-12">
                                            <textarea class="form-control" placeholder="Your reviews.."></textarea>
                                        </div>
                                        <div class="col-md-6">
                                            <input type="text" class="form-control" placeholder="Enter your name..">
                                        </div>
                                        <div class="col-md-6">
                                            <input type="email" class="form-control" placeholder="Enter email..">
                                        </div>
                                        <div class="col-md-12">
                                            <button type="submit" class="btn btn-primary">Submit</button>
                                        </div>
                                    </form>
                                </div>
                                <c:if test="${sessionScope.signedUser.id == requestScope.owner.id}">
                                    <div id="requestToJoin" class="tab-pane fade">
                                        <h3>Request(s)</h3>
                                        <table class="table">
                                            <thead>
                                            <tr>
                                                <td><strong>First Name</strong></td>
                                                <td><strong>Last Name</strong></td>
                                                <td>Email</td>
                                                <td>Graduate Year</td>
                                                <td>———</td>
                                                <td>———</td>
                                            </tr>
                                            </thead>
                                            <tbody class="requestsTable">
                                            <c:forEach var="item" items="${requestScope.userJoinRequests}">
                                                <c:if test="${item.id != requestScope.owner.id}">
                                                    <form method="post">
                                                        <tr class="requestsTr">
                                                            <input type="hidden" class="clubId" name="clubId" value="${requestScope.club.id}">
                                                            <input type="hidden" class="userId" name="userId" value="${item.id}">
                                                            <td><strong><c:out value="${item.userFirstName}"/></strong></td>
                                                            <td><strong><c:out value="${item.userLastName}"/></strong></td>
                                                            <td><c:out value="${item.userLastName}"/></td>
                                                            <td><c:out value="${item.graduateYear}"/></td>
                                                            <td><input type='submit' class="addUser" name="addSubmitBtn"  value="Add"></td>
                                                            <td><input type='submit' class="removeUser" name="removeSubmitBtn" value="Remove"></td>
                                                        </tr>
                                                    </form>
                                                </c:if>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </c:if>
                            </div>
                        </div><!-- end shop-extra -->
                        <c:if test="${sessionScope.signedUser.id == requestScope.owner.id}">
                            <div class="deleteClub">
                                <form method="post">
                                    <input type="hidden" class="clubId" name="clubId" value="${requestScope.club.id}">
                                    <input type="submit" class="clubDelete" value="Delete Club">
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
    $(document).on('click', '.clubDelete', function(event) {
        event.preventDefault();
        let button = $(this);
        let clubId;
        $(this).siblings().each(function(){
            if($(this).hasClass("clubId")){
                clubId = $(this).val();
            }
        });
        $.ajax({
            url: "api/club/remove/" + clubId,
            type: "POST",
            success: function() {
                window.location.href = "club?action=getAll";
            }
        });
    });
    //Script to delete news

    //Script to update club
    $(document).on('click', '.clubUpdate', function(event) {
        event.preventDefault();
        let button = $(this);
        let card = button.closest('.tab-pane');
        let clubId;
        let ownerId;
        let clubName = card.find('.updateName').val();
        let clubImgUrl = card.find('.updateImgUrl').val();
        let clubDescription = card.find('.updateDescription').val();
        $(this).siblings().each(function() {
            if ($(this).hasClass("clubId")) {
                clubId = $(this).val();
            }
            if ($(this).hasClass("ownerId")) {
                ownerId = $(this).val();
            }
        });
        let toSend = {
            id: clubId,
            clubName: clubName,
            clubDescription: clubDescription,
            clubImgUrl: clubImgUrl,
            clubOwnerId: ownerId,
        }
        let jsonData = JSON.stringify(toSend);
        $.ajax({
            url: "api/club/update",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            data: jsonData,
            success: function(message) {
                alert(message);
                if (message === "Club was updated successfully!") {
                    $('.clubName').text(clubName);
                    $('.clubImg').attr('src', clubImgUrl);
                    card.find('.updateName').val(clubName);
                    card.find('.updateImgUrl').val(clubImgUrl);
                    card.find('.updateDescription').val(clubDescription);
                }
            }
        })
    });
    //Script to update club

    //Script to update club owner
    $(document).on('click', '.updateOwner', function(event) {
        event.preventDefault();
        let button = $(this);
        let card = button.closest('.shop-meta');
        let clubId;
        let clubOwnerEmail = card.find('.updateOwnerEmail').val();
        $(this).siblings().each(function() {
            if ($(this).hasClass("clubId")) {
                clubId = $(this).val();
            }
        });
        $.ajax({
            url: "api/club/update/owner/"+clubId+"/"+clubOwnerEmail,
            type: "POST",
            success: function(message) {
                alert(message);
                window.location.href = "club?action=getClub&clubId="+clubId;
            }
        });
    });
    //Script to update club

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

    $(document).on('click', '.addUser', function (event){
        event.preventDefault();
        let button = $(this);
        let row = button.closest(".requestsTr");
        let clubId = row.find(".clubId").val();
        let userId = row.find(".userId").val();
        $.ajax({
            url: "api/club/member/add/"+clubId+"/"+userId,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            success: function(message) {
                alert(message);
                window.location.href = "club?action=getClub&clubId="+clubId;

            }
        })
    });

    $(document).on('click', '.removeUser', function (event){
        event.preventDefault();
        let button = $(this);
        let row = button.closest(".requestsTr");
        let clubId = row.find(".clubId").val();
        let userId = row.find(".userId").val();
        $.ajax({
            url: "api/club/joinRequest/remove/"+clubId+"/"+userId,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            success: function(message) {
                alert(message);
                window.location.href = "club?action=getClub&clubId="+clubId;
            }
        })
    });

    $(document).on('click', '.removeMember', function (event){
        event.preventDefault();
        let button = $(this);
        let row = button.closest(".memberRow");
        let clubId = row.find(".clubId").val();
        let memberId = row.find(".memberId").val();
        $.ajax({
            url: "api/club/member/remove/"+clubId+"/"+memberId,
            type: "POST",
            contentType: "application/json; charset=utf-8",
            success: function(message) {
                alert(message);
                window.location.href = "club?action=getClub&clubId="+clubId;
            }
        })
    });
</script>

