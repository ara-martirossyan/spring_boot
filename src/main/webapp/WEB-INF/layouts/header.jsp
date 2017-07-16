<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot">${pageContext.request.contextPath}</c:set>

<header class="blackgrad" role="banner">
	<div class="container">
      <div class="row">
        <div class="col-sm-12">
          <div id="f1_container">
            <div id="f1_card" class="shadow">
              <div class="front face">
                <img src="${contextRoot}/img/logo.png" width="100" height="100"/>
              </div>
              <div class="back face center">
                <img src="${contextRoot}/img/ara.png" width="100" height="100"/>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</header>