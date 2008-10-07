package br.com.unibratec.core;

import java.util.Stack;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

import br.com.unibratec.ProjetoMIDLet;
import br.com.unibratec.telas.Alerta;
import br.com.unibratec.telas.FichaDiaria;
import br.com.unibratec.telas.Login;
import br.com.unibratec.telas.MenuUs;

public class UIController {

	private ProjetoMIDLet midLet;
	private Display disp;

	private Stack telas;
	private Displayable current;

	private static UIController instance;

	private UIController(ProjetoMIDLet midLet) {
		this.midLet = midLet;
		this.disp = Display.getDisplay(midLet);
		telas = new Stack();
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
	
	public void login(String login, String passwd) {
		
		if (login.equals("adm") && passwd.equals("123")) {    				// conecata ao servidor e realiza login
			setCurrent(FichaDiaria.getInstance("Ficha Diaria"));  	// encaminha para MENU
			
		} else {
			setCurrent(Alerta.getInstance("ERRO"), Login.getInstance("LOGIN"));
		}
	}

	public void unidadeSaude() {

		setCurrent(MenuUs.getInstance("Unidade de Saude", List.IMPLICIT));

	}

	public void profissionalSaude(String psNome, String psCns, String psCbo,
			String psCr) {
		setCurrent(MenuUs.getInstance("Profissional de Saude", List.IMPLICIT));

	}

	public void paciente() {
		setCurrent(MenuUs.getInstance("Paciente", List.IMPLICIT));

	}

	public void MenuFichaDiaria() {
		setCurrent(MenuUs.getInstance("Ficha Diaria", List.IMPLICIT));

	}

	public void sair() {
		midLet.destroyApp(true);
		midLet.notifyDestroyed();
	}

	public void setCurrent(Displayable tela) {
		telas.push(tela);
		disp.setCurrent(tela);
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

	public void ok() {
//		if (List.SELECT_COMMAND.equals("Unidade de Saude")){
//			Displayable atual = (Displayable) telas.pop();
//			setCurrent(atual);
//		}
	}

}
