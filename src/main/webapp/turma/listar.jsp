<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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
			<h1>Turmas</h1>
		</div>
		<div class="row">
			<div class="col-sm-2">
				<form class="navbar-form" action="<%=request.getContextPath()%>/turma/novaTurma" method="post">
					<button type="submit" class="btn btn-primary">Inserir</button>
					<input type="hidden" name="cod" value="${curso.codCurso}">
				</form>
			</div>
			<div class="col-sm-6">
				<form class="navbar-form" action="<%=request.getContextPath()%>/turma/filtrar">
					<div class="form-group">
						<input type="text" name="busca" placeholder="Digite uma data" class="form-control" />
					</div>
					<button type="submit" class="btn btn-success">Filtrar</button>
				</form>
			</div>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>C�digo</th>
						<th>In�cio</th>
						<th>Quantidade de Vagas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${itens}" var="x">
						<tr>
							<td>${x.codTurma}</td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${x.datainicio}"/></td>
							<td>${x.numeroDeVagas}</td>
							<td><a
								href="<%=request.getContextPath()%>/turma/editar?cod=${x.codTurma}"
								class="btn btn-primary btn-xs">Editar</a> <a
								href="<%=request.getContextPath()%>/turma/remover?cod=${x.codTurma}"
								class="btn btn-danger btn-xs">Excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>



	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
