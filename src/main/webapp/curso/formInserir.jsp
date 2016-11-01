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
        <h1>Inserir Novo Curso</h1>
      </div>
      
      
      <form method="post" name="myform" class="form-horizontal" 
      	action="<%=request.getContextPath()%>/curso/inserir">
      
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="nome">Nome:</label>
      		<div class="col-sm-5">
      			<input type="text" name="nome" id="nome" value="${item.nome}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="preco">Preço:</label>
      		<div class="col-sm-5">
      			<input type="text" name="preco" id="preco" value="${item.preco}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="pontuacao">Pontuação:</label>
      		<div class="col-sm-5">
      			<input type="text" name="pontuacao" id="pontuacao" value="${item.pontuacao}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="cargaHoraria">Carga Horária:</label>
      		<div class="col-sm-5">
      			<input type="text" name="cargaHoraria" id="cargaHoraria" value="${item.cargaHoraria}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	
      	<div class="form-group">
      		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-primary">Inserir</button>
      			<a href="<%=request.getContextPath()%>/curso/listar" class="btn btn-default">Voltar</a>
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
