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
								 <!--  Construct the url to se the user profile  
								<c:url var="userProfile" value="/userProfile/showUserProfile">
									<c:param name="userId" value="${userDetail.userId}" />
								</c:url> 
								-->
								 <!--  ${pageContext.request.contextPath}/userProfile/showUserProfile-userId-${userDetail.userId} -->
								<form action="${pageContext.request.contextPath}/userProfile/showUserProfile-userId-${userDetail.userId}">				
									<input type="submit" value="Return Home" class="return-button"/>
								</form>
								
					
							<!--  <button class="return-button">Return Home</button> -->
						
				</div>
	</section>
	
</body>







</html>