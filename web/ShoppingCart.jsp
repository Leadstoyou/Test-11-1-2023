<%-- 
    Document   : ShoppingCart
    Created on : Oct 17, 2022, 8:22:48 PM
    Author     : trinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <h2>Shopping Cart</h2>
                                <div class="breadcrumb__option">
                                    <a href="Home">Home</a>
                                    <span>Shopping Cart</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Shoping Cart Section Begin -->
            <section class="shoping-cart spad">
                <div class="container">
                    <form action="addorder" method="get" role="form" >
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="shoping__cart__table">
                                    <table>
                                        <caption>Shopping Cart Table</caption>
                                        <thead>
                                            <tr>
                                                <th class="shoping__product">Food</th>
                                                <th>Price</th>
                                                <th>Quantity</th>
                                                <th>Total</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:set var="t" value="0"/>
                                        <c:forEach items="${listadd}" var="o">
                                            <tr>
                                        <input name="accidd" type="hidden" class="form-control" value="${sessionScope.acc.id}" >
                                        <input name="foodidd${t}" type="hidden" class="form-control" value="${o.id}" >
                                        <td class="shoping__cart__item">
                                            <img src="${o.image}" alt="" width="150" height="150">
                                            <a href="detail?fid=${o.id}">${o.name}</a>
                                        </td>
                                        <td class="shoping__cart__price">
                                            <div id="inputProductPrice" >
                                                <span value=${o.price} key= ${o.id} class="priceID">
                                                    ${o.price}  
                                                </span>
                                            </div>
                                        </td>
                                        <td class="shoping__cart__quantity">
                                            <div class="quantity">
                                                <div class="pro-qty" >
                                                    <input type="text" name="inputquantity${t}" value="${o.quantity}" onchange = "multiply()" class="quantityyyy">
                                                </div>
                                            </div>
                                        </td>
                                        <td class="shoping__cart__total">
                                            <div id="totalPrice">
                                                <span class = "total">
                                                    ${o.price * o.quantity}
                                                </span>
                                            </div>
                                        </td>
                                        <td class="shoping__cart__item__close">
                                            <a href="deleteaddtocart?fid=${o.id}"><strong class="icon_close"></strong><span></span></a>
                                        </td>
                                        </tr>
                                        <c:set var="t" value="${t+1}"/>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="shoping__cart__btns">
                                <a href="list" class="primary-btn cart-btn">CONTINUE SHOPPING</a>
                                <a href="shoppingcart" class="primary-btn cart-btn cart-btn-right"><span class="icon_loading"></span>
                                    RELOAD</a>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="shoping__continue">
                            </div>
                        </div>
                          <input name="countt" type="hidden" class="form-control" value="${t}" >
                        <div class="col-lg-6">
                            <div class="shoping__checkout">
                                <h5>Cart Total</h5>
                                <h5  class="text-danger">${message}</h5>
                                <ul>
                                    <li>Total <span id="sum"> </span></li>
                                </ul>
                                <button id="btn-signup" type="submit" class="primary-btn">PROCEED TO CHECKOUT</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>

        <!-- Shoping Cart Section End -->

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
            <script>
            function multiply() {
                var price = document.getElementsByClassName('priceID');
                var quantity = document.getElementsByClassName('quantityyyy');
                var total = document.getElementsByClassName('total');
                var sumInput = document.getElementById('sum');
                var n = 0;
                var sum = 0;
            <c:forEach items="${listadd}" var="o">
            total[n].innerHTML = parseFloat(price[n].innerText) * parseFloat(quantity[n].value);
            sum += parseFloat(total[n].innerText);
            n++;
            </c:forEach>
        sumInput.innerHTML = sum;
    }
    
            window.addEventListener('load',function(){
     
                multiply();
            });
        </script>
    </body>

</html>