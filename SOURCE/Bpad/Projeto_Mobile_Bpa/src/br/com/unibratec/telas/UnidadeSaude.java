package br.com.unibratec.telas;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDletStateChangeException;

import br.com.unibratec.core.UIController;

public class UnidadeSaude extends Form implements CommandListener {

	private TextField usNome;
	private TextField usCnpj;
	private TextField usSigla;
	private TextField usSecretaria;
	private ChoiceGroup usTipoOrgao;

	private Command cmd_opcao;
	private Command cmd_ok;
	private Command cmd_voltar;

	private static UnidadeSaude instance;

	public static UnidadeSaude getInstance(String title) {
		if (instance == null) {
			instance = new UnidadeSaude(title);
		}
		return instance;
	}

	private UnidadeSaude(String title) {
		super(title);

		usNome = new TextField("Nome: ", "", 20, TextField.ANY);
		usCnpj = new TextField("CNPJ: ", "", 13, TextField.ANY);
		usSigla = new TextField("Sigla: ", "", 5, TextField.ANY);
		usSecretaria = new TextField("Secretaria: ", "", 20, TextField.ANY);
		this.usTipoOrgao = new ChoiceGroup("TpOrgao", List.EXCLUSIVE);

		cmd_opcao = new Command("Opções", Command.OK, 0);
		cmd_ok = new Command("Ok", Command.OK, 1);
		cmd_voltar = new Command("Voltar", Command.BACK, 2);
		
		append(usNome);
		append(usCnpj);
		append(usSigla);
		append(usSecretaria);
		this.usTipoOrgao.append("Estadual", null);
		this.usTipoOrgao.append("Municipal", null);
		

		addCommand(cmd_opcao);
		addCommand(cmd_ok);
		addCommand(cmd_voltar);
		setCommandListener(this);
	}

	public void commandAction(Command cmd, Displayable disp) {

		if (cmd == cmd_opcao) {
			UIController.getInstance().unidadeSaude();
		}
	}
}