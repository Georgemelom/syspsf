package core;

import java.util.Stack;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;

import list.ListaPc;
import midlet.ProjetoMIDLet;
import record.RecordLogin;
import record.RecordPaciente;
import form.Alerta;
import form.Login;
import form.MenuPrincipal;
import form.PacienteForm;

public class UIController {

	private ProjetoMIDLet midLet;
	private static Display disp;
	// PacienteMidLet paciente = new PacienteMidLet(null);
	// EditFormPc formPc = new EditFormPc();
	// ListaPc listaPc = new ListaPc(title, listType, menu);

	private static Stack telas;
	// private int recID = -1;
//	EditFormPc formPc = new EditFormPc(null);
	private static UIController instance;

	private UIController(ProjetoMIDLet midLet) {
		this.midLet = midLet;
		this.disp = Display.getDisplay(midLet);
		telas = new Stack();
		startUp();
	}

	public void startUp() {

	}

	public static UIController createInstance(ProjetoMIDLet midLet) {
		if (instance == null) {
			instance = new UIController(midLet);
		}
		return instance;
	}

	public static UIController getInstance() {
		return instance;
	}

	public void salvarLogin(String login, String passwd) {
		RecordLogin.setLogin(login);
		RecordLogin.setSenha(passwd);
	}

	public void salvarPc(String pcCns, String pcNome, String pcDtNasc,
			String pcSexo, String pcEndereco) {
		RecordPaciente c = RecordPaciente.getPaciente();
		c.store();
//		RecordPaciente.setPcCns(pcCns);
//		RecordPaciente.setPcNome(pcNome);
//		RecordPaciente.setPcDtNasc(pcDtNasc);
//		RecordPaciente.setPcSexo(pcSexo);
//		RecordPaciente.setPcEndereco(pcEndereco);
	}

	public void exibirLogin() {
		Alert alert = new Alert("Seu Login  é:", RecordLogin.getLogin(), null,
				AlertType.CONFIRMATION);
		disp.setCurrent(alert);
	}

	public void exibirPaciente() {
		
				Alert alert = new Alert("Seu Dados são:", (RecordPaciente.getPaciente()).toString(),null, AlertType.CONFIRMATION);
		disp.setCurrent(alert);
//		setCurrent(listaPc);
		setCurrent(ListaPc.getInstance("Lista de Pacientes"));
	}

	public void login(String login, String passwd) {
		 // conecata ao servidor e realiza login
		if (login.equals("adm") && passwd.equals("123")) {
			 // encaminha par Menu
			setCurrent(MenuPrincipal.getInstance("Menu Principal"));
		
		} else {
			setCurrent(Alerta.getInstance("ERRO"), Login.getInstance("LOGIN"));
		}
	}

	public void sair() {
		midLet.destroyApp(true);
		midLet.notifyDestroyed();
	}

	public static void setCurrent(Displayable recordPacientes) {
		telas.push(recordPacientes);
		disp.setCurrent(recordPacientes);
	}
	public static void setCurrent(RecordPaciente formPc) {
		telas.push(formPc);
//		disp.setCurrent(formPc);
	}

	public void setCurrent(Alert alerta, Displayable tela) {
		telas.push(tela);
		disp.setCurrent(alerta, tela);
	}

	public void voltar() {
		telas.pop();
		Displayable anterior = (Displayable) telas.pop();
		setCurrent(anterior);
	}

	public void ok(int x) {
		// UIController.setCurrent(paciente);
		// UIController.setCurrent(listaPc);
		switch (x) {
		case 0:
			setCurrent(ListaPc.getInstance("Lista de Pacientes"));
			break;
		// case 1 : setCurrent(SubMenu.getInstance("Menu ",List.IMPLICIT,x));
		// break;

		}
	}

	public void novoPc() {
		// formPc.setPaciente(new PacienteRecord());
		// Display.getDisplay(this).setCurrent(formPc);
		// disp.setCurrent(formPc);
		setCurrent(PacienteForm.getInstance("Novo Paciente"));

	}
}
