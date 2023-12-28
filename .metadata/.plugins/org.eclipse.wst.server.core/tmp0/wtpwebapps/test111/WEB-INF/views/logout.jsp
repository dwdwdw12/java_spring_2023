<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header2.jsp"%>    
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
<!-- Google web font "Open Sans" -->
<link rel="stylesheet"
	href="../resources/font-awesome-4.7.0/css/font-awesome.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<!-- Bootstrap style -->
<link rel="stylesheet" type="text/css"
	href="../resources/css/datepicker.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/slick/slick.css" />
<link rel="stylesheet" type="text/css"
	href="../resources/slick/slick-theme.css" />
<link rel="stylesheet" href="../resources/css/templatemo-style.css">
<!-- Templatemo style -->

<div class="tm-page-wrap mx-auto">

	<div class="tm-container-outer tm-position-relative" id="tm-section-4">
		<form action="/login" method="post" class="tm-contact-form">
			<div class="form-group tm-name-container">
				<input type="text" id="id" name="id"
					class="form-control" placeholder="id" required />
			</div>
			<div class="form-group tm-email-container">
				<input type="password" id="pwd" name="pwd"
					class="form-control" placeholder="password" required />
			</div>
			<button type="submit"
				class="btn btn-primary tm-btn-primary tm-btn-send text-uppercase">login</button>
		</form>
	</div>
	<!-- .tm-container-outer -->
	<%@ include file="includes/footer.jsp"%>
</body>
</html>