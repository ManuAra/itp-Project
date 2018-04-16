<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
	<title>Home Page</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/web-resources/css/home-style.css">

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
									<!--  <li><a href="#">Edit Profile</a></li>
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

		
			
			<div class="search-bar">
		
				<!-- search bar -->
					<div class="search">
						<form:form action="${pageContext.request.contextPath}/userProfile/search" method="POST">
						
							Search User: <input type="text" name="SearchName" />
						
							<input type="submit" id="search" value="Search" class="search-button">
							<label for="search">Search</label>
						</form:form>
					</div>
				
				
					<div class="add-user">
						<input type="button" value="Add User" id="addUser" class="add-user-bttn"
						   	onclick="window.location.href='${pageContext.request.contextPath}/userDetail/formForAddUserDetail'; return false;"/>
						 <label for="addUser">Add User</label>  	
					</div>
				
			</div>
			
			
		<div class="main-container">	
			<!-- userDetail por tempUser -->
			
		<c:forEach var="userDetail" items="${usersDetails}">	
			<div class="user-container">
			
				
				
						<!-- c:url var="userProfile" value="/userProfile/showUserProfile">
								c:param name="userId" value="${tempUser.userId}" />
						   	/c:url> -->
					<c:url var="userProfile" value="/userProfile/showUserProfile-userId-${userDetail.userId}" />	
						
						<img src="${pageContext.request.contextPath}/web-resources/images/blue_icon.jpg" class="profile-img">
						
						<c:url var="deleteUser" value="/userDetail/deleteUserDetail-userId-${userDetail.userId}" />
						
							<a href="${deleteUser}" class="delete-user" 
							onclick="if (!(confirm('Are you sure you want to delete the user'))) return false"> &times;</a>
							
							
								<table class="user-table" >	
									<tbody> 	
										<tr>
											<th>${userDetail.firstName} ${userDetail.lastName} </th>
											
										</tr>	
										<tr>
											<td class="td-normal"> Username: ${userDetail.username} </td>
										</tr>	
										<tr>
											<td class="td-normal"> ${userDetail.email} </td>
										</tr>
										<tr>
											<td class="td-normal"> Current Situation: ${userDetail.currentSituation}</td>
										</tr>
										<tr>
											<td class="td-normal">Experience: ${userDetail.experience}</td>
										</tr>
										<tr>
											<td class="td-description"> ${userDetail.bio} </td>
										</tr>
										<tr>
											<td class="td-button">
												<a href="${userProfile}" class="button">See Profile</a>
											</td>
										</tr>
									</tbody>
								</table>	
			</div>	
			
		</c:forEach>		
		</div>
	</section>	
</body>

</html>


