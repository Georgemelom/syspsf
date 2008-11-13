package br.com.unibratec.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

import br.com.unibratec.core.UIController;

public class FichaDiaria extends Form implements CommandListener {
	
	DateField fdDtProducao;
	private TextField fdID;
	private TextField folha_folID;
	private TextField procedimentos_proCodigo;
	private TextField pacientes_pcCns;
	private TextField profissinalSaude_psCns;

	private Command cmd_sair;
//	private Command cmd_ok;
	private Command cmd_voltar;
	private Command cmd_salvar;
	private Command cmd_exibir;
	
	private static FichaDiaria instance;

	public static FichaDiaria getInstance(String title) {
		if (instance == null) {
			instance = new FichaDiaria(title);
		}
		return instance;
	}

	private FichaDiaria(String title) {
		super(title);

		fdDtProducao = new DateField("", DateField.DATE_TIME);
		fdID = new TextField("Codigo : ", "", 3, TextField.ANY);
		folha_folID = new TextField("Folha : ", "", 3, TextField.ANY);
		procedimentos_proCodigo = new TextField("Cod.Procediemtno : ", "", 6, TextField.ANY);
		pacientes_pcCns = new TextField("CNS Paciente: ", "", 6, TextField.ANY);
		profissinalSaude_psCns = new TextField("CNS Profissional :", "", 6, TextField.ANY);

//		append(fdDtProducao);
		append(fdID);
		append(folha_folID);
		append(procedimentos_proCodigo);
		append(pacientes_pcCns);
		append(profissinalSaude_psCns);

		cmd_sair = new Command("Sair", Command.EXIT, 1);
		cmd_voltar = new Command("Voltar", Command.BACK, 1);
//		cmd_ok = new Command("Ok", Command.OK, 2);
		cmd_salvar = new Command("Salvar", Command.EXIT, 1);
		cmd_exibir = new Command("Exibir", Command.EXIT, 1);

		addCommand(cmd_sair);
		addCommand(cmd_voltar);
//		addCommand(cmd_ok);
		addCommand(cmd_salvar);
		addCommand(cmd_exibir);
		setCommandListener(this);

	}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd.equals(cmd_sair)) {
			UIController.getInstance().sair();
		} else if (cmd.equals(cmd_voltar)) {
			UIController.getInstance().voltar();
//		} else if (cmd.equals(cmd_ok)) {
//			UIController.getInstance().unidadeSaude();
		} else if (cmd.equals(cmd_salvar)) {
			UIController.getInstance().salvarFd(fdDtProducao.getDate(), 
					fdID.getString(), folha_folID.getString(), 
					procedimentos_proCodigo.getString(),
					pacientes_pcCns.getString(),
					profissinalSaude_psCns.getString());
		} else if (cmd.equals(cmd_exibir)) {
			UIController.getInstance().exibirFd();
		}
	}

}