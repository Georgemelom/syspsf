<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.FichaDiaria"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.CadastrarFichaDiaria"%>

<%
	ArrayList<FichaDiaria> fichaDiariaEncontradas = (ArrayList) request
			.getAttribute("fdEncontrada");
%>

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
		<div class="conteudo"><script language="JavaScript"
			type="text/javascript">
			function setarAcao(botao){
    		document.formConsultarFichaDiaria.hidAcao.value = botao.id;
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


								<form id="formConsultarFichaDiaria"
									name="formConsultarFichaDiaria" method="post"
									action="ConsultarFichaDiaria"><input name="hidAcao"
									type="hidden" value="" />
								<table width="90%" border="0" align="center">
									<tr>
										<td colspan="2" class="tituloSecao">
										<p align="center"><big>Dados da Ficha</big></p>
										</td>
									</tr>
									<tr>
										<td></td>
									</tr>
									<tr>
										<td class="tituloCampo" style="width: 185px">Data
										Produção:</td>
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
										<td><input name="fdID" type="text" id="fdID" tabindex="3"
											size="50" maxlength="12" value="${fichadiaria.fdID} "
											style="width: 99px" /></td>
									</tr>
								</table>
								<table width="90%" border="0" align="center">

									<tr>
										<td>
										<div align="center">
										<p><br />
										<td style="width: 119px" align="center"><input
											name="listar" type="submit" id="listar" tabindex="24"
											onclick="setarAcao(this);" value="Listar" /></td>
										</div>
										</td>
									</tr>
								</table>

								<%
									if (fichaDiariaEncontradas != null) {
								%><br />
								<br />

								<table width="90%" border="1" align="center" class="tituloCampo">
									<caption><%=fichaDiariaEncontradas.size()%> Fichas
									Encontradas</caption>
									<tr class="tituloSecao">
										<td width="10%" style="width: 80px"><span class="style3">Data</span></td>
										<td width="28%" style="width: 80px"><span class="style3">Ficha</span></td>
										<td width="51%" style="width: 80px"><span class="style3">Procedimento</span></td>
										<td width="28%" style="width: 80px"><span class="style3">Paciente</span></td>
										<td width="11%" style="width: 80px"><span class="style3">Profissional</span></td>
									</tr>
									<br />

									<%
										Iterator i = fichaDiariaEncontradas.iterator();
											while (i.hasNext()) {
												FichaDiaria p = (FichaDiaria) i.next();
									%>
									<tr>
										<td>
										<div align="left"><span class="style5"><a
											href="AtualizarFichaDiaria?hidAcao=detalharFichaDiaria&fdDtProducao=<%=p.getFdDtProducao()%>"><%=p.getFdDtProducao()%></a></span>

										</span></div>
										</td>
										<td>
										<div align="left"><span class="style5"><a
											href="AtualizarFichaDiaria?hidAcao=detalharFichaDiaria&fdID=<%=p.getFdID()%>"><%=p.getFdID()%></span></div>
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
								</form>
								</td>
							</TR>
						</TBODY>
					</table>
					<%
						}
					%> <br />
					<br />
					<p>&nbsp;</p>
					</td>
				</TR>
			</TBODY>
		</TABLE>
		<BR />
		</TD>
		<TD class="padding2" vAlign="top" width="221"> 
		<table cellSpacing="0" cellPadding="0" width="100%" border="0">
			<tbody>
				<tr>
					<td class="padding" vAlign="top" width="221">
					<h2 class="boxcaption">SubMenu</h2>
					<div class="box">
					<ul>
						<li><small><a href="cadastrarFD.jsp">Cadastrar
						Ficha Diaria</a></small></li>
						<li><a href="consultarFD.jsp"><small>Consultar
						Ficha Diaria</small></a></li>
						<li><a href="atualizarFD.jsp"><small>Atualizar
						Ficha Diaria</small></a></li>
					</ul>
					</div>
					<p class="boxbottom" />
					</td>
				</tr>
			</tbody>
		</table>
		</TD>
	</TR>
	</TBODY>
</TABLE>
</div>
<td class="padding2" vAlign="top" width="221"></td>
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

