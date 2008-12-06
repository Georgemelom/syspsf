<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.FichaDiaria"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.CadastrarFichaDiaria"%>

<%
	ArrayList mensagens = (ArrayList) request.getAttribute("mensagens");
	ArrayList erros = (ArrayList) request.getAttribute("erros");
%>

<jsp:useBean id="fichaDiaria" class="modelo.entidades.FichaDiaria"
	scope="request">
</jsp:useBean>


<html xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<HEAD>
<TITLE>BPAD</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="../arquivos/style.css" type=text/css rel=stylesheet>
<META content="BPA - BOLETIM DE PRODUÇÃO AMBULATORIAL" name=description>
<META content="BPAD" name=author>
<META content="Copyright (c) 2008 by YOUR NAME. All rights reserved!"
	name=copyright>
<META content="MSHTML 6.00.6000.16705" name=GENERATOR>
</HEAD>

<BODY>
<DIV id=container>
<DIV class=header>
<H1><IMG alt="BPA Digital" src="../images/logo.gif" border=0></H1>
</DIV>
<DIV class=bar><SPAN></SPAN>
<UL>
	<LI><A class=common href="home.jsp">Home</A></LI>
	<LI><A class=common href="unidadeDeSaude.jsp">Unidade de Saude</A></LI>
	<LI><A class=common href="profissional.jsp">Profissional de
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


						<form bgcolor="#bbbcca" id="formAtualizarFichaDiaria"
							name="formAtualizarFichaDiaria" method="post"
							action="AtualizarFichaDiaria"><input name="hidAcao"
							type="hidden" value="">

						<table width="90%" border="0" align="center">
							<tr>
								<td colspan="2" class="tituloSecao" color="">Dados da Ficha
								Diaria</td>
							</tr>
							<tr>
								<td class="tituloCampo">Data Produção:</td>
								<td><input name="fdDtProducao" type="text"
									id="fdDtProducao" tabindex="1" size="12" maxlength="10"
									value="<%SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			if (fichaDiaria != null && fichaDiaria.getFdDtProducao() != null) {
				out.print(formato.format(fichaDiaria.getFdDtProducao()));
			}%>" />

								</td>
							</tr>


							<tr>
								<td class="tituloCampo">Ficha:</td>
								<td><input name="fdID" type="text" id="fdID" tabindex="2"
									size="100" maxlength="12" value="${fichaDiaria.fdID}"
									style="width: 359px"></td>
							</tr>
							<jsp:scriptlet>FichaDiaria fichadiaria = (FichaDiaria) request
					.getAttribute("fichadiaria");

			if (fichaDiaria != null) {</jsp:scriptlet>


							<tr>
								<td class="tituloCampo">
								<p>Procedimento:</p>
								</td>
								<td><input name="procedimentos_proCodigo" type="text"
									id="procedimentos_proCodigo" tabindex="3" size="50"
									maxlength="100" value="${fichaDiaria.procedimentos_proCodigo} " /></td>
							</tr>
							<tr>
								<td class="tituloCampo">
								<p>Paciente:</p>
								</td>
								<td><input name="pacientes_pcCns" type="text"
									id="pacientes_pcCns" tabindex="4" size="6" maxlength="100"
									value="${fichaDiaria.pacientes_pcCns} " style="width: 181px" /></td>
							</tr>
							<tr>
								<td class="tituloCampo">
								<p>Profissional:</p>
								</td>
								<td><input name="profissionalSaude_psCns" type="text"
									id="profissionalSaude_psCns" tabindex="5" size="18"
									maxlength="100" value="${fichaDiaria.profissionalSaude_psCns} "
									style="width: 182px" /></td>
							</tr>
							<jsp:scriptlet>}</jsp:scriptlet>

						</table>
						<table width="90%" border="0" align="center">

							<tr>
								<td>
								<div align="center">
								<p><br>
								<input name="atualizarFichaDiaria" type="submit"
									id="atualizarFichaDiaria" tabindex="24" onclick="setarAcao(this);"
									value="Atualizar"> <input name="detalharFichaDiaria"
									type="submit" id="detalharFichaDiaria" tabindex="25"
									onclick="setarAcao(this);" value="Detalhar"></p>
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
						<LI><small><a href="cadastrarFD.jsp">Cadastrar Ficha Diaria</a></small></LI>
						<LI><A href="consultarFD.jsp"><small>Consultar Ficha Diaria</small></A></LI>
						<LI><A href="atualizarFD.jsp"><small>Atualizar Ficha Diaria</small></A></LI>
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

