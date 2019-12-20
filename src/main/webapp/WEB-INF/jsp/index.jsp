<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/jsp/includes/global-header.jsp"></jsp:include>

<body>
	<section id="" class="homepage-section container col-12">
		<div class="index-left text-center">
<%--			<img src="./images/logo.png"/>--%>
		</div>
		<c:set var="username" value=""/>
		<c:if test="${registeredUser != null}">
			<c:set var="username" value="${registeredUser.username}"/>
		</c:if>
		<form class="index-right container shadow bg-white rounded border border-light p-5" action="/login" method="post">

			<p class="h2 mb-2 text-center">mum-social Sign in</p>

			<p class="p-underline"></p>
			<input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
			<div class="md-form">
				<i class="fa fa-user blue-grey-text font-weight-normal prefix"></i>
				<input type="text" id="form2" class="form-control" name="username" value="${username}">
				<label for="form2">Your username</label>
			</div>

		    <div class="md-form">
				<i class="fa fa-key blue-grey-text prefix"></i>
				<input type="password" id="form4" class="form-control" name="password">
				<label for="form4">Your password</label>
			</div>
	
		    <div class="d-flex justify-content-around mt-5">
		        <div>
		            <div class="custom-control custom-checkbox">
		                <input type="checkbox" class="custom-control-input" id="defaultLoginFormRemember">
		                <label class="custom-control-label" for="defaultLoginFormRemember">Remember me</label>
		            </div>
		        </div>
		        <div class="">
		            <a href="timeline">Forgot password?</a>
		        </div>
		    </div>
		
		    <button class="btn btn-block blue-gradient my-4 mt-5" type="submit">Sign in</button>

			<p class="text-center">or sign in with:
			<a href="/login" class="mx-2" role="button"><i class="fab fa-google light-blue-text"></i></a></p>
			<hr>
			<div class="text-center mt-5">
				
				<p>Don't have an account?</p>

				<div>
					<a href="register" class="purple-text font-weight-normal">sign up</a>
				</div>
			</div>
		</form>
	</section>
<jsp:include page="/WEB-INF/jsp/includes/global-footer.jsp"></jsp:include>
