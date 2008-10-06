package br.com.unibratec.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

import br.com.unibratec.core.UIController;

public class MenuUs extends List implements CommandListener {
	
	private static MenuUs instance;
	private List MenuUs;
	
	private Command cmd_sair;
	private Command cmd_voltar;
	private Command cmd_okUs;
	
	private Command cmd_Cadastrar;
	private Command cmd_Alterar;
	private Command cmd_Excluir;
	private Command cmd_Consultar;

		
	private MenuUs(String title, int listType) {
		super(title, listType);
		
		append("Cdastrar", null);
		append("Alterar", null);
		append("Excluir", null);
		append("Consultar", null);
		
		cmd_sair = new Command("sair", Command.EXIT, 1);
		cmd_voltar = new Command("voltar", Command.BACK, 1);
		cmd_okUs = new Command("Ok", Command.OK, 2);
				
		addCommand(cmd_sair);
		addCommand(cmd_voltar);
		addCommand(cmd_okUs);
		
		setCommandListener(this);
	}
	
	public static MenuUs getInstance(String title, int listType) {
		if (instance == null) {
			instance = new MenuUs(title, listType);
		}
		return instance;
	}
	
	public void commandAction(Command cmd, Displayable arg1) {
		if (cmd.equals(cmd_sair)) {
			UIController.getInstance().sair();
		} else if (cmd.equals(cmd_voltar)) {
			UIController.getInstance().voltar();
		}
	}
	}
