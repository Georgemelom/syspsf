<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.Profissional"%>


<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.CadastrarProfissional"%><html
	xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>

<%
	ArrayList mensagens = (ArrayList) request.getAttribute("mensagens");
	ArrayList erros = (ArrayList) request.getAttribute("erros");
%>

<jsp:useBean id="profissional" class="modelo.entidades.Profissional"
	scope="request">
</jsp:useBean>


<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Atualizar Profissional</title>
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
    document.formAtualizarProfissional.hidAcao.value = botao.id;
}
</script>
</head>

<BODY>
<DIV id=container>
<DIV class=header>
<H1><IMG alt="BPA Digital" src="../images/logo.gif" border=0></H1>
</DIV>
<DIV class=bar><SPAN></SPAN>
<UL>
	<LI><A class=common href="home.jsp">Home</A></LI>
	<LI><A class=common href="unidadeDeSaude.jsp" style="width: 138px">Unidade de Saude</A></LI>
	<LI><A class=common href="profissional.jsp" style="width: 180px">Profissional de
	Saude</A></LI>
	<LI><A class=common href="paciente.jsp">Paciente</A></LI>
	<LI><A class=common href="fichaDiaria.jsp">Boletim</A></LI>
	<LI><A class=common href="relatorios.jsp">Relatorios</A></LI>
</UL>
</DIV>


<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
	<TR>
		<TD class=padding vAlign=top width=221>
		<h2 class="boxcaption">Bem Vindo Fulano!</h2>
		<h2 class="boxbottom">
		</TD>
		<TD vAlign="top">
		<p></p>
		<div class="conteudo">
		
		
		<script language="JavaScript" type="text/javascript">
			function setarAcao(botao){
    			document.formAtualizarFichaDiaria.hidAcao.value = botao.id;
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
						<p><img src="mm_spacer.gif" alt="" width="305" height="1"
							border="0"><br>
						</p>
						<jsp:scriptlet>if (erros != null&&!erros.isEmpty()) {
				Iterator i = erros.iterator();</jsp:scriptlet>
						<div class="erros" id="msgErros" bgcolor="#bbc023">
						<jsp:scriptlet>while (i.hasNext()) {</jsp:scriptlet> <br>
						<jsp:scriptlet>out.print(i.next());
				}</jsp:scriptlet>
						</div>
						<jsp:scriptlet>}</jsp:scriptlet>
						<div class="informacoes" id="msgSucesso"></div>


						<form bgcolor="#bbbcca" id="formAtualizarProfissional"
							name="formAtualizarProfissional" method="post"
							action="AtualizarProfissional"><input name="hidAcao"
							type="hidden" value="">

						<table width="90%" border="0" align="center">
							<tr>
								<td colspan="2" class="tituloSecao" color=""><big>Dados do Profissional</big></td>
							</tr>
							<tr><br/><br/>
				<td class="tituloCampo" style="width: 97px">CNS:</td>
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
					value="${profissionalsaude.conselhos_conselho} " style="width: 183px"/></td>
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
					style="width: 181px" /></td>
			</tr>
			<tr>
				<td class="tituloCampo">Telefone:</td>
				<td><input name="psTelefone" type="text" id="psTelefone"
					tabindex="7" size="18" maxlength="100"
					value="${profissionalsaude.psTelefone} " style="width: 182px" /></td>
			</tr>							<jsp:scriptlet>}</jsp:scriptlet>

						</table>
						<table width="90%" border="0" align="center">

							<tr>
								<td>
								<div align="center">
								<p><br>
								<input name="atualizarProfissional" type="submit"
									id="atualizarProfissional" tabindex="24" onclick="setarAcao(this);"
									value="Atualizar"> <input name="detalharProfissional"
									type="submit" id="detalharProfissional" tabindex="25"
									onclick="setarAcao(this);" value="Detalhar"></p>
								</div>
								</td>
							</tr>
						</table>
						<br>
						</form>						<p>&nbsp;</p>
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


		</div>
		</TD>

		<TD class=padding2 vAlign=top width=221>
		<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
			<TBODY>
				<TR>
					<TD class=padding vAlign=top width=221><!--SubMenu em ajax-->
					<H2 class=boxcaption>SubMenu</H2>
					<DIV class=box>
					<UL>
						<LI><small><a href="cadastrarPS.jsp">Cadastrar Profissional</a></small></LI>
						<LI><A href="consultarPS.jsp"><small>Consultar Profissional</small></A></LI>
						<LI><A href="atualizarPS.jsp"><small>Atualizar Profissional</small></A></LI>
					</UL>
					</DIV>
					<P class=boxbottom></P>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		</TD>
	</TR>
	</DIV>
</TABLE>
<div class="footer">
<h3>&nbsp;</h3>
<p>© Copyright <a title="BPA Digital"
	href="http://www.bpad.com/testrun/">BPA </a>2008 - All rights reserved.</p>
</div>
</BODY>
</HTML>

