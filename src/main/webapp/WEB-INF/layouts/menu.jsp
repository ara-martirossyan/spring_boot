<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextRoot">${pageContext.request.contextPath}</c:set>

	<!-- Static navbar -->
<div class="navbar navbar-custom navbar-inverse navbar-static-top preload" id="nav">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class='navbar-brand' href='${contextRoot}/' style="padding: 0px !important; display: none"><img src='${contextRoot}/img/logo.png'></a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${contextRoot}/">Home</a></li>
        <li><a href="${contextRoot}/about">About</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<sec:authorize access="!isAuthenticated()">
      		<li><a href="${contextRoot}/login">Login</a></li>
      		<li><a href="${contextRoot}/register">Register</a></li>
      	</sec:authorize>
        <sec:authorize access="isAuthenticated()">
        	<li><a href="${contextRoot}/profile">Profile</a></li>
        </sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')"> 	
	        <li><a href="${contextRoot}/add-status">Add Status</a></li>
	        <li><a href="${contextRoot}/statuses">View Statuses</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        	<li><a href="javascript:$('#logoutForm').submit();">Logout</a></li>
        </sec:authorize>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</div>

<c:url var="logoutLink" value="/logout" />
<form id="logoutForm" method="post" action="${logoutLink}">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>