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
                            <h2><strong>Edit Food ⸜(｡˃ ᵕ ˂ )⸝</strong></h2>
                        </div>
                        <div class="col-sm-6">
                        </div>
                    </div>
                </div>
            </div>
            <div id="editEmployeeModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="edit" method="get">
                            <div class="modal-header">						
                                <h4 class="modal-title">Edit Food (,,◕　⋏　◕,,)</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <p>ID</p>
                                    <input name="id"value="${detail.id}" type="text" class="form-control" readonly required>
                                </div>
                                <div class="form-group">
                                    <p>Name</p>
                                    <input name="name"value="${detail.name}" type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <p>Price</p>
                                    <input name="price" value="${detail.price}"type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <p>Quantity</p>
                                    <input name="quantity" value="${detail.quantity}"type="text" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <p>Description</p>
                                    <textarea name="description" class="form-control" required>${detail.describe}</textarea>
                                </div>
                                <div class="form-group">
                                    <p>Image</p>
                                    <textarea name="image" class="form-control" required>${detail.image}</textarea>
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
                                <div class="form-group">
                                    <p>Category</p>
                                    <select name="category" class="form-select" aria-label="Default select example">
                                        <c:forEach items="${lst}" begin="0" end="3" var="o">
                                            <option value="${o.cid}">${o.cname}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <input type="submit" class="btn btn-success" value="Edit">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <a href="list"><button type="button" class="btn btn-primary">Back to home</button>
            <a href="manager"><button type="button" class="btn btn-primary">Back to Manager Food</button>
            <script src="js/manager.js" type="text/javascript"></script>
    </body>
</html>