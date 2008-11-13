package br.com.unibratec.menus;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

import br.com.unibratec.core.UIController;

public class ListaAtendimento extends List implements CommandListener {

	Command selectCmd = new Command("Visualizar", Command.ITEM, 1);
	Command exitCmd = new Command("Sair", Command.EXIT, 1);

	Command saveCmd = new Command("Salvar", Command.SCREEN, 1);
	Command deleteCmd = new Command("Remover", Command.SCREEN, 1);
	Command cancelCmd = new Command("Cancelar", Command.SCREEN, 1);

	Command searchCmd = new Command("Buscar", Command.SCREEN, 1);

	List listaFd = new List("Fichas", List.IMPLICIT);
//	EditFormFd formFd = new EditFormFd();
//	SearchFormFd searchFormFd = new SearchFormFd();

//	NameComparatorFd orderby = new NameComparatorFd();
//	NameFilterFd nameFilter = new NameFilterFd(orderby);

	private ListaAtendimento[] currentFichaList;

	
	
	private Command cmd_sair;
	private Command cmd_voltar;
	private Command cmd_alterar;
	
	private static ListaAtendimento instance;
	
	private ListaAtendimento(String title) {
		super(title, IMPLICIT);

		append("Unidade de Saude", null);
		append("Profissional de Saude", null);
		append("Paciente", null);
		append("Atendimento", null);

		cmd_sair = new Command("sair", Command.EXIT, 0);
		cmd_voltar = new Command("voltar", Command.BACK, 1);
		cmd_alterar = new Command("Alterar", Command.OK, 2);

		addCommand(cmd_sair);
		addCommand(cmd_voltar);
		addCommand(cmd_alterar);

		setCommandListener(this);
	}

	public static ListaAtendimento getInstance(String title) {
		if (instance == null) {
			instance = new ListaAtendimento(title);
		}
		return instance;
	}

	public void commandAction(Command cmd, Displayable arg1) {
		if (cmd.equals(cmd_sair)) {
			UIController.getInstance().sair();
		} else if (cmd.equals(cmd_voltar)) {
			UIController.getInstance().voltar();
		} else if (cmd.equals(cmd_alterar)) {
//			UIController.getInstance().ok(getSelectedIndex());
		}
	}
}
