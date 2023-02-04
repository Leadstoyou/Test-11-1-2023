
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import = "java.util.*" %>
<%@page import = "model.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    CategoryDAO cate = new CategoryDAO();
    List<Category> listCategories = cate.getCategories();
     request.setAttribute("lst", listCategories);
%>

            <!-- Hero Section Begin -->
            <section class="hero hero-normal">
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
                                    <em class="fa fa-phone"></em>
                                </div>
                                <div class="hero__search__phone__text">
                                    <h5>0947257842</h5>
                                    <span>support 24/7 time</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Hero Section End -->
