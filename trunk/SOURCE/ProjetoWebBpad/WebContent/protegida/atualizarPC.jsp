<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.Paciente"%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.CadastrarPaciente"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>

<% 
	ArrayList mensagens = (ArrayList)request.getAttribute("mensagens"); 
	ArrayList erros = (ArrayList)request.getAttribute("erros");	
%>

<jsp:useBean id="paciente" class="modelo.entidades.Paciente"
	scope="request">
</jsp:useBean>


<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Atualizar Paciente</title>
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
    document.formAtualizarPaciente.hidAcao.value = botao.id;
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
		<div class="informacoes" id="msgSucesso"></div>


		<form bgcolor="#bbbcca" id="formAtualizarPaciente"
			name="formAtualizarPaciente" method="post" action="AtualizarPaciente"><input
			name="hidAcao" type="hidden" value="" />

		<table width="90%" border="0" align="center">
			<tr>
				<td colspan="2" class="tituloSecao" color>Dados do Paciente</td>
			</tr>
			<tr>
				<td class="tituloCampo">CNS:</td>
				<td><input name="pcCns" type="text" id="pcCns" tabindex="1"
					size="12" maxlength="12" value="${paciente.pcCns}"
					style="width: 166px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><input name="pcNome" type="text" id="pcNome" tabindex="2"
					size="100" maxlength="12" value="${paciente.pcNome}"
					style="width: 359px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Data de Nascimento:</td>
				<td><input name="pcDataNascimento" type="text"
					id="pcDataNascimento" tabindex="2" size="12" maxlength="10"
					value="<% SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            if(paciente != null && paciente.getPcDataNascimento() != null){
            	out.print(formato.format(paciente.getPcDataNascimento()));
            }%>" />
				</td>
			</tr>
			<tr>
				<td class="tituloCampo">Sexo:</td>
				<td><input name="pcSexo" type="radio" value="1" tabindex="3"
					<% 
                if (paciente.getPcSexo() != null && paciente.getPcSexo().equals("1")){
                	out.print("checked='checked'");
                }
                %> />Masculino
				 <input name="pcSexo" type="radio" tabindex="3" value="2"
					<% if (paciente.getPcSexo()!= null && paciente.getPcSexo().equals("2")){
                	out.print("checked='checked'"); 
                	}
                	%> />
				Feminino</td>
			</tr>
			<tr>
				<td class="tituloCampo">Endereço:</td>
				<td><input name="pcEndereco" type="text" id="pcEndereco"
					tabindex="6" size="18" maxlength="100"
					value="${paciente.pcEndereco} " style="width: 354px" /></td>
			</tr>

		</table>
		<table width="90%" border="0" align="center">

			<tr>
				<td>
				<div align="center">
				<p><br />
				<input name="atualizarPaciente" type="submit" id="atualizarPaciente"
					tabindex="24" onclick="setarAcao(this);" value="Atualizar">
				<input name="detalharPaciente" type="submit" id="detalharPaciente"
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
