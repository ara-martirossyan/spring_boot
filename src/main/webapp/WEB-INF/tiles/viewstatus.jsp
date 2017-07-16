<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "ara" tagdir = "/WEB-INF/tags" %>

<c:url var="url" value="/statuses"></c:url>

<div class="row">
	<div class="col-md-8 col-md-offset-2">
	
		<h1>Statuses</h1>
		
		<ara:pagination page="${page}" url="${url}" size="5"/>
		
		<c:forEach var="status" items="${page.content}">
			<c:url var="editLink" value="/status/edit/${status.id}"/>
			<c:url var="deleteLink" value="/status/delete/${status.id}"/>
			<br>
			<div class="panel panel-default">			
				<div class="panel-heading">				
					Added on <fmt:formatDate pattern="EEEE d MMMM y 'at' HH:mm:ss" value="${status.addedAt}"/>
				</div>
				<div class="panel-body">
				    <div>${status.text}</div>
				    <div class="edit-links pull-right">
				    	<a href="${editLink}">edit</a> | <a href="${deleteLink}">delete</a>
				    </div>
				</div>
			</div>
			<br>
		</c:forEach>
	</div>
	
</div>
