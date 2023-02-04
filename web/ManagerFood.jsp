
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
                            <h2>Manager Food (づ ◕‿◕ )づ</h2>
                        </div>
                        <div class="col-sm-6">
                            <a href="#addNewFood"  class="btn btn-success" data-toggle="modal"><em class="material-icons">&#xE147;</em> <span>Add New Food</span></a>                        </div>
                    </div>
                </div>
                <table class="table table-striped table-hover">
                    <caption>Food Table</caption>
                    <thead>
                        <tr>
                            <th>
                                <span class="custom-checkbox">
                                </span>
                            </th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Image</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listPage}" var="o">
                            <tr>
                                <td>
                                </td>
                                <td>${o.id}</td>
                                <td>${o.name}</td>
                                <td>
                                    <img src="${o.image}" alt="food image">
                                </td>
                                <td>${o.price}</td>
                                <td>
                                    <a href="loadFood?fid=${o.id}"  class="edit" data-toggle="modal"><em class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</em></a>
                                    <a href="delete?fid=${o.id}" class="delete" data-toggle="modal"><em class="material-icons" data-toggle="tooltip" title="Delete">&#10008;</em></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="clearfix">
                    <ul class="pagination">
                        <c:forEach begin="1" end="${pageNumber}" var="i">
                            <li class="page-item ${indexPage==i?"active":""}" ><a class="page-link" href="manager?index=${i}">${i}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <a href="list"><button type="button" class="btn btn-primary">Back to home</button></a>


        </div>
        <!-- Add -->
        <div id="addNewFood" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="add" method="get">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <p>Name</p>
                                <input name="name" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <p>Price</p>
                                <input name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <p>Quantity</p>
                                <input name="quantity" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <p>Description</p>
                                <textarea name="description" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <p>Image</p>
                                <textarea name="image" class="form-control" required>Image/.png</textarea>
                            </div>
                            <div class="form-group">
                                <p>Region</p>
                                <select name="region" class="form-select" aria-label="Default select example">
                                    <option value="Mondstadt">Mondstadt</option>
                                    <option value="Liyue">Liyue</option>
                                    <option value="Inazuma">Inazuma</option>
                                    <option value="Sumeru">Sumeru</option>
                                </select>
                            </div>
                            <div class="form">
                                <p>Category</p>
                                <select name="category" class="form-select" aria-label="Default select example">
                                    <c:forEach items="${lst}" begin="0" end="3" var="o">
                                        <option value="${o.cid}">${o.cname}</option>
                                    </c:forEach>
                                </select>
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