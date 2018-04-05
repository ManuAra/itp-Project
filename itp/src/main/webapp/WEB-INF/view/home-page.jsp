<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

		
			
			<div class="search-bar">
		
				<!-- put new button: Add Customer
		
			input type="button" value="Add Customer"
				   onclick="window.location.href='${pageContext.request.contextPath}/userDetail/formForAddUserDetail'; return false;"
				   class="add-button"
			/>
			-->
			
			<!-- serach bar -->
			
				<form:form action="search" method="POST">
				
					Search User: <input type="text" name="SearchName" />
				
					<input type="submit" value="Search" class="search-button">
				</form:form>
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
						
							<table class="user-table" >	
								<tbody> 	
									<tr>
										<th>${userDetail.firstName}  </th>
									</tr>	
									<tr>
										<td class="td-normal">Position: Status</td>
									</tr>	
									<tr>
										<td class="td-normal">Pasante o titulado</td>
									</tr>
									<tr>
										<td class="td-normal">Experience</td>
									</tr>
									<tr>
										<td class="td-normal">Position: Status</td>
									</tr>
									<tr>
										<td class="td-description">Description</td>
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


