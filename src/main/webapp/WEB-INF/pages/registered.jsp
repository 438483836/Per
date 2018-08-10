<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>实贝科技用户注册</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/css/form-elements.css">
    <link rel="stylesheet" href="/assets/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/assets/ico/apple-touch-icon-57-precomposed.png">
    <script type="text/javascript" src='<s:url value="http://code.jquery.com/jquery-latest.js"></s:url>'></script>
    <script type="text/javascript">
        /**
         * 使用jquery在前台页面验证邮箱输入是否正确
         */
        function postComment() {
            //验证邮箱
            if(!$("input[name='form-email']").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
                alert("邮箱格式不正确！请重新输入");
                return false;
            } else {
                alert("邮箱正确！");
            }
        }
    </script>
</head>

<body>

<!-- Top menu -->
<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href='<s:url value="/loginVaData"></s:url>'>Bootstrap Flat Registration Form Template</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="top-navbar-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
							<span class="li-text">
								Put some text or
							</span>
                    <a href="#"><strong>links</strong></a>
							<span class="li-text">
								here, or some icons:
							</span>
							<span class="li-social">
								<a href="#"><i class="fa fa-facebook"></i></a>
								<a href="#"><i class="fa fa-twitter"></i></a>
								<a href="#"><i class="fa fa-envelope"></i></a>
								<a href="#"><i class="fa fa-skype"></i></a>
							</span>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Top content -->
<div class="top-content">
    <div class="copyrights">Collect from <a href="#"  title="实贝科技">实贝科技</a></div>
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-7 text">
                    <h1><strong>实贝科技</strong> 欢迎您</h1>
                    <div class="description">
                        <p>
                            实贝科技专注物流平台开发
                            下载资料 <a href="#"><strong>实贝科技</strong></a>, 根据您的喜好自定义和使用它！
                        </p>
                    </div>
                    <div class="top-big-link">
                        <a class="btn btn-link-1" href="#">Button 1</a>
                        <a class="btn btn-link-2" href="#">Button 2</a>
                    </div>
                </div>
                <div class="col-sm-5 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Sign up now</h3>
                            <p>填写下面的表格即可获得即时访问权限:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-pencil"></i>
                        </div>
                        <div class="form-top-divider"></div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="${pageContext.request.contextPath}/registeredMess" method="post" class="registration-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-first-name">First name</label>
                                <input type="text" name="form-first-name" placeholder="First name..." class="form-first-name form-control" id="form-first-name">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-last-name">Last name</label>
                                <input type="text" name="form-last-name" placeholder="Last name..." class="form-last-name form-control" id="form-last-name">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-email">Email</label>
                                <input type="text" name="form-email" placeholder="Email..." class="form-email form-control" id="form-email">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Password</label>
                                <input type="text" name="password" placeholder="password..." class="form-password form-control" id="form-password">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-about-yourself">About yourself</label>
			                        	<textarea name="form-about-yourself" placeholder="About yourself..."
                                                  class="form-about-yourself form-control" id="form-about-yourself"></textarea>
                            </div>
                            <button type="submit" class="btn" onclick="return postComment()">Sign me up!</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>


<!-- Javascript -->
<script src="/assets/js/jquery-1.11.1.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/jquery.backstretch.min.js"></script>
<script src="/assets/js/retina-1.1.0.min.js"></script>
<script src="/assets/js/scripts.js"></script>

<!--[if lt IE 10]>
<script src="/assets/js/placeholder.js"></script>
<![endif]-->

</body>

</html>