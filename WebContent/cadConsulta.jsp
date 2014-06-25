<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Cadastro Consultas</title>

<link rel="stylesheet" href="resources/css/estilo2.css">

 <script type="text/javascript">  
 function formatar(mascara, documento){
  var i = documento.value.length;
  var saida = mascara.substring(0,1);
  var texto = mascara.substring(i)
  
  if (texto.substring(0,1) != saida){
            documento.value += texto.substring(0,1);
  }
  
}

 </script>

</head>
<body>
<c:import url="cabecalho.jsp"></c:import>
<a id="right" class="submit-button" href="menuAdmin.jsp">Voltar</a>

<form class="form-container" action="cadConsulta" method="post">
<div class="form-title"><h4>Cadastrar Consultas</h4></div>
<div class="form-title">Paciente</div>
<select class="form-field" name="nomepac">
<c:forEach var="lista" items="${listapac}">
<option><c:out value="${lista.nome}" /></option>
</c:forEach>
</select><br />
<div class="form-title">Medico</div>
<select class="form-field" name="nomemed">
<c:forEach var="list" items="${listamed}">
<option><c:out value="${list.nome}" /></option>
</c:forEach>
</select><br />

<div class="form-title">Data Consulta</div>
<input class="form-field" type="text" name="dataconsulta" size=10 maxlength=10 pattern="\d{2}\/\d{2}\/\d{4}\" placeholder="dd/mm/aaaa" /><br />
<div class="form-title">Hora Consulta</div>
<input class="form-field" type="time" name="horaconsulta" size=10 maxlength=10 /><br />
<div class="form-title">Retorno</div>
<select class="form-field" name="retorno">
<option>SIM</option>
<option selected>N�O</option>
</select><br />
<div class="form-title">Obs:</div>
<textarea class="form-field" name="obs" cols=60 rows=3></textarea><br />
<input class="submit-button" type="submit" value="Enviar"/><br />
<input class="submit-button" type="reset" value="Limpar"/><br />
</form>

<c:import url="rodape.jsp"></c:import>
</body>
</html>