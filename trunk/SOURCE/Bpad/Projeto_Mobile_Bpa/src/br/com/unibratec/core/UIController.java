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

		setCurrent(SubMenu.getInstance("Unidade de Saude", List.IMPLICIT,0));

	}

	public void profissionalSaude(String psNome, String psCns, String psCbo,
			String psCr) {
		setCurrent(SubMenu.getInstance("Profissional de Saude", List.IMPLICIT,0));

	}

	public void paciente() {
		setCurrent(SubMenu.getInstance("Paciente", List.IMPLICIT,0));

	}

	public void MenuFichaDiaria() {
		setCurrent(SubMenu.getInstance("Ficha Diaria", List.IMPLICIT,0));

	}

	public void sair() {
		midLet.destroyApp(true);
		midLet.notifyDestroyed();
	}

	public void setCurrent(Displayable fichaDiaria) {
		telas.push(fichaDiaria);
		disp.setCurrent(fichaDiaria);
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
		case 1 :	setCurrent(SubMenu.getInstance("Menu Profissional de Saude",List.IMPLICIT,x));
		break;
		case 2 :	setCurrent(SubMenu.getInstance("Menu Paciente",List.IMPLICIT,x));
		break;
		case 3 :	setCurrent(SubMenu.getInstance("Menu Atendimento",List.IMPLICIT,x));
		break;
		
		}
	}

}