<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Sistema de Escola</title>
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/sticky-footer-navbar.css"
	rel="stylesheet">
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp"></jsp:include>

	<!-- Begin page content -->
	<div class="card card-container card-block grid">
		<div class="card-header card-block card-titulo">
			<h1 class="card-title">
				<span class="glyphicon glyphicon-education"></span> Cursos
			</h1>
		</div>

		<div class="row card-block">
			<div class="col-sm-2">
				<form class="navbar-form"
					action="<%=request.getContextPath()%>/curso/novo">
					<button type="submit" class="btn btn-primary">
						<span class=" glyphicon glyphicon-plus"></span> Inserir novo
					</button>
				</form>
			</div>
			<div class="col-sm-6">
				<form class="navbar-form"
					action="<%=request.getContextPath()%>/curso/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Dgite um nome"
							class="form-control" />
					</div>
					<button type="submit" class="btn btn-success">
						<span class="glyphicon glyphicon-search"> </span>
					</button>
				</form>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codCurso}</td>
						<td>${x.nome}</td>
						<td><a
							href="<%=request.getContextPath()%>/turma/listar?cod=${x.codCurso}"
							class="btn btn-primary btn-xs">Entrar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
</body>
</html>
