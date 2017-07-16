<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<div class="panel panel-default">			
			<div class="panel-heading">				
				Added on <fmt:formatDate pattern="EEEE d MMMM y 'at' HH:mm:ss" value="${latestStatus.addedAt}"/>
			</div>
			<div class="panel-body">
			    ${latestStatus.text}
			</div>
		</div>
    </div>
</div>

