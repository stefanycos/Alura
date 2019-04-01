<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<!-- Import da taglib do jstl -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Import da tag para exibir mensagens de erro -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- Import da tag do Spring -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Livros de desenvolvimento de software e muito mais</title>
</head>
<body>
	<!-- s: prefixo da tagLib | mvcUrl: usado para adicionar o path do controller | PC#gravar: nome do controller (PC: Produto Controller) e método que vai incocar (gravar) | build:monta a rota -->
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" commandName="produto">
		<div>
			<label>Titulo:</label>
			<input type="text" name="titulo" />
			<form:errors path="titulo" />
		</div>
		<div>
			<label>Descrição:</label>
			<textarea rows="10" cols="20" name="descricao" ></textarea>
			<form:errors path="descricao" />
		</div>
		<div>
			<label>Páginas:</label>
			<input type="text" name="paginas" />
			<form:errors path="paginas" />
		</div>
		
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label>
				<input type="text" name="precos[${status.index}].valor" />
				<input type="hidden" name="precos[${status.index }].tipo" value="${tipoPreco}" />
			</div>
		</c:forEach>
		
		<button type="submit">Cadastrar</button>
	</form:form>

</body>
</html>