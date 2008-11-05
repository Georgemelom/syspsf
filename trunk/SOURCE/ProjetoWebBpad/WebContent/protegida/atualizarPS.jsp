<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.Profissional"%>


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

<jsp:useBean id="profissional" class="modelo.entidades.Profissional"
	scope="request">
</jsp:useBean>


<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Atualizar Unidade Sa&uacute;de</title>
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
    document.formAtualizarProfissional.hidAcao.value = botao.id;
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

		<form bgcolor="#bbbcca" id="formAtualizarProfissional"
			name="AtualizarProfissional" method="post"
			action="AtualizarProfissional"><input name="hidAcao"
			type="hidden" value="" />

		<table width="90%" border="0" align="center">
			<tr>
				<td colspan="2" class="tituloSecao">Dados do Profissional</td>
			</tr>
			<tr>
				<td class="tituloCampo">CNS:</td>
				<td><input name="psCns" type="text" id="psCns" tabindex="1"
					size="12" maxlength="12"
					value="${requestScope.profissionalsaude.psCns}"
					style="width: 166px" /></td>
			</tr>
			<% Profissional profissionalsaude = (Profissional)request.getAttribute("profissionalsaude" );
			
			if(profissional != null) {
			System.out.println(profissional);
			%>

			<tr>
				<td class="tituloCampo">CBO:</td>
				<td><input name="cbo_Cbo" type="text" id="cbo_Cbo" tabindex="2"
					size="12" maxlength="12" value="${profissionalsaude.cbo_Cbo}"
					style="width: 68px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nr. Conselho:</td>
				<td><input name="conselhos_conselho" type="text"
					id="conselhos_conselho" tabindex="3" size="50" maxlength="100"
					value="${profissionalsaude.conselhos_conselho} " /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Unidade:</td>
				<td><input name="unidadeSaude_usCnes" type="text"
					id="unidadeSaude_usCnes" tabindex="4" size="6" maxlength="100"
					value="${profissionalsaude.unidadeSaude_usCnes} " /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><input name="psNome" type="text" id="psNome" tabindex="5"
					size="18" maxlength="100" value="${profissionalsaude.psNome} "
					style="width: 182px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">CPF:</td>
				<td><input name="psCpf" type="text" id="psCpf" tabindex="6"
					size="18" maxlength="100" value="${profissionalsaude.psCpf} "
					style="width: 354px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Telefone:</td>
				<td><input name="psTelefone" type="text" id="psTelefone"
					tabindex="7" size="18" maxlength="100"
					value="${profissionalsaude.psTelefone} " style="width: 353px" /></td>
			</tr>
			<table width="90%" border="0" align="center">

				<tr>
					<td>
					<div align="center">
					<p><br />
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
				<input name="atualizarProfissional" type="submit"
					id="atualizarProfissional" tabindex="24" onclick="setarAcao(this);"
					value="Atualizar"> <input name="detalharProfissional"
					type="submit" id="detalharProfissional" tabindex="25"
					onclick="setarAcao(this);" value="Detalhar" /></p>
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
