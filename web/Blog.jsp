<%-- 
    Document   : Blog
    Created on : Oct 17, 2022, 7:39:51 AM
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

            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-section set-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="breadcrumb__text">
                                <h2>Blog</h2>
                                <div class="breadcrumb__option">
                                    <a href="list">Home</a>
                                    <span>Blog</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Blog Section Begin -->
            <section class="blog spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-4 col-md-5">
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
                                <h4>Recent News</h4>
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
                    <div class="col-lg-8 col-md-7">
                        <div class="row">
                            <c:forEach items="${listblogbycate}" var="o">
                                <div class="col-lg-6 col-md-6 col-sm-6">
                                    <div class="blog__item">
                                        <div class="blog__item__pic">
                                            <img src="${o.bimage}" alt="">
                                        </div>
                                        <div class="blog__item__text">
                                            <ul>
                                                <li><strong class="fa fa-calendar-o"></strong>${o.date}</li>
                                            </ul>
                                            <h5><a href="blog?bid=${o.bid}">${o.bname}</a></h5>
                                            <a href="blog?bid=${o.bid}" class="blog__btn">READ MORE <span class="arrow_right"></span></a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Blog Section End -->

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