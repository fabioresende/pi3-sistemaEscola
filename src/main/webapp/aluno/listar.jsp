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
</head>

<body>

	<jsp:include page="/resources/templates/navbar.jsp"></jsp:include>

	<!-- Begin page content -->
	<div class="card card-container card-block grid">
		<div class="card-header card-block card-titulo">
			<h1 class="card-title">
				<span class="glyphicon glyphicon-user"></span> Alunos
			</h1>
		</div>

		<div class="row card-block">
			<div class="col-sm-2">
				<form class="navbar-form"
					action="<%=request.getContextPath()%>/aluno/novo">
					<button type="submit" class="btn btn-primary">
						<span class=" glyphicon glyphicon-plus"></span> Inserir novo
					</button>
				</form>
			</div>
			<div class="col-sm-6">
				<form class="navbar-form"
					action="<%=request.getContextPath()%>/aluno/filtrar">
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
		<table class="table card-block">
			<thead>
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>CPF</th>
					<th>Telefone</th>
					<th>Data de Nascimento</th>
					<th>Email</th>
					<th>Renda Mensal</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codAluno}</td>
						<td>${x.nome}</td>
						<td>${x.cpf}</td>
						<td>${x.telefone}</td>
						<td>${x.nascimento}</td>
						<td>${x.email}</td>
						<td><fmt:setLocale value="pt_BR" /> <fmt:formatNumber
								type="currency" value="${x.renda}" /></td>
						<td><a
							href="<%=request.getContextPath()%>/aluno/editar?cod=${x.codAluno}"
							class="btn btn-primary  glyphicon glyphicon-edit"></a> <a
							href="<%=request.getContextPath()%>/aluno/remover?cod=${x.codAluno}"
							class="btn btn-danger glyphicon glyphicon-trash"></a></td>
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
