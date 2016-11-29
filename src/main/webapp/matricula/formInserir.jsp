<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

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
				<span class="glyphicon glyphicon-folder-open"></span> Inserir nova Matrícula
			</h1>
		</div>
		<form name="myform" class="form-horizontal"
			action="<%=request.getContextPath()%>/matricula/inserir"
			method="post">
			<input type="hidden" name="codTurma" value="${codTurma}"> <input
				type="hidden" name="codAluno" value="${codAluno}">
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-12">
					<ul>
						<c:forEach items="${erros}" var="x">
							<li class="erro">${msg}</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-3 control-label" for="numParcelas">Numero
					de parcelas:</label>
				<div class="col-sm-5">
					<input type="number" name="numParcelas" id="numParcelas"
						value="${item.numParcelas}" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-12">
					<button type="submit" class="btn btn-primary">Inserir</button>
					<a href="<%=request.getContextPath()%>/turma/listar?cod=${cod}"
						class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
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
