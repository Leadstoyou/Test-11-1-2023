
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.*" %>
<%@page import = "model.*" %>
<%@page import="java.sql.*" %>
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
                                <h2>Genshin Food</h2>
                                <div class="breadcrumb__option">
                                    <a href="list">Home</a>
                                    <span>Shop</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Product Section Begin -->
            <section class="product spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3 col-md-5">
                            <div class="sidebar">
                                <div class="sidebar__item">
                                    <h4>Department</h4>
                                    <ul>
                                    <c:forEach items="${lst}" var="o">
                                        <li><a href="ShopGrid?cid=${o.cid}">${o.cname}</a></li>
                                        </c:forEach>
                                </ul>
                            </div>
                            <div class="sidebar__item">
                                <h4>Region</h4>
                                <c:forEach items="${lst1}" var="o">
                                    <div class="sidebar__item__size">
                                        <ul><a href="ShopGrid2?rid=${o.regionName}">${o.regionName}</a></ul>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="sidebar__item">
                                <div class="latest-product__text">
                                    <h4>Cheapest Products</h4>
                                    <div class="latest-product__slider owl-carousel">
                                        <div class="latest-prdouct__slider__item">
                                            <c:forEach items="${lst3}" var="o" begin="0" end="2">
                                                <a href="detail?fid=${o.id}" class="latest-product__item">
                                                    <div class="latest-product__item__pic">
                                                        <img src="${o.image}" alt="">
                                                    </div>
                                                    <div class="latest-product__item__text">
                                                        <h6>${o.name}</h6>
                                                        <span>${o.price}</span>
                                                    </div>
                                                </a>
                                            </c:forEach>
                                        </div>
                                        <div class="latest-prdouct__slider__item">
                                            <div class="latest-prdouct__slider__item">
                                                <c:forEach items="${lst3}" var="o" begin="3" end="5">
                                                    <a href="detail?fid=${o.id}" class="latest-product__item">
                                                        <div class="latest-product__item__pic">
                                                            <img src="${o.image}" alt="">
                                                        </div>
                                                        <div class="latest-product__item__text">
                                                            <h6>${o.name}</h6>
                                                            <span>${o.price}</span>
                                                        </div>
                                                    </a>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-7">
                        <div class="filter__item">
                            <div class="row">
                                <div class="col-lg-4 col-md-5">
                                </div>
                                <div class="col-lg-4 col-md-4">
                                    <div class="filter__found">
                                        <h6>Products found</h6>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-3">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:forEach items="${listrandom}" var="o"> 
                                <div class="col-lg-4 col-md-6 col-sm-6">
                                    <div class="product__item">
                                        <div class="product__item__pic set-bg" data-setbg="${o.image}">
                                            <ul class="product__item__pic__hover">
                                                <li><a href="foodlike?fid=${o.id}"><em class="fa fa-heart"></em></a></li>
                                                <li><a href="foodaddtocart?fid=${o.id}"><em class="fa fa-shopping-cart"></em></a></li>
                                            </ul>
                                        </div>
                                        <div class="product__item__text">
                                            <h6><a href="detail?fid=${o.id}">${o.name}</a></h6>
                                            <h5>${o.price}</h5>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Product Section End -->

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