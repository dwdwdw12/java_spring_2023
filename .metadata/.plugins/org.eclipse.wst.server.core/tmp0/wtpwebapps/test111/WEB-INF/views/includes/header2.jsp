<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>	
<!doctype html>
<html class="no-js" lang="zxx">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Montana</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon"
	href="../resources/img/favicon.png">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="../resources/css/magnific-popup.css">
<link rel="stylesheet" href="../resources/css/font-awesome.min.css">
<link rel="stylesheet" href="../resources/css/themify-icons.css">
<link rel="stylesheet" href="../resources/css/nice-select.css">
<link rel="stylesheet" href="../resources/css/flaticon.css">
<link rel="stylesheet" href="../resources/css/gijgo.css">
<link rel="stylesheet" href="../resources/css/animate.css">
<link rel="stylesheet" href="../resources/css/slicknav.css">
<link rel="stylesheet" href="../resources/css/style.css">
<!-- <link rel="stylesheet" href="css/responsive.css"> -->

</head>

<body>
	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

	<!-- header-start -->
	<header>
		<div class="header-area ">
			<div id="sticky-header" class="main-header-area">
				<div class="container-fluid p-0">
					<div class="row align-items-center no-gutters">
						<div class="col-xl-5 col-lg-6">
							<div class="main-menu  d-none d-lg-block">
								<nav>
									<ul id="navigation">
									<li><a href="index.html" href="#"><img src="../resources/img/kakao/chunsik.png"
									alt="" style="width: 60px"></a></li>
										<li><a href="index.html" href="/">home</a></li>
										<li><a href="rooms.html" href="#">flight<i class="ti-angle-down"></i></a><ul class="submenu">
												<li><a href="blog.html">blog</a></li>
												<li><a href="single-blog.html">single-blog</a></li>
											</ul></li>
										<li><a href="about.html" href="#">board<i class="ti-angle-down"></i></a><ul class="submenu">
												<li><a href="blog.html">blog</a></li>
												<li><a href="single-blog.html">single-blog</a></li>
											</ul></li>
										<li><a href="contact.html">Contact</a></li>
									</ul>
								</nav>
							</div>
						</div>
						<div class="col-xl-2 col-lg-2">
							<div class="main-menu">
								<a href="/"> Kakao airline</a>
							</div>
						</div>
						<div class="col-xl-5 col-lg-4 d-none d-lg-block">
							<div class="book_room">
								<div class="socail_links">
									<ul>
										<li><a href="#">notice <!-- <i class="fa fa-facebook-square"></i> -->
										</a></li>
										<li><a href="#">event <!-- <i class="fa fa-twitter"></i> -->
										</a></li>
<!-- 										<li><a href="#"> <i class="fa fa-instagram"></i>
										</a></li> -->
									</ul>
								</div>
								<sec:authorize access="isAnonymous">
									<div class="book_btn d-none d-lg-block">
									<!-- a태그 클래스 이름 바꿔야함 -->
										<a class="aaa" href="/login">Login</a>
									</div>
								</sec:authorize>
								<!-- 로그인시만 보이게 바꿔야함 -->
								<sec:authorize access="isAuthenticated()">
									<div>
										<form action="/logout" method="post">
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
											<a onclick="href='/logout'">logout</a>
										</form>
									</div>
								</sec:authorize>
							</div>
						</div>
						<div class="col-12">
							<div class="mobile_menu d-block d-lg-none"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<script type="text/javascript">

</script>
	<!-- header-end -->