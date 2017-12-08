<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Team5-Inventory Login</title>
</head>
<body>
	<div class="container">
		<div class="row" id="pwd-container">
			<div class="col-md-4">
				<section class="login-form"> 
				<form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/home/authenticate">
					<img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive"
						alt="" />
					<form:input path="name" size="40" />
					<form:password path="password" size="40" />
					<div class="pwstrength_viewport_progress"></div>
					<form:button name="submit" type="submit" value="s">
					<img src="${pageContext.request.contextPath}/image/button_login.gif" alt="" align="middle">
				</form:button>
				
				<form:button name="clear" type="reset" value="r">
					<img src="${pageContext.request.contextPath}/image/button_clear.gif" alt="" align="middle">
				</form:button>
					<div>
						<a href="#">Create account</a> or <a href="#">reset password</a>
					</div>

				</form:form> 
				</section>
			</div>
		</div>
	</div>
</body>
</html>