
<%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/includes/global-header.jsp"></jsp:include>
	<section id="" class="homepage-section container col-12">
		<div class="index-left text-center">
<%--			<img src="./images/logo.png"/>--%>
		</div>
		<!-- Default form register -->
		<form:form modelAttribute="newUser" class="text-center shadow bg-white rounded border border-light p-5" method="post">
			<p class="h4 mb-2">Sign up</p>
			<p class="p-underline"></p>
			<div class="form-row md-form">
				<div class="col">
					<!-- First name -->
					<form:input type="text" path="surname" class="form-control"/>
					<form:label path="surname">Surname</form:label>
					<form:errors path="surname" cssStyle="color: red; font-size: 12px;"/>
				</div>
				<div class="col">
					<!-- Last name -->
					<form:input type="text" class="form-control" path="otherNames"/>
					<form:label path="otherNames">Other names</form:label>
					<form:errors path="otherNames" cssStyle="color: red; font-size: 12px;"/>
				</div>
			</div>

			<!-- E-mail -->
			<div class="md-form">
				<form:input type="email" class="form-control" path="email"/>
				<form:label path="email">Email</form:label>
				<form:errors path="email" cssStyle="color: red; font-size: 12px;"/>
			</div>

			<!-- DOB -->
			<div class="md-form">
				<form:input type="date" class="form-control" path="dateOfBirth"/>
				<form:label path="dateOfBirth">Year of Birth</form:label>
				<form:errors path="dateOfBirth" cssStyle="color: red; font-size: 12px;"/>
			</div>

			<!-- Username -->
			<div class="md-form">
				<form:input class="form-control" path="username"/>
				<form:label path="username">Username</form:label>
				<form:errors path="username" cssStyle="color: red; font-size: 12px;"/>
			</div>

			<!-- Password -->
			<div class="md-form">
				<form:password class="form-control" path="password" aria-describedby="passHelp"/>
				<form:label path="password">Password</form:label>
				<form:errors path="password" cssStyle="color: red; font-size: 12px;"/>
				<small id="passHelp" class="form-text text-left text-muted">
					At least 8 characters and 1 digit
				</small>
			</div>

			<!-- Sign up button -->
			<button class="btn btn-block purple-gradient my-4 mt-4" type="submit">Sign up</button>

			<!-- Social register -->
			<p>or sign up with:</p>
				<a href="" class="mx-2" role="button"><i class="fab fa-google light-blue-text"></i></a>
				<a href="#" class="mx-2" role="button"><i class="fab fa-twitter light-blue-text"></i></a>
				<a href="#" class="mx-2" role="button"><i class="fab fa-linkedin-in light-blue-text"></i></a>
				<a href="#" class="mx-2" role="button"><i class="fab fa-github light-blue-text"></i></a>

			<hr>

			<p><a href="/login" class="teal-text font-weight-normal">sign in</a></p>

		</form:form>

	</section>
<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"></jsp:include>
