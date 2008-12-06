<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.UnidadeSaude"%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.CadastrarUnidadeSaude"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>

<%
	ArrayList mensagens = (ArrayList) request.getAttribute("mensagens");
	ArrayList erros = (ArrayList) request.getAttribute("erros");
%>

<jsp:useBean id="unidadeSaude" class="modelo.entidades.UnidadeSaude"
	scope="request">
</jsp:useBean>


<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Cadastrar Unidade de Saude</title>
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
<script language="JavaScript" type="text/javascript">
function setarAcao(botao){
    document.formCadastrarUnidadeSaude.hidAcao.value = botao.id;
}
</script>

</head>

<BODY>
<DIV id="container">
<DIV class="header">
<H1><IMG alt="BPA Digital" src="../images/logo.gif" border="0" /></H1>
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

			<TD class=padding2 vAlign=top width=221>
			<H2 class=boxcaption>Bem Vindo Fulano !</H2>
			<P class=boxbottom></P>
			</TD>


			<TD vAlign="top" width="100%">
			<TABLE cellSpacing="0" cellPadding="0" width="98%" align="center"
				border="0">
				<TBODY>
					<TR>

						<td colspan="3" valign="top">
						<p><img src="mm_spacer.gif" alt="" width="305" height="1"
							border="0"><br>
						</p>
						<jsp:scriptlet>
						if (erros != null&&!erros.isEmpty()) {
							Iterator i = erros.iterator();
						</jsp:scriptlet>
						
						<div class="erros" id="msgErros" bgcolor="#bbc023">
						<jsp:scriptlet>while (i.hasNext()) {</jsp:scriptlet> <br>
						<jsp:scriptlet>out.print(i.next());
								}</jsp:scriptlet>
						</div>
						
						<jsp:scriptlet>}</jsp:scriptlet>
						
						
						<jsp:scriptlet>
						if (mensagens != null && !mensagens.isEmpty()) {
							Iterator i = mensagens.iterator();
						</jsp:scriptlet>
						
						<div class="informacoes" id="msgSucesso"></div>
						
						<jsp:scriptlet>while (i.hasNext()) {</jsp:scriptlet> <br>
						<jsp:scriptlet>out.print(i.next());
								}</jsp:scriptlet>
						</div>
						
						<jsp:scriptlet>}</jsp:scriptlet>


						<form bgcolor="#bbbcca" id="formCadastrarUnidadeSaude"
							name="formCadastrarUnidadeSaude" method="post"
							action="CadastrarUnidadeSaude"><input name="hidAcao"
							type="hidden" value="">

						<table width="90%" border="0" align="center">
							<tr>
								<td colspan="2" class="tituloSecao" color="">Cadastrar
								Unidade de Saude</td>
							</tr>
							<tr>
								<br />
								<br />
							<tr>
								<td class="tituloCampo">CNES:</td>
								<td><input name="usCnes" type="text" id="usCnes"
									tabindex="1" size="12" maxlength="12"
									value="${requestScope.unidadesaude.usCnes}" style="width: 99px" /></td>
							</tr>
							<tr>
								<td class="tituloCampo">CIDADE:</td>
								<td><input name="cidade_ciSigla" type="text"
									id="cidade_ciSigla" tabindex="2" size="12" maxlength="12"
									value="${unidadesaude.cidade_ciSigla}" style="width: 372px" /></td>
							</tr>
							<tr>
								<td class="tituloCampo">Nome:</td>
								<td><input name="usNome" type="text" id="usNome"
									tabindex="3" size="50" maxlength="100"
									value="${unidadesaude.usNome} " /></td>
							</tr>
							<tr>
								<td class="tituloCampo">Sigla:</td>
								<td><input name="usSigla" type="text" id="usSigla"
									tabindex="4" size="6" maxlength="100"
									value="${unidadesaude.usSigla} " style="width: 173px" /></td>
							</tr>
							<tr>
								<td class="tituloCampo">CNPJ:</td>
								<td><input name="usCnpj" type="text" id="usCnpj"
									tabindex="5" size="18" maxlength="100"
									value="${unidadesaude.usCnpj} " style="width: 172px" /></td>
							</tr>
							<tr>
								<td class="tituloCampo">Razão Social:</td>
								<td><input name="usRazaoSocial" type="text"
									id="usRazaoSocial" tabindex="6" size="18" maxlength="100"
									value="${unidadesaude.usRazaoSocial} " style="width: 354px" /></td>
							</tr>
							<tr>
								<td class="tituloCampo">Endereço:</td>
								<td><input name="usEndereco" type="text" id="usEndereco"
									tabindex="7" size="18" maxlength="100"
									value="${unidadesaude.usEndereco} " style="width: 353px" /></td>
							</tr>
						</table>
						<table width="90%" border="0" align="center">

							<tr>
								<td>
								<div align="center">
								<p><br>
								<input name="adicionarUnidadeSaude" type="submit"
									id="adicionarUnidadeSaude" tabindex="24"
									onclick="setarAcao(this);" value="Adicionar">
									</p>
								</div>
								</td>
							</tr>
						</table>
						<br>
						</form>
						</td>
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
							<LI><small><a href="cadastrarUS.jsp">Cadastrar
							Unidade</a></small></LI>
							<LI><A href="consultarUS.jsp"><small>Consultar
							Unidade</small></A></LI>
							<LI><A href="atualizarUS.jsp"><small>Atualizar
							Unidade</small></A></LI>
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
