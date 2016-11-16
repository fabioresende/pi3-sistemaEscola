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
			<h1>Confirmar Exclusão de Curso</h1>
		</div>
		<div>
			<ul class="list-group">
				<li class="list-group-item">Código: ${item.codCurso}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">Preço: <fmt:setLocale value="pt_BR" /> <fmt:formatNumber
						type="currency" value="${item.preco}" /></li>
				<li class="list-group-item">Pontuação: ${item.pontuacao}</li>
				<li class="list-group-item">Carga Horária: ${item.cargaHoraria}</li>
			</ul>
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<a href="<%=request.getContextPath()%>/curso/excluir?cod=${item.codCurso}" class="btn btn-danger">Excluir</a> 
			<a href="<%=request.getContextPath()%>/curso/listar" class="btn btn-default">Voltar</a>
		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>



	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
