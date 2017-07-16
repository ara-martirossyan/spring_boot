<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="loginUrl" value="/login"/>

<div class="row">
	<div class="col-md-6 col-md-offset-3 col-sm-10 col-sm-offset-1">
		<div class="panel panel-default">		
			<div class="panel-heading">
				User Login
			</div>
			
			<div class="panel-body">
				<form method="post" action="${loginUrl}" class="login-form">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					
					<c:if test="${param.error != null}">
						<div class="login-error">Incorrect username or password.</div>
					</c:if>	
					
			    	<div class="input-group">
			    		<input type="text" name="username" placeholder="Username" class="form-control" />
			    	</div>
			    	<div class="input-group">
			    		<input type="password" name="password" placeholder="Password" class="form-control" />
			    	</div>
			    	<div class="input-group">
			    		<button type="submit" class="btn btn-danger pull-right">Sign in</button>
			    	</div>
			    </form>
			</div>
			
		</div>		
	</div>
	
</div>