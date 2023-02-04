
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manger Order</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>

        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
    <body>
        <div class="container">
            <div class="table-wrapper">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manager Order(づ ◕‿◕ )づ</h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="managerbill"><button type="button" class="btn btn-primary">View Bill</button></a>
                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <caption>Order Table</caption>
                    <thead>
                        <tr>
                            <th>
                            </th>
                            <th>ID</th>
                            <th>Date</th>
                            <th>Food</th>
                            <th>Quantity</th>
                            <th>Total</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listorder}" var="o">
                            <tr>
                                <td>
                                </td>
                                <td>${o.orderId}</td>
                                <td>${o.orderDate}</td>
                                <td>${o.foodName}</td>
                                <td>${o.foodQuantity}</td>               
                                <td>${o.total}</td>
                                <td>
                                    <a href="deleteorder?orderid=${o.orderId}" class="delete" data-toggle="modal"><em class="material-icons" data-toggle="tooltip" title="Confirm">&#10004;</em></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                    </ul>
                </div>
            </div>
            <a href="list"><button type="button" class="btn btn-primary">Back to home</button></a>
        </div>
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>