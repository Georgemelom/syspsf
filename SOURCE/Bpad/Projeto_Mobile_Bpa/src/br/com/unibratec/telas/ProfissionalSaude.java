package br.com.unibratec.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDletStateChangeException;

import br.com.unibratec.core.UIController;

public class ProfissionalSaude extends Form implements CommandListener {
	
	private TextField psNome;
	private TextField psCns;
	private TextField psCbo;
	private TextField psCr;
		
	private Command cmd_ok;
	
	private static ProfissionalSaude instance;

	public static ProfissionalSaude getInstance(String title) {
		if (instance == null) {
			instance = new ProfissionalSaude(title);
		}
		return instance;
	}

	private ProfissionalSaude(String title) {
		super(title);

		psNome = new TextField("Nome: ", "", 20, TextField.ANY);
		psCns = new TextField("CNS: ", "", 12, TextField.ANY);
		psCbo = new TextField("CBO: ", "", 5, TextField.ANY);
		psCr = new TextField("CR: ", "", 20, TextField.ANY);

		cmd_ok = new Command("Entrar", Command.OK, 1);
		append(psNome);
		append(psCns);
		append(psCbo);
		append(psCr);

		addCommand(cmd_ok);
		setCommandListener(this);

	}

	public void commandAction(Command cmd, Displayable disp) {

		if (cmd == cmd_ok) {
			UIController.getInstance().profissionalSaude(psNome.getString(),
					psCns.getString(), psCbo.getString(), psCr.getString());
		}
	}
}
