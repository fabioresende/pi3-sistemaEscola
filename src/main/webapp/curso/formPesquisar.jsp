<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">

    <title>Sistema de Escola</title>
    <link href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath() %>/resources/css/sticky-footer-navbar.css" rel="stylesheet">
  </head>

  <body>

    <jsp:include page="/resources/templates/navbar.jsp"></jsp:include>

    <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Pesquisar Cursos</h1>
      </div>
      
      
      <form method="post" name="myform" class="form-horizontal" 
      	action="<%=request.getContextPath()%>/curso/resultadoPesquisa">
      
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="trechoNome">Nome:</label>
      		<div class="col-sm-5">
      			<input type="text" name="trechoNome" id="trechoNome" required="required" class="form-control"/>
      		</div>
      	</div>
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="precoMinimo">Preço Minimo:</label>
      		<div class="col-sm-5">
      			<input type="text" name="precoMinimo" id="precoMinimo" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="precoMaximo">Preço Máximo:</label>
      		<div class="col-sm-5">
      			<input type="text" name="precoMaximo" id="precoMaximo" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	
      	<div class="form-group">
      		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-primary">Pesquisar</button>
      		</div>
      	</div>
      	
      </form>
    </div>

    <jsp:include page="/resources/templates/rodape.jsp"></jsp:include>


    
    <!-- Core JS -->
    <script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/bootstrap.min.js"></script>
  </body>
</html>
