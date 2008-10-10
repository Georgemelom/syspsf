package br.com.unibratec.menus;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

import br.com.unibratec.core.UIController;

public class ListaCNS extends List implements CommandListener {

	private static ListaCNS instance;
	
	private Command cmd_sair;
	private Command cmd_voltar;
	private Command cmd_ok;

	private ListaCNS(String title) {
		super(title, IMPLICIT);

		append("123456789", null);
		append("123456789", null);
		append("123456789", null);
		append("123456789", null);

		cmd_sair = new Command("sair", Command.EXIT, 0);
		cmd_voltar = new Command("voltar", Command.BACK, 1);
		cmd_ok = new Command("Ok", Command.OK, 2);

		addCommand(cmd_sair);
		addCommand(cmd_voltar);
		addCommand(cmd_ok);

		setCommandListener(this);
	}

	public static ListaCNS getInstance(String title) {
		if (instance == null) {
			instance = new ListaCNS(title);
		}
		return instance;
	}

	public void commandAction(Command cmd, Displayable arg1) {
		if (cmd.equals(cmd_sair)) {
			UIController.getInstance().sair();
		} else if (cmd.equals(cmd_voltar)) {
			UIController.getInstance().voltar();
		} else if (cmd.equals(cmd_ok)) {
			UIController.getInstance().ok(getSelectedIndex());
		}
	}
}
