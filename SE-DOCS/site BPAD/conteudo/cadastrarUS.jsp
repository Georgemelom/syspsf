           
            <h1> Cadastrar Unidade de Saúde</h1>
            <br />
            <br />
            <form name="form1" method="post" action="">
            <p>Dados a preencher </p>
               <p> Nome da Unidade de Saúde : 
                 <label>
                 <input type="text" name="nome" id="nome" size="50">
                 </label>
               </p>
               <p>Sigla da Unidade de Saúde : 
                 <label>
                 <input type="text" name="sigla" id="sigla" size="5">
                 </label>
                 CNPJ da Unidade de Saúde : 
                 <input type="text" name="cnpj" id="cnpj" size="13"> 
				</p>
               <p>Nome da Secretaria de Saúde Destino : 
                 <label>
                 <input type="text" name="mResidencia" id="mResidencia" size="25">
                 </label>
               Tipo do Órgão  : 
                 <label>
                 <select name="orgao" id="orgao">
                 </select>
                 </label>
               </p>
               <p>
                 <label>
                 <input type="submit" name="enviar" id="enviar" value="Enviar">
                 </label>
                 <label>&nbsp;</label><label>&nbsp;</label>
                 <label>
                 <input type="reset" name="limpar" id="limpar" value="Limpar">
                 </label>
               </p>
            </form>
             