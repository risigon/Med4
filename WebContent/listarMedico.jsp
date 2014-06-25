<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar M�dicos</title>
<link rel="stylesheet" href="resources/css/estilo.css">
</head>
<body>

<c:import url="cabecalho.jsp"></c:import>

<table id="zebra" class="tabela">
            <thead>
            <tr>
            		<th colspan=10>Listagem de M�dicos Cadastrados</th>
            </tr>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>CRM</th>
                    <th>Especialidade</th>
                    <th>Endereco</th>
                    <th>Bairro</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                    <th>Login</th>
                    
              
                </tr>
            </thead>
            <tbody>
                <c:forEach var="med" items="${medlista}">
                <tr>
                    <td width=20 align="center"><c:out value="${med.idmed}"  /></td>
                    <td width=150 align="left"><c:out value="${med.nome}" /></td>
                    <td width=130 align="center"><c:out value="${med.cpf}" /></td>
                    <td width=100 align="center"><c:out value="${med.crm}" /></td>
                    <td width=100 align="center"><c:out value="${med.especialidade}" /></td>
                    <td width=150 align="left"><c:out value="${med.endereco}" /></td>
                    <td width=120 align="left"><c:out value="${med.bairro}"  /></td>
                    <td width=90 align="center"><c:out value="${med.cidade}"  /></td>
                    <td width=20 align="center"><c:out value="${med.estado}"  /></td>
                    <td width=90 align="center"><c:out value="${med.login}"  /></td>
                    
                </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>Quantidade de Registros - <c:out value="${contador}"  /></p>
<form action="listar" method="post">
	<table class="tabela2">
	<tr>
	<td>Informar Nome:
	<input type="text" name="nome" size=50>
	<input type="hidden" name="opc" value="listarmednome">
	<input type="submit" value="Buscar"></td>
	</tr>
	</table>
</form>        

<form action="listar" method="post">
	<table  class="tabela2">
	<tr>
	<td>Informar Id:
	<input type="text" name="id" value="1" size=3>
	<input type="hidden" name="opc" value="listarmedid">
	<input type="submit" value="Alterar"></td>
	</tr>
	</table>
</form>        

<form action="excluir" method="post">
	<table class="tabela2">
	<tr>
	<td>Informar Id:
	<input type="text" name="id" value="1" size=3>
	<input type="hidden" name="opc" value="excluirmed">
	<input type="submit" value="Excluir"></td>
	</tr>
	</table>
</form>

<form action="listar" method="post">
	<input type="hidden" name="opc" value="listarmed">
	<input type="submit" value="Listar Todos">
</form>
<form action="cadMedico">
	<input type="submit" value="Novo Medico">
</form>

<c:import url="rodape.jsp"></c:import>
</body>
</html>