<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<h1>Turmas de ${curso.nome}</h1>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>Código</th>
						<th>Início</th>
						<th>Quantidade de Vagas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${itens}" var="x">
						<tr>
							<td>${x.codTurma}</td>
							<td>${x.datainicio}</td>
							<td>${x.numeroDeVagas}</td>
							<td><a href="<%=request.getContextPath()%>/turma/editar?cod=${x.codTurma}" class="btn btn-primary btn-xs">Editar</a>
								<a href="<%=request.getContextPath()%>/turma/listar?cod=${x..codTurma}" class="btn btn-danger btn-xs">Excluir</a>
							</td>
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
