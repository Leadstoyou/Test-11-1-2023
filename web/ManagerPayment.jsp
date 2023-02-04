
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manger Food</title>
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
                            <h2>Manager Payment(づ ◕‿◕ )づ</h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addNewPayment"  class="btn btn-success" data-toggle="modal"><em class="material-icons">&#xE147;</em> <span>Add New Payment</span></a>                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <caption>Payment Table</caption>
                    <thead>
                        <tr>
                            <th scope="0">
                                <span class="custom-checkbox">
                                </span>
                            </th>
                            <th scope="1">ID</th>
                            <th scope="2">Status</th>
                            <th scope="3">Date</th>
                            <th scope="4">Value</th>
                            <th scope="5">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listpayment}" var="o">
                            <tr>
                                <td>
                                </td>
                                <td>${o.id}</td>
                                <td>${o.status}</td>
                                <td>${o.date}</td>
                                <td>${o.value}</td>
                                <td>
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
        <!-- Add -->
        <div id="addNewPayment" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="addpayment" method="get">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Payment</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <p>Value</p>
                                <input name="value" type="text" class="form-control" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- -->
        <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>