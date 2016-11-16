<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Sistema de Escola</title>
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
	<div class="container">
		<div class="page-header">
			<h1>Cursos</h1>
		</div>
		
		<div class="row">
			<div class="col-sm-2">
				<form class ="navbar-form" action="<%=request.getContextPath()%>/curso/novo">
					<button type="submit" class="btn btn-primary">Inserir novo</button>
				</form>
			</div>
			<div class="col-sm-6">
				<form class ="navbar-form" action="<%=request.getContextPath()%>/curso/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Dgite um nome" class="form-control"/>
					</div>
					<button type="submit" class="btn btn-success">Filtrar</button>
				</form>
			</div>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Preço</th>
					<th>Pontuação</th>
					<th>Carga Horária</th>
					<th>Ação</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codCurso}</td>
						<td>${x.nome}</td>
						<td><fmt:setLocale value="pt_BR"/><fmt:formatNumber type="currency" value="${x.preco}"/></td>
						<td>${x.pontuacao}</td>
						<td>${x.cargaHoraria}</td>
						<td>
							<a href="<%=request.getContextPath()%>/curso/editar?cod=${x.codCurso}" class="btn btn-primary btn-xs">Editar</a>
							<a href="<%=request.getContextPath()%>/curso/remover?cod=${x.codCurso}" class="btn btn-danger btn-xs">Excluir</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>



	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
