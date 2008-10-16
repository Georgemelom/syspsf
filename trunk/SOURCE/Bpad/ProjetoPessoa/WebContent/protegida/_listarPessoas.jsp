<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>

<% ArrayList<_Pessoa> pessoasEncontradas = (ArrayList)request.getAttribute("pessoasEncontradas"); %>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="modelo.entidades._Pessoa"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%><html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>
<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Listar Pessoas</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="mm_spa.css" type="text/css" />
<style type="text/css">
<!--
.style2 {font-size: 16px}
.style3 {
	font-size: 14px;
	font-weight: bold;
}
.style4 {font-size: 14px}
.style5 {font-size: 12px}
-->
</style>
<script language="JavaScript" type="text/javascript">
function setarAcao(botao){
    document.formIncluirPessoa.hidAcao.value = botao.id;
}
</script>

</head>
<body bgcolor="#990000" background="mm_bg_red.gif">
<table border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="#220103">
   <td rowspan="2" colspan="2" nowrap="nowrap"><img src="mm_spa_photo1.jpg" alt="Header image" width="215" height="109" border="0" /></td>
   <td colspan="2" height="55" nowrap="nowrap" id="logo" valign="bottom">Projeto Pessoa </td>
   <td width="390" rowspan="2"><img src="mm_spa_photo2.jpg" alt="header image 2" width="176" height="108" border="0" /></td>
   <td width="83" rowspan="2">&nbsp;</td>
  </tr>

  <tr bgcolor="#220103">
    <td height="54" colspan="2" nowrap="nowrap" id="tagline" valign="top"><p>Cadastro local de pessoas.<br />
N&atilde;o repare nas figuras! </p>    </td>
  </tr>

 <tr bgcolor="#FF9900">
 	<td colspan="6"><img src="mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
 </tr>

 <tr bgcolor="#FF080E">
 	<td colspan="6"><img src="mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
 </tr>

 <tr bgcolor="#FF9900">
 	<td colspan="6"><img src="mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
 </tr>

 <tr bgcolor="#FF080E">
 	<td colspan="6"><div align="center"><span class="style2"><img src="mm_spacer.gif" alt="" width="1" height="18" border="0" /><strong>Listar Pessoas</strong></span> </div></td>
 </tr>

 <tr bgcolor="#FF9900">
 	<td colspan="6"><img src="mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
 </tr>

 <tr bgcolor="#FF080E">
 	<td colspan="6"><img src="mm_spacer.gif" alt="" width="1" height="2" border="0" /></td>
 </tr>

 <tr bgcolor="#FF9900">
 	<td colspan="6"><img src="mm_spacer.gif" alt="" width="1" height="1" border="0" /></td>
 </tr>

 <tr>
    <td width="174" valign="top" id="navborder"><br />
   		<%@ include file="menu.jsp" %>				 
	</td>
    <td width="50"><img src="mm_spacer.gif" alt="" width="50" height="1" border="0" /></td>
    <td colspan="3" valign="top"><p><img src="mm_spacer.gif" alt="" width="305" height="1" border="0" /><br />
</p>
      <div class="informacoes" id="msgSucesso"></div>
      <div class="erros" id="msgErros"></div>
      <form id="formListarPessoa" name="formListarPessoa" method="post" action="ServletListarPessoas">
	  <input name="hidAcao" type="hidden" value="" />
        <table width="90%" border="0" align="center">
          <tr>
            <td colspan="2" class="tituloSecao">Dados da pessoa</td>
          </tr>
          <tr>
            <td class="tituloCampo">Nome:</td>
            <td><input name="nome" type="text" id="nome" tabindex="1" size="50" maxlength="100" /></td>
          </tr>
          <tr>
            <td class="tituloCampo">Data de Nascimento: </td>
            <td><input name="dataNascimento" type="text" id="dataNascimento" tabindex="2" size="12" maxlength="10" /></td>
          </tr>
          <tr>
            <td class="tituloCampo">Sexo:</td>
            <td><input name="sexo" type="radio" value="1" tabindex="3" />
              Masculino
                <input name="sexo" type="radio" tabindex="3" value="2" checked="checked" /> 
            Feminino </td>
          </tr>
          <tr>
            <td colspan="2" class="tituloCampo"><div align="center">
              <input name="listar" type="submit" id="listar" tabindex="24" onclick="setarAcao(this);" value="Listar"/>
            </div></td>
          </tr>
        </table>
        <br />
        
        <% if(pessoasEncontradas != null) {%>
        
	        <table width="90%" border="1" align="center" class="tituloCampo">
	          <caption>
	            <%=pessoasEncontradas.size()%> pessoas encontradas
	          </caption>
	          <tr class="tituloSecao">
	            <td width="10%"><span class="style3">C&oacute;digo</span></td> 
	            <td width="51%"><span class="style3">Nome</span></td>
	            <td width="28%"><span class="style3"> Nascimento </span></td>
	            <td width="11%"><span class="style3">Sexo</span></td>
	            
	          </tr>
	         
	         <% 
	         Iterator i = pessoasEncontradas.iterator();
	         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	         while (i.hasNext()){ 
	         	_Pessoa p = (_Pessoa)i.next();
	         %>
	        	 <tr>
	        	 <td><div align="left"><span class="style5">
	               <span class="style5"><a href="ServletIncluirPessoa?hidAcao=detalharPessoa&idPessoa=<%=p.getIdPessoa()%>"><%=p.getIdPessoa()%></a></span>
	             </span></div></td> 
	             <td><div align="left"><span class="style5"><%=p.getNome() %> </span></div></td>
	             <td><div align="left"><span class="style5"><%=formato.format(p.getDataNascimento()) %></span></div></td>
	             <td><div align="left"><span class="style5"><%=p.getSexo() %></span></div></td>
	            
	           </tr> 
	         <%}%> 
	          
	        </table>
	    <%} %>
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
