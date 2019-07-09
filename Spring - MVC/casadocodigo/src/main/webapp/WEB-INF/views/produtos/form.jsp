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
	<!-- enctype="multipart/form-data": habilita o multipart para enviar arquivos pelo form -->
	<!-- s: prefixo da tagLib | mvcUrl: usado para adicionar o path do controller | PC#gravar: nome do controller (PC: Produto Controller) e m�todo que vai invocar (gravar) | build:monta a rota -->
	<form:form action= "${s:mvcUrl('PC#gravar').build()}" method="POST" commandName="produto" enctype="multipart/form-data" >
		<div>
			<label>Titulo:</label>
			<form:input  path="titulo" />
			<form:errors path="titulo" />
		</div>
		<div>
			<label>Descri��o:</label>
			<form:textarea rows="10" cols="20" path="descricao" />
			<form:errors path="descricao" />
		</div>
		<div>
			<label>P�ginas:</label>
			<form:input  path="paginas" />
			<form:errors path="paginas" />
		</div>
		<div>
			<label>Data de Lan�amento</label>
			<form:input path="dataLancamento" />
			<form:errors path="dataLancamento"/>
		</div>
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label>
				<form:input path="precos[${status.index}].valor" />
				<form:hidden path="precos[${status.index }].tipo" value="${tipoPreco}" />
			</div>
		</c:forEach>
		<div>
			<label>Sum�rio</label>
			<input name="sumario" type="file" />
		</div>
		<button type="submit">Cadastrar</button>
	</form:form>

</body>
</html>