<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Sistema de Escola</title>
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp"></jsp:include>

	<!-- Begin page content -->
	<div class="card card-container card-block grid">
		<div class="card-header card-block card-titulo">
			<h1 class="card-title">
				<span class="glyphicon glyphicon-search"></span> Pesquisar Cursos
			</h1>
		</div>
		<div class="card-block">
			<form method="post" name="myform" class="form-horizontal"
				action="<%=request.getContextPath()%>/curso/resultadoPesquisa">

				<div class="form-group">
					<label class="col-sm-2 control-label" for="trechoNome">Nome:</label>
					<div class="col-sm-5">
						<input type="text" name="trechoNome" id="trechoNome"
							required="required" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label" for="precoMinimo">Preço
						Minimo:</label>
					<div class="col-sm-5">
						<input type="text" name="precoMinimo" id="precoMinimo"
							required="required" class="form-control" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label" for="precoMaximo">Preço
						Máximo:</label>
					<div class="col-sm-5">
						<input type="text" name="precoMaximo" id="precoMaximo"
							required="required" class="form-control" />
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">Pesquisar</button>
					</div>
				</div>

			</form>
		</div>
		<div class="bg-black"></div>
		<div class="expand">
			<img src="../imagens/teste3.jpg" class="expand-image">
		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>



	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#minhaTabela').dataTable();
		});
	</script>
</body>
</html>
