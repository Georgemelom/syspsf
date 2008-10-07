package br.com.unibratec.telas;

import java.util.Date;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDletStateChangeException;

import br.com.unibratec.core.UIController;

public class FichaDiaria extends Form implements CommandListener {

	private TextField fdPcCns;
	private DateField fdDtProducao;
	private List fdCodProcedimento;
	private List fdTpAtendimento;
	private TextField fdPcNome;
	private TextField fdProDescricao;
	private TextField fdAtDescricao;
	private List fdCodCid;

	private Command cmd_ok;
	private Command cmd_reg;
	
	private static FichaDiaria instance;

	public static FichaDiaria getInstance(String title) {
		if (instance == null) {
			instance = new FichaDiaria(title);
		}
		return instance;
	}

	private FichaDiaria(String title) {
		super(title);

		fdDtProducao = new DateField("", DateField.DATE_TIME);
		fdPcCns = new TextField("CNS: ", "", 10, TextField.ANY);
		fdPcNome = new TextField("Nome: ", "", 20, TextField.ANY);
		fdCodProcedimento = new List("Procedimento", List.IMPLICIT);
		fdProDescricao = new TextField("Procedimento: ", "", 20, TextField.ANY);
		fdTpAtendimento = new List("Atendimento", List.IMPLICIT);
		fdAtDescricao = new TextField("Atendimento: ", "", 20, TextField.ANY);
		fdCodCid = new List("CID", List.IMPLICIT);

		cmd_ok = new Command("Opções", Command.OK, 1);
		cmd_reg = new Command("Ok", Command.BACK, 1);
		append(fdDtProducao);
		append(fdPcCns);
		append(fdPcNome);
		// append(fdCodProcedimento);
		append(fdProDescricao);
		// append(fdTpAtendimento);
		append(fdAtDescricao);
		// append(fdCodCid);

		addCommand(cmd_ok);
		addCommand(cmd_reg);
		setCommandListener(this);
		this.fdDtProducao.setDate(new Date());

	}

	public void commandAction(Command cmd, Displayable disp) {

		if (cmd == cmd_ok) {
			UIController.getInstance().MenuFichaDiaria();
		}else if (cmd == cmd_reg){
			UIController.getInstance();
		}
	}
}