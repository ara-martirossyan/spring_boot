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
			 	<c:if test="${profile.about == null}">
			 	Click 'edit' to add information about yourself to your profile.
			 	
			 	Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Pellentesque in ipsum id orci porta dapibus. Praesent sapien massa, convallis a pellentesque nec, egestas non nisi. Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem. Curabitur non nulla sit amet nisl tempus convallis quis ac lectus. Mauris blandit aliquet elit, eget tincidunt nibh pulvinar a. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec velit neque, auctor sit amet aliquam vel, ullamcorper sit amet ligula. Pellentesque in ipsum id orci porta dapibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus magna justo, lacinia eget consectetur sed, convallis at tellus. Vivamus suscipit tortor eget felis porttitor volutpat. Nulla quis lorem ut libero malesuada feugiat. Pellentesque in ipsum id orci porta dapibus. Vivamus suscipit tortor eget felis porttitor volutpat. Curabitur aliquet quam id dui posuere blandit. Proin eget tortor risus. Vestibulum ac diam sit amet quam vehicula elementum sed sit amet dui. Curabitur arcu erat, accumsan id imperdiet et, porttitor at sem.
			 	</c:if>
			</div>
			
			<div class="profile-about-edit pull-right">
				<a href="${editProfileAbout}">edit</a>
			</div>
		</div>
	</div>	
</div>