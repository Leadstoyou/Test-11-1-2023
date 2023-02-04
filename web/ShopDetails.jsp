
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
                                <h2>Food Details</h2>
                                <div class="breadcrumb__option">
                                    <a href="list">Home</a>
                                    <a href="list">Details</a>
                                    <span>Food Details</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Product Details Section Begin -->
            <section class="product-details spad">
                <div class="container">
                    <form action="detailtoaddtocart" method="get">
                        <div class="row">
                            <div class="col-lg-6 col-md-6">
                                <div class="product__details__pic">
                                    <div class="product__details__pic__item">
                                        <img class="product__details__pic__item--large"
                                             src="${detail.image}" alt="">
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6 col-md-6">
                            <div class="product__details__text">
                                <h3>${detail.name}</h3>
                                <div class="product__details__price">${detail.price}</div>
                                <p>${detail.describe}</p>
                                <input type="hidden" value="${detail.id}" name="fidddd" class="fid">
                                <div class="product__details__quantity">
                                    <div class="quantity">
                                        <div class="pro-qty">
                                            <input type="number" value="1" name="qunatity" class="quantity">
                                        </div>
                                    </div>
                                </div>
                                <button id="btn-signup" class="primary-btn" type = "submit">ADD TO CARD</button>
                                <a href="foodlike?fid=${detail.id}" class="heart-icon"><span class="icon_heart_alt"></span></a>
                                <ul>
                                    <li><strong>Availability</strong> <span>In Stock</span></li>
                                    <li><strong>Share on</strong>
                                        <div class="share">
                                            <a href="https://www.facebook.com/vaycanh.thien/"><strong class="fa fa-facebook"></strong></a>
                                            <a href="https://www.facebook.com/vaycanh.thien/"><strong class="fa fa-twitter"></strong></a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
        <!-- Product Details Section End -->

        <!-- Related Product Section Begin -->
        <section class="related-product">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="section-title related__product__title">
                            <h2>Related Product</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${related}" var="o">
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__pic set-bg" data-setbg="${o.image}">
                                    <ul class="product__item__pic__hover">
                                        <li><a href="foodlike?fid=${o.id}"><strong class="fa fa-heart"></strong></a></li>
                                        <li><a href="foodaddtocart?fid=${o.id}"><strong class="fa fa-shopping-cart"></strong></a></li>
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
        </section>
        <!-- Related Product Section End -->

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