<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Project Form</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/web-resources/css/project-style.css">

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
	
					<form:form id="projectForm" action="saveProjectDetail-userId-${userDetail.userId}" modelAttribute="userProject" 
									method="POST" >
				
						<table class="project-table" >
								
							<tr>
								<th colspan="7">Add a Project</th>
							</tr>	
								
							<tr>
								<td class="td-title">Title</td>
								<td class="td-type">Type </td>
								<td class="td-course">Course</td>
								<td class="td-description">Description of the project</td>		
								<td class="button" ></td>
									
							</tr>	
							<tr>
								<td class="td-normal"><form:input path="projectTitle" placeholder="Title of the project" /></td>
								<td class="td-normal">
													<form:radiobutton path="projectType" value="personal"/> Personal 
													<br><br>
													<form:radiobutton path="projectType" value="school"/> School
								</td>
									<td class="td-normal" ><form:input path="course" placeholder="Name of the Course"/></td>
									<td class="td-normal" ><form:textarea path="projectDescription" placeholder="Breve descriptio on the project" /></td>
									<td class="td-normal" >
										  <button id="btnFile" type="submit"  value="Add a File"  class="add-file-project-button " >Add File</button>	 				
									</td>
								</tr>
									
						</table>	
					</form:form>
								 			
					<form:form action="saveProjectFile-userId-${userDetail.userId}-projectId-${userProject.projectId}" 
								modelAttribute="fileManager" enctype="multipart/form-data"  method="POST">
				
						<div id="chooseFile" class="chooseFile">
								<form:input path="file" type="file" id="file" class="inputfile" />
								<label for="file">Choose File</label>
						</div>
								
						<div class="saveFile">						
								<input type="submit" id="save" name="Save" value="Save" class="save-button" />
								<label for="save">Save</label>
						</div>
						
					</form:form>
						
						<img src="${pageContext.request.contextPath}/web-resources/images/return-button.png" class="return-button">	
						
				</div>
	</section>
	
		<script src="${pageContext.request.contextPath}/web-resources/js/project.js"></script>

</body>

</html>
