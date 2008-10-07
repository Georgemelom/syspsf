package br.com.unibratec.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDletStateChangeException;

import br.com.unibratec.core.UIController;

public class Paciente extends Form implements CommandListener {
	
	private TextField pcNome;
	private TextField pcCns;
	private TextField pcDtNasc;
	private List pcSexo;
	private TextField pcEndereco;
	private TextField pcCidade;
	private TextField pcLocalidade;
		
	private Command cmd_ok;
	
	private static Paciente instance;

	public static Paciente getInstance(String title) {
		if (instance == null) {
			instance = new Paciente(title);
		}
		return instance;
	}

	private Paciente(String title) {
		super(title);

		pcNome = new TextField("Nome: ", "", 20, TextField.ANY);
		pcCns = new TextField("CNS: ", "", 12, TextField.ANY);
		pcDtNasc = new TextField("Data Nasc.: ", "", 10, TextField.ANY);
		pcSexo = new List("Masculino",List.EXCLUSIVE);
		pcSexo = new List("Feminino",List.EXCLUSIVE);
		pcEndereco = new TextField("Endereço: ", "", 20, TextField.ANY);
		pcCidade = new TextField("Cidade: ", "", 20, TextField.ANY);
		pcLocalidade = new TextField("Localidade: ", "", 20, TextField.ANY);
	
		cmd_ok = new Command("Entrar", Command.OK, 1);
		append(pcNome);
		append(pcCns);
		append(pcDtNasc);
		append(pcEndereco);
		append(pcCidade);
		append(pcLocalidade);

		addCommand(cmd_ok);
		setCommandListener(this);


	}

	public void commandAction(Command cmd, Displayable disp) {

		if (cmd.equals(cmd_ok)) {
			UIController.getInstance().paciente();
		}
	}
}
