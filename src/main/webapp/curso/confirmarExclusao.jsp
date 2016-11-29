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
				<span class="glyphicon glyphicon-education"></span> Dados do Curso
			</h1>
		</div>
		<div>
			<ul class="list-group">
				<li class="list-group-item">C�digo: ${item.codCurso}</li>
				<li class="list-group-item">Nome: ${item.nome}</li>
				<li class="list-group-item">Pre�o: <fmt:setLocale value="pt_BR" />
					<fmt:formatNumber type="currency" value="${item.preco}" /></li>
				<li class="list-group-item">Pontua��o: ${item.pontuacao}</li>
				<li class="list-group-item">Carga Hor�ria: ${item.cargaHoraria}</li>
			</ul>
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<a
				href="<%=request.getContextPath()%>/curso/excluir?cod=${item.codCurso}"
				class="btn btn-danger">Excluir</a> <a
				href="<%=request.getContextPath()%>/curso/listar"
				class="btn btn-default">Voltar</a>
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
</body>
</html>
