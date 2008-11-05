<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<UnidadeSaude> unidadeSaudeEncontradas = (ArrayList) request
			.getAttribute("usEncontrada");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="modelo.entidades.UnidadeSaude"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Listar UnidadeSaudes</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="mm_spa.css" type="text/css" />
<style type="text/css">
<!--
.style2 {
	font-size: 16px
}

.style3 {
	font-size: 14px;
	font-weight: bold;
}

.style4 {
	font-size: 14px
}

.style5 {
	font-size: 12px
}
-->
</style>
<script language="JavaScript" type="text/javascript">
function setarAcao(botao){document.formConsultarUnidadeSaude.hidAcao.value = botao.id;
}
</script>

</head>
<body>
<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan="3" valign="top">
		<form bgcolor="#bbbcca" id="formConsultarUnidadeSaude" name="formConsultarUnidadeSaude"
			method="post" action="ConsultarUnidadeSaude"><input
			name="hidAcao" type="hidden" value="" />
		<table width="90%" border="0" align="center">
			<tr>
				<td colspan="2" class="tituloSecao">Dados da Unidade</td>
			</tr>
<tr>
				<td class="tituloCampo">CNES:</td>
				<td><input name="usCnes" type="text" id="usCnes" tabindex="1"
					size="12" maxlength="12" value="${unidadesaude.usCnes}"
					style="width: 166px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><input name="usNome" type="text" id="usNome" tabindex="3"
					size="50" maxlength="100" value="${unidadesaude.usNome} " /></td>
			</tr>
			<tr>
				<td class="tituloCampo">CNPJ:</td>
				<td><input name="usCnpj" type="text" id="usCnpj" tabindex="5"
					size="18" maxlength="100" value="${unidadesaude.usCnpj} "
					style="width: 182px" /></td>
			</tr>
		</table>
		<table width="90%" border="0" align="center">

			<tr>
				<td>
				<div align="center">
				<p><br />

			<td style="width: 119px" align="center"><input name="listar" type="submit" id="listar" tabindex="24" onclick="setarAcao(this);" value="Listar" /></td>
			</div>
				</td>
			</tr>
		</table>

		<%
			if (unidadeSaudeEncontradas != null) {
		%><br />
		<br />

		<table width="90%" border="1" align="center" class="tituloCampo">
			<caption><%=unidadeSaudeEncontradas.size()%> Unidades
			Encontradas</caption>
			<tr class="tituloSecao">
				<td width="10%"><span class="style3">CNES</span></td>
				<td width="28%"><span class="style3">Cidade</span></td>
				<td width="51%"><span class="style3">Nome</span></td>
				<td width="28%"><span class="style3">Sgila</span></td>
				<td width="11%"><span class="style3">CNPJ</span></td>
				<td width="11%"><span class="style3">Razao Social</span></td>
				<td width="11%"><span class="style3">Endereço</span></td>
			</tr>


			<br />

			<%
        				Iterator i = unidadeSaudeEncontradas.iterator();
        					while (i.hasNext()) {
        						UnidadeSaude p = (UnidadeSaude) i.next();
        			%>
			<tr>
				<td>
				<div align="left"><span class="style5"> <span
					class="style5"><a
					href="AtualizarUnidadeSaude?hidAcao=detalharUnidade&usCnes=<%=p.getUsCnes()%>"><%=p.getUsCnes()%></a></span>
				</span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getCidade_ciSigla()%>
				</span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getUsNome()%></span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getUsSigla()%></span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getUsCnpj()%></span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getUsRazaoSocial()%></span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getUsEndereco()%></span></div>
				</td>
			</tr>
			<%
				}
			%>
		</table>
</table>
<%
		}
	%>
<br />
<br />
</form>
<p>&nbsp;</p>
</td>
<td width="83">&nbsp;</td>
</tr>
<tr>
	<td width="174">&nbsp;</td>
	<td width="50">&nbsp;</td>
	<td width="193">&nbsp;</td>
	<td width="27">&nbsp;</td>
	<td width="390">&nbsp;</td>
	<td width="83">&nbsp;</td>
</tr>
</table>
</body>
</html>
