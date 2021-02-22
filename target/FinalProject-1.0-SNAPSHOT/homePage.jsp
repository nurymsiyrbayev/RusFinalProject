<%--
  Created by IntelliJ IDEA.
  User: nurym
  Date: 11/11/20
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<!--[if IE 9]> <html class="no-js ie9 fixed-layout" pageEncoding="UTF-8" lang="en"> <![endif]-->
<!--[if gt IE 9]><!--> <html class="no-js " lang="en"><!--<![endif]-->
<html lang="ru">
<head>

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <!-- Site Meta -->
    <title>Гоавная страница</title>
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
<%--<div id="preloader">--%>
<%--    <img class="preloader" src="../images/loader.gif" alt="">--%>
<%--</div><!-- end loader -->--%>
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

    <section id="home" class="video-section js-height-full">
        <div class="overlay"></div>
        <div class="home-text-wrapper relative container">
            <div class="home-message">
                <p>Система обучения </p>
                <small>Judle - идеальный выбор для вашей организации, вашего бизнеса и вашей системы онлайн-образования. Создайте онлайн-курс с неограниченным количеством шаблонов страниц, вариантов цвета и функций меню. </small>
                <div class="btn-wrapper">
                    <div class="text-center">
                        <a href="#" class="btn btn-primary wow slideInLeft">Читать далее</a> &nbsp;&nbsp;&nbsp;<a href="#" class="btn btn-default wow slideInRight">Купить</a>
                    </div>
                </div><!-- end row -->
            </div>
        </div>
        <div class="slider-bottom">
            <span>Explore <i class="fa fa-angle-down"></i></span>
        </div>
    </section>

    <section class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-4 hidden-sm hidden-xs">
                    <div class="custom-module">
                        <img src="https://sun9-47.userapi.com/tNvKRkFlWL0Sy1erxr73XXZX0a0N-5qY7RN6_Q/fSBkyJE5-1o.jpg" alt="" class="img-responsive wow slideInLeft">
                    </div><!-- end module -->
                </div><!-- end col -->
                <div class="col-md-8">
                    <div class="custom-module p40l">
                        <h2>We are a passionate <mark>learning system</mark> from<br>
                            London. Do beautiful and easy-to-use digital <br>
                            design & web development</h2>

                        <p>Nam dictum sem, ipsum aliquam . Etiam sit amet fringilla lacus. Pellentesque suscipit ante at ullamcorper pulvinar neque porttitor. Integer lectus. Praesent sed nisi eleifend, fermentum orci amet, iaculis libero.</p>

                        <hr class="invis">

                        <div class="row">
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 first">
                                <ul class="check">
                                    <li>Custom Shortcodes</li>
                                    <li>Visual Page Builder</li>
                                    <li>Unlimited Shortcodes</li>
                                    <li>Responsive Theme</li>
                                    <li>Tons of Layouts</li>
                                </ul><!-- end check -->
                            </div><!-- end col-lg-4 -->
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                                <ul class="check">
                                    <li>Font Awesome Icons</li>
                                    <li>Pre-Defined Colors</li>
                                    <li>AJAX Transitions</li>
                                    <li>High Quality Support</li>
                                    <li>Unlimited Options</li>
                                </ul><!-- end check -->
                            </div><!-- end col-lg-4 -->
                            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 last">
                                <ul class="check">
                                    <li>Shopping Layouts</li>
                                    <li>Pre-Defined Fonts</li>
                                    <li>Style Changers</li>
                                    <li>Footer Styles</li>
                                    <li>Header Styles</li>
                                </ul><!-- end check -->
                            </div><!-- end col-lg-4 -->
                        </div><!-- end row -->

                        <hr class="invis">

                        <div class="btn-wrapper">
                            <a href="#" class="btn btn-primary">Learn More About us</a>
                        </div>

                    </div><!-- end module -->
                </div><!-- end col -->
            </div><!-- end row -->
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
<script src="js/carousel.js"></script>
<script src="js/animate.js"></script>
<script src="js/custom.js"></script>
<!-- VIDEO BG PLUGINS -->
<script src="js/videobg.js"></script>

</body>
</html>

