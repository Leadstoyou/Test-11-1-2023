<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <title>Login</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
    <div class="container">    
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
            <div class="panel panel-info" >
                <div class="panel-heading">
                    <div class="panel-title">Come to visit my shop UwU</div> 
                    <p class="text-danger">${message}</p>
                    <p class="text-danger">${message2}</p>
                </div>     
                <div style="padding-top:30px" class="panel-body" >
                    <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                    <form id="loginform" class="form-horizontal" role="form" action="login" method="post" aria-label="Site-menu">
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><em class="glyphicon glyphicon-user"></em></span>
                            <input id="login-username" type="text" class="form-control" name="username" value="" placeholder="username or email">                                        
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><em class="glyphicon glyphicon-lock"></em></span>
                            <input id="login-password" type="password" class="form-control" name="password" placeholder="password">
                        </div>
                        <div style="margin-top:10px; text-align:center" class="form-group">
                            <!-- Button -->
                            <div class="col-sm-12 controls">
                                <button type="submit" class="btn btn-success">Welcome to Genshin Food </button>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-12 control">
                                <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                    Hmm! It's seem like you don't have an account?໒(⊙ᴗ⊙)७✎▤
                                    <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                        Let's Sign Up
                                    </a>
                                </div>
                            </div>
                        </div>    
                    </form>     
                </div>                     
            </div>  
        </div>
        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <div class="panel-title">Sign Up</div>
                    
                    <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                </div>  
                <div class="panel-body" >
                    <form id="signupform" class="form-horizontal" role="form" action="signup" method="get" aria-label="Site-menu2">
                        <div class="form-group">
                            <label for="number" class="col-md-3 control-label">Phone Number</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="phone" placeholder="Phone Number">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="firstname" class="col-md-3 control-label">Your Name</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="name" placeholder="Your Name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastname" class="col-md-3 control-label">User Name</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="user" placeholder="User Name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-md-3 control-label">Password</label>
                            <div class="col-md-9">
                                <input type="password" class="form-control" name="pass" placeholder="Password">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-md-3 control-label">Re Enter Password</label>
                            <div class="col-md-9">
                                <input type="password" class="form-control" name="repass" placeholder="Password">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="icode" class="col-md-3 control-label">Address</label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" name="address" placeholder="Address">
                            </div>
                        </div>

                        <div class="form-group">
                            <!-- Button -->                                        
                            <div class="col-md-offset-3 col-md-9">
                                <button id="btn-signup" type="submit" class="btn btn-info"><em class="icon-hand-right"></em>Sign Up</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div> 
    </div>
</body>


