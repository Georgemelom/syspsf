           
            <h1> Atualizar Paciente</h1>
            <br />
            <br />
            <form name="form1" method="post" action="">
              <p>CNS – Carteira Nacional de Saúde : 
                 <input type="text" name="cns" id="cns" size="13">
               
               <input type="submit" name="enviar" id="enviar" value="Enviar">
                 </label>
                 <label>&nbsp;</label><label>&nbsp;</label>
                 <label>
                 <input type="reset" name="limpar" id="limpar" value="Limpar">
                 </label>
               </p>
             </form>
            
             <br />
             <br />
             <form name="form1" method="post" action="">
            <h2>Dados a serem atualizados </h2>
               <p> Nome : 
                 <label>
                 <input type="text" name="nome" id="nome" size="50">
                 </label>
               </p>
               <p>CNS – Carteira Nacional de Saúde : 
                 <label>
                 <input type="text" name="cns" id="cns" size="10">
                 </label>
                 Data de Nascimento: 
                 <select name="dia" id="dia">
                 	<option value="1">01</option>
                 	<option value="2">02</option>
                 	<option value="3">03</option>
                 	<option value="4">04</option>
                 	<option value="5">05</option>
                 	<option value="6">06</option>
                 	<option value="7">07</option>
                 	<option value="8">08</option>
                 	<option value="9">09</option>
                 	<option value="10">10</option>
                 	<option value="11">11</option>
                 	<option value="12">12</option>
                 	<option value="13">13</option>
                 	<option value="14">14</option>
                 	<option value="15">15</option>
                 	<option value="16">16</option>
                 	<option value="17">17</option>
                 	<option value="18">18</option>
                 	<option value="19">19</option>
                 	<option value="20">20</option>
                 	<option value="22">21</option>
                 	<option value="23">23</option>
                 	<option value="24">24</option>
                 	<option value="25">25</option>
                 	<option value="26">26</option>
                 	<option value="27">27</option>
                 	<option value="28">28</option>
                 	<option value="29">29</option>
                 	<option value="30">30</option>
                 	<option value="31">31</option>
                 </select> 
                 <label>/</label>
                  <select name="mes" id="mes">
                 	<option value="1">01</option>
               	 	<option value="2">02</option>
                 	<option value="3">03</option>
                 	<option value="4">04</option>
                 	<option value="5">05</option>
                 	<option value="6">06</option>
                 	<option value="7">07</option>
                 	<option value="8">08</option>
                 	<option value="9">09</option>
                 	<option value="10">10</option>
                 	<option value="11">11</option>
                 	<option value="12">12</option>
                 </select>
                  <label>/</label>
                  <select name="ano" id="ano">
                 	<option value="2008">2008</option> 
                  </select>                
				</p>
               <p>Município de Residência : 
                 <label>
                 <select name="mResidencia" id="mResidencia">
                 </select>
                 </label>
               Sexo : 
                 <label>
                 <select name="sexo" id="sexo">
                 <option value="M">Masculino</option>
                 <option value="F">Feminino</option>
                 <option value="O">Outro</option>
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
             