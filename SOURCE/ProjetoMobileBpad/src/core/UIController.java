package core;

import java.util.Stack;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

import midlet.ProjetoMIDLet;
import record.RecordLogin;
import form.Alerta;
import form.Login;
import form.MenuPrincipal;

public class UIController {

	private ProjetoMIDLet midLet;
	private Display disp;

	private Stack telas;
//	private int recID = -1;
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
		
	public void exibirLogin() {
		Alert alert = new Alert("Seu Login  é:", RecordLogin.getLogin(), null, AlertType.CONFIRMATION);
		disp.setCurrent(alert);
	}
	
		
	public void login(String login, String passwd) {
		
		if (login.equals("adm")&& passwd.equals("123")) {    				// conecata ao servidor e realiza login
			setCurrent(MenuPrincipal.getInstance("Menu Principal"));  	// encaminha para MENU
			
		} else {
			setCurrent(Alerta.getInstance("ERRO"), Login.getInstance("LOGIN"));
		}
	}

	
	public void sair() {
		midLet.destroyApp(true);
		midLet.notifyDestroyed();
	}

	public void setCurrent(Displayable paciente) {
		telas.push(paciente);
		disp.setCurrent(paciente);
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
		
		switch (x) {
		case 0 :    ;
		break;
		case 1 :	;
		break;
		
		}
	}

}
