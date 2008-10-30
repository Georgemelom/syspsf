package br.com.unibratec.core;

import java.util.Stack;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

import br.com.unibratec.ProjetoMIDLet;
import br.com.unibratec.menus.SubMenu;
import br.com.unibratec.menus.MenuPrincipal;
import br.com.unibratec.telas.Alerta;
import br.com.unibratec.telas.FichaDiaria;
import br.com.unibratec.telas.Login;
import br.com.unibratec.telas.Paciente;
import br.com.unibratec.telas.ProfissionalSaude;
import br.com.unibratec.telas.UnidadeSaude;

public class UIController {

	private ProjetoMIDLet midLet;
	private Display disp;

	private Stack telas;
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
			setCurrent(MenuPrincipal.getInstance("Menu Principal"));  	// encaminha para MENU
			
		} else {
			setCurrent(Alerta.getInstance("ERRO"), Login.getInstance("LOGIN"));
		}
	}

	public void unidadeSaude() {

		setCurrent(UnidadeSaude.getInstance("Unidade de Saude"));

	}

	public void profissionalSaude() {
		setCurrent(ProfissionalSaude.getInstance("Profissional de Saude"));

	}

	public void paciente() {
		setCurrent(Paciente.getInstance("Paciente"));

	}

	private void setCurrent(Paciente instance2) {
		// TODO Auto-generated method stub
		
	}

	public void MenuFichaDiaria() {
		setCurrent(FichaDiaria.getInstance("Ficha Diaria"));

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
		case 0 :	setCurrent(SubMenu.getInstance("Menu ",List.IMPLICIT,x));
		break;
		case 1 :	setCurrent(SubMenu.getInstance("Menu ",List.IMPLICIT,x));
		break;
		case 2 :	setCurrent(SubMenu.getInstance("Menu ",List.IMPLICIT,x));
		break;
		case 3 :	setCurrent(SubMenu.getInstance("Menu ",List.IMPLICIT,x));
		break;
		
		}
	}
public void telas(int x) {
		
		switch (x) {
		case 0 :	setCurrent(UnidadeSaude.getInstance("Cadastrar Unidade de Saude"));
		break;
		case 1 :	setCurrent(ProfissionalSaude.getInstance("Cadstrar Profissional"));
		break;
		case 2 :	setCurrent(Paciente.getInstance("Cadastrar Paciente"));
		break;
		case 3 :	setCurrent(FichaDiaria.getInstance("Registar Atendimento"));
		break;
		
		}
	}
}
