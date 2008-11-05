<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.UnidadeSaude"%>


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

<jsp:useBean id="unidadeSaude" class="modelo.entidades.UnidadeSaude"
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
    document.formAtualizarUnidadeSaude.hidAcao.value = botao.id;
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
		<form bgcolor="#bbbcca" id="formAtualizarUnidadeSaude" name="AtualizarUnidadeSaude"
			method="post" action="AtualizarUnidadeSaude">
			<input name="hidAcao" type="hidden" value="" />

		<table width="90%" border="0" align="center">
			<tr>
				<td colspan="2" class="tituloSecao" color>Dados da Unidade</td>
			</tr>
			<tr>
				<td class="tituloCampo">CNES:</td>
				<td><input name="usCnes" type="text" id="usCnes" tabindex="1"
					size="12" maxlength="12" value="${requestScope.unidadesaude.usCnes}"
					style="width: 166px" /></td>
			</tr>
			<% UnidadeSaude unidadesaude = (UnidadeSaude)request.getAttribute("unidadesaude" );
			
			if(unidadeSaude != null) {
			System.out.println(unidadeSaude);
			%>
			
			<tr>
				<td class="tituloCampo">CIDADE:</td>
				<td><input name="cidade_ciSigla" type="text"
					id="cidade_ciSigla" tabindex="2" size="12" maxlength="12"
					value="${unidadesaude.cidade_ciSigla}" style="width: 68px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><input name="usNome" type="text" id="usNome" tabindex="3"
					size="50" maxlength="100" value="${unidadesaude.usNome} " /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Sigla:</td>
				<td><input name="usSigla" type="text" id="usSigla" tabindex="4"
					size="6" maxlength="100" value="${unidadesaude.usSigla} " /></td>
			</tr>
			<tr>
				<td class="tituloCampo">CNPJ:</td>
				<td><input name="usCnpj" type="text" id="usCnpj" tabindex="5"
					size="18" maxlength="100" value="${unidadesaude.usCnpj} "
					style="width: 182px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Razão Social:</td>
				<td><input name="usRazaoSocial" type="text" id="usRazaoSocial" tabindex="6"
					size="18" maxlength="100" value="${unidadesaude.usRazaoSocial} "
					style="width: 354px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Endereço:</td>
				<td><input name="usEndereco" type="text" id="usEndereco"
					tabindex="7" size="18" maxlength="100"
					value="${unidadesaude.usEndereco} " style="width: 353px" /></td>
			</tr>
					<table width="90%" border="0" align="center">

			<tr>
				<td>
				<div align="center">
				<p><br />
				<input name="atualizarUnidade" type="submit" id="atualizarUnidade"
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
				<input name="detalharUnidade" type="submit" id="detalharUnidade"
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
