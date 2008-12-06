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
	ArrayList mensagens = (ArrayList) request.getAttribute("mensagens");
	ArrayList erros = (ArrayList) request.getAttribute("erros");
%>

<jsp:useBean id="paciente" class="modelo.entidades.Paciente"
	scope="request">
</jsp:useBean>


<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Cadastrar Paciente</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="mm_spa.css" type="text/css" />
<LINK href="../arquivos/style.css" type=text/css rel=stylesheet>
<style type="text/css">
<!--
.style2 {
	font-size: 16px
}
-->
</style>

</head>

<BODY>
<DIV id="container">
<DIV class="header">
<H1><IMG alt="BPA Digital" src="../images/logo.gif" border="0" /><A /></H1>
</DIV>
<DIV class=bar><SPAN></SPAN>
<UL>
	<LI><A class=common href="home.jsp">Home</A></LI>
	<LI><A class=common href="unidadeDeSaude.jsp" style="width: 146px">Unidade
	de Saude</A></LI>
	<LI><A class=common href="profissional.jsp" style="width: 163px">Profissional
	de Saude</A></LI>
	<LI><A class=common href="paciente.jsp">Paciente</A></LI>
	<LI><A class=common href="fichaDiaria.jsp">Boletim</A></LI>
	<LI><A class=common href="relatorios.jsp">Relatorios</A></LI>
</UL>
</DIV>


<div id="submenu">
<TABLE cellSpacing="0" cellPadding="0" width="100%" border="0">
	<TBODY>
		<TR>
			<TD class="padding" vAlign="top" width="221">

			<h2 class="boxcaption">Bem Vindo Fulano !</h2>

			<h2 class="boxbottom"></h2>
			</TD>
			<TD vAlign="top" width="100%"><script language="JavaScript"
				type="text/javascript">
function setarAcao(botao){
    document.formAtalizarPaciente.hidAcao.value = botao.id;
}
</script>

			<TABLE cellSpacing="0" cellPadding="0" width="100%" border="0">
				<TBODY>
					<TR>

						<TD vAlign="top" width="100%">
						<TABLE cellSpacing="0" cellPadding="0" width="98%" align="center"
							border="0">
							<TBODY>
								<TR>

									<td colspan="3" valign="top">
									<jsp:scriptlet>if (erros != null&&!erros.isEmpty()) {
				Iterator i = erros.iterator();</jsp:scriptlet>
									<div class="erros" id="msgErros" bgcolor="#bbc023">
									<jsp:scriptlet>while (i.hasNext()) {</jsp:scriptlet> <br>
									<jsp:scriptlet>out.print(i.next());
				}</jsp:scriptlet>
									</div>
									<jsp:scriptlet>}</jsp:scriptlet>
									<div class="informacoes" id="msgSucesso"></div>


									<form bgcolor="#bbbcca" id="formAtualizarPaciente"
										name="formAtualizarPaciente" method="post"
										action="AtualizarPaciente"><input name="hidAcao"
										type="hidden" value="">

									<table width="90%" border="0" align="center">
										<tr>
											<td colspan="2" class="tituloSecao" color="">Dados do
											Paciente</td>
										</tr>
										<tr>
											<td class="tituloCampo">CNS:</td>
											<td><input name="pcCns" type="text" id="pcCns"
												tabindex="1" size="12" maxlength="12"
												value="${paciente.pcCns}" style="width: 166px"></td>
										</tr>
										<tr>
											<td class="tituloCampo">Nome:</td>
											<td><input name="pcNome" type="text" id="pcNome"
												tabindex="2" size="100" maxlength="12"
												value="${paciente.pcNome}" style="width: 359px"></td>
										</tr>
										<tr>
											<td class="tituloCampo">Data de Nascimento:</td>
											<td><input name="pcDataNascimento" type="text"
												id="pcDataNascimento" tabindex="2" size="12" maxlength="10"
												value='<%SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			if (paciente != null && paciente.getPcDataNascimento() != null) {
				out.print(formato.format(paciente.getPcDataNascimento()));
			}%>'>
											</td>
										</tr>
										<tr>
											<td class="tituloCampo">Sexo:</td>
											<td><input name="pcSexo" type="radio" value="1"
												tabindex="3"
												<%if (paciente.getPcSexo() != null
					&& paciente.getPcSexo().equals("1")) {
				out.print("checked='checked'");
			}%>>Masculino
											<input name="pcSexo" type="radio" tabindex="3" value="2"
												<%if (paciente.getPcSexo() != null
					&& paciente.getPcSexo().equals("2")) {
				out.print("checked='checked'");
			}%>>
											Feminino</td>
										</tr>
										<tr>
											<td class="tituloCampo">Endereço:</td>
											<td><input name="pcEndereco" type="text" id="pcEndereco"
												tabindex="6" size="18" maxlength="100"
												value="${paciente.pcEndereco} " style="width: 354px"></td>
										</tr>

									</table>
									<table width="90%" border="0" align="center">

										<tr>
											<td>
											<div align="center">
											<p><br>
											<input name="atualizarPaciente" type="submit"
												id="atualizarPaciente" tabindex="24"
												onclick="setarAcao(this);" value="Atualizar"> <input
												name="detalharPaciente" type="submit" id="detalharPaciente"
												tabindex="25" onclick="setarAcao(this);" value="Detalhar"></p>
											</div>
											</td>
										</tr>
									</table>
									<br>
									</form>
									<p>&nbsp;</p>
									</td>
									<BR />
									<BR />
									<BR />

								</TR>
							</TBODY>
						</TABLE>
						<BR />
						</TD>




					</TR>
				</TBODY>
			</TABLE>

			<BR />
			</TD>



			<TD class="padding2" vAlign="top" width="221"> 
			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
				<TBODY>
					<TR>
						<TD class=padding vAlign=top width=221><!--SubMenu em ajax-->
						<H2 class=boxcaption>SubMenu</H2>
						<DIV class=box>
						<UL>
							<LI><A href="cadastrarPC.jsp">Cadastrar Paciente</A></LI>
							<LI><A href="consultarPC.jsp">Consultar Paciente</A></LI>
							<LI><A href="atualizarPC.jsp">Atualizar Paciente</A></LI>
						</UL>

						</DIV>
						<P class=boxbottom></P>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
	</TBODY>
</TABLE>
</div>
<BR />
<DIV class="footer">
<H3> </H3>
<P>© Copyright <A title="BPA Digital"
	href="http://www.bpad.com/testrun/">BPA </A>2008 - All rights reserved.</P>
</DIV>
<BR />
</DIV>
</BODY

<body>
<table border="0" cellspacing="0" cellpadding="0">

	<tr bgcolor="#FF9900">

	</tr>

	<tr>
		
	</tr>
	<tr>
	</tr>
</table>
</body>






</html>
