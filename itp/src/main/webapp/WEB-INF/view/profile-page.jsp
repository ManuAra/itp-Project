<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Profile Page</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/web-resources/css/profile-style.css">

	<link href="https://fonts.googleapis.com/css?family=Quicksand:500" rel="stylesheet">

	<script type="text/javascript" 
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
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
								<li><a href="${pageContext.request.contextPath}/userProfile/showHomePage">Home</a></li>
							</ul>	
						</nav>	
		</header>
		
		<div class="profile-image-container">
		
			<img src="${pageContext.request.contextPath}/web-resources/images/blue_icon.jpg" class="profile-img">	
		
		</div>
		
		
		<div class="primary-container"></div>
		
				<div class="sec-container">
			
							<table class="user-table" >
									<tr>
										<th> ${userDetail.firstName} (Middle Name) + Last Name</th>
									</tr>	
									<tr>
										<td>Current Position</td>
									</tr>	
									<tr>
										<td>Pasante o titulado</td>
									</tr>
									<tr>
										<td>Experience</td>
									</tr>
									<tr>
										<td>Email</td>
									</tr>
									<tr>
										<td class="td-description">Description
										<br><br>
										"Breve description of yourself"
										</td>
									</tr>
							</table>	
							
						
							<table class="experience-table">
									<tr>
										<th colspan="3">Experience
											<a href="${pageContext.request.contextPath}/userExperience/formForAddUserExperience-userId-${userDetail.userId}"  
																	class="add-button"> Add New </a></th>
									</tr>	
								<c:forEach var="userExperience" items="${userExperiences}">	
									<tr>
										<td >Puesto / Area: ${userExperience.position}</td>
									</tr>	
									<tr>
										<td class="exp-edit-delete">Place: ${userExperience.place}</td>
										<td class="exp-edit">
											 <a href="${pageContext.request.contextPath}/userExperience/formForUpdateUserExperience-userId-${userDetail.userId}-experienceId-${userExperience.experienceId}" class="edit-button">Edit</a>
										</td>
										<td class="exp-delete">
											<a href="${pageContext.request.contextPath}/userExperience/deleteUserExperience-userId-${userDetail.userId}-experienceId-${userExperience.experienceId}" 
														onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" class="delete-button">Delete</a>
										</td>
									</tr>
									<tr>
										<td>Period: ${userExperience.period}</td>
									</tr>
									<tr>
										<td colspan="3" class="td-description">Activities / Responsibilities
										<br><br>
										${userExperience.activities}
										</td>
									</tr>
								</c:forEach>
							</table>	
							
							<table class="project-table" >
									
									<tr>
										<th colspan="7">Projects
										
											<a href="<c:url value="/project/formForAddProjectDetail-userId-${userDetail.userId}" />" 
																	class="add-button"> Add New</a>    	
										</th>	
									</tr>	
								<c:forEach var="userProject" items="${userProjects}">	
									<tr>
										<td class="td-file">File</td>
										<td class="td-title">Title</td>
										<td class="td-type">Type </td>
										<td class="td-course">Course</td>
										<td class="td-description">Description of the project</td>		
										<td class="button" ></td>
									</tr>	
									<tr>
										<td class="td-normal" >Name of File</td>
										<td rowspan="2" class="td-normal" >${userProject.projectTitle}</td>
										<td rowspan="2" class="td-normal" >${userProject.projectType}</td>
										<td rowspan="2" class="td-normal" >${userProject.course}</td>
										<td rowspan="2" class="td-normal" >${userProject.projectDescription}</td>
										<td rowspan="2" class="td-normal" >
											<a href="${pageContext.request.contextPath}/project/deleteUserProject-userId-${userDetail.userId}-projectId-${userProject.projectId}" 
													onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" class="delete-button">Delete</a>
										</td>
									</tr>
									<tr>
										<td class="td-normal"><a href="<c:url value="/project/formForAddProjectDetail-userId-${userDetail.userId}" />" class="download-button">Download</a></td>
									</tr>
								</c:forEach>		
							</table>	
							
						
							
							<table class="skill-table" >
									<tr>
										<th colspan="2">Skills
										<!--  id="SkillModalBtn"  href="${pageContext.request.contextPath}/skill/formForAddUserSkill-${userDetail.userId}" -->
											<a href="${pageContext.request.contextPath}/userSkill/formForAddUserSkill-${userDetail.userId}"
															class="add-button">Add New </a>								
										</th>
									</tr>	
								<c:forEach var="userSkill" items="${userSkills}">	
									<tr>
										<td>- ${userSkill.skill}</td>
										<td class="skill-delete">
											<a href="${pageContext.request.contextPath}/userSkill/deleteSkill-userId-${userDetail.userId}-skillId-${userSkill.skillId}" 
													onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" class="delete-button">Delete</a>
										</td>
										
									</tr>
								</c:forEach>		
							</table>	
							
						
				</div>
	</section>
	
		<script src="${pageContext.request.contextPath}/web-resources/js/profile.js"></script>

</body>

</html>






