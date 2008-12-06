<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.Paciente"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.CadastrarFichaDiaria"%>

<%
	ArrayList<Paciente> pacienteEncontrado = (ArrayList) request
			.getAttribute("pcEncontrado");
%>

<%
	ArrayList mensagens = (ArrayList) request.getAttribute("mensagens");
	ArrayList erros = (ArrayList) request.getAttribute("erros");
%>

<jsp:useBean id="paciente" class="modelo.entidades.Paciente"
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
		<TD class=padding vAlign=top width=221>
		<h2 class="boxcaption">Bem Vindo Fulano!</h2>
		<h2 class="boxbottom">
		</TD>
		<TD vAlign="top">
		<p></p>

		<script language="JavaScript" type="text/javascript">
function setarAcao(botao){
    document.formConsultarPaciente.hidAcao.value = botao.id;
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
								<p></p>
								<jsp:scriptlet>if (erros != null&&!erros.isEmpty()) {
				Iterator i = erros.iterator();</jsp:scriptlet>
								<div class="erros" id="msgErros" bgcolor="#bbc023">
								<jsp:scriptlet>while (i.hasNext()) {</jsp:scriptlet> <br>
								<jsp:scriptlet>out.print(i.next());
				}</jsp:scriptlet>
								</div>
								<jsp:scriptlet>}</jsp:scriptlet>
								<div class="informacoes" id="msgSucesso"></div>


								<form bgcolor="#bbbcca" id="formConsultarPaciente"
									name="formConsultarPaciente" method="post"
									action="ConsultarPaciente"><input name="hidAcao"
									type="hidden" value="" />
								<table width="90%" border="0" align="center">
									<tr>
										<td colspan="2" class="tituloSecao"><big>Dados do
										Paciente</big></td>
									</tr>
									<tr style="height: 22px"></tr>
									<tr>
										<td class="tituloCampo">CNS:</td>
										<td><input name="pcCns" type="text" id="pcCns"
											tabindex="1" size="12" maxlength="12"
											value="${Paciente.pcCns}" style="width: 166px" /></td>
									</tr>
									<tr>
										<td class="tituloCampo">Nome:</td>
										<td><input name="pcNome" type="text" id="pcNome"
											tabindex="3" size="50" maxlength="100"
											value="${Paciente.pcNome} " /></td>
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
									if (pacienteEncontrado != null) {
								%><br />
								<br />

								<table width="90%" border="1" align="center" class="tituloCampo">
									<caption><%=pacienteEncontrado.size()%> Pacientes
									Encontrados</caption>
									<tr class="tituloSecao">
										<td width="10%"><span class="style3">CNS</span></td>
										<td width="51%"><span class="style3">Nome</span></td>
										<td width="28%"><span class="style3">Data
										Nascimento</span></td>
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
										<div align="left"><span class="style5"> <span
											class="style5"><a
											href="AtualizarPaciente?hidAcao=detalharPaciente&pcNome=<%=p.getPcNome()%>"><%=p.getPcNome()%></span></div>
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
					%> <br />
					<br />
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
		<TD class="padding2" vAlign="top" width="221"> 
		<table cellSpacing="0" cellPadding="0" width="100%" border="0">
			<tbody>
				<tr>
					<TD class=padding vAlign=top width=221><!--SubMenu em ajax-->
					<H2 class=boxcaption>SubMenu</H2>
					<DIV class=box>
					<UL>
						<LI><small><A href="cadastrarPC.jsp">Cadastrar Paciente</A></small></LI>
						<LI><small><A href="consultarPC.jsp">Consultar Paciente</A></small></LI>
						<LI><small><A href="atualizarPC.jsp">Atualizar Paciente</A></small></LI>
					</UL>

					</DIV>
					<P class=boxbottom></P>
					</TD>
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

