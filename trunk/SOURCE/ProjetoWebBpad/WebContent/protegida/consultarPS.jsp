<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades.Profissional"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controlador.CadastrarFichaDiaria"%>

<%
	ArrayList<Profissional> profissionalEncontrado = (ArrayList) request
			.getAttribute("psEncontrado");
%>

<%
	ArrayList mensagens = (ArrayList) request.getAttribute("mensagens");
	ArrayList erros = (ArrayList) request.getAttribute("erros");
%>

<jsp:useBean id="profissional" class="modelo.entidades.Profissional"
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

<div class="header">
<h1><img alt="BPA Digital" src="../images/logo.gif" border="0"></h1>
</div>
<div class="bar"><span></span>
<ul>
	<li><a class="common" href="home.jsp">Home</a></li>
	<li><a class="common" href="unidadeDeSaude.jsp">Unidade de
	Saude</a></li>
	<li><a class="common" href="profissional.jsp">Profissional de
	Saude</a></li>
	<li><a class="common" href="paciente.jsp">Paciente</a></li>
	<li><a class="common" href="fichaDiaria.jsp">Boletim</a></li>
	<li><a class="common" href="relatorios.jsp">Relatorios</a></li>
</ul>
</div>


<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
	<TR>
		<TD class=padding vAlign=top width=221>
		<h2 class="boxcaption">Bem Vindo Fulano!</h2>
		<h2 class="boxbottom">
		</TD>

		<td vAlign="top">
		<p></p>
		<script language="JavaScript" type="text/javascript">
			function setarAcao(botao){
    		document.formConsultarProfissional.hidAcao.value = botao.id;
			}
		</script>

		<table cellSpacing="0" cellPadding="0" width="100%" border="0"
			style="height: 867px; width: 860px">
			<tbody>
				<tr>

					<td vAlign="top" width="100%">
					<table cellSpacing="0" cellPadding="0" width="98%" align="center"
						border="0">
						<tbody>
							<tr>

								<td vAlign="top" width="100%">
								<table cellSpacing="0" cellPadding="0" width="98%"
									align="center" border="0">
									<tbody>
										<tr>

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


											<form bgcolor="#bbbcca" id="formConsultarProfissional"
												name="formConsultarProfissional" method="post"
												action="ConsultarProfissional"><input name="hidAcao"
												type="hidden" value="">
											<table width="90%" border="0" align="center">
												<tr>
													<td colspan="2" class="tituloSecao"><big>Dados
													do Profissional</big></td>
												</tr>
												<tr>
													<td class="tituloCampo">CNS:</td>
													<td><input name="psCns" type="text" id="psCns"
														tabindex="1" size="12" maxlength="12"
														value="${profissionalsaude.psCns}" style="width: 166px"></td>
												</tr>
												<tr>
													<td class="tituloCampo">Nome:</td>
													<td><input name="psNome" type="text" id="psNome"
														tabindex="3" size="50" maxlength="100"
														value="${profissionalsaude.psNome} "></td>
												</tr>
												<tr>
													<td class="tituloCampo">CPF:</td>
													<td><input name="psCpf" type="text" id="psCpf"
														tabindex="5" size="18" maxlength="100"
														value="${profissionalsaude.psCpf} " style="width: 182px"></td>
												</tr>
											</table>
											<table width="90%" border="0" align="center">

												<tr>
													<td>
													<div align="center">
													<p><br>
													</p>
													</div>
													</td>
													<td style="width: 119px" align="center"><input
														name="listar" type="submit" id="listar" tabindex="24"
														onclick="setarAcao(this);" value="Listar"></td>
													<div></div>
													<td></td>
												</tr>
											</table>

											<%
							if (profissionalEncontrado != null) {
						%><br>
											<br>

											<table width="90%" border="1" align="center"
												class="tituloCampo">
												<caption><%=profissionalEncontrado.size()%>Profissionais
												Encontrados</caption>
												<tr class="tituloSecao">
													<td width="10%"><span class="style3">CNS</span></td>
													<td width="28%"><span class="style3">CBO</span></td>
													<td width="51%"><span class="style3">NR.
													CONSELHO</span></td>
													<td width="28%"><span class="style3">UNIDADE</span></td>
													<td width="11%"><span class="style3">NOME</span></td>
													<td width="11%"><span class="style3">CPF</span></td>
													<td width="11%"><span class="style3">TELEFONE</span></td>
												</tr>


												<br>

												<%
								Iterator i = profissionalEncontrado.iterator();
									while (i.hasNext()) {
										Profissional p = (Profissional) i.next();
							%>
												<tr>
													<td>
													<div align="left"><span class="style5"> <span
														class="style5"><a
														href="AtualizarProfissional?hidAcao=detalharProfissional&amp;psCns=<%=p.getPsCns()%>"><%=p.getPsCns()%></a></span>
													</span></div>
													</td>
													<td>
													<div align="left"><span class="style5"><%=p.getCbo_Cbo()%>
													</span></div>
													</td>
													<td>
													<div align="left"><span class="style5"><%=p.getConselhos_conselho()%></span></div>
													</td>
													<td>
													<div align="left"><span class="style5"><%=p.getUnidadeSaude_usCnes()%></span></div>
													</td>
													<td>
													<div align="left"><span class="style5"><%=p.getPsNome()%></span></div>
													</td>
													<td>
													<div align="left"><span class="style5"><%=p.getPsCpf()%></span></div>
													</td>
													<td>
													<div align="left"><span class="style5"><%=p.getPsTelefone()%></span></div>
													</td>
												</tr>
												<%
								}
							%>
											</table>
											</form>
											</td>
										</tr>
									</tbody>
								</table>
								<%
							}
			%> <br>
								</td>
							</tr>
						</tbody>
					</table>
					</td>
				</TR>
			</TBODY>
		</TABLE>
		<BR />
		</TD>

		<td class="padding" vAlign="top" width="221">
		<h2 class="boxcaption">SubMenu</h2>
		<div class="box">
		<ul>
			<li><small><a href="cadastrarPS.jsp">Cadastrar Profissional</a></small></li>
			<li><a href="consultarPS.jsp"><small>Consultar Profissional</small></a></li>
			<li><a href="atualizarPS.jsp"><small>Atualizar Profissinoal</small></a></li>
		</ul>
		</div>
		<p class="boxbottom"></p>
		</td>

		<td></td>

	</tr>
	</tbody>
</table>
<div class="footer">
<h3>&nbsp;</h3>
<p>© Copyright <a title="BPA Digital"
	href="http://www.bpad.com/testrun/">BPA </a>2008 - All rights reserved.</p>
</div>
</BODY>
</HTML>

