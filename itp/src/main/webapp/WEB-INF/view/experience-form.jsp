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
										<!-- Both of these options will be appear when the Spring Security its set up, if the
											user is loged in, these two (edit profile and log out) will be shown, but if not it will appear
											log in, as of now, i comment all of the options -->
										<!-- <li><a href="#">Edit Profile</a></li>
											<li><a href="#">Log Out</a></li>
											<li><a href="${pageContext.request.contextPath}/">Log in</a></li>
										-->
										</ul>
								</li>
								<li><a href="#">Blog</a></li>
								<li><a href="#">About</a></li>
								<li><a href="${pageContext.request.contextPath}/userProfile/showHomePage">Home</a></li>
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
								
								
							 <!--  ${pageContext.request.contextPath}/userProfile/showUserProfile-userId-${userDetail.userId} -->
								<form action="${pageContext.request.contextPath}/userProfile/showUserProfile-userId-${userDetail.userId}">				
									<input type="submit" value="Go Back" class="return-button"/>
								</form>		
				</div>
				
					
	</section>
	
		<script src="${pageContext.request.contextPath}/web-resources/js/project.js"></script>

</body>

</html>
