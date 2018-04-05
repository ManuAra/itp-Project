<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Experience Form</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/web-resources/css/experience-style.css">

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
			
					<form:form action="saveUserExperience-userId-${userDetail.userId}" modelAttribute="userExperience" method="POST">
						
						<form:hidden path="experienceId" />	
								
						<table class="experience-table" >
								
								<tr>
									<th colspan="7">Add a Experience</th>
								</tr>	
								
								<tr>
									<td class="td-normal"><label>Position:</label></td>
									<td class="td-middle"><form:input path="position" type="text" placeholder="Enter text" /></td>
									<td class="td-right">
													<label>Current Job:</label>	
														<form:radiobutton path="currentPosition" value="yes" />Yes
														<form:radiobutton path="currentPosition" value="no" /> No
									 </td>	
								</tr>	
								<tr>
									<td class="td-normal" ><label>Place:</label></td>	
									<td class="td-middle"><form:input path="place" type="text" placeholder="Enter text" /></td>	
								</tr>
								<tr>
									<td class="td-normal"><label>Period:</label></td>
									<td class="td-middle"><form:input path="period" type="text" placeholder="Enter text" /></td>
								</tr>
								<tr>
									<td class="td-normal">Activities / Responsibilities:</td>
									<td class="td-middle"><form:textarea path="activities" placeholder="Enter text" /></td>
								</tr>
								<tr>
						</table>	
								
								<input type="submit" id="save" name="Save" value="Save" class="save-button" />
										<label for="save">Save</label>
					</form:form>	
								
								
							<!-- Construct the url to se the user profile -->	
								<c:url var="userProfile" value="/userProfile/showUserProfile">
									<c:param name="userId" value="${userDetail.userId}" />
								</c:url>	
										
								<form action="${userProfile}">				
									<input type="submit" value="Return Home" class="return-button"/>
								</form>			
				</div>
				
					
	</section>
	
		<script src="${pageContext.request.contextPath}/web-resources/js/project.js"></script>

</body>

</html>
