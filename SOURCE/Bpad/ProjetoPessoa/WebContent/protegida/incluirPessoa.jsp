<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="modelo.entidades._Pessoa"%>


<%@page import="java.text.SimpleDateFormat"%><html xmlns="http://www.w3.org/1999/xhtml">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- DW6 -->
<head>

<%
	ArrayList mensagens = (ArrayList)request.getAttribute("mensagens"); 
	ArrayList erros = (ArrayList)request.getAttribute("erros");
%>

<jsp:useBean id="pessoa" class="modelo.entidades._Pessoa" scope="request">
</jsp:useBean>


<!-- Copyright 2005 Macromedia, Inc. All rights reserved. -->
<title>Incluir Pessoa</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="mm_spa.css" type="text/css" />
<style type="text/css">
<!--
.style2 {font-size: 16px}
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
 	<td colspan="6"><div align="center"><span class="style2"><img src="mm_spacer.gif" alt="" width="1" height="18" border="0" /><strong>Incluir Pessoa</strong></span> </div></td>
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
	<%
	if (erros != null && !erros.isEmpty()) { 
		Iterator i = erros.iterator();	
		%> <div class="erros" id="msgErros"> <% 
		while (i.hasNext()){ 
			 %> <br /> <% out.print(i.next());	 
		 }
		 %> </div>		
	<% } %>
	
	<%
	if (mensagens != null && !mensagens.isEmpty()) { 
		Iterator j = mensagens.iterator();	
		%> <div class="informacoes" id="msgSucesso"> <% 
		while (j.hasNext()){ 
			 %> <br /> <% out.print(j.next());	 
		 }
		 %> </div>		
	<% } %>					
     
      <form id="formIncluirPessoa" name="formIncluirPessoa" method="post" action="ServletIncluirPessoa">
	  <input name="hidAcao" type="hidden" value="" />
	  <input name="hidIdPessoa" type="hidden" value="${pessoa.idPessoa}" /> 
        <table width="90%" border="0" align="center">
          <tr>
            <td colspan="2" class="tituloSecao">Dados da pessoa</td>
          </tr>
          <tr>
            <td class="tituloCampo">C&oacute;digo:</td>
            <td><input name="idPessoa" type="text" id="idPessoa" tabindex="1" size="12" 
            	maxlength="12"  value="${pessoa.idPessoa}"/></td>
          </tr>
          <tr>
            <td class="tituloCampo">Nome:</td>
            <td><input name="nome" type="text" id="nome" tabindex="1" size="50" 
            	maxlength="100"  value="${pessoa.nome} "/></td>
          </tr>
          <tr>
            <td class="tituloCampo">Data de Nascimento: </td>
            <td>
            <input name="dataNascimento" type="text" id="dataNascimento" 
            tabindex="2" size="12" maxlength="10" 
            value=
            "<% SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            if(pessoa != null && pessoa.getDataNascimento() != null){
            	out.print(formato.format(pessoa.getDataNascimento()));
            }%>"/>
            </td>
          </tr>
          <tr>
            <td class="tituloCampo">Sexo:</td>
            <td><input name="sexo" type="radio" value="1" tabindex="3" 
                <% 
                if (pessoa.getSexo() != null && pessoa.getSexo().equals(1)){
                	out.print("checked=\"checked\"");
                }
                %> />
              Masculino
                <input name="sexo" type="radio" tabindex="3" value="2" 
                <% if (pessoa.getSexo() != null && pessoa.getSexo().equals(2))
                	out.print("checked=\"checked\""); %>/> 
            Feminino </td>
          </tr>
        </table>
        <table width="90%" border="0" align="center">
          <tr>
            <td colspan="2" class="tituloSecao">Endere&ccedil;o</td>
          </tr>
          <tr>
            <td class="tituloCampo">Bairro:</td>
            <td><input name="bairro" type="text" id="bairro" tabindex="4" size="50" maxlength="100" /></td>
          </tr>
          <tr>
            <td class="tituloCampo">Tipo do Logradouro:</td>
            <td><select name="tipoLogradouro" id="tipoLogradouro" tabindex="5">
              <option value="1">Avenida</option>
              <option value="2">Rua</option>
            </select>            </td>
          </tr>
          <tr>
            <td class="tituloCampo">Logradouro:</td>
            <td><input name="logradouro" type="text" id="logradouro" tabindex="6" size="50" maxlength="100" /></td>
          </tr>
          <tr>
            <td class="tituloCampo">N&uacute;mero:</td>
            <td><input name="numero" type="text" id="numero" tabindex="7" size="10" maxlength="10" /></td>
          </tr>
          <tr>
            <td colspan="2" class="tituloCampo"><p>Complemento:<textarea name="textarea" tabindex="8" rows="5" cols="50"></textarea>
            </p>
            </td>
          </tr>
          <tr>
            <td class="tituloCampo">Munic&iacute;pio:</td>
            <td><input name="municipio" type="text" id="municipio" tabindex="9" size="50" maxlength="100" /></td>
          </tr>
          <tr>
            <td class="tituloCampo">CEP:</td>
            <td><input name="CEP" type="text" id="CEP" tabindex="10" size="10" maxlength="9" /></td>
          </tr>
        </table>
        <table width="90%" border="0" align="center">
          <tr>
            <td colspan="2" class="tituloSecao">Documentos</td>
          </tr>
          <tr>
            <td class="tituloCampo">Tipo:</td>
            <td><select name="tipoDocumento" id="tipoDocumento" tabindex="11">
              <option value="1">RG</option>
              <option value="2">CPF</option>
              <option value="3">CNH</option>
              <option value="4">Certid&atilde;o de Nascimento</option>
              <option value="5">Carteira Militar</option>
                                    </select></td>
          </tr>

          <tr>
            <td class="tituloCampo">N&uacute;mero:</td>
            <td><input name="numeroDocumento" type="text" id="numeroDocumento" tabindex="7" size="12" maxlength="10" /></td>
          </tr>
          <tr>
            <td colspan="2" class="tituloCampo"><p>Complemento:<textarea name="textarea" tabindex="14" rows="5" cols="50"></textarea>
            </p></td>
          </tr>
          <tr>
            <td colspan="2"><div align="center">
              <input name="adicionarDocumento" type="submit" id="adicionarDocumento" tabindex="15" onclick="setarAcao(this);" value="Adicionar Documento"/>
              <input name="excluirDocumento" type="submit" id="excluirDocumento" tabindex="16" onclick="setarAcao(this);" value="Excluir Documento"/>
              <input name="alterarDocumento" type="submit" id="alterarDocumento" tabindex="17" onclick="setarAcao(this);" value="Alterar Documento"/>
            </div></td>
          </tr>
          <tr>
            <td colspan="2"><input name="radioDocumentos" type="radio" value="1 # CPF # 000.999.888.77 " tabindex="30" />
            CPF - 000.999.888.77 </td>
          </tr>
          <tr>
            <td colspan="2"><input name="radioDocumentos" type="radio" value="2 RG # 192938 # SSP/PB" tabindex="30" />
