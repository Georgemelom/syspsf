<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<!-- saved from url=(0058)http://www.phpldaddons.com/testrun/?preview=Lemon Shadow 2 -->
<HTML xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>BPAD</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<LINK href="arquivos/style.css" type=text/css rel=stylesheet>
<META content="BPA - BOLETIM DE PRODU��O AMBULATORIAL" name=description>
<META content="BPAD" name=author>
<META content="Copyright (c) 2008 by YOUR NAME. All rights reserved!"
	name=copyright>
<META content="MSHTML 6.00.6000.16705" name=GENERATOR>
</HEAD>
<script type="text/javascript">
<!--
//Create a boolean variable to check for a valid Internet Explorer instance.
var xmlhttp = false;
//Check if we are using IE.
try {
//If the Javascript version is greater than 5.
xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
//alert ("You are using Microsoft Internet Explorer.");
} catch (e) {
//If not, then use the older active x object.
try {
//If we are using Internet Explorer.
xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
//alert ("You are using Microsoft Internet Explorer");
} catch (E) {
//Else we must be using a non-IE browser.
xmlhttp = false;
}
}
//If we are using a non-IE browser, create a javascript instance of the object.
if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
xmlhttp = new XMLHttpRequest();
//alert ("You are not using Microsoft Internet Explorer");
}
function makerequest(serverPage, objID) {
var obj = document.getElementById(objID);
xmlhttp.open("GET", serverPage);
xmlhttp.onreadystatechange = function() 
	{
	if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		obj.innerHTML = xmlhttp.responseText;
		}
	}
xmlhttp.send(null);
}

//-->
</script>
<SCRIPT language=javascript type=text/javascript>/* <![CDATA[ */var root = '/testrun';
      var a = document.getElementsByTagName("a");
      for(i = 0; i< a.length; i++)
         if(a[i].id != '')
            a[i].onclick = count_link;
      function count_link() {
         i = new Image();
         i.src= root+'/cl.php?id='+this.id;
         return true;
      }
      /* ]]> */
</SCRIPT>

<BODY>
<DIV id=container>
<DIV class=header>
<H1><IMG alt="BPA Digital" src="images/logo.gif" border=0></A></H1>
</DIV>
<DIV class=bar><SPAN></SPAN>
<UL>
	<LI><A class=common href="home.jsp"
		onClick="makerequest('home.jsp','conteudo');return false;">Home</A></LI>
	<LI><A class=common href="protegida/unidadeDeSaude.jsp"
		onClick="makerequest('protegida/unidadeDeSaude.jsp','submenu');return false;">Unidade
	de Saude</A></LI>
	<LI><A class=common href="protegida/profissional.jsp"
		onClick="makerequest('protegida/profissional.jsp','submenu');return false;">Profissional
	de Sa�de</A></LI>
	<LI><A class=common href="protegida/paciente.jsp"
		onClick="makerequest('protegida/paciente.jsp','submenu');return false;">Paciente</A>
	</LI>
	<LI><A class=common href="protegida/fichaDiaria.jsp"
		onClick="makerequest('protegida/boletim.jsp','submenu');return false;">Boletim</A>
	</LI>
	<LI><A class=common href="protegida/consolida��o.jsp"
		onClick="makerequest('protegida/consolida��o.jsp','submenu');return false;">Consolida��o</A>
	</LI>

	<LI></LI>
	<LI></LI>
</UL>
</DIV>
<!--Div conteudo que usa ajax -->
<div id="submenu">
<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
	<TBODY>
		<TR>
			<TD class=padding vAlign=top width=221>
			<TD vAlign=top width="100%">
			<TABLE cellSpacing=0 cellPadding=0 width="98%" align=center border=0>
				<TBODY>
					<TR>
						<TD vAlign=top>
						<p><BR>
						<BR />
						<!--Div conteudo que usa ajax -->
						<div id="conteudo"></div>
						</TD>
						<TD vAlign=top><BR>
						<BR>
						<BR>
						</TD>
					</TR>
				</TBODY>
			</TABLE>
			<BR>
			</TD>
			

			<TD class=padding2 vAlign=top width=221>
			<H2 class=boxcaption>Autenticacao</H2>
			<DIV class=box>
			<FORM action=/testrun/index.php method=get><label>
			Login :</label> <input type="text" name="login" id="login"> <br />
			<br />
			<label>Senha :</label> <input type="password" name="senha" id="senha"
				size="10"> <br />
			<br />
			<INPUT type=submit value="OK"></FORM>
			</DIV>
			<P class=boxbottom></P>



			</TD>
			<TD class=padding2 vAlign=top width=221>&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<BR>
<DIV class=footer>
<H3>&nbsp;</H3>
<P>� Copyright <A title="BPA Digital"
	href="http://www.bpad.com/testrun/">BPA </A>2008 - All rights reserved.</P>
</DIV>
<BR>
</DIV>
</BODY>
</HTML>
