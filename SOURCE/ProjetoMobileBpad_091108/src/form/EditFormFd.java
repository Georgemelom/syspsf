package form;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

import midlet.Ficha;

public class EditFormFd extends Form {
	private Ficha ficha;
	private TextField fdIDFld = new TextField("Ficha: ", "", 3,	TextField.ANY);
	private TextField folha_FolIDFld = new TextField("Folha: ", "", 3,TextField.ANY);
	private TextField procedimentos_proCodigoFld = new TextField("Cod.Proc: ", "", 6,TextField.ANY);
	private TextField pacientes_pcCnsFld = new TextField("Paciente:", "", 6,TextField.ANY);
	private TextField profissionaisSaude_psCnsFld = new TextField("Profissional: ", "", 6,TextField.ANY);
	

	public EditFormFd() {
		super("Editar Ficha");
		append(fdIDFld);
		append(folha_FolIDFld);
		append(procedimentos_proCodigoFld);
		append(pacientes_pcCnsFld);
		append(profissionaisSaude_psCnsFld);
		
	}

	public void setFicha(Ficha c)// envia para a classe conta
	{
		ficha = c;
		fdIDFld.setString(ficha.fdID);
		folha_FolIDFld.setString(ficha.folha_FolID);
		procedimentos_proCodigoFld.setString(ficha.procedimentos_proCodigo);
		pacientes_pcCnsFld.setString(ficha.pacientes_pcCns);
		profissionaisSaude_psCnsFld.setString(ficha.profissionaisSaude_psCns);
	}

	public Ficha getFicha()// atribui para a classe conta
	{
		ficha.fdID = fdIDFld.getString();
		ficha.folha_FolID = folha_FolIDFld.getString();
		ficha.procedimentos_proCodigo = procedimentos_proCodigoFld.getString();
		ficha.pacientes_pcCns = pacientes_pcCnsFld.getString();
		ficha.profissionaisSaude_psCns = profissionaisSaude_psCnsFld.getString();
		return ficha;
	}
}
