<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>

<head>
	<title>Login</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/web-resources/css/demo-style.css">

	<link href="https://fonts.googleapis.com/css?family=Quicksand:500" rel="stylesheet">

</head>

<body>

	<section class="background">
		
		<header>	
			<!--  <img src="${pageContext.request.contextPath}/web-resources/images/ing.png" class="logo">	 -->
			<p class="logo">LOGO</p>
		</header>
	
	
		<div class="registration-modal">
		
			<div class="registrationbox">
				
				<form:form>
				
					<p>Username:	</p>
					<input type="text" placeholder="Enter username">
								
					<p>Password:</p>
					<input type="password" placeholder="Enter password">
									
					<p></p>
					<input type="submit" value="Login"/>
								
				</form:form>
			
			</div>
		
		</div>
	
				<div class="loginbox">
					<img src="${pageContext.request.contextPath}/web-resources/images/icon.png" class="avatar">
					
						<h1>Login Here</h1>
							
							<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
								<p>Username:	</p>
								<input type="text" name="username" placeholder="Enter username">
								
								<p>Password:</p>
								<input type="password" name="password" placeholder="Enter password">
									
								<p></p>
								<input type="submit" value="Login"/>
								
							</form:form>
							
							<p></p>
							
							<!-- Link a formulario para registrarse -->
							
							<a href="#" class="button">Not Log yet? Register now</a>
							
							
				</div>
	
				<div class="textbox">
				
					<h1>Get to Know ITP Engineers</h1>
				
					<p>
					
					<!-- Modificar texto -->
					
						The Engineer in Process Technologies (ITP) is able to develop, improve and manage, processes for the generation 
						of goods and services of the different industries, using cutting-edge technological applications, machinery, 
						tools, equipment, raw materials and human resources to update, innovate, optimize and control industrial 
						processes, contributing with the organization to achieve greater efficiency, quality, productivity and 
						profitability for the benefit of society. It carries out its activities in a humanistic framework of respect 
						for the environment, ethics and values.
					
					</p>
				
					<br><br><br>
					
					<a href="${pageContext.request.contextPath}/userProfile/showHomePage" class="button"> Go to Home Page </a>
				
				</div>
	
			</section>		
</body>

</html>



