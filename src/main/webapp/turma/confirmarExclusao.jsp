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
				<li class="list-group-item">Código: ${item.codTurma}</li>
				<li class="list-group-item">Número de Vagas: ${item.numeroDeVagas}</li>
				<li class="list-group-item">Início: ${item.datainicio}</li>
			</ul>
		</div>
		<div class="col-sm-offset-2 col-sm-10">
			<a href="<%=request.getContextPath()%>/turma/excluir?cod=${item.codTurma}" class="btn btn-danger">Excluir</a> 
			<a href="<%=request.getContextPath()%>/turma/listar?cod=${codCurso}" class="btn btn-default">Voltar</a>
		</div>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>



	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
