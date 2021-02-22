<%--
  Created by IntelliJ IDEA.
  User: nurym
  Date: 11/11/20
  Time: 21:32
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
    <title>News Page</title>
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

    <section class="section db p120">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="tagline-message page-title text-center">
                        <h3>News</h3>
                        <ul class="breadcrumb">
                            <li><a href="javascript:void(0)">Judle</a></li>
                            <li class="active">News</li>
                        </ul>
                    </div>
                </div><!-- end col -->
            </div><!-- end row -->
        </div><!-- end container -->
    </section><!-- end section -->

    <section class="section gb nopadtop">
        <div class="container">
            <c:if test="${sessionScope.signedUser.userRole == 2}">
                <div class="mx-auto">
                    <h2>Add New News</h2>
                    <form method="post" class="newsInsert">
                        <p>News Title: <input type="text" name="newTitle" class="newTitle"></p>
                        <p>News Description<br><textarea name="newDescription" cols="45" rows="5" class="newDescription"></textarea></p>
                        <p>News Image URL <input type="text" name="newUrl" class="newUrl"></p>
                        <input type="submit" name="addNews" class="addNews" value="Add news">
                    </form>
                </div>
            </c:if>

            <br><br><br><br>

            <div class="boxed">
                <div class="row">
                    <div class="col-md-8">
                        <%--      News loop     --%>
                        <div class="content blog-list">
                            <c:forEach items="${requestScope.newsQueue}" var="news">
                                <div class="blog-wrapper clearfix">
                                    <div class="blog-meta">
                                        <h3><a class="newsTitle" title=""><c:out value="${news.newsTitle}"/></a></h3>
                                    </div>

                                    <div class="blog-media">
                                        <a title=""><img src="${news.newsImgUrl}" style="width: 1000px;" alt="" class="img-responsive img-rounded newsImg"></a>
                                    </div>

                                    <c:if test="${sessionScope.signedUser.userRole == 2}">
                                        <div class="blog-desc-big">
                                            News title: <input class="updateTitle" type="text" value="${news.newsTitle}"><br>
                                            News Image URl: <input class="updateImgUrl"  type="text" value="${news.newsImgUrl}"><br>
                                            News Description: <br><textarea class="updateDescription" cols="50" rows="5"><c:out value="${news.newsDescription}"/></textarea>
                                            <form method="post">
                                                <input type="submit" class="btn btn-primary newsDelete" name="newsDelete" value="Delete">
                                                <input type="submit" class="btn btn-primary newsUpdate" name="newsUpdate" value="Update">
                                                <input type="hidden" class="newsId" name="newsId" value="${news.id}">
                                            </form>
                                        </div>
                                    </c:if>

                                    <c:if test="${sessionScope.signedUser.userRole != 2}">
                                        <div class="blog-desc-big">
                                            <p>${news.newsDescription}</p>
                                        </div>
                                    </c:if>
                                </div>
                            </c:forEach>
                        </div><!-- end content -->
                    </div><!-- end col -->

                    <div class="sidebar col-md-4">
                        <div class="widget clearfix">
                            <div class="banner-widget">
                                <img src="https://english-skype.net/wp-content/uploads/2019/07/systemic-evaluation.jpg" alt="" class="img-responsive img-rounded">
                            </div>
                        </div>

                        <div class="widget clearfix">
                            <h3 class="widget-title">Popular Posts</h3>
                            <div class="post-widget">
                                <div class="media">
                                    <img src="https://lh3.googleusercontent.com/r8UdDsbZQEL0yXIiKJjHJh3bBB4N20KOH6bIdmOXE0VWJFbbyKOckdX1qSpdQWkWYKA=w80" alt="" class="img-responsive alignleft img-rounded">
                                    <div class="media-body">
                                        <h5 class="mt-0"><a href="">Learning English Like a Pro..</a></h5>
                                        <div class="blog-meta">
                                            <ul class="list-inline">
                                                <li>4 days ago</li>
                                                <li><span>by</span> <a href="#">Edulogy Team</a></li>
                                            </ul>
                                        </div><!-- end blog-meta -->
                                    </div>
                                </div>

                                <div class="media">
                                    <img src="https://img.icons8.com/ultraviolet/2x/knowledge-sharing.png" alt="" class="img-responsive alignleft img-rounded">
                                    <div class="media-body">
                                        <h5 class="mt-0"><a href="">How to create a beautiful website with Bootstrap</a></h5>
                                        <div class="blog-meta">
                                            <ul class="list-inline">
                                                <li>5 days ago</li>
                                                <li><span>by</span> <a href="#">Boby DOE</a></li>
                                            </ul>
                                        </div><!-- end blog-meta -->
                                    </div>
                                </div>

                                <div class="media">
                                    <img src="https://www.alpaytirasoglu.com/wp-content/uploads/2018/04/bilim-80x80.png" alt="" class="img-responsive alignleft img-rounded">
                                    <div class="media-body">
                                        <h5 class="mt-0"><a href="blog-single.html">Don't forget to update your Google web master tools</a></h5>
                                        <div class="blog-meta">
                                            <ul class="list-inline">
                                                <li>6 days ago</li>
                                                <li><span>by</span> <a href="#">Martin</a></li>
                                            </ul>
                                        </div><!-- end blog-meta -->
                                    </div>
                                </div>
                            </div><!-- end post-widget -->
                        </div><!-- end widget -->

                        <div class="widget clearfix">
                            <h3 class="widget-title">Subscribe Our Newsletter</h3>
                            <div class="newsletter-widget">
                                <p>You can opt out of our newsletters at any time. See our <a href="#">privacy policy</a>.</p>
                                <form class="form-inline" role="search">
                                    <div class="form-1">
                                        <input type="text" class="form-control" placeholder="Enter email here..">
                                        <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane-o"></i></button>
                                    </div>
                                </form>
                            </div><!-- end newsletter -->
                        </div><!-- end widget -->

                        <div class="widget clearfix">
                            <h3 class="widget-title">Popular Tags</h3>
                            <div class="tags-widget">
                                <ul class="list-inline">
                                    <li><a href="#">course</a></li>
                                    <li><a href="#">web design</a></li>
                                    <li><a href="#">development</a></li>
                                    <li><a href="#">language</a></li>
                                    <li><a href="#">teacher</a></li>
                                    <li><a href="#">speaking</a></li>
                                    <li><a href="#">material</a></li>
                                    <li><a href="#">css3</a></li>
                                    <li><a href="#">html</a></li>
                                    <li><a href="#">learning</a></li>
                                </ul>
                            </div><!-- end list-widget -->
                        </div><!-- end widget -->
                    </div><!-- end sidebar -->
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
        $('.addNews').click(function(event) {
            event.preventDefault();
            let button = $(this);
            let form = button.closest('.newsInsert');
            let newsTitle = form.find('.newTitle').val();
            let newsDescription = form.find('.newDescription').val();
            let newsUrl = form.find('.newUrl').val();
            let toSend = {
                newsTitle: newsTitle,
                newsDescription: newsDescription,
                newsImgUrl: newsUrl
            };
            let sendJson = JSON.stringify(toSend);
            $.ajax({
                url: "api/news/insert",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: sendJson,
                success: function(message) {
                    alert(message);
                    if(message === "News was inserted successfully!") {
                        $.ajax({
                            url: "api/news/all",
                            type: "GET",
                            success: function (responseJson) {
                                let lastNews = responseJson.queue[responseJson.queue.length-1];
                                // let news = form.closest('.blog-list');
                                $('.blog-list').append(
                                    `<div class="blog-wrapper clearfix">
                                        <div class="blog-meta">
                                            <h3><a class="newsTitle" title="">` + newsTitle + `</a></h3>
                                        </div>

                                        <div class="blog-media">
                                            <a title=""><img src="` + newsUrl + `" style="width: 1000px;" alt="" class="img-responsive img-rounded newsImg"></a>
                                        </div>

                                        <c:if test="${sessionScope.signedUser.userRole == 2}">
                                            <div class="blog-desc-big">
                                                News title: <input class="updateTitle" type="text" value="` + newsTitle + `"><br>
                                                News Image URl: <input class="updateImgUrl"  type="text" value="` + newsUrl + `"><br>
                                                News Description: <br><textarea class="updateDescription" cols="50" rows="5">` + newsDescription + `</textarea>
                                                <form method="post">
                                                    <input type="submit" class="btn btn-primary newsDelete" name="newsDelete" value="Delete">
                                                    <input type="submit" class="btn btn-primary newsUpdate" name="newsUpdate" value="Update">
                                                    <input type="hidden" class="newsId" name="newsId" value="` + lastNews.id + `">
                                                </form>
                                            </div>
                                        </c:if>

                                        <c:if test="${sessionScope.signedUser.userRole != 2}">
                                            <div class="blog-desc-big">
                                                <p>` + newsDescription + `</p>
                                            </div>
                                        </c:if>
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
        $(document).on('click', '.newsDelete', function(event) {
            event.preventDefault();
            let button = $(this);
            let newsId;
            $(this).siblings().each(function(){
                if($(this).hasClass("newsId")){
                    newsId = $(this).val();
                }
            });
            $.ajax({
                url: "api/news/remove/" + newsId,
                type: "POST",
                success: function(message) {
                    alert(message);
                    if(message === "News was removed successfully!") {
                        button.closest('.blog-wrapper').remove();
                    }
                }
            });
        });
        //Script to delete news

        //Script to update news
        $(document).on('click', '.newsUpdate', function(event) {
            event.preventDefault();
            let button = $(this);
            let card = button.closest('.blog-wrapper');
            let newsId;
            let newsTitle = card.find('.updateTitle').val();
            let newsImgUrl = card.find('.updateImgUrl').val();
            let newsDescription = card.find('.updateDescription').val();
            $(this).siblings().each(function() {
                if ($(this).hasClass("newsId")) {
                    newsId = $(this).val();
                }
            });
            let toSend = {
                id: newsId,
                newsTitle: newsTitle,
                newsDescription: newsDescription,
                newsImgUrl: newsImgUrl
            }
            let jsonData = JSON.stringify(toSend);
            $.ajax({
                url: "api/news/update",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                data: jsonData,
                success: function(message) {
                    alert(message);
                    if (message === "News was updated successfully!") {
                        card.find('.newsTitle').text(newsTitle);
                        card.find('.newsImg').attr('src', newsImgUrl);
                        card.find('.updateTitle').val(newsTitle);
                        card.find('.updateImgUrl').val(newsImgUrl);
                        card.find('.updateDescription').val(newsDescription);
                    }
                }
            })
        });
        //Script to update news
    });
</script>

