package br.com.unibratec.telas;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordListener;
import javax.microedition.rms.RecordStore;

import br.com.unibratec.core.UIController;

public class Paciente extends Form implements CommandListener {

	private TextField pcNome;
	private TextField pcCns;
	private TextField pcDtNasc;
	private TextField pcSexo;
	private TextField pcEndereco;

	private Command cmd_sair;
	// private Command cmd_ok;
	private Command cmd_voltar;
	private Command cmd_salvar;
	private Command cmd_exibir;

	private static Paciente instance;

	public static Paciente getInstance(String title) {
		if (instance == null) {
			instance = new Paciente(title);
		}
		return instance;
	}

	private Paciente(String title) {
		super(title);

		pcNome = new TextField("Nome: ", "", 30, TextField.ANY);
		pcCns = new TextField("CNS: ", "", 6, TextField.ANY);
		pcDtNasc = new TextField("Data Nasc.: ", "", 10, TextField.ANY);
		pcSexo = new TextField("Sexo : ", "", 1, TextField.ANY);
		pcEndereco = new TextField("Endereço: ", "", 30, TextField.ANY);

		append(pcNome);
		append(pcCns);
		append(pcDtNasc);
		append(pcEndereco);

		cmd_sair = new Command("Sair", Command.EXIT, 1);
		cmd_voltar = new Command("Voltar", Command.BACK, 1);
		// cmd_ok = new Command("Ok", Command.OK, 2);
		cmd_salvar = new Command("Salvar", Command.EXIT, 1);
		cmd_exibir = new Command("Exibir", Command.EXIT, 1);

		addCommand(cmd_sair);
		addCommand(cmd_voltar);
		// addCommand(cmd_ok);
		addCommand(cmd_salvar);
		addCommand(cmd_exibir);
		setCommandListener(this);

	}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd.equals(cmd_sair)) {
			UIController.getInstance().sair();
		} else if (cmd.equals(cmd_voltar)) {
			UIController.getInstance().voltar();
			// } else if (cmd.equals(cmd_ok)) {
			// UIController.getInstance().paciente();
		} else if (cmd.equals(cmd_salvar)) {
			UIController.getInstance().salvarPc(pcCns.getString(),
					pcNome.getString(), pcDtNasc.getString(),
					pcSexo.getString(), pcEndereco.getString());
		} else if (cmd.equals(cmd_exibir)) {
			UIController.getInstance().exibirPc();
		}
	}
}
