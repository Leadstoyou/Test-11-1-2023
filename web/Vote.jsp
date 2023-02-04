<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Genshin Food</title>
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
                            <h2><strong>Vote ⸜(｡˃ ᵕ ˂ )⸝</strong></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="vote" method="get">
                            <div class="modal-header">						
                                <h4 class="modal-title">Vote (,,◕　⋏　◕,,)</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick='window.history.go(-1);'>&times;</button>
                            </div>
                            <div class="modal-body">
                                <input name="billid" type="hidden" class="form-control" value="${billid}" >
                                <div class="form-group">
                                    <p>Order ID</p>
                                    <input name="orderid" value="${detail.orderId}" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <p>Food Name</p>
                                    <input name="foodname" value="${detail.foodName}" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <p>Vote</p>
                                    <select name="vote" class="form-select" aria-label="Default select example">
                                        <option value="0">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Vote">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <a href="list"><button type="button" class="btn btn-primary">Back to home</button>D
            <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>