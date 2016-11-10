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
			<h1>Confirmar Exclusão de Aluno</h1>
		</div>
		<div>
			<ul class="list-group">
				<li class="list-group-item">Código: ${item.codAluno}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">CPF: ${item.cpf}</li>
				<li class="list-group-item">Telefone: ${item.telefone}</li>
				<li class="list-group-item">Data de Nascimento: ${item.nascimento}</li>
				<li class="list-group-item">Email: ${item.email}</li>
				<li class="list-group-item">Renda Mensal: <fmt:setLocale value="pt_BR" /> <fmt:formatNumber
						type="currency" value="${item.renda}" /></li>
			</ul>
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<a href="<%=request.getContextPath()%>/aluno/excluir?cod=${item.codAluno}" class="btn btn-danger">Excluir</a> 
			<a href="<%=request.getContextPath()%>/aluno/listar" class="btn btn-default">Voltar</a>
		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>



	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
