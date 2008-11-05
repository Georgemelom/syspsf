<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.FichaDiaria"%>


<%@page import="java.text.SimpleDateFormat"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>

<% 
	ArrayList mensagens = (ArrayList)request.getAttribute("mensagens"); 
	ArrayList erros = (ArrayList)request.getAttribute("erros");	
%>

<jsp:useBean id="fichaDiaria" class="modelo.entidades.FichaDiaria"
	scope="request">
</jsp:useBean>


<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Atualizar Ficha</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="mm_spa.css" type="text/css" />
<style type="text/css">
<!--
.style2 {
	font-size: 16px
}
-->
</style>
<script language="JavaScript" type="text/javascript">
function setarAcao(botao){
    document.formAtualizarFichaDiaria.hidAcao.value = botao.id;
}
</script>

</head>
<body>
<table border="0" cellspacing="0" cellpadding="0">

	<tr bgcolor="#FF9900">

	</tr>

	<tr>
		<td colspan="3" valign="top">
		<p><img src="mm_spacer.gif" alt="" width="305" height="1"
			border="0" /><br />
		</p>
		<%
	if (erros != null && !erros.isEmpty()) { 
		Iterator i = erros.iterator();	
		%>
		<div class="erros" id="msgErros" bgcolor="#bbc023">
		<% 
		while (i.hasNext()){ 
			 %> <br />
		<% out.print(i.next());	 
		 }
		 %>
		</div>
		<% } %>
<!-- 		<div class="informacoes" id="msgSucesso">
		A música é : ${musicList}<br>
A música é : ${musicList[0]}
<br>
Comidas : ${comidas} <br>
Primeira comida : ${comidas[0]} <br>

Ambiente é : ${mapaDeMusicas.Ambiente} <br>
Ambiente é : ${mapaDeMusicas[Ambiente]}

		</div>

 -->		
		<form bgcolor="#bbbcca" id="formAtualizarFichaDiaria" name="AtualizarFichaDiaria"
			method="post" action="AtualizarFichaDiaria">
			<input name="hidAcao" type="hidden" value="" />

		<table width="90%" border="0" align="center">
			<tr>
				<td colspan="2" class="tituloSecao" color>Dados da Ficha</td>
			</tr>
			<tr>
				<td class="tituloCampo">Ficha:</td>
				<td><input name="fdID" type="text" id="fdID" tabindex="1"
					size="12" maxlength="12" value="${requestScope.fichadiaria.fdID}"
					style="width: 166px" /></td>
			</tr>
			<% FichaDiaria fichadiaria = (FichaDiaria)request.getAttribute("fichadiaria" );
			
			if(fichaDiaria != null) {
			System.out.println(fichaDiaria);
			%>
			
			<tr>
				<td class="tituloCampo">Folha:</td>
				<td><input name="folha_FoID" type="text"
					id="folha_FoID" tabindex="2" size="12" maxlength="12"
					value="${fichadiaria.folha_FoID}" style="width: 68px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Procedimento:</td>
				<td><input name="procedimentos_proCodigo" type="text" id="procedimentos_proCodigo" tabindex="3"
					size="50" maxlength="100" value="${fichadiaria.procedimentos_proCodigo} " /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Paciente:</td>
				<td><input name="pacientes_pcCns" type="text" id="pacientes_pcCns" tabindex="4"
					size="6" maxlength="100" value="${fichadiaria.pacientes_pcCns} " /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Profissional:</td>
				<td><input name="profissionalSaude_psCns" type="text" id="profissionalSaude_psCns" tabindex="5"
					size="18" maxlength="100" value="${fichadiaria.profissionalSaude_psCns} "
					style="width: 182px" /></td>
			</tr>
			<table width="90%" border="0" align="center">
			<tr>
				<td>
				<div align="center">
				<p><br />
				<input name="atualizarFicha" type="submit" id="atualizarFicha"
					tabindex="24" onclick="setarAcao(this);" value="Atualizar" />
				</div>
				</td>
			</tr>
		</table>
			
			<% } %>
		</table>
		<table width="90%" border="0" align="center">

			<tr>
				<td>
				<div align="center">
				<p><br />
				<input name="detalharFicha" type="submit" id="detalharFicha"
					tabindex="25" onclick="setarAcao(this);" value="Detalhar" /></p>
				</div>
				</td>
			</tr>
		</table>
		<br />
		</form>
		<p>&nbsp;</p>
		</td>
	</tr>
	<tr>
	</tr>
</table>
</body>
</html>