RG - 192938 - SSP/PB </td>
          </tr>
        </table>
        <br />
        <br />
        <table width="90%" border="0" align="center">
          <tr>
            <td colspan="2" class="tituloSecao">Telefones</td>
          </tr>
          <tr>
            <td class="tituloCampo">Tipo:</td>
            <td><select name="tipoTelefone" id="tipoTelefone" tabindex="18">
              <option value="1">Residencial</option>
              <option value="2">Comercial</option>
              <option value="3">Celular</option>
              <option value="4">Fax</option>
                        </select></td>
          </tr>
          <tr>
            <td class="tituloCampo">N&uacute;mero:</td>
            <td>(
              <input name="numeroDocumento2" type="text" id="numeroDocumento2" tabindex="19" size="3" maxlength="2" />
              )
              <input name="numeroDocumento22" type="text" id="numeroDocumento22" tabindex="20" size="10" maxlength="8" /></td>
          </tr>

          <tr>
            <td colspan="2"><div align="center">
                <input name="adicionarTelefone" type="submit" id="adicionarTelefone" tabindex="21" onclick="setarAcao(this);"  value="Adicionar Telefone"/>
                <input name="excluirTelefone" type="submit" id="excluirTelefone" tabindex="22" onclick="setarAcao(this);" value="Excluir Telefone"/>
                <input name="alterarTelefone" type="submit" id="alterarTelefone" tabindex="23" onclick="setarAcao(this);" value="Alterar Telefone"/>
            </div></td>
          </tr>
          <tr>
            <td colspan="2"><input name="radioTelefones" type="radio" value="1 # 3 #83 # 99009900 " tabindex="30" />
Celular - (83) 9900-9900 </td>
          </tr>
          <tr>
            <td colspan="2"><input name="radioTelefones" type="radio" value="2 # 1 #83 # 32323232" tabindex="30" />
Residencial - (83) 3232-3232</td>
          </tr>
        </table>
        <table width="90%" border="0" align="center">

          <tr>
            <td><div align="center">
                <p><br />
                  <input name="adicionarPessoa" type="submit" id="adicionarPessoa" tabindex="24" onclick="setarAcao(this);" value="Adicionar Pessoa"/>
                  <input name="detalharPessoa" type="submit" id="detalharPessoa" tabindex="25" onclick="setarAcao(this);" value="Detalhar Pessoa"/>
                  
                </p>
                </div></td>
          </tr>
        </table>  
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
