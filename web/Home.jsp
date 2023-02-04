
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

            <!-- Hero Section Begin -->
            <section class="hero">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-3">
                            <div class="hero__categories">
                                <div class="hero__categories__all">
                                    <em class="fa fa-bars"></em>
                                    <span>All departments</span>
                                </div>
                                <ul>
                                <c:forEach items="${lst}" var="o">
                                    <li><a href="ShopGrid?cid=${o.cid}">${o.cname}</a></li>
                                    </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-9">
                        <div class="hero__search">
                            <div class="hero__search__form">
                                <form action="search" method="get">
                                    <input name="foodtxt" type="text" placeholder="Do you need something UwU">
                                    <button type="submit" class="site-btn">SEARCH</button>
                                </form>
                            </div>
                            <div class="hero__search__phone">
                                <div class="hero__search__phone__icon">

                                    <a href='https://www.facebook.com/vaycanh.thien/'><em class="fa fa-phone"></em></a>

                                </div>
                                <div class="hero__search__phone__text">
                                    <h5>0947257842</h5>
                                    <span>support 24/7 time</span>
                                </div>
                            </div>
                        </div>
                        <div class="hero__item set-bg" data-setbg="Image/kfc_logo.jpg">
                            <div class="hero__text">
                                <span>Genshin Food</span>
                                <h2>KFC Collab</h2>

                                <a href="detail?fid=36" class="primary-btn">Buy now</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->

        <!-- Categories Section Begin -->
        <section class="categories">
            <div class="container">
                <div class="row">
                    <div class="categories__slider owl-carousel">
                        <c:forEach items="${lst1}" var="o">
                            <div class="col-lg-3">
                                <div class="categories__item set-bg" data-setbg="${o.image}">
                                    <h5><a href="detail?fid=${o.id}">${o.name}</a></h5>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </section>
        <!-- Categories Section End -->

        <!-- Featured Section Begin -->
        <section class="featured spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title">
                            <h2>List Food</h2>
                        </div>
                        <div class="featured__controls">
                            <ul>
                                <li class="active" data-filter="*">All</li>
                                <li data-filter=".oranges">Boosting</li>
                                <li data-filter=".fresh-meat">Recovery</li>
                                <li data-filter=".vegetables">Essential</li>
                                <li data-filter=".fastfood">Adventurer</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="row featured__filter">
                    <c:forEach items="${listcate1}" var="o">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix oranges">
                            <div class="featured__item">
                                <div class="featured__item__pic set-bg" data-setbg="${o.image}">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="foodlike?fid=${o.id}"><em class="fa fa-heart"></em></a></li>
                                        <li><a href="foodaddtocart?fid=${o.id}"><em class="fa fa-shopping-cart"></em></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?fid=${o.id}">${o.name}</a></h6>
                                    <h5>${o.price}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <c:forEach items="${listcate2}" var="o">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix fresh-meat">
                            <div class="featured__item">
                                <div class="featured__item__pic set-bg" data-setbg="${o.image}">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="foodlike?fid=${o.id}"><em class="fa fa-heart"></em></a></li>
                                        <li><a href="foodaddtocart?fid=${o.id}"><em class="fa fa-shopping-cart"></em></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?fid=${o.id}">${o.name}</a></h6>
                                    <h5>${o.price}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <c:forEach items="${listcate3}" var="o">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix vegetables">
                            <div class="featured__item">
                                <div class="featured__item__pic set-bg" data-setbg="${o.image}">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="foodlike?fid=${o.id}"><em class="fa fa-heart"></em></a></li>
                                        <li><a href="foodaddtocart?fid=${o.id}"><em class="fa fa-shopping-cart"></em></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?fid=${o.id}">${o.name}</a></h6>
                                    <h5>${o.price}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    <c:forEach items="${listcate4}" var="o">
                        <div class="col-lg-3 col-md-4 col-sm-6 mix fastfood">
                            <div class="featured__item">
                                <div class="featured__item__pic set-bg" data-setbg="${o.image}">
                                    <ul class="featured__item__pic__hover">
                                        <li><a href="foodlike?fid=${o.id}"><em class="fa fa-heart"></em></a></li>
                                        <li><a href="foodaddtocart?fid=${o.id}"><em class="fa fa-shopping-cart"></em></a></li>
                                    </ul>
                                </div>
                                <div class="featured__item__text">
                                    <h6><a href="detail?fid=${o.id}">${o.name}</a></h6>
                                    <h5>${o.price}</h5>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Featured Section End -->

        <!-- Banner Begin -->
        <div class="banner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="banner__pic">
                            <img src="https://images2.alphacoders.com/111/thumbbig-1110676.webp" alt="">
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="banner__pic">
                            <img src="https://images.alphacoders.com/118/thumbbig-1183122.webp" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Banner End -->

        <!-- Latest Product Section Begin -->
        <section class="latest-product spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-4 col-md-6">
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
                    <div class="col-lg-4 col-md-6">
                        <div class="latest-product__text">
                            <h4>Top Rated Products</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${listRating}" var="o" begin="0" end="2">
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
                                    <c:forEach items="${listRating}" var="o" begin="3" end="5">
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
                    <div class="col-lg-4 col-md-6">
                        <div class="latest-product__text">
                            <h4>Selling Products</h4>
                            <div class="latest-product__slider owl-carousel">
                                <div class="latest-prdouct__slider__item">
                                    <c:forEach items="${lst4}" var="o" begin="0" end="2">
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
                                    <c:forEach items="${lst4}" var="o" begin="3" end="5">
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
        </section>
        <!-- Latest Product Section End -->

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