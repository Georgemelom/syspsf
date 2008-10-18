           
         <h1> Cadastrar Profissional de Saúde</h1>
            <br />
            <br />
            <form name="form1" method="post" action="">
            <p>Dados a preencher </p>
               <p> Nome : 
                 <label>
                 <input type="text" name="nome" id="nome" size="50">
                 </label>
               </p>
               <p>CBO : 
                 <label>
                 <select name="cbo" id="cbo">
                 </select>
                 </label>
                 CR - Coselho Regional :
                 <label>
                 <input type="text" name="cr" id="cr" size="10">
                 </label>
                 CNS :
                 <label>
                 <input type="text" name="cns" id="cns" size="10">
                 </label>    
				</p>
               <p>Unidade de Saúde  : 
                 <label>
                 <select name="us" id="us">
                 <option value="NomeDoPosto">Nome do Posto</option>
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
             