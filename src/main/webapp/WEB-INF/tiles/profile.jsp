<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="img" value="/img"/>
<c:url var="editProfileAbout" value="/edit-profile-about"/>

<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<c:out value="${username}"/>
		<div class="profile-about">
		
			<div class="profile-image">
				<img alt="" src="${img}/avatar.jpg">
			</div>
			
			<div class="profile-text">				
				<c:choose>
					<c:when test="${profile.about == null}">
						<h1>Click 'edit' to add information about yourself to your profile.</h1>
					</c:when>
					<c:otherwise>
						<c:out value="${profile.about}"/>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="profile-about-edit pull-right">
				<a href="${editProfileAbout}">edit</a>
			</div>
		</div>
	</div>	
</div>