package br.com.unibratec.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

import br.com.unibratec.core.UIController;

public class ProfissionalSaude extends Form implements CommandListener {

	private TextField psNome;
	private TextField psCns;
	private TextField psCbo;
	private TextField psCr;

	private Command cmd_sair;
//	private Command cmd_ok;
	private Command cmd_voltar;
	private Command cmd_salvar;
	private Command cmd_exibir;

	private static ProfissionalSaude instance;

	public static ProfissionalSaude getInstance(String title) {
		if (instance == null) {
			instance = new ProfissionalSaude(title);
		}
		return instance;
	}

	private ProfissionalSaude(String title) {
		super(title);
		
		psCns = new TextField("CNS: ", "", 6, TextField.ANY);
		psNome = new TextField("Nome: ", "", 30, TextField.ANY);
		psCbo = new TextField("CBO: ", "", 6, TextField.ANY);
		psCr = new TextField("CR: ", "", 6, TextField.ANY);

		append(psNome);
		append(psCns);
		append(psCbo);
		append(psCr);

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
			UIController.getInstance().salvarPs(psCns.getString(), 
					psNome.getString(), psCbo.getString(), 
					psCr.getString());
		} else if (cmd.equals(cmd_exibir)) {
			UIController.getInstance().exibirPs();
		}
	}

}