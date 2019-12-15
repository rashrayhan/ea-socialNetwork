<<<<<<< HEAD

<jsp:include page="/WEB-INF/jsp/includes/global-header.jsp"></jsp:include>
=======
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/includes/index-header.jsp"></jsp:include>
>>>>>>> 7116a2cf423565ac8e55fba271e3b7d359d5571e
	<section id="" class="homepage-section container col-12">
		<div class="index-left text-center">
<%--			<img src="./images/logo.png"/>--%>
		</div>
		<!-- Default form register -->
		<form class="text-center shadow bg-white rounded border border-light p-5" action="#" method="post">

			<p class="h4 mb-2">Sign up</p>
			<p class="p-underline"></p>


			<div class="form-row md-form">
				<div class="col">
					<!-- First name -->
					<input type="text" id="fname" class="form-control" name="fname">
					<label for="fname">First name</label>
				</div>
				<div class="col">
					<!-- Last name -->
					<input type="text" id="lname" class="form-control" name="lname">
					<label for="lname">Last name</label>
				</div>
			</div>

			<!-- E-mail -->
			<div class="md-form">
				<input type="email" id="email" class="form-control" name="email">
				<label for="email">Email</label>
			</div>

			<!-- DOB -->
			<div class="md-form">
				<input type="text" id="dob" class="form-control" name="dob">
				<label for="dob">Year of Birth</label>
			</div>

			<!-- Password -->
			<div class="md-form">
				<input type="password" id="password" class="form-control" name="password" aria-describedby="passHelp">
				<label for="password">Password</label>
				<small id="passHelp" class="form-text text-left text-muted">
					At least 8 characters and 1 digit
				</small>
			</div>

			<!-- Sign up button -->
			<button class="btn btn-block purple-gradient my-4 mt-4" type="submit">Sign up</button>

			<!-- Social register -->
			<p>or sign up with:</p>
				<a href="#" class="mx-2" role="button"><i class="fab fa-facebook-f light-blue-text"></i></a>
				<a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
				<a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
				<a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>

			<hr>

			<p><a href="index" class="teal-text font-weight-normal">sign in</a></p>

		</form>

	</section>
<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"></jsp:include>