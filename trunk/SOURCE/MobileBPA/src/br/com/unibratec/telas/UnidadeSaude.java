package br.com.unibratec.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

import br.com.unibratec.core.UIController;

public class UnidadeSaude extends Form implements CommandListener {

	private TextField usCnes;
	private TextField cidade_ciSigla;
	private TextField usNome;
	private TextField usSigla;
	private TextField usRazaoSocial;
	private TextField usCnpj;
	private TextField usEndereco;

	private Command cmd_sair;
//	private Command cmd_ok;
	private Command cmd_voltar;
	private Command cmd_salvar;
	private Command cmd_exibir;

	private static UnidadeSaude instance;

	public static UnidadeSaude getInstance(String title) {
		if (instance == null) {
			instance = new UnidadeSaude(title);
		}
		return instance;
	}

	private UnidadeSaude(String title) {
		super(title);

		usCnes = new TextField("CNES: ", "", 6, TextField.ANY);
		cidade_ciSigla = new TextField("Cidade: ", "", 6, TextField.ANY);
		usNome = new TextField("Nome: ", "", 30, TextField.ANY);
		usSigla = new TextField("Sigla: ", "", 6, TextField.ANY);
		usRazaoSocial = new TextField("Razao: ", "", 30, TextField.ANY);
		usCnpj = new TextField("CNPJ: ", "", 13, TextField.ANY);
		usEndereco = new TextField("Endereco: ", "", 30, TextField.ANY);

		append(usCnes);
		append(cidade_ciSigla);
		append(usNome);
		append(usSigla);
		append(usRazaoSocial);
		append(usCnpj);
		append(usEndereco);

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
			UIController.getInstance().salvarUs(usCnes.getString(), 
					cidade_ciSigla.getString(), usNome.getString(), 
					usSigla.getString(), usRazaoSocial.getString(), 
					usCnpj.getString(), usEndereco.getString());
		} else if (cmd.equals(cmd_exibir)) {
			UIController.getInstance().exibirUs();
		}
	}

}