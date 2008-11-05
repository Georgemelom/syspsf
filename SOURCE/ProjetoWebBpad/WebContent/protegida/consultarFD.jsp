<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<FichaDiaria> fichaDiariaEncontradas = (ArrayList) request
			.getAttribute("fdEncontrada");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="modelo.entidades.FichaDiaria"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Listar Fichas Diarias</title>
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
function setarAcao(botao){document.formConsultarFichaDiaria.hidAcao.value = botao.id;
}
</script>

</head>
<body>
<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan="3" valign="top">
		<form bgcolor="#bbbcca" id="formConsultarFichaDiaria" name="formConsultarFichaDiaria"
			method="post" action="ConsultarFichaDiaria"><input
			name="hidAcao" type="hidden" value="" />
		<table width="90%" border="0" align="center">
			<tr>
				<td colspan="2" class="tituloSecao">Dados da Ficha</td>
			</tr>
<tr>
				<td class="tituloCampo">Ficha:</td>
				<td><input name="fdID" type="text" id="fdID" tabindex="1"
					size="12" maxlength="12" value="${fichadiaria.fdID}"
					style="width: 166px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><input name="folha_FoID" type="text" id="folha_FoID" tabindex="3"
					size="50" maxlength="12" value="${fichadiaria.folha_FoID} " /></td>
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
			if (fichaDiariaEncontradas != null) {
		%><br />
		<br />

		<table width="90%" border="1" align="center" class="tituloCampo">
			<caption><%=fichaDiariaEncontradas.size()%> Fichas Encontradas</caption>
			<tr class="tituloSecao">
				<td width="10%"><span class="style3">Ficha</span></td>
				<td width="28%"><span class="style3">Folha</span></td>
				<td width="51%"><span class="style3">Procedimento</span></td>
				<td width="28%"><span class="style3">Paciente</span></td>
				<td width="11%"><span class="style3">Profissional</span></td>
			</tr>
			<br />

			<%
        				Iterator i = fichaDiariaEncontradas.iterator();
        					while (i.hasNext()) {
        						FichaDiaria p = (FichaDiaria) i.next();
        			%>
			<tr>
				<td>
				<div align="left"><span class="style5"> <span
					class="style5"><a
					href="AtualizarFichaDiaria?hidAcao=detalharFicha&fdID=<%=p.getFdID()%>"><%=p.getFdID()%></a></span>
				</span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getFolha_FoID()%>
				</span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getProcedimentos_proCodigo()%></span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getPacientes_pcCns()%></span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getProfissionalSaude_psCns()%></span></div>
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
