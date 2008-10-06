package br.com.unibratec.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDletStateChangeException;

import br.com.unibratec.core.UIController;

public class UnidadeSaude extends Form implements CommandListener {
	
	private TextField usNome;
	private TextField usCnpj;
	private TextField usSigla;
	private TextField usSecretaria;
	private List usTipoOrgao;
	
	private Command cmd_ok;
	
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
		usCnpj = new TextField("CNPJ: ", "", 12, TextField.ANY);
		usSigla = new TextField("Sigla: ", "", 5, TextField.ANY);
		usSecretaria = new TextField("Secretaria: ", "", 20, TextField.ANY);
		usTipoOrgao = new List("Estadual", List.EXCLUSIVE);
		usTipoOrgao = new List("Municipal", List.EXCLUSIVE);

		cmd_ok = new Command("Entrar", Command.OK, 1);
		append(usNome);
		append(usCnpj);
		append(usSigla);
		append(usSecretaria);

		addCommand(cmd_ok);
		setCommandListener(this);


	}

	public void commandAction(Command cmd, Displayable disp) {

		if (cmd == cmd_ok) {
			UIController.getInstance().unidadeSaude(usNome.getString(),
					usSigla.getString(), usCnpj.getString(),
					usSecretaria.getString(), usTipoOrgao.EXCLUSIVE);
		}
	}
}