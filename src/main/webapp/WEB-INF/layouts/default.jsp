<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot">${pageContext.request.contextPath}</c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><tiles:insertAttribute name="title" /></title>
<!-- Bootstrap -->
<link href="${contextRoot}/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextRoot}/css/header.css" rel="stylesheet">
<link href="${contextRoot}/css/menu.css" rel="stylesheet">
<link href="${contextRoot}/css/form.css" rel="stylesheet">
<link href="${contextRoot}/css/main.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<br/>
	<div class="container">
		<tiles:insertAttribute name="content" />
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="${contextRoot}/js/bootstrap.min.js"></script>
	<script src="${contextRoot}/js/menu.js"></script>
	<script src="${contextRoot}/js/tableFilterSort.js"></script>
</body>
</html>