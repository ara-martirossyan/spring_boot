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
				Create an Account
			</div>
			
			<div class="panel-body">
				<form:form method="post" class="login-form" modelAttribute="siteUser">
					
					<div class="errors">
		    			<form:errors path="email" />
		    		</div>					
			    	<div class="input-group">
			    		<form:input type="text" path="email" placeholder="Email" class="form-control" />
			    	</div>
			    	
					<div class="errors">
		    			<form:errors path="plainPassword" />
		    		</div>
			    	<div class="input-group">
			    		<form:input type="password" path="plainPassword" placeholder="Password" class="form-control" />
			    	</div>
			    	
			    	<div class="errors">
		    			<form:errors />
		    		</div>
			    	<div class="input-group">
			    		<form:input type="password" path="repeatPassword" placeholder="Reapeat Password" class="form-control" />
			    	</div>
			    	
			    	<div class="input-group">
			    		<button type="submit" class="btn btn-danger pull-right">Register</button>
			    	</div>
			    </form:form>
			</div>
			
		</div>		
	</div>
	
</div>