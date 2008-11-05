<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>

<%
	ArrayList<Paciente> pacienteEncontrado = (ArrayList) request
			.getAttribute("pcEncontrado");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="modelo.entidades.Paciente"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Listar Pacientes</title>
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
function setarAcao(botao){document.formConsultarPaciente.hidAcao.value = botao.id;
}
</script>

</head>
<body>
<table border="0" cellspacing="0" cellpadding="0">

	<tr>
		<td colspan="3" valign="top">
		<form bgcolor="#bbbcca" id="formConsultarPaciente" name="formConsultarPaciente"
			method="post" action="ConsultarPaciente"><input
			name="hidAcao" type="hidden" value="" />
		<table width="90%" border="0" align="center">
			<tr>
				<td colspan="2" class="tituloSecao">Dados do Paciente</td>
			</tr>
<tr>
				<td class="tituloCampo">CNS:</td>
				<td><input name="pcCns" type="text" id="pcCns" tabindex="1"
					size="12" maxlength="12" value="${Paciente.pcCns}"
					style="width: 166px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Nome:</td>
				<td><input name="pcNome" type="text" id="pcNome" tabindex="3"
					size="50" maxlength="100" value="${Paciente.pcNome} " /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Sexo:</td>
				<td><input name="pcSexo" type="text" id="pcSexo" tabindex="5"
					size="18" maxlength="100" value="${Paciente.pcSexo} "
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
			if (pacienteEncontrado != null) {
		%><br />
		<br />

		<table width="90%" border="1" align="center" class="tituloCampo">
			<caption><%=pacienteEncontrado.size()%> Pacientes
			Encontrados</caption>
			<tr class="tituloSecao">
				<td width="10%"><span class="style3">CNS</span></td>
				<td width="51%"><span class="style3">Nome</span></td>
				<td width="28%"><span class="style3">Data Nascimento</span></td>
				<td width="11%"><span class="style3">Sexo</span></td>
				<td width="11%"><span class="style3">Endereço</span></td>
			</tr>


			<br />

			<%
        				Iterator i = pacienteEncontrado.iterator();
        					while (i.hasNext()) {
        						Paciente p = (Paciente) i.next();
        			%>
			<tr>
				<td>
				<div align="left"><span class="style5"> <span
					class="style5"><a
					href="AtualizarPaciente?hidAcao=detalharPaciente&pcCns=<%=p.getPcCns()%>"><%=p.getPcCns()%></a></span>
				</span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getPcNome()%>
				</span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getPcDataNascimento()%></span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getPcSexo()%></span></div>
				</td>
				<td>
				<div align="left"><span class="style5"><%=p.getPcEndereco()%></span></div>
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
