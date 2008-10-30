package br.com.unibratec.telas;

import java.util.Date;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;

import br.com.unibratec.core.UIController;

public class FichaDiaria extends Form implements CommandListener {

	Display tela;
	Command cmd_ok, cdm_opc, cmd_sair, cmd_voltar;
	List pcCns, pcCid, pcProc, pcAtd;
	TextBox t1;

	TextField fdFolha;
	DateField fdDtProducao;

	public void startApp() {
		this.tela = Display.getDisplay(null);
		this.tela.setCurrent(this.pcCns);
	}

	public void destroyApp(boolean i) {
	}

	public void pauseApp() {
	}

	private void notifyDestroyed() {
		// TODO Auto-generated method stub
		
	}
	
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
		fdFolha = new TextField("Folha: ", "", 20, TextField.ANY);

		cmd_ok = new Command("Ok", Command.OK, 1);
		cmd_voltar = new Command("Opções", Command.BACK, 1);
		append(fdDtProducao);
		append(fdFolha);

		addCommand(cmd_ok);
		addCommand(cmd_voltar);
		setCommandListener(this);
		this.fdDtProducao.setDate(new Date());

		
		// arrays que irao apracer nas listas
		String[] ListaCNS = { "1234,5,6", "1234,5,6", "1234,5,6", "1234,5,6",
				"1234,5,6" };
		String[] ListaCID = { "1234,5,6", "1234,5,6", "1234,5,6", "1234,5,6",
				"1234,5,6" };
		String[] ListaAtendimento = { "1234,5,6", "1234,5,6", "1234,5,6",
				"1234,5,6", "1234,5,6" };
		String[] ListaProcedimento = { "1234,5,6", "1234,5,6", "1234,5,6",
				"1234,5,6", "1234,5,6" };

		this.cmd_ok = new Command("Confirma", Command.SCREEN, 1);
		this.cmd_voltar = new Command("Proximo", Command.SCREEN, 1);
		this.cmd_sair = new Command("Sair", Command.SCREEN, 1);

		this.t1 = new TextBox("Result", "", 200, TextField.ANY);
		this.addCommand(cmd_sair);
		this.setCommandListener(this);

		this.pcCns = new List("CNS do Paciente", List.IMPLICIT, ListaCNS, null);
		this.pcCns.addCommand(this.cmd_sair);
		this.pcCns.addCommand(this.cmd_ok);
		this.pcCns.setCommandListener(this);

	}

	public void commandAction(Command c, Displayable d) {
		String opcao = "";

		if (c == this.cmd_sair) {
			this.destroyApp(true);
			this.notifyDestroyed();
		}
		//if (c == this.cmd_voltar) {
		//	// pega a String do item selecionado para por no textbox
		//	opcao = this.pcCns.getString(this.pcCns.getSelectedIndex());
		//	this.t1.setString(opcao);
		//	this.tela.setCurrent(this.t1);
		//}
		else if (c.equals(cmd_voltar)) {
			UIController.getInstance().voltar();
		}
		if ((c == List.SELECT_COMMAND) && (d == this.pcCns)) {
			int selecionado = this.pcCns.getSelectedIndex();
			// aqui verificamos se foi selecionado um dos Alerts
			// entao ele eh acionado, e apos ser mostrado
			// a tela anterior que é o menu
			// eh mostrado novamente
			switch (selecionado) {
			case 0:
				this.tela.setCurrent(this.pcCns);
				break;
			case 1:
				this.tela.setCurrent(this.pcProc);
				break;
			case 2:
				this.tela.setCurrent(this.pcAtd);
				break;
			case 3:
				this.tela.setCurrent(this.pcCid);
				break;
			// aqui temos as outras listas...
			case 5:
				this.pcCns.setCommandListener(this);
				this.tela.setCurrent(this.pcCns);
				break;
			case 6:
				this.pcProc.setCommandListener(this);
				this.tela.setCurrent(this.pcProc);
				break;
			}
		}
	}

}