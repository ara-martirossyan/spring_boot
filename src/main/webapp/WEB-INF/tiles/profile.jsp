<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="profilePhoto" value="/profilephoto"/>
<c:url var="editProfileAbout" value="/edit-profile-about"/>

<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<c:out value="${username}"/>
		<div class="profile-about">
		
			<div class="profile-image">
				<img alt="" src="${profilePhoto}" width="100" height="100">
			</div>
			
			<div class="profile-text">				
				<c:choose>
					<c:when test="${profile.about == null}">
						<h1>Click 'edit' to add information about yourself to your profile.</h1>
					</c:when>
					<c:otherwise>
						${profile.about}
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="profile-about-edit pull-right">
				<a href="${editProfileAbout}">edit</a>
			</div>
			
			<p>&nbsp;</p>
			<br>
			<br>
			<br>
			<c:url value="/upload-profile-photo" var="uploadPhotoLink"/>
			<form action="${uploadPhotoLink}" enctype="multipart/form-data" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				Select Photo: <input type="file" accept="image/*" name="file" />
				<br>
				<input type="submit" value="upload"/>
			</form>
		</div>
	</div>	
</div>