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
				<span class="glyphicon  glyphicon-folder-open"></span> Escolha um Aluno  
			</h1>
		</div>

		<table class="table">
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
						<td><fmt:setLocale value="pt_BR" />
							<fmt:formatNumber type="currency" value="${x.renda}" /></td>
						<td><a
							href="<%=request.getContextPath()%>/matricula/novo?codAluno=${x.codAluno}&codTurma=${codTurma}"
							class="btn btn-primary btn-xs">Matricular</a></td>
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
