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
			<h1>Editar Turma</h1>
		</div>
		<form name="myform" class="form-horizontal"
			action="<%=request.getContextPath()%>/turma/atualizar" method="post">
			<input type="hidden" name="codCurso" value="${codCurso}">
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
				<label class="col-sm-2 control-label" for="codTurma">Código:</label>
				<div class="col-sm-5">
					<input type="text" name="codTurma" id="codTurma"
						value='${item.codTurma}' readonly="readonly" class="form-control"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="datainicio">Data
					de início:</label>
				<div class="col-sm-5">
					<input type="text" name="datainicio" id="datainicio" class="form-control"
						value='<fmt:formatDate pattern="dd/MM/yyyy"  value="${item.datainicio}"/>' />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="numeroDevagas">Numero
					de vagas:</label>
				<div class="col-sm-5">
					<input type="number" name="numeroDeVagas" id="numeroDeVagas" class="form-control"
						value="${item.numeroDeVagas}" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-12">
					<button type="submit" class="btn btn-primary">Atualizar</button>
					<a href="<%=request.getContextPath()%>/turma/listar?cod=${codCurso}"
						class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
	</div>

	<jsp:include page="/resources/templates/rodape.jsp"></jsp:include>



	<!-- Core JS -->
	<script src="<%=request.getContextPath()%>/resources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
</body>
</html>
