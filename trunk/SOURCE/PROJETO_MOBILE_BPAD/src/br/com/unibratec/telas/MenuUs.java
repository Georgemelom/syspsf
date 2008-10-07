package br.com.unibratec.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

import br.com.unibratec.core.UIController;

public class MenuUs extends List implements CommandListener {
	
	private static MenuUs instance;
	//private Command cmd_sair;
	private Command cmd_voltar;
	private Command cmd_ok;
	
	private MenuUs(String title, int listType) {
		super(title, listType);
		
		append("Cadastrar", null);
		append("Atualizar", null);
		//append("Excluir", null);
		//append("Consultar", null);
		
		//cmd_sair = new Command("sair", Command.EXIT, 1);
		cmd_voltar = new Command("voltar", Command.BACK, 1);
		cmd_ok = new Command("Ok", Command.OK, 2);
				
	//	addCommand(cmd_sair);
		addCommand(cmd_voltar);
		addCommand(cmd_ok);
		
		setCommandListener(this);
	}
	
	public static MenuUs getInstance(String title, int listType) {
		if (instance == null) {
			instance = new MenuUs(title, listType);
		}
		return instance;
	}
	
	public void commandAction(Command cmd, Displayable arg1) {
		//if (cmd.equals(cmd_sair)) {
		//	UIController.getInstance().sair();
	//	} else 
	if (cmd.equals(cmd_voltar)) {
			UIController.getInstance().voltar();
		}
	}
	}
