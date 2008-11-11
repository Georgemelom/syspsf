package form;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

//import record.NameComparatorPc;
//import record.NameFilterPc;
import record.SearchFormPc;
import core.UIController;

public class PacienteForm extends Form implements CommandListener {

	public static TextField pcCnsFld;
	public static TextField pcNomeFld;
	public static TextField pcDtNasFld;
	public static TextField pcSexoFld;
	public static TextField pcEnderecoFld;

	Command addCmd;
	Command selectCmd;
	Command exitCmd;
	Command saveCmd;
	Command deleteCmd;
	Command cancelCmd;
	Command searchCmd;

	private static PacienteForm instance;

	public static PacienteForm getInstance(String title) {
		if (instance == null) {
			instance = new PacienteForm(title);
		}
		return instance;
	}

	// private PacienteRecord[] currentPacienteList;
	SearchFormPc searchFormPc = new SearchFormPc();
//	NameComparatorPc orderby = new NameComparatorPc();
//	NameFilterPc nameFilter = new NameFilterPc(orderby);

	public PacienteForm(String title) {
		super(title);

		pcCnsFld = new TextField("CNS : ", "",6, TextField.ANY);
		pcNomeFld = new TextField("Nome", "", 30, TextField.ANY);
		pcDtNasFld = new TextField("Dt. Nasc.: ", "", 10, TextField.ANY);
		pcSexoFld = new TextField("Sexo :", "", 1, TextField.ANY);
		pcEnderecoFld = new TextField("Endereço: ", "", 30, TextField.ANY);

		addCmd = new Command("Novo Paciente", Command.OK, 1);
		selectCmd = new Command("Visualizar", Command.OK, 1);
		exitCmd = new Command("Sair", Command.EXIT, 1);
		saveCmd = new Command("Salvar", Command.OK, 1);
		deleteCmd = new Command("Remover", Command.OK, 1);
		cancelCmd = new Command("Cancelar", Command.OK, 1);
		searchCmd = new Command("Buscar", Command.OK, 1);

		append(pcCnsFld);
		append(pcNomeFld);
		append(pcDtNasFld);
		append(pcSexoFld);
		append(pcEnderecoFld);
		
		
		addCommand(addCmd);
		addCommand(selectCmd);
		addCommand(exitCmd);
		addCommand(saveCmd);
		addCommand(deleteCmd);
		addCommand(cancelCmd);
		addCommand(searchCmd);
		
		setCommandListener(this);
	}


	public void commandAction(Command cmd, Displayable d) {
		if (cmd == exitCmd) {
			UIController.getInstance().sair();
			
		}else if (cmd == addCmd) {
			UIController.getInstance().novoPc();
			
		} else if (cmd == saveCmd){
			UIController.getInstance().salvarPc(pcCnsFld.getString(), 
					pcNomeFld.getString(), pcDtNasFld.getString(), 
					pcSexoFld.getString(), pcEnderecoFld.getString());
		}else if (cmd == selectCmd) {
			UIController.getInstance().exibirPaciente(); 
	}
		
//			// } else if ((d == listaPc) && (cmd == selectCmd)) {
			// showForm(currentPacienteList[listaPc.getSelectedIndex()]);
			// } else if ((d == formPc) && (cmd == deleteCmd)) {
//			formPc.getPaciente().delete();
			// refreshList();
//		} else if ((d == formPc) && (cmd == deleteCmd)) {
			// refreshList();
			// } else if ((d == listaPc) && (cmd == searchCmd)) {
			// // Display.getDisplay(this).setCurrent(searchFormPc);
			// UIController.setCurrent(searchFormPc);
//		} else if ((d == searchFormPc) && (cmd == searchCmd)) {
//			nameFilter.criteria = searchFormPc.getCriteria();
			// refreshList();
//		} else if ((d == formPc) && (cmd == cancelCmd)) {
			// refreshList();
//		}
//	}
}}
