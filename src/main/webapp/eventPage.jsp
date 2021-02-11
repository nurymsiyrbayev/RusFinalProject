<%--
  Created by IntelliJ IDEA.
  User: nurym
  Date: 11/11/20
  Time: 21:02
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
    <title>Event Page</title>
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
                        <h3>Event</h3>
                        <ul class="breadcrumb">
                            <li><a href="javascript:void(0)">Judle</a></li>
                            <li class="active">Event</li>
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
                        <h2>Add New Event</h2>
                        <form method="post" class="eventInsert">
                            <p>Event Name: <input class="newTitle" type="text"></p>
                            <p>Event Description: <br><textarea class="newDescription" cols="100" rows="10"></textarea></p>
                            <p>Event Image URL: <input class="newUrl" type="text"></p>
                            <p>Club:
                                <select class="clubId">
                                    <c:forEach items="${requestScope.clubs}" var="club">
                                        <option value="${club.id}"><c:out value="${club.clubName}"/></option>
                                    </c:forEach>
                                </select>
                            </p>
                            <input type="submit" name="addEvent" class="addEvent" value="Add Event">
                        </form>
                    </div>
                </c:if>

                <br><br><br><br>

                <div class="row blog-grid">
<%--    Loop for Event Here     --%>
                    <c:forEach var="event" items="${requestScope.events}">
                        <div class="col-md-12">
                            <div class="course-box">
                                <div class="image-wrap entry">
                                    <img src="${event.eventImgUrl}" alt="" class="img-responsive eventImg">
                                </div>
                                <c:if test="${sessionScope.signedUser.userRole == 2}">
                                    <div class="course-details">
                                        <h4>
                                            Event Title: <input class="updateTitle" value="${event.eventTitle}"><br>
                                            Event Image URL: <input class="updateImgUrl" value="${event.eventImgUrl}"><br>
                                            Event Description: <br><textarea rows="5" cols="50" class="updateDescription"><c:out value="${event.eventDescription}"/></textarea>
                                            <form method="post">
                                                <input type="submit" class="btn btn-primary eventDelete" name="eventDelete" value="Delete">
                                                <input type="submit" class="btn btn-primary eventUpdate" name="eventUpdate" value="Update">
                                                <input type="hidden" class="eventId" name="eventId" value="${event.id}">
                                            </form>
                                        </h4>
                                    </div>
                                </c:if>
                                <c:if test="${sessionScope.signedUser.userRole != 2}">
                                <div class="course-details">
                                    <h4>
                                        <small>event</small>
                                        <h3 class="eventTitle"><c:out value="${event.eventTitle}"/></h3>
                                    </h4>
                                    <p class="eventDescription"><c:out value="${event.eventDescription}"/></p>
                                </div>
                                </c:if>
                            </div>
                        </div>
                    </c:forEach>
                </div><!-- end row -->
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

</body>
</html>
<script>
    $(document).ready(function() {
        //Script to add new news
        $('.addEvent').click(function(event) {
            event.preventDefault();
            let button = $(this);
            let form = button.closest('.eventInsert');
            let eventTitle = form.find('.newTitle').val();
            let eventDescription = form.find('.newDescription').val();
            let eventUrl = form.find('.newUrl').val();
            let clubId = form.find('.clubId').val();
            let toSend = {
                eventTitle: eventTitle,
                eventDescription: eventDescription,
                eventImgUrl: eventUrl,
                clubId: clubId
            };
            let sendJson = JSON.stringify(toSend);
            $.ajax({
                url: "api/event/insert",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: sendJson,
                success: function(message) {
                    if(message === "Event was inserted successfully!") {
                        $.ajax({
                            url: "api/event/all",
                            type: "GET",
                            success: function (responseJson) {
                                alert(message);
                                let lastEvent = responseJson.stack[responseJson.stack.length-1];
                                $('.blog-grid').append(
                                    `<div class="col-md-12">
                                        <div class="course-box">
                                            <div class="image-wrap entry">
                                                <img src="` + eventUrl + `" alt="" class="img-responsive eventImg">
                                            </div>
                                            <c:if test="${sessionScope.signedUser.userRole == 2}">
                                                <div class="course-details">
                                                    <h4>
                                                        Event Title: <input class="updateTitle" value="` + eventTitle + `"><br>
                                                        Event Image URL: <input class="updateImgUrl" value="` + eventUrl + `"><br>
                                                        Event Description: <br><textarea rows="5" cols="50" class="updateDescription">` + eventDescription + `</textarea>
                                                        <form method="post">
                                                            <input type="submit" class="btn btn-primary eventDelete" name="eventDelete" value="Delete">
                                                            <input type="submit" class="btn btn-primary eventUpdate" name="eventUpdate" value="Update">
                                                            <input type="hidden" class="eventId" name="eventId" value="` + lastEvent.id + `">
                                                        </form>
                                                    </h4>
                                                </div>
                                            </c:if>
                                            <c:if test="${sessionScope.signedUser.userRole != 2}">
                                                <div class="course-details">
                                                    <h4>
                                                        <small>event</small>
                                                        <h3 class="eventTitle">` + eventTitle + `</h3>
                                                    </h4>
                                                    <p class="eventDescription">` + eventDescription + `</p>
                                                </div>
                                            </c:if>
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

        //Script to delete news
        $(document).on('click', '.eventDelete', function(event) {
            event.preventDefault();
            let button = $(this);
            let eventId;
            $(this).siblings().each(function(){
                if($(this).hasClass("eventId")){
                    eventId = $(this).val();
                }
            });
            $.ajax({
                url: "api/event/remove/" + eventId,
                type: "POST",
                success: function(message) {
                    alert(message);
                    if(message === "Event was removed successfully!") {
                        button.closest('.col-md-12').remove();
                    }
                }
            });
        });
        //Script to delete news

        //Script to update news
        $(document).on('click', '.eventUpdate', function(event) {
            event.preventDefault();
            let button = $(this);
            let card = button.closest('.col-md-12');
            let eventId;
            let eventTitle = card.find('.updateTitle').val();
            let eventImgUrl = card.find('.updateImgUrl').val();
            let eventDescription = card.find('.updateDescription').val();
            $(this).siblings().each(function() {
                if ($(this).hasClass("eventId")) {
                    eventId = $(this).val();
                }
            });
            let toSend = {
                id: eventId,
                eventTitle: eventTitle,
                eventDescription: eventDescription,
                eventImgUrl: eventImgUrl
            }
            let jsonData = JSON.stringify(toSend);
            $.ajax({
                url: "api/event/update",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: jsonData,
                success: function(message) {
                    if (message === "Event was updated successfully!") {
                        alert(message);
                        card.find('.eventTitle').text(eventTitle);
                        card.find('.eventImg').attr('src', eventImgUrl);
                        card.find('.updateTitle').val(eventTitle);
                        card.find('.updateImgUrl').val(eventImgUrl);
                        card.find('.updateDescription').val(eventDescription);
                    }
                }
            })
        });
        //Script to update news
    });
</script>

