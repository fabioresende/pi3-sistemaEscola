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
				<span class="glyphicon glyphicon-education"></span>Escolha um curso
			</h1>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>C�digo</th>
					<th>Nome</th>
					<th>Pre�o</th>
					<th>Pontua��o</th>
					<th>Carga Hor�ria</th>
					<th>A��o</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${itens}" var="x">
					<tr>
						<td>${x.codCurso}</td>
						<td>${x.nome}</td>
						<td><fmt:setLocale value="pt_BR" /> <fmt:formatNumber
								type="currency" value="${x.preco}" /></td>
						<td>${x.pontuacao}</td>
						<td>${x.cargaHoraria}</td>
						<td><a
							href="<%=request.getContextPath()%>/matricula/turmaListar?cod=${x.codCurso}"
							class="btn btn-primary btn-xs">Selecionar</a></td>
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
