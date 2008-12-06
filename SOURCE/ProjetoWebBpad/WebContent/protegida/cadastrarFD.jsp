<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<script language="JavaScript" src="../arquivos/calendar_us.js"></script>

</HEAD>

<BODY>
<DIV id=container>
<DIV class=header>
<H1><IMG alt="BPA Digital" src="../images/logo.gif" border=0></H1>
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


<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
	<TR>
		<TD class=padding2 vAlign=top width=221>
		<H2 class=boxcaption>Bem Vindo Fulano !</H2>
		<P class=boxbottom></P>
		</TD>

		<TD vAlign="top">
		<p></p>
		<div class="conteudo"><script language="JavaScript"
			type="text/javascript">
			function setarAcao(botao){
				document.formCadastrarFichaDiaria.hidAcao.value = botao.id;
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


								<form bgcolor="#bbbcca" id="formCadastrarFichaDiaria"
									name="formCadastrarFichaDiaria" method="post"
									action="CadastrarFichaDiaria"><input name="hidAcao"
									type="hidden" value="">

								<table width="90%" border="0" align="center">
									<tr>
										<td colspan="2" class="tituloSecao"><big>Dados da
										Ficha Diaria</big></td>
									</tr>
									<tr>
										<td class="tituloCampo" style="width: 193px">Data
										Produção:</td>
										<td><input name="fdDtProducao" type="text"
											id="fdDtProducao" tabindex="1" size="12" maxlength="10"
											value="<%SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			if (fichaDiaria != null && fichaDiaria.getFdDtProducao() != null) {
				out.print(formato.format(fichaDiaria.getFdDtProducao()));
			}%>" />
			<script language="JavaScript">
				new tcal ({ 'forname' :'formCadastrarFichaDiaria', 'controlname':'fdDtProducao'});
			</script>

										</td>
									</tr>
									<tr>
										<td class="tituloCampo">Ficha:</td>
										<td><input name="fdID" type="text" id="fdID" tabindex="1"
											size="12" maxlength="12" value="${fichadiaria.fdID}"
											style="width: 101px" /></td>
									</tr>

									<tr>
										<td class="tituloCampo">Procedimento:</td>
										<td>
											<select name="procedimentos_proCodigo" id="procedimentos_proCodigo" style="height: 28px; width: 190px">
											<c:forEach var="proc" items="${listaProcediemnto}" >
											 
												<option value="${proc.proCodigo}"> ${proc.proDescricao} </option>
											</c:forEach>
											</select>
											
										</td>
									</tr>
									<tr>
										<td class="tituloCampo">Paciente:</td>
										<td>
											
										<select name="pacientes_pcCns" id="pacientes_pcCns" style="height: 28px; width: 190px">
											<c:forEach var="pc" items="${listaPaciente}" >
											 
												<option value="${pc.pcCns}"> ${pc.pcNome}</option>
											</c:forEach>
										</select>
										</td>
									</tr>
									<tr>
										<td class="tituloCampo">Profissional:</td>
										<td>
											<select name="profissionalSaude_psCns" id="profissionalSaude_psCns" style="height: 28px; width: 190px">
											<c:forEach var="ps" items="${listaProfissional}" >
											 
												<option value="${ps.psCns}"> ${ps.psNome}</option>
											</c:forEach>
										</select>
											</td>
									</tr>
								</table>
								<table width="90%" border="0" align="center">

									<tr>
										<td></td>
										<td>
										<div align="center"><br>
										<input name="adicionarFichaDiaria" type="submit"
											id="adicionarFichaDiaria" tabindex="24"
											onclick="setarAcao(this);" value="Adicionar"></div>

										</td>
										<td>
										
										</td>
										<td></td>
									</tr>
								</table>
								<br>
								</form>
								<p>&nbsp;</p>
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
						<LI><small><a href="CadastrarFichaDiaria?hidAcao=montar">Cadastrar
						Ficha Diaria</a></small></LI>
						<LI><A href="consultarFD.jsp"><small>Consultar
						Ficha Diaria</small></A></LI>
						<LI><A href="atualizarFD.jsp"><small>Atualizar
						Ficha Diaria</small></A></LI>
					</UL>
					</DIV>
					<P class=boxbottom></P>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		</TD>
	</TR>
	
</TABLE>
<div class="footer">
<h3>&nbsp;</h3>
<p>© Copyright <a title="BPA Digital"
	href="http://www.bpad.com/testrun/">BPA </a>2008 - All rights reserved.</p>
</div>
</BODY>
</HTML>

