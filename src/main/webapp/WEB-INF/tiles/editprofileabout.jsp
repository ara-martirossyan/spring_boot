<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		
		<div class="errors">
		<form:errors path="profile.*"/>
		</div>	
		
		<div class="panel panel-default">			
			<div class="panel-heading">
				Edit your "About" text
			</div>
			
		    <form:form modelAttribute="profile">		    		    	
		    	<div class="form-group">
		    		<form:textarea id="textarea" path="about" name="about" rows="10" cols="50" style="width:100%"/>
		    	</div>
		    	<input type="submit" name="submit" value="Publish"/>
		    </form:form>
			
		</div>
		
	</div>
	
</div>

  <script src='https://cloud.tinymce.com/stable/tinymce.min.js'></script>
  <script>
  tinymce.init({
    selector: 'textarea',
  });
  </script>
