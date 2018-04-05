<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>User Detail Form</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/web-resources/css/profile-style.css">
		  
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/web-resources/css/userDetail-style.css">	  

	<link href="https://fonts.googleapis.com/css?family=Quicksand:500" rel="stylesheet">

</head>

<body>


	<section class="main-section">
		<header>
			<div class="logo">
				<img src="${pageContext.request.contextPath}/web-resources/images/ing.png">
					</div>
						<nav>
							<ul>
								<li><a href="#"><img src="${pageContext.request.contextPath}/
											web-resources/images/icon_profile.png" class="profile"></a>
										<ul>
										<li><a href="#">Edit Profile</a></li>
										<li><a href="#">Log Out</a></li>
										</ul>
								</li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">About</a></li>
								<li><a href="#">Home</a></li>
							</ul>	
						</nav>	
		</header>
		
		<div class="profile-image-container">
		
			<img src="${pageContext.request.contextPath}/web-resources/images/blue_icon.jpg" class="profile-img">	
		
		</div>
		
		
		<div class="primary-container"></div>
		
			<div class="sec-container">
				<h3>Basic Information</h3>
				
					<form:form action="saveUserDetail" modelAttribute="userDetail" method="POST">
								
						<table id="userDetail" class="user-table" >		
				
								<tr>
									<td class="td-normal"><label>First Name:</label>
									</td>
									<td class="td-input">
										<form:input type="text" path="firstName" />
									</td>
									
								</tr>	
								<tr>
									<td class="td-normal"><label> Last Name:</label></td>
									<td class="td-input"><form:input type="text" path="lastName" /></td>
								</tr>
								<tr>
									<td class="td-normal"><label> Matricula:</label>
									<!--<form:input path="username" /> -->
									</td>
									<td class="td-input"><input type="text" /></td>
								</tr>
								<tr>
									<td class="td-normal"><label>Email:</label></td>
									<td class="td-input"><form:input path="email" /></td>
								</tr>
								<tr>
									<td class="td-description" colspan="2"><form:textarea path="bio" 
																			placeholder="Write a breve description of yourself" /></td>
								</tr>
								<tr>
									<td colspan="2" class="td-save"><input type="submit" id="save" name="Save" value="Save" class="save-button" />
										<label for="save">Save</label>
									</td>
								</tr>
							
							
						</table>	
					
					</form:form>
			</div>
	</section>
	
</body>

</html>