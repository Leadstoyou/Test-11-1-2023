<%-- 
    Document   : BlogDetails
    Created on : Oct 17, 2022, 7:36:26 AM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Genshin Food</title>

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>

    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <jsp:include page="Header2.jsp"></jsp:include>



            <!-- Blog Details Hero Begin -->
            <section class="blog-details-hero set-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="blog__details__hero__text">
                                <h2>${blogtop.bname}</h2>
                            <ul>
                                <li>${blogtop.author}</li>
                                <li>${blogtop.date}</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Blog Details Hero End -->

        <!-- Blog Details Section Begin -->
        <section class="blog-details spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-5 order-md-1 order-2">
                        <div class="blog__sidebar">
                            <div class="blog__sidebar__search">
                                <form action="#">
                                    <input type="text" placeholder="Search...">
                                    <button type="submit"><span class="icon_search"></span></button>
                                </form>
                            </div>
                            <div class="blog__sidebar__item">
                                <h4>Categories</h4>
                                <ul>
                                    <li><a href="allblog2">All</a></li>
                                        <c:forEach items="${blog3}" var="o">
                                        <li><a href="allblog?bid=${o.id}">${o.name}(${o.countBlog})</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                            <div class="blog__sidebar__item">
                                <h4>Newest News</h4>
                                <div class="blog__sidebar__recent">
                                    <c:forEach items="${blogtop3}" var="o">
                                        <a href="blog?bid=${o.bid}" class="blog__sidebar__recent__item">
                                            <div class="blog__sidebar__recent__item__pic">
                                                <img src="${o.bimage}" alt="">
                                            </div>
                                            <div class="blog__sidebar__recent__item__text">
                                                <h6>${o.bname}</h6>
                                                <span>${o.date}</span>
                                            </div>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-8 col-md-7 order-md-1 order-1">
                        <div class="blog__details__text">
                            <img src="${blogtop.bimage}" alt="">
                            <p>${blogtop.bdetail}</p>
                        </div>
                        <div class="blog__details__content">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="blog__details__author">
                                        <div class="blog__details__author__pic">
                                            <img src="Image/logo_blog.png" alt="">
                                        </div>
                                        <div class="blog__details__author__text">
                                            <h6>${blogtop.author}</h6>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="blog__details__widget">
                                        <ul>
                                            <li><span>Categories:</span> ${blogtop.bcate}</li>
                                        </ul>
                                        <div class="blog__details__social">
                                            <a href="https://www.facebook.com/vaycanh.thien/"><strong class="fa fa-facebook"></strong></a>
                                            <a href="https://www.facebook.com/vaycanh.thien/"><strong class="fa fa-twitter"></strong></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Blog Details Section End -->

        <!-- Related Blog Section Begin -->
        <section class="related-blog spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title related-blog-title">
                            <h2>Post You May Like</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${blogrelated3}" var="o" begin="0" end="3">
                        <div class="col-lg-4 col-md-4 col-sm-6">
                            <div class="blog__item">
                                <div class="blog__item__pic">
                                    <img src="${o.bimage}" alt="">
                                </div>
                                <div class="blog__item__text">
                                    <ul>
                                        <li><em class="fa fa-calendar-o"></em>${o.date}</li>
                                    </ul>
                                    <h5><a href="blog?bid=${o.bid}">${o.bname}</a></h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Related Blog Section End -->

        <jsp:include page="Footer.jsp"></jsp:include>


        <!-- Js Plugins -->
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>



    </body>

</html>