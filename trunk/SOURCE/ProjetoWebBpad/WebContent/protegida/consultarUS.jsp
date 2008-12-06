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
	ArrayList<UnidadeSaude> unidadeSaudeEncontradas = (ArrayList) request
			.getAttribute("usEncontrada");
%>

<%
	ArrayList mensagens = (ArrayList) request.getAttribute("mensagens");
	ArrayList erros = (ArrayList) request.getAttribute("erros");
%>

<jsp:useBean id="unidadeSaude" class="modelo.entidades.UnidadeSaude"
	scope="request">
</jsp:useBean>


<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Consultar Unidade de Saude</title>
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
    document.formConsultarUnidadeSaude.hidAcao.value = botao.id;
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



<table cellSpacing="0" cellPadding="0" width="100%" border="0">
	<tbody>
		<tr>
			<td class="padding" vAlign="top" width="221">
			<h2 class="boxcaption">Bem Vindo Fulano !</h2>
			<p class="boxbottom"></p>
			</td>
			<td vAlign="top" width="100%">
			<table cellSpacing="0" cellPadding="0" width="98%" align="center" border="0">
				<tbody>
					<tr>

						<td colspan="3" valign="top">
						<p><img src="mm_spacer.gif" alt="" width="305" height="1" border="0"><br>
						</p>
						
						<form bgcolor="#bbbcca" id="formConsultarUnidadeSaude" name="formConsultarUnidadeSaude" method="post" action="ConsultarUnidadeSaude"><input name="hidAcao" type="hidden" value="">
						<table width="90%" border="0" align="center">
							<tr>
								<td colspan="2" class="tituloSecao">Dados da Unidade</td>
							</tr>
							<tr>
								<td class="tituloCampo">CNES:</td>
								<td><input name="usCnes" type="text" id="usCnes" tabindex="1" size="6" maxlength="12" value="${unidadesaude.usCnes}" style="width: 166px"></td>
							</tr>
							<tr>
								<td class="tituloCampo">Nome:</td>
								<td><input name="usNome" type="text" id="usNome" tabindex="3" size="50" maxlength="100" value="${unidadesaude.usNome} "></td>
							</tr>
							<tr>
								<td class="tituloCampo">CNPJ:</td>
								<td><input name="usCnpj" type="text" id="usCnpj" tabindex="5" size="18" maxlength="100" value="${unidadesaude.usCnpj} " style="width: 182px"></td>
							</tr>
						</table>
						<table width="90%" border="0" align="center">

							<tr>
								<td>
								<div align="center">
								<p><br>
								</p></div></td><td style="width: 119px" align="center"><input name="listar" type="submit" id="listar" tabindex="24" onclick="setarAcao(this);" value="Listar"></td>
								<div></div>
								<td></td>
							</tr>
						</table>

						<%
							if (unidadeSaudeEncontradas != null) {
						%><br>
						<br>

						<table width="90%" border="1" align="center" class="tituloCampo">
							<caption><%=unidadeSaudeEncontradas.size()%> Unidades
							Encontradas</caption>
							<tr class="tituloSecao">
								<td width="10%"><span class="tituloCampo">CNES</span></td>
								<td width="28%"><span class="tituloCampo">Cidade</span></td>
								<td width="51%"><span class="tituloCampo">Nome</span></td>
								<td width="28%"><span class="tituloCampo">Sgila</span></td>
								<td width="11%"><span class="tituloCampo">CNPJ</span></td>
								<td width="11%"><span class="tituloCampo">Razao
								Social</span></td>
								<td width="11%"><span class="tituloCampo">Endereço</span></td>
							</tr>


							<br>

							<%
								Iterator i = unidadeSaudeEncontradas.iterator();
									while (i.hasNext()) {
										UnidadeSaude p = (UnidadeSaude) i.next();
							%>
							<tr>
								<td>
								<div align="left"><span class="style5"> <span class="style5"><a href="AtualizarUnidadeSaude?hidAcao=detalharUnidade&amp;usCnes=<%=p.getUsCnes()%>"><%=p.getUsCnes()%></a></span>
								</span></div>
								</td>
								<td>
								<div align="left"><span class="style5"><%=p.getCidade_ciSigla()%>
								</span></div>
								</td>
								<td>
								<div align="left"><span class="style5"><%=p.getUsNome()%></span></div>
								</td>
								<td>
								<div align="left"><span class="style5"><%=p.getUsSigla()%></span></div>
								</td>
								<td>
								<div align="left"><span class="style5"><%=p.getUsCnpj()%></span></div>
								</td>
								<td>
								<div align="left"><span class="style5"><%=p.getUsRazaoSocial()%></span></div>
								</td>
								<td>
								<div align="left"><span class="style5"><%=p.getUsEndereco()%></span></div>
								</td>
							</tr>
							<%
								}
							%>
						</table>
			</form></td></tr></tbody></table>
			<%
				}
			%>
			</td>
			<td>
			</td><td class="padding2" vAlign="top" width="221">
			<h2 class="boxcaption">SubMenu</h2>
			<div class="box">
			<ul>
				<li><small><a href="cadastrarUS.jsp">Cadastrar
				Unidade</a></small></li>
				<li><a href="consultarUS.jsp"><small>Consultar
				Unidade</small></a></li>
				<li><a href="atualizarUS.jsp"><small>Atualizar
				Unidade</small></a></li>
			</ul>
			</div>
			<p class="boxbottom"></p>
			 </td>
			<td></td>
		</tr>
	</tbody>
</table>
<br>
<td></td>


<td class="padding2" vAlign="top" width="221">
<p class="boxbottom">
</p></td>
<td class="padding2" vAlign="top" width="221"> </td>
<tr></tr>
<tbody></tbody>

<DIV class="footer">

<P>© Copyright <A title="BPA Digital" href="http://www.bpad.com/testrun/">BPA 
	</A>2008 - All rights reserved.</P>
</DIV>

</DIV>
</BODY
</html>
