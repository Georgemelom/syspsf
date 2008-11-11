package midlet;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;

import record.NameComparatorFd;
import record.NameFilterFd;
import record.SearchFormFd;
import form.EditFormFd;

public class FichaMidLet extends MIDlet implements CommandListener {
	Command addCmd = new Command("Nova Ficha", Command.SCREEN, 1);
	Command selectCmd = new Command("Visualizar", Command.ITEM, 1);
	Command exitCmd = new Command("Sair", Command.EXIT, 1);

	Command saveCmd = new Command("Salvar", Command.SCREEN, 1);
	Command deleteCmd = new Command("Remover", Command.SCREEN, 1);
	Command cancelCmd = new Command("Cancelar", Command.SCREEN, 1);

	Command searchCmd = new Command("Buscar", Command.SCREEN, 1);

	List listaFd = new List("Fichas", List.IMPLICIT);
	EditFormFd formFd = new EditFormFd();
	SearchFormFd searchFormFd = new SearchFormFd();

	NameComparatorFd orderby = new NameComparatorFd();
	NameFilterFd nameFilter = new NameFilterFd(orderby);

	private Ficha[] currentFichaList;

	public FichaMidLet() {
		formFd.addCommand(saveCmd);
		formFd.addCommand(cancelCmd);
		formFd.addCommand(deleteCmd);
		formFd.setCommandListener(this);

		searchFormFd.addCommand(searchCmd);
		searchFormFd.setCommandListener(this);

		listaFd.addCommand(searchCmd);
		listaFd.addCommand(addCmd);
		listaFd.addCommand(exitCmd);
		listaFd.setSelectCommand(selectCmd);
		listaFd.setCommandListener(this);

	}

	public void startApp() {
		refreshList();
	}

	public void pauseApp() {
	}

	public void destroyApp(boolean unc) {
	}

	private void refreshList() {
		listaFd.deleteAll();
		currentFichaList = Ficha.listaFd(orderby, nameFilter);
		for (int ccnt = 0; ccnt < currentFichaList.length; ccnt++) {
			String name = currentFichaList[ccnt].fdID;
			listaFd.append(name + " " + currentFichaList[ccnt].folha_FolID,null);
		}
		Display.getDisplay(this).setCurrent(listaFd);
	}

	private void showForm(Ficha c) {
		formFd.setFicha(c);
		Display.getDisplay(this).setCurrent(formFd);
	}

	public void commandAction(Command cmd, Displayable d) {
		if (cmd == exitCmd) {
			destroyApp(true);
			notifyDestroyed();
		} else if ((d == listaFd) && (cmd == addCmd)) {
			formFd.setFicha(new Ficha());
			Display.getDisplay(this).setCurrent(formFd);
		} else if ((d == formFd) && (cmd == saveCmd)) {
			Ficha c = formFd.getFicha();
			c.store();
			refreshList();
		} else if ((d == listaFd) && (cmd == selectCmd)) {
			showForm(currentFichaList[listaFd.getSelectedIndex()]);
		} else if ((d == formFd) && (cmd == deleteCmd)) {
			formFd.getFicha().delete();
			refreshList();
		} else if ((d == formFd) && (cmd == deleteCmd)) {
			refreshList();
		} else if ((d == listaFd) && (cmd == searchCmd)) {
			Display.getDisplay(this).setCurrent(searchFormFd);
		} else if ((d == searchFormFd) && (cmd == searchCmd)) {
			nameFilter.criteria = searchFormFd.getCriteria();
			refreshList();
		} else if ((d == formFd) && (cmd == cancelCmd)) {
			refreshList();
		}
	}

	public static Displayable getInstance(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
