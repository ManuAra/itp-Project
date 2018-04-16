<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Project Form</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/web-resources/css/skill-style.css">

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
	
					<form:form action="saveUserSkill-userId-${userDetail.userId}" modelAttribute="userSkill" method="POST">
						<table class="skill-table" >
									
							<tr>
								<th colspan="7">Add a Skill</th>
							</tr>	
							<tr>
								<td colspan="2" class="td-title">Note: Remember not to be redundant on your personal skills. </td>
							</tr>	
							<tr>
								<td class="td-normal" ><form:textarea path="skill" placeholder="Enter text" /></td>
								<td colspan="2" class="td-normal" >
									<input type="submit" class="save-button" value="Save"/>
							</tr>	
								
						</table>	
					</form:form>	
								 <!--  ${pageContext.request.contextPath}/userProfile/showUserProfile-userId-${userDetail.userId} -->
								<form action="${pageContext.request.contextPath}/userProfile/showUserProfile-userId-${userDetail.userId}">				
									<input type="submit" value="Go Back" class="return-button"/>
								</form>
				</div>
	</section>
	
</body>







</html>