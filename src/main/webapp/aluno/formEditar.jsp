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
        <h1>Editar Aluno</h1>
      </div>
      
      
      <form method="post" name="myform" class="form-horizontal" 
      	action="<%=request.getContextPath()%>/aluno/atualizar">
      
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="codAluno">Código:</label>
      		<div class="col-sm-5">
      			<input type="text" name="codAluno" id="codAluno" value="${item.codAluno}" required="required" readonly="readonly" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="nome">Nome:</label>
      		<div class="col-sm-5">
      			<input type="text" name="nome" id="nome" value="${item.nome}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="cpf">CPF:</label>
      		<div class="col-sm-5">
      			<input type="text" name="cpf" id="cpf" value="${item.cpf}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="telefone">Telefone:</label>
      		<div class="col-sm-5">
      			<input type="text" name="telefone" id="telefone" value="${item.telefone}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="email">Email:</label>
      		<div class="col-sm-5">
      			<input type="text" name="email" id="email" value="${item.email}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="nascimento">Data de Nascimento:</label>
      		<div class="col-sm-5">
      			<input type="text" name="nascimento" id="nascimento" value="${item.nascimento}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	<div class="form-group">
      		<label class="col-sm-2 control-label" for="renda">Renda Mensal:</label>
      		<div class="col-sm-5">
      			<input type="text" name="renda" id="renda" value="${item.renda}" required="required" class="form-control"/>
      		</div>
      	</div>
      	
      	
      	<div class="form-group">
      		<div class="col-sm-offset-2 col-sm-10">
      			<button type="submit" class="btn btn-primary">Atualizar</button>
      			<a href="<%=request.getContextPath()%>/aluno/listar" class="btn btn-default">Voltar</a>
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
