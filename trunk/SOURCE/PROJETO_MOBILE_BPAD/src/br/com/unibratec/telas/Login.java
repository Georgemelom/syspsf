package br.com.unibratec.telas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

import br.com.unibratec.core.UIController;

public class Login extends Form implements CommandListener {
	
	private TextField login;
	private TextField passwd;
	
	private Command cmd_login;
	
	private static Login instance;

	public static Login getInstance(String title) {
		if (instance == null) {
			instance = new Login(title);
		}
		return instance;
	}

	private Login(String title) {
		super(title);
		
		login = new TextField("login: ", "", 10, TextField.ANY);
		passwd = new TextField("senha: ", "", 10, TextField.PASSWORD);
		
		cmd_login = new Command("logar", Command.OK, 1);
		
		append(login);
		append(passwd);
		
		addCommand(cmd_login);
		setCommandListener(this);
	}

	public void commandAction(Command cmd, Displayable disp) {
		if (cmd == cmd_login) {
			UIController.getInstance().login(login.getString(), passwd.getString());
		}
		
	}

}
