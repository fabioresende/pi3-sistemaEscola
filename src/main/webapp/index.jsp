<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Sistema de Escola</title>
    <link href="<%=request.getContextPath() %>/resources/css/bootstrap.css" rel="stylesheet">
     <link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/sticky-footer-navbar.css" rel="stylesheet">
  </head>

  <body>

    <jsp:include page="/resources/templates/navbar.jsp"></jsp:include>

    <!-- Begin page content -->
    <div class="container">
      <div class="card teste">
      	<div class="card-block">
        	<h1 class="card-title">Página inicial</h1>
      	</div>
      		<p class="lead">Sistema Java para escola</p>
      		<p>Back to <a href="../sticky-footer">the default sticky footer</a> minus the navbar.</p>
      </div>
    </div>
    <div class="bg-black">
    </div>
	<div class="expand">
		<img src="imagens/teste3.jpg" class="expand-image">
	</div>
    <jsp:include page="/resources/templates/rodape.jsp"></jsp:include>

	
    
    <!-- Core JS -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
