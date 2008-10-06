package br.com.unibratec.core;

import java.util.Stack;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

import br.com.unibratec.ProjetoMIDLet;
import br.com.unibratec.telas.Alerta;
import br.com.unibratec.telas.Login;
import br.com.unibratec.telas.MenuLogin;
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
	
	public static final Command LOGIN_CMD = new Command("login", Command.OK, 0);
	public static final Command MENUOK_CMD = new Command("ok", Command.OK, 0);
	public static final Command VOLTAR_CMD = new Command("voltar", Command.BACK, 1);


	public void login(String login, String passwd) {
		// conecata ao servidor e realiza login
		if (login.equals("adm") && passwd.equals("123")) {
			// encaminha para MENU
			setCurrent(MenuLogin.getInstance("MENU", List.IMPLICIT));
		} else {
			setCurrent(Alerta.getInstance("ERRO"), Login.getInstance("LOGIN"));
		}
	}

	public void unidadeSaude(String usNome, String usSigla, String usCnpj,
			String usSecretaria, int selectedIndex) {

		setCurrent(MenuUs.getInstance("Opções", List.IMPLICIT));

	}

	public void profissionalSaude(String psNome, String psCns, String psCbo,
			String psCr) {
		setCurrent(MenuUs.getInstance("Opções", List.IMPLICIT));

	}

	public void paciente(String pcNome, String pcCns, String pcDtNasc,
			int selectedIndex, String pcEndereco, String pcCidade,
			String pcLocalidade) {
		setCurrent(MenuUs.getInstance("Opções", List.IMPLICIT));

	}

	public void fichaDiaria(int fdDtProducao, String fdPcCns, String fdPcNome,
			int fdCodProcedimento, String fdProDescricao, int fdTpAtendimento,
			String fdAtDescricao, int fdCodCid) {
		setCurrent(MenuUs.getInstance("Opções", List.IMPLICIT));

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

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd.equals(MENUOK_CMD)) {
			setCurrent(MenuUs.getInstance("Opções", List.IMPLICIT));
		}
		if (cmd.equals(LOGIN_CMD)) {
			// vai no server e verifica login
			setCurrent(MenuLogin.getInstance("Menu", List.IMPLICIT));
		}
		if (cmd.equals(VOLTAR_CMD)) {
			telas.pop();
			Displayable d = (Displayable) telas.pop();
			setCurrent(d);
		}
	}

}
