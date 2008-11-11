package list;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

import record.NameComparatorPc;
import record.NameFilterPc;
import record.RecordPaciente;
import core.UIController;
import form.PacienteForm;

public class ListaPc extends List implements CommandListener {

	Command addCmd;
	Command selectCmd;
	Command exitCmd ;

	List listaPc = new List("Pacientes", List.IMPLICIT);
	PacienteForm formPc = new PacienteForm(getTitle());
	RecordPaciente recPc = new RecordPaciente();
//	SearchFormPc searchFormPc = new SearchFormPc();

	NameComparatorPc orderby = new NameComparatorPc();
	NameFilterPc nameFilter = new NameFilterPc(orderby);

	private RecordPaciente[] currentPacienteList;

	private static ListaPc instance;

	public static ListaPc getInstance(String title) {
		if (instance == null) {
			instance = new ListaPc(title);
		}
		return instance;
	}

	public ListaPc(String title) {
		super(title, List.IMPLICIT);

		addCmd = new Command("Novo Paciente", Command.OK, 1);
		selectCmd = new Command("Visualizar", Command.ITEM, 1);
		exitCmd = new Command("Sair", Command.EXIT, 1);

//		saveCmd = new Command("Salvar", Command.SCREEN, 1);
//		deleteCmd = new Command("Remover", Command.SCREEN, 1);
//		cancelCmd = new Command("Cancelar", Command.SCREEN, 1);
//		searchCmd = new Command("Buscar", Command.SCREEN, 1);


//		addCommand(searchCmd);
		addCommand(addCmd);
		addCommand(exitCmd);
		setSelectCommand(selectCmd);
		setCommandListener(this);

	}

	public void startApp() {
		refreshList();
//		RecordPaciente.listaPc(orderby, nameFilter);
	}


	private void refreshList() {
		listaPc.deleteAll();
		currentPacienteList = RecordPaciente.listaPc(orderby, nameFilter);
		for (int ccnt = 0; ccnt < currentPacienteList.length; ccnt++) {
			String cns = currentPacienteList[ccnt].pcCns;
			String nome = currentPacienteList[ccnt].pcNome;
			append(cns + " " + nome, null);
		}
//		 Display.getDisplay(this).setCurrent(listaPc);
		UIController.setCurrent(listaPc);
	}

	private void showForm(RecordPaciente c) {
		recPc.setPaciente(c);
		// Display.getDisplay(this).setCurrent(formPc);
		UIController.setCurrent(recPc);
	}

	public void commandAction(Command cmd, Displayable d) {
		if (cmd == exitCmd) {
//			destroyApp(true);
			// notifyDestroyed();
			UIController.getInstance().sair();

		} else if ((d == listaPc) && (cmd == addCmd)) {
			recPc.setPaciente(new RecordPaciente());
			UIController.setCurrent(formPc);

//		} else if ((d == formPc) &&(cmd == saveCmd)) {
//			RecordPaciente c = recPc.getPaciente();
//			c.store();
//			refreshList();

		} else if ((d == listaPc) && (cmd == selectCmd)) {
			showForm(currentPacienteList[listaPc.getSelectedIndex()]);

//		} else if ((d == formPc) &&(cmd == deleteCmd)) {
//			recPc.getPaciente().delete();
//			refreshList();
//
//		} else if ((d == listaPc) && (cmd == searchCmd)) {
//			UIController.setCurrent(searchFormPc);
//
//		} else if ((d == searchFormPc) && (cmd == searchCmd)) {
//			nameFilter.criteria = searchFormPc.getCriteria();
//			refreshList();
//		} else if (cmd == cancelCmd) {
//			refreshList();
		}
	}

}
